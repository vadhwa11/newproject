package com.icg.util;

import org.hibernate.SessionFactory;

public class HibernateUtil {

private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
}
