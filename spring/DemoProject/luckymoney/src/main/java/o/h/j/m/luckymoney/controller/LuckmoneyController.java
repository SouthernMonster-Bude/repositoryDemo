package o.h.j.m.luckymoney.controller;

import com.google.gson.Gson;
import o.h.j.m.luckymoney.dao.LuckymoneyDAO;
import o.h.j.m.luckymoney.service.LuckmoneyService;
import o.h.j.m.luckymoney.vo.Luckymoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("luck")
public class LuckmoneyController {
    @Autowired
    private LuckymoneyDAO luckymoneyDAO;
    @Autowired
    private LuckmoneyService luckmoneyService;

    private Gson gson = new Gson();
    @GetMapping("luckmoneys")
    public List<Luckymoney> getAll(){
        return luckymoneyDAO.findAll();
    }
    @PostMapping("luckmoneys")
    public Luckymoney create(Luckymoney luckm){
        return luckymoneyDAO.save(luckm);
    }
    @RequestMapping("luckmoneys/{id}")
    public Luckymoney find(@PathVariable("id") Integer id){
        return luckymoneyDAO.findById(id).orElse(null);
    }
    @PutMapping("luckmoneys/{id}")
    public Luckymoney update(Luckymoney luckm){
        Optional<Luckymoney> lm = luckymoneyDAO.findById(luckm.getId());
        Map<String,Object> map = gson.fromJson(gson.toJson(luckm), HashMap.class);
        if(lm.isPresent()){
            Luckymoney oldLuck = lm.get();
            Map<String,Object> map2 = gson.fromJson(gson.toJson(oldLuck), HashMap.class);
            for(String key:map.keySet()){
                Object value = map.get(key);
                if(value!=null){
                    map2.put(key,value);
                }
            }
            luckm = gson.fromJson(gson.toJson(map2), Luckymoney.class);
        }

        return luckymoneyDAO.save(luckm);
    }
    @PostMapping("luckmoneys/tow")
    public void createTow(){
        luckmoneyService.createTow();
    }
}
