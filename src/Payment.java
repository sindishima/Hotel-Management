import java.util.concurrent.TimeUnit;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class Payment {
	
	static TextField idd=new TextField();
	static TextField Minibar=new TextField();
	static TextField TotalPayment=new TextField();
	static Button btCalculate=new Button("Calculate");
	 
	 static Payment p=new Payment();
	
	public static Scene getScene() {
		
		GridPane calculator=new GridPane();
		calculator.setHgap(5);
		calculator.setVgap(20);
		
		DropShadow shadow = new DropShadow();
	    shadow.setOffsetY(5.0);
	    shadow.setOffsetX(5.0);
	
		Label l0=new Label("Guest's ID");
		Label l1=new Label("Minibar Price");
		Label l2=new Label("Total Payment");		
		
		calculator.add(l0,1,1);
		l0.setStyle("-fx-font-weight: bold");
		l0.setTextFill(Color.BLACK);
		calculator.add(idd,2,1);
		idd.setStyle("-fx-background-color: WHITE;");
		
		calculator.add(l1,1,2);
		l1.setStyle("-fx-font-weight: bold");
		l1.setTextFill(Color.BLACK);
		calculator.add(Minibar,2,2);
		Minibar.setStyle("-fx-background-color: WHITE;");
		
		calculator.add(l2,1,3);
		l2.setStyle("-fx-font-weight: bold");
		l2.setTextFill(Color.BLACK);
		calculator.add(TotalPayment,2,3);
		TotalPayment.setStyle("-fx-background-color: WHITE;");
		
		
		calculator.add(btCalculate,2,4);
		btCalculate.setTextFill(Color.BLACK);
		btCalculate.setStyle("-fx-background-color: PLUM; -fx-font-weight: bold");
		btCalculate.setEffect(shadow);
		
		calculator.setPadding(new Insets(75,0,0,25)); 
		  
	
		btCalculate.setOnAction(e-> CalculateTotalPayment());
		
		StackPane st=new StackPane();
		//st.setStyle("-fx-background-color: THISTLE;");
		//st.getChildren().addAll(calculator);
		
	//	ImageView color=new ImageView(new Image("pink.png"));
	//	color.setFitHeight(400);
	//	color.setFitWidth(300);
		st.getChildren().addAll(calculator);
		
		
		st.setStyle("-fx-background-color: THISTLE;");
		Scene scene1=new Scene(st,300,400);
		return scene1;
	}
	
	public static void CalculateTotalPayment() {
		long amount;
		for (Costumer i:AddCostumer.costumer) {
			if (idd.getText().equals(i.getID())) {
				long diffInMillies = Math.abs(i.getCheckout().getTime()- i.getCheckin().getTime());
				long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				if(i.getRoomType().equals("Suite")) {
					amount=diff*200+Long.parseLong(Minibar.getText());
					TotalPayment.setText(""+amount);
					i.setPay((int)amount);
				}
				else if(i.getRoomType().equals("Double Room")) {
					amount=diff*100+Long.parseLong(Minibar.getText());
					TotalPayment.setText(""+amount);
					i.setPay((int)amount);
				}
				else {
					amount=diff*50+Long.parseLong(Minibar.getText());
					TotalPayment.setText(""+amount);
					i.setPay((int)amount);
				}
				
			}
		}

	}
}