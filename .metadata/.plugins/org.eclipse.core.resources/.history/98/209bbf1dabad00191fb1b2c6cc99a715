package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
						 .configure("hibernate.cfg.xml")
						 .addAnnotatedClass(Student.class)
						 .buildSessionFactory();
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {		
			// create three student objs
			System.out.println("Creating 3 new student objects...");
			Student tempStuent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStuent2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student tempStuent3 = new Student("Bonita", "Applebum", "applebum@luv2code.com");
		
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStuent1);
			session.save(tempStuent2);
			session.save(tempStuent3);
			// commit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}
	
}
