package Callableuse;

import java.util.concurrent.Callable;

/**
 * 实现callable接口
 * @author admin_cg
 * @date 2020/8/9 14:54
 */
public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        return false;
    }
}
