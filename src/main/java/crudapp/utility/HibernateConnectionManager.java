package crudapp.utility;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionManager {

	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() throws HibernateException{
		if(sessionFactory == null) {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		}
		
		return sessionFactory;
	}

}
