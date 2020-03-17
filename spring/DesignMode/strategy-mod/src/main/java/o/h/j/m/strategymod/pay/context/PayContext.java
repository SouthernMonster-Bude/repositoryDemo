package o.h.j.m.strategymod.m.pay.context;

import o.h.j.m.strategymod.m.pay.IPayService;
import o.h.j.m.strategymod.m.pay.type.PayType;
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
    }

    /**
     * 注册支付类型
     */
    public void registerPayType(){
        Map<String,IPayService> payMap = applicationContext.getBeansOfType(IPayService.class);

        for (IPayService payService : payMap.values()){
            chooseMap.put(payService.payType(),payService);
        }
    }
}
