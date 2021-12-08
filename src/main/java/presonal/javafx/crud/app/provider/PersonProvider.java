package presonal.javafx.crud.app.provider;

import java.util.List;

import presonal.javafx.crud.app.entity.Person;

public interface PersonProvider {

	Person getPerson(String socialSecurityNumber);

	void addPerson(Person person);

	List<Person> getPersonList();

}
