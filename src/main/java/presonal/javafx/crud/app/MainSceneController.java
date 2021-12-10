package presonal.javafx.crud.app;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import presonal.javafx.crud.app.databaseService.CustomPersonService;
import presonal.javafx.crud.app.databaseService.PersonService;
import presonal.javafx.crud.app.databaseService.SessionBuilder;
import presonal.javafx.crud.app.databaseService.DTO.PersonDTO;
import presonal.javafx.crud.app.entity.Person;

public class MainSceneController implements Initializable {

	@FXML
	private TableView<Person> tableData;

	@FXML
	private TableColumn<Person, Long> personId;
	@FXML
	private TableColumn<Person, String> name;
	@FXML
	private TableColumn<Person, String> surname;
	@FXML
	private TableColumn<Person, String> phoneNumber;
	@FXML
	private TableColumn<Person, String> street;
	@FXML
	private TableColumn<Person, String> city;
	@FXML
	private TableColumn<Person, BigDecimal> salary;
	@FXML
	private TableColumn<Person, String> socialSecurityNumber;
	@FXML
	private TableColumn<Person, LocalDate> birthday;
	@FXML
	private TableColumn<Person, LocalDate> employedSince;
	@FXML
	private TableColumn<Person, String> job;

	private ObservableList<Person> observable;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		personId.setCellValueFactory(new PropertyValueFactory<Person, Long>("Id"));
		name.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));
		surname.setCellValueFactory(new PropertyValueFactory<Person, String>("Surname"));
		phoneNumber.setCellValueFactory(new PropertyValueFactory<Person, String>("PhoneNumber"));
		street.setCellValueFactory(new PropertyValueFactory<Person, String>("Street"));
		city.setCellValueFactory(new PropertyValueFactory<Person, String>("City"));
		salary.setCellValueFactory(new PropertyValueFactory<Person, BigDecimal>("Salary"));
		socialSecurityNumber.setCellValueFactory(new PropertyValueFactory<Person, String>("SocialSecurityNumber"));
		birthday.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("DateOfBirth"));
		employedSince.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("DateOfEmployment"));
		job.setCellValueFactory(new PropertyValueFactory<Person, String>("Job"));
//		fill();
		populate();
		tableData.refresh();

	}

	private void populate() {
		CustomPersonService service = new CustomPersonService();
		SessionBuilder.getSession();
		observable = FXCollections.observableArrayList(service.getPersonList());
		tableData.setItems(observable);
		SessionBuilder.closeSession();
	}

	private void fill() {
		PersonService service = new PersonService();
		SessionBuilder.getSession();
		PersonDTO person = new PersonDTO("Robert", "Makłowicz", "222333444", "Wojska Polskiego 3", "Zielona Góra",
				"112233445", new BigDecimal(5000.0), LocalDate.of(1978, 5, 9), LocalDate.of(2018, 1, 10), "Accountant");
		PersonDTO person2 = new PersonDTO("Aleksandra", "Pawelec", "765098123", "Poznańska 5", "Poznan", "798365934",
				new BigDecimal(4500.0), LocalDate.of(1998, 8, 4), LocalDate.of(2019, 2, 10), "Accountant");
		PersonDTO person3 = new PersonDTO("Tomasz", "Kot", "534404355", "Lodzka 3", "Lodz", "980304098",
				new BigDecimal(10000.0), LocalDate.of(1965, 11, 14), LocalDate.of(2020, 5, 10), "Accountant");
		PersonDTO person4 = new PersonDTO("Grażyna", "Gładysz", "164534457", "Warszawska 1", "Warszawa", "765489521",
				new BigDecimal(2900.0), LocalDate.of(1999, 9, 27), LocalDate.of(2020, 3, 10), "Accountant");
		PersonDTO person5 = new PersonDTO("Aenta", "Strzelec", "365798934", "Augustowska 7", "Zielona Góra",
				"349856712", new BigDecimal(2300.0), LocalDate.of(1985, 3, 17), LocalDate.of(2021, 5, 10),
				"Accountant");
		PersonDTO person6 = new PersonDTO("Krzysztof", "Ibisz", "980884881", "Sienkiewicza 34", "Lodz", "764859132",
				new BigDecimal(13700.0), LocalDate.of(1975, 1, 12), LocalDate.of(2021, 5, 10), "Accountant");
		service.add(person);
		service.add(person6);
		service.add(person5);
		service.add(person4);
		service.add(person3);
		service.add(person2);
		SessionBuilder.closeSession();
	}

}
