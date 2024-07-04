package org.hzz.dynamic.test;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.dynamic.entity.Friend;
import org.hzz.dynamic.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.hzz.dynamic.annotations.DS;
import java.util.List;
import static org.hzz.dynamic.datasource.DataSourceKeyConstants.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Component
@Slf4j
public class TestCommandLineRunner implements CommandLineRunner {

    /**
     * 防止aop失效
     */
    @Setter(onMethod_ = {@Autowired,@Lazy})
    private TestCommandLineRunner self;

    @Setter(onMethod_ = @Autowired)
    private FriendMapper  friendMapper;

    @Override
    public void run(String... args) throws Exception {
//        self.testDbA();
//        self.testDbB();
        combine();
    }


    @DS(DB_A)
    public void testDbA(){
        System.out.println("============数据库A==============");
        List<Friend> friends = friendMapper.selectFriends();
        System.out.println(friends);
    }

    @DS(DB_B)
    public void testDbB(){
        System.out.println("============数据库B==============");
        List<Friend> friends = friendMapper.selectFriends();
        System.out.println(friends);
    }


    public void combine(){
        self.testDbA();
        self.testDbB();
    }
}
/**output: 测试结果
 * 2024-07-04T15:51:59.631+08:00  INFO 8156 --- [           main] o.hzz.dynamic.aspectj.DataSourceAspect   : 测试@DS的value = DB_A
 * ============数据库A==============
 * [Friend(id=1, name=pkmer)]
 * 2024-07-04T15:52:00.522+08:00  INFO 8156 --- [           main] o.hzz.dynamic.aspectj.DataSourceAspect   : 测试@DS的value = DB_B
 * ============数据库B==============
 * [Friend(id=1, name=hzz), Friend(id=2, name=q10viking)]
 * friendMapper
 */