package io.gitee.pkmer.handler;

import io.gitee.pkmer.command.ACmd;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/developeros/videos-online">Code Repository</a>
 * At 2025/1/2
 */
@Component
public class ACommandHandler implements CommandHandler<ACmd, Integer> {
    @Override
    public Integer handle(ACmd aCmd) {
        System.out.println("命令要执行的操作：" + aCmd.getMsg());
        int r = 1 + aCmd.getStep();
        System.out.println("执行结果：" + r);
        return r;
    }
}
