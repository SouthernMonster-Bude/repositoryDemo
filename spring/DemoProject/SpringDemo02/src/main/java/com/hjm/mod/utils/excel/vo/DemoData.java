package com.hjm.mod.utils.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * @author Houjiemu
 * @create 2020-04-19 15:47
 */
@Data
public class DemoData {
    @ExcelProperty(value = "学号", index = 0)
    private Integer id;
    @ExcelProperty(value ="姓名", index = 1)
    private String name;
    @ExcelProperty(value ="年龄", index = 2)
    private Integer age;
    @ExcelProperty(value ="班级", index = 3)
    private String classId;
    @ExcelProperty(value ="学校", index = 4)
    private String school;
    @ExcelProperty(value ="性别", index = 5)
    private Integer sex;
    @ColumnWidth(0)
    @ExcelProperty(value ="名称重复", index = 6)
    private Integer repeat;

}
