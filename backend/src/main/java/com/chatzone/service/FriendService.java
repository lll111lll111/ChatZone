package com.chatzone.service;

import com.chatzone.dao.FriendDao;
import com.chatzone.dao.UserDao;
import com.chatzone.entity.Friend;
import com.chatzone.entity.PrivateChat;
import com.chatzone.exception.FriendshipAlreadyExistsException;
import com.chatzone.exception.FriendshipNotExitsException;
import com.chatzone.exception.SlefFriendException;
import com.chatzone.exception.UserNotFoundException;
import com.chatzone.model.ServerMessage;
import com.chatzone.session.WebSocketSessionManager;
import com.chatzone.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.chatzone.model.ServerMessage.Type.FRIEND_UPDATE;

@Service
public class FriendService {
    @Autowired
    private FriendDao friendDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WebSocketSessionManager webSocketSessionManager;

    public List<Friend> getFriendList(int id) {
        return friendDao.getFriendList(id);
    }

    public boolean addFriend(int user_id, String friendUsername) throws IOException {
        Integer friend_id = userDao.selectIdByUsername(friendUsername);
        if (friend_id == null) throw new UserNotFoundException();
        if (user_id == friend_id) throw new SlefFriendException();
        int isFriend = friendDao.selectFriendship(user_id, friend_id);
        if (isFriend > 0) throw new FriendshipAlreadyExistsException();
        if (friendDao.addFriend(user_id, friend_id)) {
            if (friendDao.reAddFriend(user_id, friend_id)) {
                webSocketSessionManager.getSessionMap().get((long) user_id).sendMessage(new TextMessage(JsonUtil.messgeToJsonString(new ServerMessage(FRIEND_UPDATE, "好友添加成功"))));
                return true;
            }
        }
        return false;
    }

    public boolean deleteFriend(int user_id, String friendUsername) throws IOException {
        Integer friend_id = userDao.selectIdByUsername(friendUsername);
        if (friend_id == null) throw new UserNotFoundException();
        int isFriend = friendDao.selectFriendship(user_id, friend_id);
        if (isFriend == 0) throw new FriendshipNotExitsException();
        if (friendDao.deleteFriend(user_id, friend_id)) {
            if (friendDao.reDeleteFriend(user_id, friend_id)) {
                webSocketSessionManager.getSessionMap().get((long) user_id).sendMessage(new TextMessage(JsonUtil.messgeToJsonString(new ServerMessage(FRIEND_UPDATE, "好友删除成功"))));
                return true;
            }
        }
        return false;
    }

    public List<PrivateChat> getPrivateChatList(int id) {
        List<PrivateChat> privateChatList = new ArrayList<>();
        //先找出所有和用户有来往的人的set集合
        Set<Integer> userSet = new HashSet<>();
        List<Integer> userList1 = friendDao.selectSenderIdInPrivateChat(id);
        List<Integer> userList2 = friendDao.selectReceiverIdInPrivateChat(id);
        userSet.addAll(userList1);
        userSet.addAll(userList2);
        userSet.remove(id);
        //拿到所有和用户来往人的id,找最后一条消息
        for(Integer i : userSet){
            privateChatList.add(friendDao.selectLastMessageOfPrivateChat(i));
        }
        return privateChatList;
    }
}
