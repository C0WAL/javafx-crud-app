package presonal.javafx.crud.app.databaseService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionBuilder {

	private static SessionFactory factory;
	private static Session session;
	private static String config = "hibernate.cfg.xml";

	public static Session getSession() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure(SessionBuilder.config).build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		if (factory == null || factory.isClosed()) {
			factory = meta.getSessionFactoryBuilder().build();
		}
		if (session == null || !session.isOpen()) {
			session = factory.openSession();
		}
		return session;
	}

	public static void closeFactory() {
		if (factory.isOpen()) {
			factory.close();
		}
	}

	public static void closeSession() {
		if (session.isOpen()) {
			session.close();
		}
	}

	public static void setConfig(String config) {
		SessionBuilder.config = config;
	}
}
