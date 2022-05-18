import java.util.Date;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public abstract class Guests extends Application {

	
	@SuppressWarnings("unchecked")
	public static Scene getScene() {
		TableView<Costumer> table = new TableView<Costumer>();
		
		table.setEditable(true);
		 
        TableColumn<Costumer,String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Costumer,String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        TableColumn<Costumer,String> IDCol = new TableColumn<>("ID");
        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn<Costumer,String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Costumer,String> countryCol = new TableColumn<>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        TableColumn<Costumer,Integer> numberCol = new TableColumn<>("Phone no.");
        numberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        TableColumn<Costumer,String> roomCol = new TableColumn<>("Room Type");
        roomCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        TableColumn<Costumer,String> roomnrCol = new TableColumn<>("Room Number");
        roomnrCol.setCellValueFactory(new PropertyValueFactory<>("roomNr"));
        TableColumn<Costumer,Date> INCol = new TableColumn<>("Check-in");
        INCol.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        TableColumn<Costumer,Date> OUTCol = new TableColumn<>("Check-out");
        OUTCol.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        
        
        table.getColumns().addAll(firstNameCol, lastNameCol, IDCol, emailCol,countryCol,numberCol,roomCol,roomnrCol, INCol,OUTCol);
        table.setItems(AddCostumer.costumer);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll( table);
        
        Group group=new Group();
 
        Scene scene=new Scene(group,820,425);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
 
		
		//guest.setScene(scene);
		//guest.show();
        return scene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}