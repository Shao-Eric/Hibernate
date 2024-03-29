package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("mary's courses: " + tempStudent.getCourses());
			
			
			// create courses
			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game development");
			
			// add student to course
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			System.out.println("mary's courses: " + tempStudent.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done~~");
		} finally {
			session.close();
			factory.close();
		}

	}

}
