package org.hzz.dynamic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.hzz.dynamic.entity.Friend;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Mapper
public interface FriendMapper {

    @Select("select * from friend;")
    List<Friend> selectFriends();
}
