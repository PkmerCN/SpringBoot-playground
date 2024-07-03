package org.hzz.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.hzz.multi.entity.Friend;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
@Mapper
public interface MyFriendMapper {

    @Select("select * from friend;")
    List<Friend> selectFriends();
}
