package com.hjm.webdemo.dao;

import com.hjm.webdemo.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(10000,new Department(100,"教学部"));
        departmentMap.put(10001,new Department(101,"教学部"));
        departmentMap.put(10002,new Department(102,"教学部"));
        departmentMap.put(10003,new Department(103,"教学部"));
        departmentMap.put(10004,new Department(104,"教学部"));
        departmentMap.put(10005,new Department(105,"教学部"));
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
