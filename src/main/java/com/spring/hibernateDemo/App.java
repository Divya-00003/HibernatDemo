package com.spring.hibernateDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Address.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        //create student
        Student student= new Student();
        student.setId(3333);
        student.setName("Rahul");
        student.setCity("Banglore");
        
        //create address
        Address address1 = new Address();
        address1.setStreet("1st main,mandipete");
        address1.setCity("Ballari");
        address1.setOpen(true);
        address1.setX(244.87);
        address1.setAddressDate(new Date());
        
        //read and save image
        //FileInputStream fileInputStream = new FileInputStream("src/main/java/image1.jpg");
        //byte[] data = new byte[fileInputStream.available()];
        //fileInputStream.read(data);
        //address1.setImage(data);
        
      
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.save(student);
        session.save(address1);
        session.getTransaction().commit();
        
        session.close();
        sessionFactory.close();
        
        
        
    }
}
