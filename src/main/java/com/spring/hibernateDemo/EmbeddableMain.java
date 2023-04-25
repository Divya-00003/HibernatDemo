package com.spring.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbeddableMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Certification.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Certification certi = new Certification();
        certi.setCourse("java");
        certi.setDuration("5 hours");
        
        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("Messi");
        student1.setCity("Arjentina");
        student1.setCerti(certi);
        
        session.save(student1);
        
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        
        

	}

}
