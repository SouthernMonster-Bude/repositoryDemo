package o.h.j.m.luckymoney.service;

import o.h.j.m.luckymoney.dao.LuckymoneyDAO;
import o.h.j.m.luckymoney.vo.Luckymoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckmoneyService {
    @Autowired
    private LuckymoneyDAO luckymoneyDAO;

    /**
     * 事务 数据库的事务 要考虑数据库是否也支持事务
     *
     */
    @Transactional
    public void createTow(){
        Luckymoney luck1 = new Luckymoney();
        luck1.setProducer("阿童木");
        luck1.setConsumer("心雨 ");
        luck1.setMoney(new BigDecimal(520));
        luckymoneyDAO.save(luck1);
        Luckymoney luck2 = new Luckymoney();
        luck2.setProducer("阿童木");
        luck2.setConsumer("心雨");
        luck2.setMoney(new BigDecimal(1314));
        luckymoneyDAO.save(luck2);
    }
}
