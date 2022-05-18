import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainMenu{

	static Stage stage=new Stage();
	
	public static Scene getScene(){
		
		GridPane choicespane=new GridPane();   //creates a GridPane
		choicespane.setHgap(20);
		choicespane.setVgap(20);
		
		DropShadow shadow = new DropShadow();
	    shadow.setOffsetY(5.0);
	    shadow.setOffsetX(5.0);
	    
	    Rectangle s1=border();
	    Rectangle s2=border();
	    Rectangle s3=border();
	    Rectangle s4=border();
	    Rectangle s5=border();
	    Rectangle s6=border();
	    
	    ImageView booking=new ImageView(new Image("Booking.png"));
		booking.setFitHeight(150);
		booking.setFitWidth(150);
		Label lb=new Label("Booking");
		VBox firstChoice=new VBox();
		firstChoice.getChildren().addAll(booking,lb);
		firstChoice.setAlignment(Pos.CENTER);
		
		ImageView chIn=new ImageView(new Image("CheckIn.png"));
		chIn.setFitHeight(150);
		chIn.setFitWidth(150);
		Label lci=new Label ("Check-In");
		VBox secondChoice=new VBox();
		secondChoice.getChildren().addAll(chIn,lci);
		secondChoice.setAlignment(Pos.CENTER);
		
		ImageView rooms=new ImageView(new Image("Rooms.png"));
		rooms.setFitHeight(150);
		rooms.setFitWidth(150);
		Label lr=new Label ("Rooms");
		VBox thirdChoice=new VBox();
		thirdChoice.getChildren().addAll(rooms,lr);
		thirdChoice.setAlignment(Pos.CENTER);
		
		ImageView payment=new ImageView(new Image("Payment.png"));
		payment.setFitHeight(150);
		payment.setFitWidth(150);
		Label lp=new Label("Payment");
		VBox fourthChoice=new VBox();
		fourthChoice.getChildren().addAll(payment,lp);
		fourthChoice.setAlignment(Pos.CENTER);
		
		ImageView chOut=new ImageView(new Image("CheckOut.png"));
		chOut.setFitHeight(150);
		chOut.setFitWidth(150);
		Label lco=new Label("Check-Out");
		VBox fifthChoice=new VBox();
		fifthChoice.getChildren().addAll(chOut,lco);
		fifthChoice.setAlignment(Pos.CENTER);
		
		ImageView guests=new ImageView(new Image("Guests.png"));
		guests.setFitHeight(150);
		guests.setFitWidth(150);
		Label lg=new Label("Guests");
		VBox sixthChoice=new VBox();
		sixthChoice.getChildren().addAll(guests,lg);
		sixthChoice.setAlignment(Pos.CENTER);
		
		
		choicespane.add(firstChoice,0,0);
		choicespane.add(s1,0,0);
		choicespane.add(secondChoice,1,0);
		choicespane.add(s2,1,0);
		choicespane.add(thirdChoice,2,0);
		choicespane.add(s3,2,0);
		choicespane.add(fourthChoice,0,1);
		choicespane.add(s4,0,1);
		choicespane.add(fifthChoice,1,1);
		choicespane.add(s5,1,1);
		choicespane.add(sixthChoice,2,1);
		choicespane.add(s6,2,1);
		
		
		lci.setStyle("-fx-font-weight: bold");
		lci.setTextFill(Color.INDIGO);
		lci.setEffect(shadow);
		lco.setStyle("-fx-font-weight: bold");
		lco.setTextFill(Color.INDIGO);
		lco.setEffect(shadow);
		lb.setStyle("-fx-font-weight: bold");
		lb.setTextFill(Color.INDIGO);
		lb.setEffect(shadow);
		lp.setAlignment(Pos.BASELINE_CENTER);
		lp.setStyle("-fx-font-weight: bold");
		lp.setTextFill(Color.INDIGO);
		lp.setEffect(shadow);
		lr.setStyle("-fx-font-weight: bold");
		lr.setTextFill(Color.INDIGO);
		lr.setEffect(shadow);
		lg.setStyle("-fx-font-weight: bold");
		lg.setTextFill(Color.INDIGO);
		lg.setEffect(shadow);
		choicespane.setAlignment(Pos.CENTER);
		choicespane.setStyle("-fx-background-color: LAVENDER;");
		
		
		
		
		s4.setOnMouseClicked(e->{
			stage.setTitle("Payment");
			Scene scene1=Payment.getScene();
			stage.setScene(scene1);
			stage.show();
	});
		
		s2.setOnMouseClicked(e->{
			stage.setTitle("Check-in");
			Scene scene2=CheckIn.getScene();
			stage.setScene(scene2);
			stage.show();
	});
		
		s3.setOnMouseClicked(e->{
			stage.setTitle("Rooms: ");
			Scene scene3=(Room.getScene());
			stage.setScene(scene3);
			stage.show();
	});
				
		s1.setOnMouseClicked(e->{
			stage.setTitle("Add Costumer: ");
			Scene scene4=(AddCostumer.getScene());
			stage.setScene(scene4);
			stage.show();
	});
		s6.setOnMouseClicked(e->{
			stage.setTitle("Guests ");
			Scene scene5=(Guests.getScene());
			stage.setScene(scene5);
			stage.show();
	});
		s5.setOnMouseClicked(e->{
			stage.setTitle("Check-Out ");
			Scene scene6=(CheckOut.getScene());
			stage.setScene(scene6);
			stage.show();
	});
		
		
		BorderPane menupane=new BorderPane();
		menupane.setCenter(choicespane);
		Scene menuscene= new Scene(menupane,800,600);
		
		return menuscene;

	}
	
	static Rectangle border() {
		Rectangle sq1=new Rectangle(200,200);
	    sq1.setArcWidth(30.0); 
	    sq1.setArcHeight(20.0);
	    sq1.setFill(Color.TRANSPARENT);
	    sq1.setStroke(Color.WHITE);
	    sq1.setStrokeWidth(3.0);
	    DropShadow shadow = new DropShadow();
	    shadow.setOffsetY(5.0);
	    shadow.setOffsetX(5.0);
	    sq1.setEffect(shadow);
		return sq1;
		
	}
}