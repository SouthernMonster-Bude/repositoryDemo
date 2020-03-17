package com.hjm.webdemo.dao;

import com.hjm.webdemo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(10000,new Department(600,"教学部"));
        departmentMap.put(10001,new Department(601,"后勤部"));
        departmentMap.put(10002,new Department(602,"活动部"));
        departmentMap.put(10003,new Department(603,"宣传部"));
        departmentMap.put(10004,new Department(604,"科研部"));
        departmentMap.put(10005,new Department(605,"体育部"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    //获得部门信息
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }


}
