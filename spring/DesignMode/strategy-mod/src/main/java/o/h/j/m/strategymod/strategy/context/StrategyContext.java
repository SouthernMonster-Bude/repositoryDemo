package o.h.j.m.strategymod.m.strategy.context;

import o.h.j.m.strategy.IStrategy;

public class StrategyContext {

    private IStrategy strategy;
    public StrategyContext(IStrategy strategy){
        this.strategy = strategy;
    }
    public void contextMethod(){
        System.out.println("StrategyContext contextMethod executed...");
        strategy.strategyMethod();
    }
}
