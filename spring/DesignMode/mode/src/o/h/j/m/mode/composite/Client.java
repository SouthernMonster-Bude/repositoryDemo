package o.h.j.m.mode.composite;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        OrganizationComponent university = new University("清华大学","中国第一大学");

        OrganizationComponent college1 = new College("计算机学院","计算机学院");
        OrganizationComponent college2 = new College("美术学院","美术学院");
        university.add(college1);
        university.add(college2);

        OrganizationComponent department11 = new Department("软件工程","软件工程");
        OrganizationComponent department12 = new Department("信息工程","信息工程");
        OrganizationComponent department13 = new Department("计算机科学与技术","计算机科学与技术");
        college1.add(department11);
        college1.add(department12);
        college1.add(department13);

        OrganizationComponent department21 = new Department("素描专业","素描专业");
        OrganizationComponent department22 = new Department("产品设计","产品设计");
        OrganizationComponent department23 = new Department("UI设计","UI设计");
        college2.add(department21);
        college2.add(department22);
        college2.add(department23);

        university.print();


//        HashMap
    }
}
