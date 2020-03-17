package o.h.j.m.mode.composite;

//叶子结点 不需要重写增删功能
public class Department extends OrganizationComponent{
    public Department(String name, String des){
        super(name,des);
    }
    @Override
    public void print() {
        System.out.println("***"+getName()+"***");
    }
    @Override
    public String getName(){
        return super.getName();
    }
    @Override
    public String getDes(){
        return super.getDes();
    }

}
