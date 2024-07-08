package org.hzz.lifecycle.factory.mysql;

import org.hzz.lifecycle.factory.ConnectionDetails;
import org.hzz.lifecycle.factory.MyFactory;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
public class MySqlConnectionDetailsFactory implements MyFactory<MySqlConnectionDetails> {
    @Override
    public MySqlConnectionDetails getConectionDetails() {
        return new MySqlConnectionDetails();
    }
}
