package presonal.javafx.crud.app.provider;

import java.util.List;

import presonal.javafx.crud.app.databaseService.CustomPersonService;
import presonal.javafx.crud.app.databaseService.CustomService;
import presonal.javafx.crud.app.databaseService.PersonService;
import presonal.javafx.crud.app.databaseService.Service;
import presonal.javafx.crud.app.databaseService.DTO.PersonDTO;
import presonal.javafx.crud.app.entity.Person;

public class DatabasePersonProvider implements PersonProvider {

	Service service;
	CustomService customService;

	public DatabasePersonProvider() {
		this(new PersonService(), new CustomPersonService());
	}

	public DatabasePersonProvider(Service service) {
		this(service, new CustomPersonService());
	}

	public DatabasePersonProvider(CustomService service) {
		this(new PersonService(), service);
	}

	public DatabasePersonProvider(Service service, CustomService customService) {
		this.service = service;
		this.customService = customService;
	}

	@Override
	public Person getPerson(String socialSecurityNumber) {
		return customService.getPerson(socialSecurityNumber);
	}

	@Override
	public void addPerson(Person person) {
		service.add(new PersonDTO(person));
	}

	public List<Person> getPersonList() {
		return customService.getPersonList();
	}

}
