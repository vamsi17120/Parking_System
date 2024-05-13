package Models;

public class Operator extends BaseModel {

    private String name;

    private int empId;

    public Operator(String name, int id) {
        this.name = name;
        empId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

}
