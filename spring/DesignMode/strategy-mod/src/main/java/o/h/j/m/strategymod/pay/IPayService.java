package o.h.j.m.strategymod.pay;

import o.h.j.m.strategymod.pay.type.PayType;

public interface IPayService {
    PayType payType();
    void pay();
}
