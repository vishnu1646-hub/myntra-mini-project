package company.myntra.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import company.myntra.model.RegisterData;

public class RegistrationDao {

	public void registerUserToDB(String name, String password, String email, String mobileNumber) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		RegisterData add = new RegisterData();
		add.setName(name);
		add.setPassword(password);
		add.setEmail(email);
		add.setMobileNumber(mobileNumber);
		session.save(add);
		transaction.commit();
		factory.close();
		session.close();

	}
}
