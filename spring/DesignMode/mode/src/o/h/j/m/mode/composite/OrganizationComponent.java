package o.h.j.m.mode.composite;

//学校 学院 系 都视为一种组织
//学校聚合学院 学院聚合系
public abstract class OrganizationComponent {
    private String name;
    private String des;

    public abstract void print();

    public OrganizationComponent(){}

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }
    public void add(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }
    public void remove(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
