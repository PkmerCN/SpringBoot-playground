package org.hzz.lifecycle.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
@Slf4j
public class MyFactories {
    private final List<MyFactory> factories;
    public MyFactories(){
         this(SpringFactoriesLoader.forDefaultResourceLocation(
                 MyFactory.class.getClassLoader()
         ));
    }

    MyFactories(SpringFactoriesLoader loader){
        factories = loader.load(MyFactory.class);
    }


    public List<MyFactory> getFactories(){
        return this.factories;
    }


}
