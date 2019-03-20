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
		Wiki w2 = new Wiki("Sidney Crosby",
				"Crosby debuted in the NHL during the 2005–2006 season, recording 102 points and finishing as runner-up for the Calder Memorial Trophy as the NHL Rookie of the Year. By his second season, he led the NHL with 120 points to capture the Art Ross Trophy, becoming the youngest player and the only teenager to win a scoring title in any major North American sports league. That same season, Crosby won the Hart Memorial Trophy as the league's most valuable player (MVP) and the Lester B. Pearson Award for most outstanding player as judged by his peers. He started the 2007–08 season with the team's captaincy and subsequently led them to the 2008 Stanley Cup Finals, where they were defeated by the Detroit Red Wings in six games. The Penguins returned to the Finals against Detroit the following year and won in seven games; Crosby became the youngest captain in NHL history to win the Stanley Cup. In 2009–10, he received the Mark Messier Leadership Award and scored 51 goals, winning the Maurice Richard Trophy as the NHL's leading goal scorer. In early 2011, Crosby sustained a concussion that left him sidelined for the rest of the season and for most of the 2011–12 campaign. In 2014, Crosby again won the Hart Memorial Trophy as well as his second Art Ross Trophy (104 points) and his third Ted Lindsay Award. Crosby led Pittsburgh to Stanley Cup championships in 2016 and 2017, becoming the third player to win the Conn Smythe Trophy (playoff MVP) in consecutive years. In 2017, he also captured his second Richard Trophy and was named one of the 100 Greatest NHL Players in history.",
				"/images/sidney-crosby.jpg");
		Wiki w3 = new Wiki("Wayne Gretzky", "Wore #99, most points, has more assists than anyone has points!",
				"/images/wayne-gretzky.jpg");
		Wiki w4 = new Wiki("World War II", "The second World war began in 1939", "/images/ww2.jpg");
		Wiki w5 = new Wiki("Daddy Yankee", "The King of Reggaeton, born in Puerto Rico.", "/images/dy.jpg");
		Wiki w6 = new Wiki("Spring Framework",
				"The Spring Framework is an application framework and inversion of control container for the Java platform.",
				"/images/spring.png");

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
