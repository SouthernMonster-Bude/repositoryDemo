package o.h.j.m.luckymoney.controller;

import o.h.j.m.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

//@RestController//可以直接返回String
@Controller//只使用@Controller无法返回String，需要@ResponseBody模板
//@ResponseBody 这里使用 则会导致controller内部的方法只能返回对象不能反回模板
@RequestMapping("hey")
public class HelloController {

//    @Value("${minMoney}")
//    private BigDecimal minMoney;
//    @Value("${description}")
//    private String description;

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "大家好！minMoney:"+limitConfig.getMinMoney()+"，说明："+limitConfig.getDescription();
    }
    @PostMapping("/des")
    @ResponseBody
    public String des(){
        return "说明："+limitConfig.getDescription();
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/num/{id}/{second}")
    @ResponseBody
    public String num(@PathVariable("id") Integer id,
                      @PathVariable(value = "second") Integer second){
        return "id: "+id+", second: "+second;
    }
    @GetMapping("/num2")
    @ResponseBody
    public String num2(@RequestParam("id") Integer id,
                      @RequestParam(value = "second",required = false ,defaultValue = "default") String second){
        return "id: "+id+", second: "+second;
    }

}
