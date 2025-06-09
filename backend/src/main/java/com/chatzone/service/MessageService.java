package com.chatzone.service;

import com.chatzone.dao.MessageDao;
import com.chatzone.dao.UserDao;
import com.chatzone.entity.PrivateMessage;
import com.chatzone.model.PrivateChatMessage;
import com.chatzone.model.WebsocketMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDao userDao;
    public boolean handlePrivateChatMessage(WebsocketMessage<PrivateChatMessage> websocketMessage) {
        boolean isInsert = false;
        PrivateChatMessage privateChatMessage = new ObjectMapper().convertValue(websocketMessage.data(), PrivateChatMessage.class);
        String content = privateChatMessage.content();
        Integer senderId = userDao.selectIdByUsername(privateChatMessage.senderUsername());
        Integer receiverId = userDao.selectIdByUsername(privateChatMessage.receiverUsername());
        if(senderId != null && receiverId!=null){
            messageDao.insertPrivateMessage(senderId,receiverId,content);
        }
        return isInsert;
    }

    public List<PrivateMessage> getPrivateMessages(int sender_id, int receiver_id){
        List<PrivateMessage> datas = messageDao.selectPrivateMessageByUserIdAndFriendId(sender_id,receiver_id);
        datas.addAll(messageDao.selectPrivateMessageByUserIdAndFriendId(receiver_id,sender_id));
        for(PrivateMessage data : datas){
            data.setReceiver_username(userDao.selectUsernameById(data.getReceiver_id()));
            data.setSender_username(userDao.selectUsernameById(data.getSender_id()));
            data.setSender_id(0);
            data.setReceiver_id(0);
        }
        return datas;
    }
}
