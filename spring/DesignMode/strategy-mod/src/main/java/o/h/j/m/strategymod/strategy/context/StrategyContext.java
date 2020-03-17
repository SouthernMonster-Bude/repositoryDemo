package o.h.j.m.strategymod.strategy.context;

import o.h.j.m.strategymod.strategy.IStrategy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;

public class StrategyContext {

    private IStrategy strategy;
    public StrategyContext(IStrategy strategy){
        this.strategy = strategy;
    }
    public void contextMethod(){
        System.out.println("StrategyContext contextMethod executed...");
        strategy.strategyMethod();
    }
//    HandlerAdapter
    DispatcherServlet
}

