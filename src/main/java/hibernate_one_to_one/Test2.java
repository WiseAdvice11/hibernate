package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {

            session = factory.getCurrentSession();
//            Employee emp = new Employee("Sergey","Bezrukov","movie",1200);
//            Detail detail = new Detail("Moscow","500-500","berezki@mail.ru");
//            emp.setEmpDetail(detail);
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
//            session.save(emp);
            session.delete(employee);
            session.getTransaction().commit();
            System.out.println(employee);
        } finally {
            session.close();
            factory.close();
        }
    }
}