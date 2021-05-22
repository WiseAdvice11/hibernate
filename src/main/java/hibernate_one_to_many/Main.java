package hibernate_one_to_many;


import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Main {



    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Employee.class)
                                                    .addAnnotatedClass(Department.class)
                                                    .buildSessionFactory();
        Session session= null;

        Department dep = new Department("IT",1500,3000);
        Employee employee1 = new Employee("Kanye","West",1499);
        Employee employee2 = new Employee("Slim","Shaddy",2999);

        dep.addEmployeeToDepartment(employee1);
        dep.addEmployeeToDepartment(employee2);

        try {
             session = factory.getCurrentSession();


            session.beginTransaction();
            Department department =session.get(Department.class,1);
            Employee emp = session.get(Employee.class,1);
            System.out.println(department);
            System.out.println(department.getEmployees());
//          session.save(dep);
            session.delete(department);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();

            List l = new ArrayList<>();
//            remove      как работает метод ?
        }

    }
}

