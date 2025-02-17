package hibernate_test;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test6 {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            session.createQuery("update Employee set salary = 2000 where first_name ='Vladimir'");

            session.getTransaction().commit();
            System.out.println("Done !!!");

            System.out.println("Ich find dich schaisse !!! Schaissegal");

        } finally {

            factory.close();
        }

    }

}





