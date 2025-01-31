package hibernate_test;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {


    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Alexandr", "Ivanov", "IT", 1000);
//            Employee emp2 = new Employee("Mikhail", "Ovechkin", "HR", 750);


            session.beginTransaction();
            session.save(emp);
//            session.save(emp2);

            session.getTransaction().commit();


            System.out.println("The opreation is done !!!");
            System.out.println("The employee is: " + emp);

        } finally {
            factory.close();
        }

    }

}

