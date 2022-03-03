package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor i = session.get(Instructor.class, 3);

			InstructorDetail id = new InstructorDetail("p", "p");

			System.out.println(i);
//			session.delete(i);

			i.setInstructorDetail(session.get(InstructorDetail.class, 4));

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
