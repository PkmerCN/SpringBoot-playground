package org.hzz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hzz.domain.User;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/2
 */
@Mapper
public interface UserXMLMapper {
    List<User> getAllUsers();
}
