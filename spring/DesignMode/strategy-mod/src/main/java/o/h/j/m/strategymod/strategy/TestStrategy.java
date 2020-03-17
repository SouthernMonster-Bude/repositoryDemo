package o.h.j.m.strategymod.strategy;

import o.h.j.m.strategymod.strategy.context.StrategyContext;

//标准的策略模式
public class TestStrategy {
    public static void main(String[] args) {
        IStrategy strategyA = new StrategyA();
        StrategyContext contextA = new StrategyContext(strategyA);
        contextA.contextMethod();

        IStrategy strategyB = new StrategyB();
        StrategyContext contextB = new StrategyContext(strategyB);
        contextB.contextMethod();

        IStrategy strategyC = new StrategyC();
        StrategyContext contextC = new StrategyContext(strategyC);
        contextC.contextMethod();
    }
}
