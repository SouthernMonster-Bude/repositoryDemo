package o.h.j.m.strategymod.m.pay.impl;

import o.h.j.m.strategymod.m.pay.IPayService;
import o.h.j.m.strategymod.m.pay.type.PayType;
import org.springframework.stereotype.Component;

@Component
public class ZHPayService implements IPayService {
    @Override
    public PayType payType() {
        return PayType.ZHPAY;
    }

    @Override
    public void pay() {
        System.out.println("ZHPayService pay...");
    }
}