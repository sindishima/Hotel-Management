import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;

public class Room extends Application{
	public String number;
	public boolean available=true;
	static VBox vbox = new VBox();
	
	static TableView<roomType> table=new TableView<roomType>();

	
	 
	public Room(String number, boolean available) {
		
		this.number = number;
		this.available = available;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}	
	
	@SuppressWarnings("unchecked")
	public static Scene getScene() {
	
	TableColumn<roomType,String> numberCol = new TableColumn<>("Room no.:");
    numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
    numberCol.setMinWidth(100);
    TableColumn<roomType,String> typeCol = new TableColumn<>("Room type:");
    typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    typeCol.setMinWidth(100);
    TableColumn<roomType,Boolean> availabilityCol = new TableColumn<>("Available");
    availabilityCol.setCellValueFactory(new PropertyValueFactory<>("available"));
    availabilityCol.setMinWidth(100);
    availabilityCol.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    availabilityCol.setOnEditCommit(new EventHandler<CellEditEvent<roomType, Boolean>>() {

		@Override
		public void handle(CellEditEvent<roomType, Boolean> event) {
			roomType newer = event.getRowValue();
			newer.setAvailable(event.getNewValue());
			
		}
	});
    
    TableColumn<roomType,Integer> priceCol = new TableColumn<>("Price");
    priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    priceCol.setMinWidth(100);
    ObservableList<roomType> rooms=FXCollections.observableArrayList();//to store all rooms

	
    table.getColumns().addAll(numberCol,typeCol,availabilityCol,priceCol);
    table.setEditable(true);
    table.setItems(roomsdatabase());
    //table.setItems(moreCheckIn.r);
    
    
    
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().add(table);
    StackPane pane=new StackPane();
    pane.getChildren().add(vbox);
    
  
	Group group=new Group();
	Scene scene=new Scene(group,430,425);
   ((Group) scene.getRoot()).getChildren().addAll(vbox);
   
    
    
    return scene;
	}
	
	public static ObservableList<roomType> roomsdatabase(){
		ObservableList<roomType> rooms=FXCollections.observableArrayList(); //to store all rooms
		rooms.add(new roomType("101",true,"single"));
		rooms.add(new roomType("102",true,"single"));
		rooms.add(new roomType("103",true,"single"));
		rooms.add(new roomType("104",true,"single"));
		rooms.add(new roomType("105",true,"single"));
		rooms.add(new roomType("106",true,"single"));
		rooms.add(new roomType("107",true,"single"));
		rooms.add(new roomType("108",true,"single"));
		rooms.add(new roomType("109",true,"single"));
		rooms.add(new roomType("201",true,"double"));
		rooms.add(new roomType("202",true,"double"));
		rooms.add(new roomType("203",true,"double"));
		rooms.add(new roomType("204",true,"double"));
		rooms.add(new roomType("205",true,"double"));
		rooms.add(new roomType("206",true,"double"));
		rooms.add(new roomType("207",true,"double"));
		rooms.add(new roomType("208",true,"double"));
		rooms.add(new roomType("209",true,"double"));
		rooms.add(new roomType("301",true,"suite"));
		rooms.add(new roomType("302",true,"suite"));
		rooms.add(new roomType("303",true,"suite"));
		rooms.add(new roomType("304",true,"suite"));
		rooms.add(new roomType("401",true,"suite"));
		rooms.add(new roomType("402",true,"suite"));
		rooms.add(new roomType("403",true,"suite"));
		rooms.add(new roomType("404",true,"suite"));
		return rooms;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
 }