package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Student;
import ca.sheridancollege.beans.Wiki;

public class StudentDAO implements DAO {
	// Opens Database session
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void Populate() {
		Session session = sessionFactory.openSession();

		Wiki w1 = new Wiki("Alexander Ovechkin", "The Great 8", "/images/alex-ovechkin.jpg");
		Wiki w2 = new Wiki("Sidney Crosby", "Sid the Kid", "/images/sidney-crosby.jpg");
		Wiki w3 = new Wiki("Wayne Gretzky", "Wore #99, most points, has more assists than anyone has points!", "/images/wayne-gretzky.jpg");
		Wiki w4 = new Wiki("World War II", "The second World war began in 1939", "/images/ww2.jpg");
		Wiki w5 = new Wiki("Daddy Yankee", "The King of Reggaeton, born in Puerto Rico.", "/images/dy.jpg");
		Wiki w6 = new Wiki("Spring Framework", "The Spring Framework is an application framework and inversion of control container for the Java platform.", "/images/spring.png");
		
		session.saveOrUpdate(w1);
		session.saveOrUpdate(w2);
		session.saveOrUpdate(w3);
		session.saveOrUpdate(w4);
		session.saveOrUpdate(w5);
		session.saveOrUpdate(w6);
		// transaction
		session.beginTransaction();

		session.getTransaction().commit();
		session.close();
	}
	
	public List<Wiki> getWikiList() {
		Session session = sessionFactory.openSession();

		// transaction
		session.beginTransaction();

		Query query = session.createNamedQuery("Wiki.getWikiList");
		List<Wiki> wikiList = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return wikiList;
	}
	
	public void deleteWiki(Long wikiId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Wiki toDelete = session.get(Wiki.class, wikiId);
		session.delete(toDelete);

		session.getTransaction().commit();
		session.close();
	}
	
	public void insertWiki(Wiki wiki) {
		Session session = sessionFactory.openSession();

		// transaction
		session.beginTransaction();

		session.saveOrUpdate(wiki);

		session.getTransaction().commit();
		session.close();
	}
}
