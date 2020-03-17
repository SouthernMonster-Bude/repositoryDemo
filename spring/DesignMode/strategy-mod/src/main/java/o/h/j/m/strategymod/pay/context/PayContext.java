package o.h.j.m.strategymod.pay.context;

import o.h.j.m.strategymod.pay.IPayService;
import o.h.j.m.strategymod.pay.type.PayType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PayContext implements ApplicationContextAware {
    /***
     * 获取Sring容器
     */
    private ApplicationContext applicationContext;
    /***
     * 支付服务的map
     */
    private Map<PayType, IPayService> chooseMap = new HashMap<PayType, IPayService>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        registerPayType();
    }

    /**
     * 注册支付类型
     */
    public void registerPayType(){
        //获取支付的几个实现类
        Map<String,IPayService> payMap = applicationContext.getBeansOfType(IPayService.class);

        for (IPayService payService : payMap.values()){
            //把枚举类型支付方式和具体的策略实现关联起来
            chooseMap.put(payService.payType(),payService);
        }
    }

    public IPayService getPayMethod(PayType type){
        return chooseMap.get(type);
    }
}
