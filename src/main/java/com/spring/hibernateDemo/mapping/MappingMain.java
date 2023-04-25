package com.spring.hibernateDemo.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.buildSessionFactory();
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(444);
		answer1.setAnswer("python is a language");
		
		
		Question question1 = new Question();
		question1.setQuestionId(4);
		question1.setQuestion("what is python?");
		question1.setAnswer(answer1);
		
		answer1.setQuestion(question1); //setting question through answer
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.save(question1);
		session.save(answer1);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
		

	}

}
