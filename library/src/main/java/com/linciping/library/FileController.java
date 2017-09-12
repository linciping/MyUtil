package com.linciping.library;

/**
 * @author linciping
 * @date 2017/9/8
 * @note 文件控制器
 */
public interface FileController {

    /**
     * 获取文件路径成功
     * @param path 文件路径
     */
    void onPath(String path);

    /**
     * 获取文件路径发生错误
     * @param message 错误信息
     */
    void onFailed(String message);
}
