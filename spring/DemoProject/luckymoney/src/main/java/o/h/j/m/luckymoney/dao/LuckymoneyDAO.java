package o.h.j.m.luckymoney.dao;

import o.h.j.m.luckymoney.vo.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyDAO extends JpaRepository<Luckymoney,Integer> {

}
