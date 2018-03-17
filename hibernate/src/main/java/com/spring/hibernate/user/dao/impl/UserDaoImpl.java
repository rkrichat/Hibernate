package com.spring.hibernate.user.dao.impl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.spring.bean.UserInformation;
import com.spring.hibernate.user.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public String getUserDetail(String id){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserInformation.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			return session.get(UserInformation.class, id).toString();			
		}catch(Exception exception) {
			System.out.println(exception);
		}finally {
			factory.close();
		}
		return "Error while get user detail";
	}

	@Override
	public String updateUserDetail(UserInformation bean){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserInformation.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery("UPDATE UserInformation SET name = :name WHERE id = :id");
			query.setParameter("name", bean.getName());
			query.setParameter("id", bean.getId());
			query.executeUpdate();
			session.getTransaction().commit();
			return "Update Successfully";
		}catch(Exception exception) {
			session.getTransaction().rollback();
			System.out.println(exception);
		}finally {
			factory.close();
		}
		return "Error while update user detail";
	}

	@Override
	public String createUser(UserInformation bean){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserInformation.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(bean);
			session.getTransaction().commit();
			return "User was created Successfully";
		}catch(Exception exception) {
			session.getTransaction().rollback();
			System.out.println(exception);
		}finally{
			factory.close();
		}
		return "Error while creat user";
	}

	@Override
	public String deleteUser(UserInformation bean){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserInformation.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(bean);
			session.getTransaction().commit();
			return "User was deleted Successfully";
		}catch(Exception exception) {
			session.getTransaction().rollback();
			System.out.println(exception);
		}finally {
			factory.close();
		}
		return "Error while delete user detail";
	}
}
