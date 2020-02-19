package o.h.j.m.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ElasticSearchApplication {


    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

}
