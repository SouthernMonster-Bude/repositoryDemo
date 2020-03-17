package o.h.j.m.strategymod.m.pay.impl;

import o.h.j.m.strategymod.m.pay.IPayService;
import o.h.j.m.strategymod.m.pay.type.PayType;
import org.springframework.stereotype.Component;

@Component
public class WXPayService implements IPayService {
    @Override
    public PayType payType() {
        return PayType.WXPAY;
    }

    @Override
    public void pay() {
        System.out.println("WXPayService pay...");
    }
}