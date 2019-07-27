package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
						 .configure("hibernate.cfg.xml")
						 .addAnnotatedClass(Instructor.class)
						 .addAnnotatedClass(InstructorDetail.class)
						 .addAnnotatedClass(Course.class)
						 .addAnnotatedClass(Review.class)
						 .addAnnotatedClass(Student.class)
						 .buildSessionFactory();
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {		

			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one million points");
			
			
			
			// save the course ... and leverage the cascade all :-)
			System.out.println("\nSaving the course.....");
			session.save(tempCourse);
			System.out.println("\nSaved the course.....");
			
			// create the students
			Student theStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student theStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student theStudent3 = new Student("John2", "Doe2", "john@luv2code.com");
			
			// add students to the course
			tempCourse.addStudent(theStudent1);
			tempCourse.addStudent(theStudent2);
			tempCourse.addStudent(theStudent3);
			
			// save the students
			System.out.println("\nSaving the students");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			System.out.println("\nSaved the students: " + tempCourse.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done~~");
		} finally {
			session.close();
			factory.close();
		}

	}

}
