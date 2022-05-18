import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class moreCheckIn extends Application {
	
	static ObservableList<roomType> r=FXCollections.observableArrayList();

	 
	public static Scene getScene() {
		
		ChoiceBox<String> suiteBox=new ChoiceBox<String>();
		ChoiceBox<String> singleBox=new ChoiceBox<String>();
		ChoiceBox<String> doubleBox=new ChoiceBox<String>();
		
		Button b=new Button("Continue");
		
	    VBox info2=new VBox();		
	    
	    b.setStyle("-fx-background-color: LAVENDER;");
		info2.setStyle("-fx-background-color: GREY;");
		
		r=Room.roomsdatabase();
		
		info2.getChildren().addAll(CheckIn.ro);
	
		
		for(roomType first: r) {  //filling suitebox
			if(first.getType().equals("Suite")&&first.isAvailable()) {
			
				suiteBox.getItems().addAll((first.getNumber()));
			}
		}
		
		
		for(roomType second: r) {
			if(second.getType().equals("Double Room")&&second.isAvailable()) {
			
				doubleBox.getItems().add(second.getNumber());
			}
		}
		
		for(roomType third:r) {
			if(third.getType().equals("Single Room")&&third.isAvailable()) {
			
				singleBox.getItems().add(third.getNumber());
			}
		}
		
		
		for(Costumer i:AddCostumer.costumer) {
		
					if (i.getID().equals(CheckIn.idfield.getText())){
						i.setCheckin(new Date());
						if(i.getRoomType().equals("Suite")) {
							info2.getChildren().addAll(suiteBox,b);
							b.setOnAction(e->{
								i.setRoomNr(suiteBox.getValue());
								
							});
							
						}
						else if(i.getRoomType().equals("Double Room")) {
							info2.getChildren().addAll(doubleBox,b);
							b.setOnAction(e->{
								i.setRoomNr(doubleBox.getValue());
								
							});
						}
						else {
							info2.getChildren().addAll(singleBox,b);
							b.setOnAction(e->{
								i.setRoomNr(singleBox.getValue());
		                    });
						}
					
				    }
		}
		info2.setAlignment(Pos.CENTER);
		
	
		Scene scene=new Scene(info2,300,300);
	    return scene;	
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}