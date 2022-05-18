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

public class CheckOut extends Application {
	
	static Label labelId=new Label("Guest's ID: ");
	static TextField textId=new TextField();
	static Button sb=new Button("Search");
	
	public static Scene getScene() {
		
		VBox v=new VBox();
		BorderPane p=new BorderPane();
		GridPane pane=new GridPane();
		
		sb.setOnAction(e->searchAction());
		
		labelId.setStyle("-fx-font-weight: bold");
		sb.setStyle("-fx-background-color: LAVENDER; -fx-font-weight: bold");
		v.setStyle("-fx-background-color: THISTLE;");
			
			ImageView chechout=new ImageView(new Image("out.png"));
			chechout.setFitHeight(300);
			chechout.setFitWidth(300);
			StackPane stack=new StackPane();
			stack.setStyle("-fx-background-color: THISTLE;");
			stack.getChildren().add(chechout);
		  	
		  	p.setCenter(v);
		  	p.setRight(stack);
		  	
		  	
		pane.add(stack,0,0);
		pane.add(labelId,0,1);
		pane.add(textId,0,2);
		pane.add(sb,0,4);
		pane.setVgap(5);
		
		StackPane parent=new StackPane();
		v.getChildren().addAll(pane);
		parent.getChildren().add(v);
		Scene scene =new Scene(parent,400,400);
		return scene;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public static void searchAction() {
		for(Costumer i:AddCostumer.costumer) {
			
			if (i.getID().equals(textId.getText())){
				i.setCheckout(new Date());
			}
		}
	}

}