package hibernateTest2;

import hibernateTest2.entity.Detail;
import hibernateTest2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Employee.class)
                                                    .addAnnotatedClass(Detail.class)
                                                    .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Гоша","Куценко","movie",500);
            Detail detail = new Detail("Saransk","333666","goshan@mail.ru");
            emp.setEmpDetail(detail);
            session.beginTransaction();

            session.save(emp);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}

