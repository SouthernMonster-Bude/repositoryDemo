package o.h.j.m.strategymod.m.pay;

import o.h.j.m.strategymod.m.pay.type.PayType;

public interface IPayService {
    public PayType payType();
    void pay();
}
