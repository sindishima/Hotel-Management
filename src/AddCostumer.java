import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AddCostumer extends Application {
	static ObservableList<Costumer> costumer=FXCollections.observableArrayList();//to store all costumers

	static Label l1=new Label("First name: ");
	static TextField t1=new TextField();
	
	static Label l2=new Label("Last name: ");
	static TextField t2=new TextField();
	
	static Label l3=new Label("ID: ");
	static TextField t3=new TextField();
	
	static Label l4=new Label("Email: ");
	static TextField t4=new TextField();
	
	static Label l5=new Label("Country: ");
	static ChoiceBox<String> cb=new ChoiceBox<String>();
	
	static Label l6=new Label("Phone Number: ");
	static TextField t6=new TextField();
	
	static Label l7=new Label("Room type: ");
	static ChoiceBox<String> cb2=new ChoiceBox<String>();
	
	public static Scene getScene() {

		BorderPane parent=new BorderPane();
		GridPane pane=new GridPane();
		
		l1.setStyle("-fx-font-weight: bold");
		l2.setStyle("-fx-font-weight: bold");
		l3.setStyle("-fx-font-weight: bold");
		l4.setStyle("-fx-font-weight: bold");
		l5.setStyle("-fx-font-weight: bold");
		l6.setStyle("-fx-font-weight: bold");
		
		cb.getItems().add("Albania   ");
		cb.getItems().add("America   ");
		cb.getItems().add("England   ");
		cb.getItems().add("France   ");
		cb.getItems().add("Germany   ");
		cb.getItems().add("Japan   ");
		cb.getItems().add("Spain   ");
		cb.getItems().add("Turkey   ");
		
		cb2.getItems().add("Single Room");
		cb2.getItems().add("Double Room");
		cb2.getItems().add("Suite");
		
		pane.setVgap(20);
		pane.setHgap(10);
		pane.add(l1,0,0);
		pane.add(t1,1,0);
		pane.add(l2,0,1);
		pane.add(t2,1,1);
		pane.add(l3,0,2);
		pane.add(t3,1,2);
		pane.add(l4,0,3);
		pane.add(t4,1,3);
		pane.add(l5,0,4);
		pane.add(cb,1,4);
		pane.add(l6,0,5);
		pane.add(t6,1,5);
		pane.add(l7,0,6);
		pane.add(cb2,1,6);
	  	pane.setPadding(new Insets(25,0,0,25)); 
	  	
	  	Button bt=new Button("Complete");
	  	pane.add(bt,1,7);
	  	bt.setStyle("-fx-background-color: LAVENDER; -fx-font-weight: bold");
	  	bt.setOnAction(e->{saveCostumerInformation();
	  	     MainMenu.stage.close();
	  	});
	  	pane.setStyle("-fx-background-color: THISTLE;");
	  	
	  	ImageView ch=new ImageView(new Image("client.png"));
		ch.setFitHeight(300);
		ch.setFitWidth(250);
		StackPane st=new StackPane();
		st.setStyle("-fx-background-color: THISTLE;");
		st.getChildren().add(ch);
		st.setPadding(new Insets(0,25,0,0)); 
	  	
	  	parent.setCenter(pane);
	  	parent.setRight(st);
	  
	  	
		Scene scene3=new Scene(parent,600,400);
		return scene3;
	}

	public static void saveCostumerInformation() {

		costumer.add(new Costumer(t1.getText(),t2.getText(),t3.getText(),t4.getText(),(String)cb.getValue(),t6.getText(),((String)cb2.getValue())));
		t1.setText(null);
		t2.setText(null);
		t3.setText(null);
		t4.setText(null);
		cb.setValue(null);
		t6.setText(null);
		cb2.setValue(null);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}

}