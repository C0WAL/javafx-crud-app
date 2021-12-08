package presonal.javafx.crud.app.databaseService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import presonal.javafx.crud.app.entity.Person;
import presonal.javafx.crud.app.exceptions.DatabaseTransactionException;

public class CustomPersonService implements CustomService {

	@Override
	public Person getPerson(String socialSecurityNumber) {
		Session session = SessionBuilder.getSession();
		try {
			Query query = session.getNamedQuery(Person.FIND_PERSON).setParameter("socialSecurityNumber",
					socialSecurityNumber);
			Person result = (Person) query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			throw new DatabaseTransactionException(
					"Person with given SSN :" + socialSecurityNumber + "does not exist in databse", e);
		} catch (NonUniqueResultException e) {
			throw new DatabaseTransactionException("More than 1 row returned with SSN: " + socialSecurityNumber, e);
		}
	}

	@Override
	public List<Person> getPersonList() {
		Session session = SessionBuilder.getSession();
		List<Person> list = new ArrayList<Person>();
		try {
			Query query = session.getNamedQuery(Person.GET_TABLE);
			list = query.getResultList();
			return list;
		} catch (Exception e) {
			throw new DatabaseTransactionException("Error while downloading table Person");
		}
	}

}
