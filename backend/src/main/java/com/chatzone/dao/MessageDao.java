package com.chatzone.dao;

import com.chatzone.entity.PrivateMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageDao {
    @Insert("INSERT INTO private_message (sender_id,receiver_id,content) VALUES (#{sender_id},#{receiver_id},#{content})")
    void insertPrivateMessage(long sender_id,long receiver_id,String content);
    @Results({
            @Result(property = "sender_id", column = "sender_id"),
            @Result(property = "receiver_id", column = "receiver_id"),
            @Result(property = "content", column = "content"),
            @Result(property = "create_time", column = "create_time")
    })
    @Select("SELECT sender_id, receiver_id, content, create_time FROM private_message WHERE sender_id = #{sender_id} AND receiver_id = #{receiver_id}")
    List<PrivateMessage> selectPrivateMessageByUserIdAndFriendId(long sender_id, long receiver_id);
}
