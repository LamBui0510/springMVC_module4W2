package lambui.model;

import javax.persistence.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String staff_code;
    private int age;
    private double salary;
    @ManyToOne
    private Branch branch;

    public Staff() {
    }


    public Staff(String name, String staff_code, int age, double salary, Branch branch) {
        this.name = name;
        this.staff_code = staff_code;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
