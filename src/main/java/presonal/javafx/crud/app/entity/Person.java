package presonal.javafx.crud.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import presonal.javafx.crud.app.databaseService.DTO.PersonDTO;

@NamedQueries({ @NamedQuery(name = Person.FIND_PERSON, query = Person.FIND_PERSON_HQL),
		@NamedQuery(name = Person.FIND_IF_PERSON_EXISTS, query = Person.FIND_IF_PERSON_EXISTS_HQL),
		@NamedQuery(name = Person.GET_TABLE, query = Person.GET_TABLE_HQL) })
@Entity
@Table(name = "Person")
public class Person extends AbstractEntity {

	protected static final String FIND_PERSON_HQL = "FROM Person p WHERE p.socialSecurityNumber = :socialSecurityNumber";
	protected static final String FIND_IF_PERSON_EXISTS_HQL = "SELECT COUNT(*) FROM Person p WHERE p.socialSecurityNumber = :socialSecurityNumber";
	protected static final String GET_TABLE_HQL = "FROM Person";

	public static final String FIND_IF_PERSON_EXISTS = "Person.findIfPersonExists";
	public static final String FIND_PERSON = "Person.findPerson";
	public static final String GET_TABLE = "Person.getTable";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rate_generator")
	@SequenceGenerator(name = "rate_generator", sequenceName = "rate_seq")
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "surname", nullable = false)
	private String surname;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(name = "street", nullable = false)
	private String street;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "salary", precision = 19, scale = 4, nullable = false)
	private BigDecimal salary;
	@Column(name = "social_security_number", nullable = false, unique = true)
	private String socialSecurityNumber;
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	@Column(name = "date_of_employment", nullable = false)
	private LocalDate dateOfEmployment;
	@Column(name = "job", nullable = false)
	private String job;

	public Person() {

	}

	public Person(PersonDTO dto) {
		this(dto.getName(), dto.getSurname(), dto.getPhoneNumber(), dto.getStreet(), dto.getCity(), dto.getSalary(),
				dto.getSocialSecurityNumber(), dto.getDateOfBirth(), dto.getDateOfEmployment(), dto.getJob());
	}

	public Person(String name, String surname, String phoneNumber, String street, String city, BigDecimal salary,
			String socialSecurityNumber, LocalDate dateOfBirth, LocalDate dateOfEmployment, String job) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.salary = salary;
		this.socialSecurityNumber = socialSecurityNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
		this.job = job;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateOfEmployment(LocalDate dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
