package org.hzz.mapper;

import java.util.List;
import org.hzz.model.AppUsers;

public interface AppUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppUsers row);

    AppUsers selectByPrimaryKey(Long id);

    List<AppUsers> selectAll();

    int updateByPrimaryKey(AppUsers row);
}