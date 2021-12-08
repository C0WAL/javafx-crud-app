package presonal.javafx.crud.app.databaseService;

import java.util.List;

import presonal.javafx.crud.app.entity.Person;

public interface CustomService {

	public Person getPerson(String socialSecurityNumber);

	public List<Person> getPersonList();

}
