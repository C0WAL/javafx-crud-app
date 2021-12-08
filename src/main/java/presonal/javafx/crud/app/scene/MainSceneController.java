package presonal.javafx.crud.app.scene;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		personId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		surname.setCellValueFactory(new PropertyValueFactory<>("Surname"));

	}

}
