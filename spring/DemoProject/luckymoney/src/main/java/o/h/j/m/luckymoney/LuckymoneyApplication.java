package o.h.j.m.luckymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;

@SpringBootApplication
public class LuckymoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckymoneyApplication.class, args);
    }

}
