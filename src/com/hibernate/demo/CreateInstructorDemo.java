package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor i = new Instructor("p", "r", "pn@gmail.com");
			InstructorDetail id = new InstructorDetail("pn", "w m");

			i.setInstructorDetail(id);

			System.out.println("i : " + i);

			session.beginTransaction();

			session.save(i);

			session.getTransaction().commit();

			System.out.println("i : " + i);

		} finally {
			factory.close();
		}
	}

}
