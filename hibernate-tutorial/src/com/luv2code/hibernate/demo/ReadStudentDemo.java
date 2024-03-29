package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
						 .configure("hibernate.cfg.xml")
						 .addAnnotatedClass(Student.class)
						 .buildSessionFactory();
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {		
			// create a student obj
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// My new code
			
			// find out the students id: primary key
			System.out.println("Saved student. Generated ID: " + tempStudent.getId());
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Committed and Done...");

		}finally {
			factory.close();
		}

	}

}
