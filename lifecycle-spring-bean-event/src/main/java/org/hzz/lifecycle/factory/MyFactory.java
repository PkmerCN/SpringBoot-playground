package org.hzz.lifecycle.factory;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
public interface MyFactory<D extends ConnectionDetails> {
    D getConectionDetails();
}
