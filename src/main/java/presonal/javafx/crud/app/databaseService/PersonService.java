package presonal.javafx.crud.app.databaseService;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import presonal.javafx.crud.app.databaseService.DTO.PersonDTO;
import presonal.javafx.crud.app.entity.Person;
import presonal.javafx.crud.app.exceptions.BadInputException;
import presonal.javafx.crud.app.exceptions.DatabaseTransactionException;

public class PersonService extends DatabaseService<Person, PersonDTO> {

	@Override
	public Person get(PersonDTO object) {
		Session session = SessionBuilder.getSession();
		try {
			Query query = session.getNamedQuery(Person.FIND_PERSON).setParameter("socialSecurityNumber",
					object.getSocialSecurityNumber());
			Person result = (Person) query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			throw new DatabaseTransactionException(
					"Person with given SSN :" + object.getSocialSecurityNumber() + "does not exist in databse", e);
		} catch (NonUniqueResultException e) {
			throw new DatabaseTransactionException(
					"More than 1 row returned with SSN: " + object.getSocialSecurityNumber(), e);
		}
	}

	@Override
	public void update(PersonDTO object) {
		Session session = SessionBuilder.getSession();
		Person personEntity = new Person();
		try {
			personEntity = session.get(Person.class, object.getId());
			if (personEntity != null) {
				Transaction transaction = session.beginTransaction();
				if (object.getName() != null) {
					personEntity.setName(object.getName());
				}
				if (object.getSurname() != null) {
					personEntity.setSurname(object.getSurname());
				}
				if (object.getPhoneNumber() != null) {
					personEntity.setPhoneNumber(object.getPhoneNumber());
				}
				if (object.getCity() != null) {
					personEntity.setCity(object.getCity());
				}
				if (object.getDateOfBirth() != null) {
					personEntity.setDateOfBirth(object.getDateOfBirth());
				}
				if (object.getDateOfEmployment() != null) {
					personEntity.setDateOfEmployment(object.getDateOfEmployment());
				}
				if (object.getJob() != null) {
					personEntity.setJob(object.getJob());
				}
				if (object.getSalary() != null) {
					personEntity.setSalary(object.getSalary());
				}
				if (object.getSocialSecurityNumber() != null) {
					personEntity.setSocialSecurityNumber(object.getSocialSecurityNumber());
				}
				if (object.getStreet() != null) {
					personEntity.setStreet(object.getStreet());
				}
				session.update(personEntity);
				transaction.commit();
			} else {
				throw new BadInputException("Object with id:" + object.getId() + " does not exist in database");
			}

		} catch (Exception e) {
			throw new DatabaseTransactionException("Error while updating object with id:" + object.getId());
		}

	}

	@Override
	public Person convert(PersonDTO object) {
		return new Person(object);
	}

	@Override
	public boolean validate(PersonDTO object) {
		Session session = SessionBuilder.getSession();
		if (object.getSocialSecurityNumber() == null) {
			throw new BadInputException("Social security number (SSN) is required");
		}
		long i = 0;
		try {
			Transaction t = session.beginTransaction();
			TypedQuery<Long> query = session.getNamedQuery(Person.FIND_IF_PERSON_EXISTS)
					.setParameter("socialSecurityNumber", object.getSocialSecurityNumber());
			t.commit();
			i = query.getSingleResult();
			if (i == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new DatabaseTransactionException("Error while executing query: " + Person.FIND_IF_PERSON_EXISTS, e);
		}
	}

}
