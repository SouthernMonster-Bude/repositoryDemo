package o.h.j.m.strategymod;

import o.h.j.m.strategymod.pay.context.PayContext;
import o.h.j.m.strategymod.pay.type.PayType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StrategyModApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StrategyModApplication.class, args);
        PayContext payContext = context.getBean(PayContext.class);
        payContext.getPayMethod(PayType.ALIPAY).pay();
        payContext.getPayMethod(PayType.WXPAY).pay();
        payContext.getPayMethod(PayType.ZHPAY).pay();
    }

}
