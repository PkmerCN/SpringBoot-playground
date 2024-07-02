package org.hzz.mapper;

import java.util.List;
import org.hzz.model.City;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City row);

    City selectByPrimaryKey(Integer id);

    List<City> selectAll();

    int updateByPrimaryKey(City row);
}