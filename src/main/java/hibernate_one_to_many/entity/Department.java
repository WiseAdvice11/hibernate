package hibernate_one_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String departmentName;
    @Column(name = "min_salary")
    private  int minSalary;
    @Column(name = "max_salary")
    private  int maxSalary;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public void addEmployeeToDepartment(Employee employee){
        employees.add(employee);
        employee.setDepartment(this);


    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(String departmentName, int minSalary, int maxSalary) {
        this.departmentName = departmentName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;

    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
