package edu.wayne.cs.raptor;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** Should there be a class that serves an entity in the system which gets current session from
 *  HibernateUtil and operate ...
 *
 *  saves, searches for a Patient
 *  should implement other similar classes for User / Encounter / Med ?
 * 
 * @author Ramez
 *
 */
public class HibernateUtil {
	
	private static final SessionFactory sess = buildSessionFactory();
	
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory(){
		try {
			// Create session factory from hibernate.cfg.xml
			return  new Configuration().configure().buildSessionFactory();     // maybe changed to annontation configuration
		}
		catch (Throwable ex){
			// Log the exception since it might be swallowed 
			System.err.println("Initial SessionFactory creation failed." +ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sess;
	}
	


}