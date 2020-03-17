package o.h.j.m.templatemod.template;
/**
 * 模板设计模式 实现 游戏开发流程
 */
public abstract class GameDeveloper {
    /**
     * 开发游戏的模式
     */
    public final void work(){
        plan();
        design();
        prepare();
        code();
        test();
        pack();
        run();
    }
    /**
     * 策划
     */
    protected abstract void plan();
    /**
     * 美术设计
     */
    protected abstract void design();
    /**
     * 素材准备
     */
    protected abstract void prepare();
    /**
     * 编码工作
     */
    protected abstract void code();
    /**
     * 测试
     */
    protected abstract void test();
    /**
     * 打包发布
     */
    protected abstract void pack();
    /**
     * 线上运行
     */
    protected abstract void run();
}
