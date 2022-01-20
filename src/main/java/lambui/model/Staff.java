package lambui.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Plz enter your name")
    @Size(max = 23, min = 2, message = "min 2 max 23")
    private String name;
    @NotEmpty(message = "Not null")
    private String staff_code;
    @Min(value = 18, message = "chua du 18t")
    @Max(value = 65, message = "qua tuoi lao dong roi, nghi huu thoi")
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
