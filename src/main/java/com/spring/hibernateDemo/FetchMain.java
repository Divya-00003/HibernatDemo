package com.spring.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchMain {

	public static void main(String[] args) {
		// get and load example
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Address.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        //get() student with id 6666
        Student student1 = session.get(Student.class, 6666);
        //load() student with id 6666
        Student student2 = session.load(Student.class, 6666);
        
        Address address1 = session.get(Address.class, 1);
        
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(address1.getAddressId()+":  "+ address1.getCity());
        
        session.close();
        sessionFactory.close();
        

	}

}
