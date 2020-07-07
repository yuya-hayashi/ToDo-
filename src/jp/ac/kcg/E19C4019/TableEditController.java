package jp.ac.kcg.E19C4019;

import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;

public class TableEditController {

	@FXML
	private TableView<ToDo> tv;

	@FXML
	private TableColumn<ToDo, String> subject;

	@FXML
	private TableColumn<ToDo, LocalDateTime> deadline;

	@FXML
	private TableColumn<ToDo, Integer> priority;

	@FXML
	private TextField tf;

	@FXML
	void initialize() {

		subject.setCellValueFactory(new PropertyValueFactory<ToDo, String>("subject"));
		subject.setCellFactory(TextFieldTableCell.<ToDo> forTableColumn());

		deadline.setCellValueFactory(new PropertyValueFactory<ToDo, LocalDateTime>("deadline"));
		LocalDateTimeStringConverter lconv = new LocalDateTimeStringConverter();
		deadline.setCellFactory(TextFieldTableCell.<ToDo, LocalDateTime> forTableColumn(lconv));

		priority.setCellValueFactory(new PropertyValueFactory<ToDo, Integer>("priority"));
		IntegerStringConverter pconv = new IntegerStringConverter();
		priority.setCellFactory(TextFieldTableCell.<ToDo, Integer> forTableColumn(pconv));

		/*ToDo dummy = new ToDo();
		dummy.setSubject("ダミーのToDo");
		dummy.setDeadline("2020/05/29 09:30");
		dummy.setPriority(3);

		tv.getItems().add(dummy);*/

	}

	@FXML
	void editSubject(CellEditEvent<ToDo, String> event) {
		event.getRowValue().setSubject(event.getNewValue());

	}

	@FXML
	void editDeadline(CellEditEvent<ToDo, LocalDateTime> event) {
		event.getRowValue().setDeadline(event.getNewValue());
	}

	@FXML
	void editPriority(CellEditEvent<ToDo, Integer> event) {
		event.getRowValue().setPriority(event.getNewValue());
	}

	@FXML
	void addToDo(ActionEvent event) {
		String[] values;
		String line = tf.getText();
		values = line.split(",");


		ToDo t = new ToDo();

		t.setSubject(values[0]);
		t.setDeadline(values[1]);
		t.setPriority(Integer.parseInt(values[2]));

		tv.getItems().add(t);

		tf.setText("");

	}

}
