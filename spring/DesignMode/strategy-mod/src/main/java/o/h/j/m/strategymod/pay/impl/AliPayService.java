package o.h.j.m.strategymod.pay.impl;

import o.h.j.m.strategymod.pay.IPayService;
import o.h.j.m.strategymod.pay.type.PayType;
import org.springframework.stereotype.Component;

@Component
public class AliPayService implements IPayService {
    @Override
    public PayType payType() {
        return PayType.ALIPAY;
    }

    @Override
    public void pay() {
        System.out.println("AliPayService pay...");
    }
}
