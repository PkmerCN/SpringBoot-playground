package io.gitee.pkmer.command;

import lombok.Data;
import lombok.Value;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/developeros/videos-online">Code Repository</a>
 * At 2025/1/2
 */
@Data
@Value(staticConstructor = "commandOf")
public class ACmd {
    private String msg;
    private Integer step;
}
