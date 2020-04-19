package com.hjm.mod.utils.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.hjm.mod.utils.excel.listener.DemoDataListener;
import com.hjm.mod.utils.excel.strategy.DemoStyleStrategy;
import com.hjm.mod.utils.excel.vo.DemoData;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Houjiemu
 * @create 2020-04-19 20:43
 */
public class DemoExcel {

    @Test
    public void function() throws FileNotFoundException {
        String fileName = "D:/GitRepository/reposioryDemo/spring/DemoProject/SpringDemo02/src/main/resources/excel/out/百家姓随机姓名.xlsx";
        // 根据用户传入字段 假设我们要忽略 date
        WriteCellStyle errorWriteCellStyle = new WriteCellStyle();
        errorWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        errorWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        DemoStyleStrategy demoStyleStrategy = new DemoStyleStrategy(errorWriteCellStyle);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).registerWriteHandler(demoStyleStrategy).sheet("模板")
                .doWrite(data());

    }

    public List data() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("D:/GitRepository/reposioryDemo/spring/DemoProject/SpringDemo02/src/main/resources/excel/百家姓随机姓名.xlsx");
        List<Object> list = EasyExcel.read(fis, DemoData.class, new DemoDataListener()).sheet("学生表").doReadSync();

        Map<String, Integer> nameNumMap = new HashMap<>();
        List<DemoData> datalist = list.stream().map((item) -> {
//        List<DemoData> datalist = list.parallelStream().map((item) -> {
            DemoData data = (DemoData) item;
            if (!nameNumMap.containsKey(data.getName())) {
                nameNumMap.put(data.getName(), 1);
            } else {
                nameNumMap.put(data.getName(), nameNumMap.get(data.getName()) + 1);
            }
            return data;
        }).collect(Collectors.toList());
        System.out.println();
        datalist = datalist.stream().map((item) -> {
//        datalist = datalist.parallelStream().map((item) -> {
            if (nameNumMap.containsKey(item.getName())&&nameNumMap.get(item.getName())>1) {
                item.setRepeat(4001);
                System.out.println("name repeat ：" + item.getName()+", "+nameNumMap.get(item.getName()));
            }
            return item;
        }).collect(Collectors.toList());
        return datalist;
    }

}
