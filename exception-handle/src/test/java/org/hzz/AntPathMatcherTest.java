package org.hzz;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
public class AntPathMatcherTest {

    @Test
    public void test(){
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean match = antPathMatcher.match("/**/*.css", "/css/error.css");
        System.out.println(match);
    }
}
