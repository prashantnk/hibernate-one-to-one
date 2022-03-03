package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class BiDirInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int Iid = 3;
			InstructorDetail id = session.get(InstructorDetail.class, Iid);

			System.out.println(id);
			System.out.println(id.getInstructor());

//			deleting only instruction detail

			id.getInstructor().setInstructorDetail(null);

			session.delete(id);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

}
