package presonal.javafx.crud.app.databaseService.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import presonal.javafx.crud.app.entity.Person;

public class PersonDTO extends AbstractDTO {

	private Long id;
	private String name;
	private String surname;
	private String phoneNumber;
	private String street;
	private String city;
	private String socialSecurityNumber;
	private BigDecimal salary;
	private LocalDate dateOfBirth;
	private LocalDate dateOfEmployment;
	private String job;

	public PersonDTO(String name, String surname, String phoneNumber, String street, String city,
			String socialSecurityNumber, BigDecimal salary, LocalDate dateOfBirth, LocalDate dateOfEmployment,
			String job) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.socialSecurityNumber = socialSecurityNumber;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
		this.job = job;
	}

	public PersonDTO(Person person) {
		this(person.getName(), person.getSurname(), person.getPhoneNumber(), person.getStreet(), person.getCity(),
				person.getSocialSecurityNumber(), person.getSalary(), person.getDateOfBirth(),
				person.getDateOfEmployment(), person.getJob());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public String getJob() {
		return job;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

}
