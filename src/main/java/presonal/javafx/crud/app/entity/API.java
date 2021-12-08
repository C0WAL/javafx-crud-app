package presonal.javafx.crud.app.entity;

import java.util.List;

import presonal.javafx.crud.app.provider.DatabasePersonProvider;
import presonal.javafx.crud.app.provider.PersonProvider;

public class API {

	private PersonProvider provider;

	public API(PersonProvider provider) {
		this.provider = provider;
	}

	public API() {
		this(new DatabasePersonProvider());
	}

	public List<Person> getPersonList() {
		return provider.getPersonList();
	}

}
