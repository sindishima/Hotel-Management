import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LogIn extends Application {


	public void start(Stage stg)throws Exception{
		BorderPane bpane=new BorderPane();
		
		Polygon wall=new Polygon(65,250,175,250,190,170,120,120,50,170);//left upper corner
		Stop[] stops3 = new Stop[] { new Stop(0, Color.SNOW), new Stop(1, Color.THISTLE)};  //where gradient starts and stops
		LinearGradient wallColor = new LinearGradient(0, 0, 0, 1, true, null, stops3); 
		wall.setFill(wallColor);    //set color
		wall.setStroke(Color.BLACK);   //set stroke
		
		
		Polygon roofLineH=new Polygon(30,185,120,120,210,185,215,175,120,110,25,175);   //left down corner
		Stop[] stops = new Stop[] { new Stop(0, Color.PINK), new Stop(1, Color.MEDIUMVIOLETRED)};   //where gradient starts and stops
		LinearGradient roofColor = new LinearGradient(1, 1, 1, 0, true, null, stops); 
		roofLineH.setFill(roofColor);
        roofLineH.setStroke(Color.BLACK);
        
	    //All Lines
		Line windowLineH=new Line(120,220,120,170);
		Line windowLineVertically=new Line(90,198,150,198);
		Line roofLine=new Line(120,60,120,110);
		
		Polygon window=new Polygon(85,170,155,170,145,220,95,220);
		Stop[] stops2 = new Stop[] { new Stop(0, Color.AZURE), new Stop(1, Color.SKYBLUE)};
		LinearGradient windowColor = new LinearGradient(0, 0, 1, 0, true, null, stops2); 
		window.setFill(windowColor);
		window.setStroke(Color.BLACK);
		
		
		Polygon roof=new Polygon(50,110,120,60,190,110,215,175,120,110,25,175);   //left upper corner start
		roof.setFill(roofColor);
		roof.setStroke(Color.BLACK);
		
		Polygon chimney=new Polygon(60,135,100,110,100,75,60,75);
		chimney.setStroke(Color.BLACK);
		chimney.setFill(roofColor);
		
		Line line=new Line(60,135,100,110);
		line.setStrokeWidth(2);
		line.setStroke(roofColor);
		
		Polygon upChimney=new Polygon(60,75,100,75,100,60,70,60);
		upChimney.setFill(roofColor);
		
		CubicCurve smoke=new CubicCurve(30,30,30,60,75,40,80,70);
		smoke.setFill(Color.LAVENDER);
        smoke.setStroke(Color.DARKGREY);
		
		FadeTransition ft=new FadeTransition(Duration.millis(1000),smoke);  
		ft.setFromValue(1.0);     //start opaque value
		ft.setToValue(0.1);     //end opaque value
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();    //Start animation
		
		
		
		Label l1=new Label("   Password");
		l1.setStyle("-fx-font-weight: bold");
		PasswordField fill1 = new PasswordField();
		TextField pass=new TextField();
		
		pass.setVisible(false);
		fill1.setVisible(true);
		
		Label l2 = new Label("   Username");
		l2.setStyle("-fx-font-weight: bold");
		TextField fill2 = new TextField();
		
		RadioButton showPass=new RadioButton("Show Password");
		showPass.setStyle("-fx-font-weight: bold");
		showPass.setAlignment(Pos.CENTER);
		
		showPass.selectedProperty().addListener((ObservableValue<? extends Boolean> ov,Boolean old,Boolean newV)->{
			if(showPass.isSelected()) {
				pass.setText(fill1.getText());
				pass.setVisible(true);
				fill1.setVisible(false);
			}
			else {
			fill1.setText(pass.getText());
			fill1.setVisible(true);
			pass.setVisible(false);
			}
		});
		
		final String PASSWORD="admin";
		final String USERNAME="admin";
		
		Button logBtn=new Button(" Log in ");
		logBtn.setStyle("-fx-font-weight: bold");
		
		Label label=new Label("");
		logBtn.setAlignment(Pos.CENTER);
		
		
		logBtn.setOnAction(new EventHandler<ActionEvent>(){   //makes LogIn button work
			@Override
			public void handle(ActionEvent event) {
			if((!fill1.getText().equals(PASSWORD))||(!fill2.getText().equals(USERNAME))) {
				label.setText("Wrong username and/or password!");
				label.setTextFill(Color.RED);
				return;
			}
			else {
				stg.setTitle("Main Menu");
				Scene menuscene=MainMenu.getScene();
				stg.setScene(menuscene);
			}
			fill1.clear();
			}});
		
		ImageView color=new ImageView(new Image("blue.png"));
		color.setFitHeight(300);
		color.setFitWidth(600);
		bpane.getChildren().addAll(color);
		
		
		GridPane col1=new GridPane();
		col1.setVgap(10);
		col1.add(l2, 0, 0);
		col1.add(fill2, 0, 1);
		col1.add(l1, 0, 2);
		col1.add(fill1, 0, 3);
		col1.add(pass, 0, 3);
		col1.add(showPass, 0, 4);
		col1.add(logBtn, 0, 5);
		col1.add(label, 0, 6);
		col1.setAlignment(Pos.CENTER);
	  	col1.setPadding(new Insets(20,100,0,0)); 
	  	col1.prefWidthProperty().bind(bpane.widthProperty().divide(2)); 
	  
		Group group=new Group();
		group.getChildren().addAll(wall,roofLineH,roof,window,windowLineH,windowLineVertically,roofLine,chimney,line,upChimney,smoke,col1);
		
		bpane.setCenter(group);  //placing child pane in root pane
		bpane.setRight(col1);
		bpane.setStyle("-fx-background-color: LAVENDER;");   //makes color of background lavender
		Scene scene=new Scene(bpane,600,300);
        stg.setTitle("Log In");    //name the stage
		stg.setScene(scene);     //put the scene on the stage
		stg.show();    //show stage
		
	}
	
	public static void main(String[] args) {
		launch(args);
    }
	
}