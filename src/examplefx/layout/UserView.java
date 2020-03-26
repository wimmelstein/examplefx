package examplefx.layout;

import examplefx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserView extends VBox {
	
	ObservableList<User> users = FXCollections.observableArrayList();
	TableView<User> tableView = new TableView<>();
	
	TextField userNameInput, fullNameInput, ageInput;
	Button addButton, deleteButton;
			
	
	@SuppressWarnings("unchecked")
	public UserView() {
		

		setPadding(new Insets(10, 10, 10, 10));
		
		Label title = new Label("User List");
	
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		TableColumn<User, String> nameColumn = new TableColumn<>("Username");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		nameColumn.setMinWidth(100);
		
		TableColumn<User, String> fullNameColumn = new TableColumn<>("Full name");
		fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		fullNameColumn.setMinWidth(100);
		
		TableColumn<User, Integer> ageColumn = new TableColumn<>("Age");
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
		ageColumn.setMinWidth(50);
		
		tableView.setItems(getUsers());
		
		tableView.getColumns().addAll(nameColumn, fullNameColumn, ageColumn);
		
		userNameInput = new TextField();
		userNameInput.setPromptText("Username");
		
		fullNameInput = new TextField();
		fullNameInput.setPromptText("Full Name");
		
		ageInput = new TextField();
		ageInput.setPromptText("Age");
		
		addButton = new Button("Add");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String username = userNameInput.getText();
				String fullName = fullNameInput.getText();
				int age = Integer.parseInt(ageInput.getText());
				
				User user = new User(username,  fullName,  age);
				tableView.getItems().add(user);
				
				clearInputs();
			}
		});
		deleteButton = new Button("Delete");
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ObservableList<User> selectedUsers = tableView.getSelectionModel().getSelectedItems();
				users.removeAll(selectedUsers);				
			}
			
		});
		
		HBox form = new HBox();
		form.setPadding(new Insets(10,10,10,10));
		form.setSpacing(10);
		form
			.getChildren()
			.addAll(userNameInput, fullNameInput, ageInput, addButton, deleteButton);
				
		this.getChildren().addAll(title, tableView, form);

	}
	
	private ObservableList<User> getUsers() {
		users.add(new User("bsanders", "Bernie Sanders", 78));
		users.add(new User("emusk", "Elon Musk", 48));
		users.add(new User("pcoulson", "Phil Coulson", 55));
		return users;
		
	}

	private void clearInputs() {
		userNameInput.clear();
		fullNameInput.clear();
		ageInput.clear();
	}

}
