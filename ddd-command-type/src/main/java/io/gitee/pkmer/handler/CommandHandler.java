package io.gitee.pkmer.handler;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/developeros/videos-online">Code Repository</a>
 * At 2025/1/2
 */
public interface CommandHandler<T,R> {
    R handle(T t);
}
