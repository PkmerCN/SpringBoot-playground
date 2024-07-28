package org.hzz.redis.test.basic;

import org.hzz.redis.dto.AddressDto;
import org.hzz.redis.dto.UserDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
public class UserDataProvider {

    public static UserDto getUser() {
        UserDto userDto = new UserDto()
                .setDays(10)
                .setName("pkmer")
                .setCreateTime(LocalDateTime.now())
                .setJavaDeveloper(true)
                .setAddress(new AddressDto().setCity("桂林"));
        return userDto;
    }

    public static List<UserDto> getUsers() {
        return List.<UserDto>of(
                new UserDto()
                        .setDays(10)
                        .setName("pkmer")
                        .setCreateTime(LocalDateTime.now())
                        .setJavaDeveloper(true)
                        .setAddress(new AddressDto().setCity("桂林")),
                new UserDto()
                        .setDays(11)
                        .setName("hzz")
                        .setCreateTime(LocalDateTime.now())
                        .setJavaDeveloper(true)
                        .setAddress(new AddressDto().setCity("阳朔")),
                new UserDto()
                        .setDays(12)
                        .setName("q10viking")
                        .setCreateTime(LocalDateTime.now())
                        .setJavaDeveloper(true)
                        .setAddress(new AddressDto().setCity("北京")),
                new UserDto()
                        .setDays(12)
                        .setName("黄壮壮")
                        .setCreateTime(LocalDateTime.now())
                        .setJavaDeveloper(true)
                        .setAddress(new AddressDto().setCity("广州"))
        );
    }

    public static Set<UserDto> getSet(){
        return new HashSet<>(getUsers());
    }

    public static Map<String,UserDto> getMap(){
        return getUsers().stream().collect(Collectors.toMap(
                UserDto::getName,
                user -> user
        ));
    }
}
