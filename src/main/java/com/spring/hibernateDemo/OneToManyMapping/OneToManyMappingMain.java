package com.spring.hibernateDemo.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMappingMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.buildSessionFactory();
		
	
		Question question1 = new Question();
		question1.setQuestionId(8888);
		question1.setQuestion("what is java?");
		
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(801);
		answer1.setAnswer("java is a language");
		answer1.setQuestion(question1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(802);
		answer2.setAnswer("java is a platform indipendent language");
		answer2.setQuestion(question1);
		
		Answer answer3 = new Answer();
		answer3.setAnswerId(803);
		answer3.setAnswer("java is a popular language");
		answer3.setQuestion(question1);
		
		List<Answer> allAnswers = new ArrayList<Answer>();
		allAnswers.add(answer1);
		allAnswers.add(answer2);
		allAnswers.add(answer3);
		
		question1.setAnswers(allAnswers);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(question1);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		
		
		session.getTransaction().commit();
		
		Question question = session.get(Question.class, 8888);
		
		//lazy loading ... Eager loading example
		//if we see query in console it writes query to select only questionId and question
		System.out.println(question.getQuestionId());
		System.out.println(question.getQuestion());
		
		//if u see in console hibernate generated query to get answers also
		//this is kind of lazy loading
		System.out.println(question.getAnswers().size());
		
		//after setting fetch=EAGER
		System.out.println(question.getQuestionId());
		
		session.close();
		sessionFactory.close();
		
		
		

	}

}
