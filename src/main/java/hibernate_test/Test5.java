package hibernate_test;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


//            Employee emp = session.get(Employee.class, 2);
//            session.delete(emp);

            session.createQuery("delete Employee where first_name='Elena'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("This is done !!!");

        } finally {
            factory.close();
        }
    }
}
