package hibernateTest;

import hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {



    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {

            Session  session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp = session.get(Employee.class,12);
//            emp.setSalary(100500);
            session.createQuery("update Employee SET salary = 1000" + " where name = 'Варвара'   ").executeUpdate();

            session.getTransaction().commit();





        } finally {
            factory.close();
        }
    }
}

