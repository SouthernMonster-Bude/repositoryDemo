package com.hjm.webdemo.dao;

import com.hjm.webdemo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employeeMap = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(30200,new Employee(1500,"AA00","124222@QQ.COM",1,100000,new Date()));
        employeeMap.put(30201,new Employee(1501,"AA01","124213@QQ.COM",0,100001,new Date()));
        employeeMap.put(30202,new Employee(1502,"AA02","124415@QQ.COM",0,100002,new Date()));
        employeeMap.put(30203,new Employee(1503,"AA03","552151@QQ.COM",0,100003,new Date()));
        employeeMap.put(30204,new Employee(1504,"AA04","559157@QQ.COM",1,100004,new Date()));
        employeeMap.put(30205,new Employee(1505,"AA05","854215@QQ.COM",1,100005,new Date()));
    }

    private static Integer iniId = 30200;
    //保存员工信息
    public void save(Employee emp){
        while (getEmployeeById(iniId)!=null){
            iniId++;
        }
        employeeMap.put(iniId,emp);
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }
    //全部员工信息
    public Collection<Employee> getAllEmployee(){
        return employeeMap.values();
    }

    public void delete(Integer id){
        employeeMap.remove(id);
    }

}
