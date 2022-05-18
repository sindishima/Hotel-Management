import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckIn extends Application {
	
	static Label idno = new Label("Guests ID: ");
	static TextField idfield=new TextField();
	static Button search=new Button("Search");
	static Label ro=new Label("Choose room number: ");

	
	static VBox info=new VBox();
	

	public static Scene getScene() {
		GridPane pane=new GridPane();
		BorderPane p=new BorderPane();
		VBox vbox=new VBox();

		ro.setStyle("-fx-background-color: LAVENDER; -fx-font-weight: bold");
		search.setStyle("-fx-background-color: LAVENDER; -fx-font-weight: bold");
		info.setStyle("-fx-background-color: THISTLE; -fx-font-weight: bold");
		
	
		
		search.setOnAction(e->searchbutton());
		info.getChildren().addAll(idno,idfield,search);
		StackPane parent=new StackPane();
		parent.getChildren().add(info);
	
		
		ImageView checkin=new ImageView(new Image("inn.png"));
		checkin.setFitHeight(300);
		checkin.setFitWidth(300);
		StackPane stack=new StackPane();
		stack.setStyle("-fx-background-color: THISTLE;");
		stack.getChildren().add(checkin);
		
	  	p.setCenter(parent);
	  	p.setRight(stack);
	  	
	  
		
		Scene scene=new Scene(p,400,400);
		return scene;
		
	}
	
	public static void searchbutton() {
		MainMenu.stage.setScene(moreCheckIn.getScene());
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}