package com.chatzone.dao;

import com.chatzone.entity.Friend;
import com.chatzone.entity.PrivateChat;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendDao {
    @Results({
            @Result(property = "status", column = "user.status"),
    })
    @Select("SELECT * FROM friendship INNER JOIN user ON friendship.friend_id = user.id WHERE user_id = #{id}")
    public List<Friend> getFriendList(int id);

    @Insert("INSERT INTO friendship (user_id, friend_id) VALUES (#{user_id},#{friend_id});")
    public boolean addFriend(int user_id, int friend_id);

    @Insert("INSERT INTO friendship (user_id, friend_id) VALUES (#{friend_id},#{user_id});")
    public boolean reAddFriend(int user_id, int friend_id);

    @Select("SELECT COUNT(*) FROM friendship WHERE (user_id = #{user_id} AND friend_id = #{friend_id}) OR (user_id = #{friend_id} AND friend_id = #{user_id})")
    int selectFriendship(int user_id, Integer friend_id);

    @Delete("DELETE FROM friendship WHERE friend_id = #{friend_id} AND user_id = #{user_id};")
    Boolean deleteFriend(int user_id, Integer friend_id);

    @Delete("DELETE FROM friendship WHERE friend_id = #{user_id} AND user_id = #{friend_id};")
    Boolean reDeleteFriend(int user_id, Integer friend_id);

    @Select("SELECT sender_id FROM private_message WHERE receiver_id = #{id}")
    List<Integer> selectSenderIdInPrivateChat(int id);

    @Select("SELECT receiver_id FROM private_message WHERE sender_id = #{id}")
    List<Integer> selectReceiverIdInPrivateChat(int id);


    @Select("SELECT private_message.content,user.username,user.nickname,user.avatar " +
            "FROM private_message " +
            "INNER JOIN user ON user.id = #{id} " +
            "WHERE private_message.sender_id = #{id} OR private_message.receiver_id = #{id} " +
            "ORDER BY private_message.id " +
            "DESC " +
            "LIMIT 1;")
    PrivateChat selectLastMessageOfPrivateChat(int id);


}
