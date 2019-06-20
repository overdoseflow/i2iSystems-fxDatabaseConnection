package getDataFromButtonFX;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class main extends Application{

	private String username;

	public void start(Stage primaryStage){
		 primaryStage.setTitle("JavaFX Welcome");
	        
	     primaryStage.show();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		final TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		username = userTextField.getText();
		
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		final PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		final String pass = pwBox.getText();
		
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			 
			
		    public void handle(ActionEvent e) {
		    	 actiontarget.setFill(Color.FIREBRICK);
		         actiontarget.setText("Your username and password are adding to database...");
		         
		         
		         
		         System.out.println(userTextField.getText() + "  " + pwBox.getText());
		         
		         

		 		String sorgu = "insert into employees values( ";
		 		sorgu += "'" + userTextField.getText() +"'"+ "," +"'"+ pwBox.getText()  +"')";
		 		  try {
		 			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.99.100:32769:xe","SYSTEM","oracle");
		 		    Statement statement = conn.createStatement();
		 		    statement.executeUpdate(sorgu);
		 		} catch (SQLException e1) {
		 			// TODO Auto-generated catch block
		 			e1.printStackTrace();
		 		}
		        		    }
		});
		

	}
	
	public static void main(String[] args){
		launch(args);
		
	}

}
