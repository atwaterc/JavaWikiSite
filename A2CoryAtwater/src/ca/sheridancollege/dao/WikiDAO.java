package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Wiki;

public class WikiDAO implements DAO {
	// Opens Database session
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void Populate() {
		Session session = sessionFactory.openSession();

		Wiki w1 = new Wiki("Alexander Ovechkin", "Sports", "Alexander Mikhaylovich Ovechkin was born on September 17, 1985, in Moscow, Russia. He's the son of well-known Soviet-era athletes. His mother, Tatyana, excelled at basketball and was a two-time Olympic gold medalist. His father, Mikhail, was a serious soccer player.\r\n" + 
				"\r\n" + 
				"Ovechkin's childhood was shaped by modesty. Not long after his birth, he moved with his family to the outskirts of Moscow, making a home in a tall high-rise building that was surrounded by a crumbling neighborhood. To escape his surroundings and strict public school, Ovechkin turned to hockey, pouring everything he had into the sport.\r\n" + 
				"\r\n" + 
				"By the age of 16, Ovechkin had begun playing with the Moscow Dynamo, a pro Russian team. A year later, he became the youngest member of Russia's national team.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Spurred to escape a Russian life that had already claimed his older brother, who died in a car crash, and was consuming his friends—many having become addicted to drugs—Ovechkin dreamed of playing in the NHL. In his bedroom, he carefully stashed away the cards of many players, including his idol, Mario Lemieux.\r\n" + 
				"\r\n" + 
				"Considered a hockey phenom in his native country, Ovechkin soon earned the praise of NHL scouts. As his game took off, his confidence soared. At the 2002 Under-18 World Championships in Slovakia, the young forward led the tournament with 14 goals in just eight games.\r\n" + 
				"\r\n" + 
				"\"It's the best hockey there is,\" Ovechkin said of the NHL. \"And I think I'm ready to play there, wherever I'm drafted.\"  In the end, the highly prized and touted Alex Ovechkin went No. 1 overall to the Washington Capitals in the 2004 NHL Draft.\r\n" + 
				"\r\n" + 
				"Forced to miss a year due to the league's season-long lockout, Ovechkin made his NHL debut with a bang in October 2005, potting two goals in just four minutes and checking an opponent so hard that he broke the glass partition. He went on to net 52 goals and register 54 assists that season (2005-06), winning the Calder Memorial Trophy as the league's Rookie of the Year.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"In the years since, the Russian superstar has only stepped up his dominance to become one of the NHL's most explosive and feared scorers. During the 2007-08 season, Ovechkin scored 65 times and dished out 47 assists to capture his first Hart Trophy as the league's MVP.\r\n" + 
				"\r\n" + 
				"The following season, Ovechkin won the Hart for the second (consecutive) time. He earned a third MVP honor following the 2012-13 season.", "/images/alex-ovechkin.jpg");
		Wiki w2 = new Wiki("Sidney Crosby", "Sports",
				"Crosby debuted in the NHL during the 2005–2006 season, recording 102 points and finishing as runner-up for the Calder Memorial Trophy as the NHL Rookie of the Year. By his second season, he led the NHL with 120 points to capture the Art Ross Trophy, becoming the youngest player and the only teenager to win a scoring title in any major North American sports league. That same season, Crosby won the Hart Memorial Trophy as the league's most valuable player (MVP) and the Lester B. Pearson Award for most outstanding player as judged by his peers. He started the 2007–08 season with the team's captaincy and subsequently led them to the 2008 Stanley Cup Finals, where they were defeated by the Detroit Red Wings in six games. The Penguins returned to the Finals against Detroit the following year and won in seven games; Crosby became the youngest captain in NHL history to win the Stanley Cup. In 2009–10, he received the Mark Messier Leadership Award and scored 51 goals, winning the Maurice Richard Trophy as the NHL's leading goal scorer. In early 2011, Crosby sustained a concussion that left him sidelined for the rest of the season and for most of the 2011–12 campaign. In 2014, Crosby again won the Hart Memorial Trophy as well as his second Art Ross Trophy (104 points) and his third Ted Lindsay Award. Crosby led Pittsburgh to Stanley Cup championships in 2016 and 2017, becoming the third player to win the Conn Smythe Trophy (playoff MVP) in consecutive years. In 2017, he also captured his second Richard Trophy and was named one of the 100 Greatest NHL Players in history.",
				"/images/sidney-crosby.jpg");
		Wiki w3 = new Wiki("Wayne Gretzky", "Sports", "Born in Brantford, Ontario in 1961, Wayne Gretzky learned to skate on a rink his father Walter built in the family’s backyard. Practicing for hours on end, it was here that a young Gretzky developed the skating, shooting and stickhandling techniques that appeared instinctive to so many over the course of his career.  At six years old, an already-impressive Gretzky joined a league filled with players four years his senior. He scored only one goal in his first season, but improved dramatically over the course of his minor league career and finished it off with an incredible 378-goal season.\r\n" + 
				"\r\n" + 
				"Gretzky continued to impress as a teenager, finishing second in scoring during his only full season in the OHA, then first in the 1978 World Junior Championships. It was during that 1977-1978 OHA season that Gretzky started wearing his now-iconic ‘99’, after his usual Gordie Howe-inspired ‘9’ was taken by another player.  Next came the pros. Rather than wait three seasons in the OHA before he became NHL-eligible, a seventeen-year-old Gretzky signed with the Indianapolis Racers of the WHA in the fall of 1978. His stint with the team was short-lived, however, as the franchise folded only 25 games into the season and Gretzky’s contract was sold to the Edmonton Oilers.\r\n" + 
				"\r\n" + 
				"The move would prove to be fortuitous, to say the least. Under coach Glen Sather, Gretzky and his Edmonton teammates (including NHL legends Mark Messier, Glenn Anderson, Jari Kurri, Paul Coffey, and Grant Fuhr) would go on to break virtually every scoring record imaginable, win four Stanley Cups, score 400 goals per season as a matter of routine, and set a precedent for NHL dominance the likes of which will probably never be seen again.",
				"/images/wayne-gretzky.jpg");
		Wiki w4 = new Wiki("World War II", "History", "World War II (often abbreviated to WWII or WW2), also known as the Second World War, was a global war that lasted from 1939 to 1945. The vast majority of the world's countries—including all the great powers—eventually formed two opposing military alliances: the Allies and the Axis. A state of total war emerged, directly involving more than 100 million people from over 30 countries. The major participants threw their entire economic, industrial, and scientific capabilities behind the war effort, blurring the distinction between civilian and military resources. World War II was the deadliest conflict in human history, marked by 50 to 85 million fatalities, most of whom were civilians in the Soviet Union and China. It included massacres, the genocide of the Holocaust, strategic bombing, premeditated death from starvation and disease, and the only use of nuclear weapons in war.[1][2][3][4]\r\n" + 
				"\r\n" + 
				"Japan, which aimed to dominate Asia and the Pacific, was at war with China by 1937,[5][b] though neither side had declared war on the other. World War II is generally said to have begun on 1 September 1939,[6] with the invasion of Poland by Germany and subsequent declarations of war on Germany by France and the United Kingdom. From late 1939 to early 1941, in a series of campaigns and treaties, Germany conquered or controlled much of continental Europe, and formed the Axis alliance with Italy and Japan. Under the Molotov–Ribbentrop Pact of August 1939, Germany and the Soviet Union partitioned and annexed territories of their European neighbours, Poland, Finland, Romania and the Baltic states. Following the onset of campaigns in North Africa and East Africa, and the fall of France in mid 1940, the war continued primarily between the European Axis powers and the British Empire. War in the Balkans, the aerial Battle of Britain, the Blitz, and the long Battle of the Atlantic followed", "/images/ww2.jpg");
		Wiki w5 = new Wiki("Daddy Yankee", "Music", "Ramón Luis Ayala Rodríguez (born February 3, 1977), known by his stage name Daddy Yankee, is a Puerto Rican singer, songwriter, rapper, actor, and record producer. Ayala was born in Río Piedras, Puerto Rico, and was raised in the neighborhood of Villa Kennedy Housing Projects.[4] Daddy Yankee is the artist who coined the word Reggaeton in 1994 to describe the new music genre that was emerging from Puerto Rico;[5][6] he is known as the \"King of Reggaetón\" by music critics and fans alike.[7]\r\n" + 
				"\r\n" + 
				"Ayala aspired to be a professional baseball player, and tried out for the Seattle Mariners of Major League Baseball.[4] Before he could be officially signed, he was hit by a stray round from an AK-47 rifle while taking a break from a studio recording session with reggaeton artist DJ Playero.[4] Ayala spent roughly one and a half years recovering from the wound; the bullet was never removed from his hip, and he credits the shooting incident with allowing him to focus entirely on a music career.[4] In 2004, Daddy Yankee released his international hit single \"Gasolina\", which is credited with introducing Reggaeton to audiences worldwide, and making the music genre a global phenomenon.[8] Since then, he has sold around 20 million records.[9] Daddy Yankee's album Barrio Fino made history when it became the top-selling Latin music album of the decade between 2000–2009.[10][11] In 2017, Daddy Yankee, in collaboration with Latin pop singer Luis Fonsi, released the hit single \"Despacito\". It became the first Spanish-language song to hit number 1 on the Billboard Hot 100 since \"Macarena\" in 1996.[12] The single gained global success. The video for \"Despacito\" on YouTube received its billionth view on April 20, 2017, and became the most watched video in YouTube's history. Its success led Daddy Yankee to become the most listened artist worldwide on the streaming service Spotify in June 2017, the first Latin artist to do so", "/images/dy.jpg");
		Wiki w6 = new Wiki("Spring Framework", "Technology",
				"The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE (Enterprise Edition) platform. Although the framework does not impose any specific programming model, it has become popular in the Java community as an addition to, or even replacement for the Enterprise JavaBeans (EJB) model. The Spring Framework is open source.  The first version was written by Rod Johnson, who released the framework with the publication of his book Expert One-on-One J2EE Design and Development in October 2002. The framework was first released under the Apache 2.0 license in June 2003. The first milestone release, 1.0, was released in March 2004 with further milestone releases in September 2004 and March 2005. The Spring 1.2.6 framework won a Jolt productivity award and a JAX (Java API for XML) Innovation Award in 2006.[2][3] Spring 2.0 was released in October 2006, Spring 2.5 in November 2007, Spring 3.0 in December 2009, Spring 3.1 in December 2011, and Spring 3.2.5 in November 2013.[4] Spring Framework 4.0 was released in December 2013.[5] Notable improvements in Spring 4.0 included support for Java SE (Standard Edition) 8, Groovy 2, some aspects of Java EE 7, and WebSocket.\r\n" + 
				"\r\n" + 
				"Spring Framework 4.2.0 was released on 31 July 2015 and was immediately upgraded to version 4.2.1, which was released on 01 Sept 2015.[6] It is \"compatible with Java 6, 7 and 8, with a focus on core refinements and modern web capabilities\".[7]\r\n" + 
				"\r\n" + 
				"Spring Framework 4.3 has been released on 10 June 2016 and will be supported until 2020.[8] It \"will be the final generation within the general Spring 4 system requirements (Java 6+, Servlet 2.5+), [...]\".[9]\r\n" + 
				"\r\n" + 
				"Spring 5 is announced to be built upon Reactive Streams compatible Reactor Core.[10]",
				"/images/spring.png");

		Wiki w7 = new Wiki("War of 1812","History","The War of 1812 was a conflict fought between the United States, the United Kingdom, and their respective allies from June 1812 to February 1815. Historians in Britain often see it as a minor theater of the Napoleonic Wars; in the United States and Canada, it is seen as a war in its own right.\r\n" + 
				"\r\n" + 
				"From the outbreak of war with Napoleonic France, Britain had enforced a naval blockade to choke off neutral trade to France, which the US contested as illegal under international law. To man the blockade, Britain impressed American merchant sailors into the Royal Navy. Incidents such as the Chesapeake–Leopard affair, which happened five years before the war, inflamed anti-British sentiment in the US. In 1811, the British were in turn outraged by the Little Belt affair, in which 11 British sailors died.[9][10] Britain supplied Native Americans who raided American settlers on the frontier, hindering American expansion and provoking resentment.[11] Historians debate whether the desire to annex some or all of British North America (Canada) contributed to the American decision to go to war. On June 18, 1812, US President James Madison, after heavy pressure from the War Hawks in Congress, signed the American declaration of war into law.[12]\r\n" + 
				"\r\n" + 
				"With most of its army in Europe fighting Napoleon, Britain adopted a defensive strategy, with offensive operations initially limited to the border, and the western frontier. American prosecution of the war effort suffered from its unpopularity, especially in New England, where it was derogatorily referred to as \"Mr. Madison's War\". American defeats at the Siege of Detroit and the Battle of Queenston Heights thwarted attempts to seize Upper Canada, improving British morale. American attempts to invade Lower Canada and capture Montreal also failed. In 1813, the Americans won the Battle of Lake Erie, gaining control of the lake, and at the Battle of the Thames defeated Tecumseh's Confederacy, securing a primary war goal. A final American attempt to invade Canada was fought to a draw at the Battle of Lundy's Lane during the summer of 1814. At sea, the powerful Royal Navy blockaded American ports, cutting off trade and allowing the British to raid the coast at will. In 1814, one of these raids burned the capital, Washington, but the Americans later repulsed British attempts to invade New York and Maryland, ending invasions of the northern and mid-Atlantic United States from Canada.[13]\r\n" + 
				"\r\n" + 
				"Fighting also took place overseas in the Atlantic and Pacific oceans. In neighbouring Spanish Florida, a two-day battle for the city of Pensacola ended in Spanish surrender.[14]\r\n" + 
				"\r\n" + 
				"In Britain, there was mounting opposition to wartime taxation; merchants demanded to reopen trade with America. With the abdication of Napoleon, the war with France ended and Britain ceased impressment, rendering the issue of the impressment of American sailors moot. The British were then able to increase the strength of the blockade on the United States coast, annihilating American maritime trade, but attempts to invade the U.S. ended unsuccessfully, at which point both sides began to desire peace. [15]\r\n" + 
				"\r\n" + 
				"Peace negotiations began in August 1814, and the Treaty of Ghent was signed on December 24. News of the peace did not reach America for some time. Unaware of the treaty, British forces invaded Louisiana and were defeated at the Battle of New Orleans in January 1815. These late victories were viewed by Americans as having restored national honour, leading to the collapse of anti-war sentiment and the beginning of the Era of Good Feelings, a period of national unity. News of the treaty arrived shortly thereafter, halting military operations. The treaty was unanimously ratified by the US Senate on February 17, 1815, ending the war with no boundary changes.[16]","/images/war-1812.jpg");
		Wiki w8 = new Wiki("Ariana Grande","Music","Ariana Grande-Butera (born June 26, 1993)[2] is an American singer, songwriter and actress. After starring in the 2008 Broadway musical 13, she rose to prominence for her portrayal of Cat Valentine on the Nickelodeon television series Victorious (2010-13), and its spinoff Sam & Cat (2014-15). Grande made her first musical appearance on the soundtrack for Victorious and was signed to Republic Records in 2011 after music executive Monte Lipman came across one of her YouTube videos covering songs.\r\n" + 
				"\r\n" + 
				"Grande released her debut album, Yours Truly in 2013, which was influenced by 1990s R&B and 1950s doo-wop, and peaked atop the US Billboard 200. Grande ventured into EDM on her second album, My Everything (2014), which also topped the US charts and featured four top ten singles on the Billboard Hot 100, the most by any artist in 2014: \"Problem\", \"Break Free\", \"Bang Bang\", and \"Love Me Harder\". Her third album, Dangerous Woman (2016), explored pop and dance, and became her first number-one album in the United Kingdom. She experimented with trap on her next two releases, Sweetener (2018) and Thank U, Next (2019), with the former winning a Grammy Award for Best Pop Vocal Album, while the latter had largest streaming week ever for a pop album. With the singles \"Thank U, Next\" , \"7 Rings\", and \"Break Up with Your Girlfriend, I'm Bored\", Grande became the first solo artist to hold the top three spots on the Billboard Hot 100 simultaneously, and the second musical act overall after The Beatles in 1964. Grande is also the first artist to have the lead singles from each of their first five studio albums debut within the top-ten on the US charts.[3]\r\n" + 
				"\r\n" + 
				"Critics have compared Grande's wide vocal range to that of Mariah Carey. Her accolades include one Grammy Award, one BRIT Award, three American Music Awards, three MTV Europe Music Awards and two MTV Video Music Awards. She has supported a range of charities[4] and has a large following on social media, becoming the most followed woman on Instagram in February 2019.[5][6] In 2016, Time named Grande as one of the 100 most influential people in the world on their annual list,[7] and in 2018, Billboard named her Woman of the Year.[8]","/images/ariana-grande.jpg"); 
		Wiki w9 = new Wiki("Kotlin","Technology","Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of its standard library depends on the Java Class Library,[2] but type inference allows its syntax to be more concise. Kotlin mainly targets the JVM, but also compiles to JavaScript or native code (via LLVM). Kotlin is sponsored by JetBrains and Google through the Kotlin Foundation.\r\n" + 
				"\r\n" + 
				"Kotlin is officially supported by Google for mobile development on Android.[3] Since the release of Android Studio 3.0 in October 2017, Kotlin is included as an alternative to the standard Java compiler. The Android Kotlin compiler lets the user choose between targeting Java 6 or Java 8 compatible bytecode.[4]  In July 2011, JetBrains unveiled Project Kotlin, a new language for the JVM, which had been under development for a year.[5] JetBrains lead Dmitry Jemerov said that most languages did not have the features they were looking for, with the exception of Scala. However, he cited the slow compilation time of Scala as a deficiency.[5] One of the stated goals of Kotlin is to compile as quickly as Java. In February 2012, JetBrains open sourced the project under the Apache 2 license.[6]\r\n" + 
				"\r\n" + 
				"The name comes from Kotlin Island, near St. Petersburg. Andrey Breslav mentioned that the team decided to name it after an island just like Java was named after the Indonesian island of Java[7] (though the programming language Java was perhaps named after the coffee[8]).\r\n" + 
				"\r\n" + 
				"JetBrains hopes that the new language will drive IntelliJ IDEA sales.[9]\r\n" + 
				"\r\n" + 
				"Kotlin v1.0 was released on February 15, 2016.[10] This is considered to be the first officially stable release and JetBrains has committed to long-term backwards compatibility starting with this version.\r\n" + 
				"\r\n" + 
				"At Google I/O 2017, Google announced first-class support for Kotlin on Android.[3]\r\n" + 
				"\r\n" + 
				"Kotlin v1.2 was released on November 28, 2017.[11] Sharing code between JVM and Javascript platforms feature was newly added to this release.\r\n" + 
				"\r\n" + 
				"Kotlin v1.3 was released on October 29, 2018, bringing coroutines for asynchronous programming.  Development lead Andrey Breslav has said that Kotlin is designed to be an industrial-strength object-oriented language, and a \"better language\" than Java, but still be fully interoperable with Java code, allowing companies to make a gradual migration from Java to Kotlin.[12]\r\n" + 
				"\r\n" + 
				"Semicolons are optional as a statement terminator; in most cases a newline is sufficient for the compiler to deduce that the statement has ended.[13]\r\n" + 
				"\r\n" + 
				"Kotlin variable declarations and parameter lists have the data type come after the variable name (and with a colon separator), similar to Pascal.\r\n" + 
				"\r\n" + 
				"Variables in Kotlin can be immutable, declared with the val keyword, or mutable, declared with the var keyword.[14]\r\n" + 
				"\r\n" + 
				"Class members are public by default, and classes themselves are final by default, meaning that creating a derived class is disabled unless the base class is declared with the open keyword.\r\n" + 
				"\r\n" + 
				"In addition to the classes and methods (called member functions in Kotlin) of object-oriented programming, Kotlin also supports procedural programming with the use of functions.[15]\r\n" + 
				"\r\n" + 
				"Kotlin functions (and constructors) support default arguments, variable-length argument lists, named arguments and overloading by unique signature. Class member functions are virtual, i.e. dispatched based on the runtime type of the object they are called on.","/images/kotlin.png");
		session.saveOrUpdate(w1);
		session.saveOrUpdate(w9);
		session.saveOrUpdate(w2);
		session.saveOrUpdate(w6);
		session.saveOrUpdate(w3);
		session.saveOrUpdate(w7);
		session.saveOrUpdate(w5);
		session.saveOrUpdate(w8);
		session.saveOrUpdate(w4);
		
		
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

	public List<Wiki> getSimilarWiki(String wikiCategory){
		Session session = sessionFactory.openSession();

		// transaction
		session.beginTransaction();

		Query query = session.createNamedQuery("Wiki.getSimilarWiki");
		query.setParameter("wikiCategory", wikiCategory);
		List<Wiki> wikiList = query.getResultList();
		session.getTransaction().commit();
		session.close();

		return wikiList;
	}
	
	public void deleteWiki(Long wikiId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		if (wikiId != null) {
			Wiki toDelete = session.get(Wiki.class, wikiId);
			session.delete(toDelete);
		}
		

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
