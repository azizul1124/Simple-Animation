// Azizul Hakim

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class Main extends Application
{

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void start(Stage stage)
	{
		
		Circle pendulum = new Circle(500, 260, 18);
		pendulum.setStroke(Color.rgb(190, 190,190)); 
		pendulum.setFill(Color.DARKORANGE);
		
		Arc arc = new Arc(300, 200, 240, 220, 0, -180);
		// Make transition line invisible
		arc.setStroke(Color.rgb(250, 250, 250));
		arc.setFill(null);		

		PathTransition path = new PathTransition();
		path.setInterpolator(Interpolator.LINEAR);
		path.setDuration(Duration.millis(5000));
		path.setPath(arc);
		path.setNode(pendulum);
		
		Line string = new Line(400, 200, 300, 20);
		string.setStroke(Color.rgb(0, 0, 0));
		string.setFill(Color.BLACK);

		PathTransition path2 = new PathTransition();
		path2.setInterpolator(Interpolator.LINEAR);
		path2.setDuration(Duration.millis(5000));
		path2.setPath(string);
		path2.setNode(pendulum);
	
		string.startXProperty().bind(pendulum.centerXProperty().add(pendulum.translateXProperty()));
		string.startYProperty().bind(pendulum.centerYProperty().add(pendulum.translateYProperty()));
		
		Pane paneAnimate = new Pane(); 
		paneAnimate.setMinSize(600, 400);
		paneAnimate.getChildren().addAll(string, arc, pendulum);
			
		Button exitbtn = new Button("Exit");
		exitbtn.setMaxSize(50, 50);
		
		//  make the program exit when you click 
		// the stop button 
		exitbtn.setOnAction(e->{
			
			System.exit(0);
		});
		
		VBox vb = new VBox();
		vb.getChildren().addAll(paneAnimate, exitbtn);
				
		// Make pendulum go back and forth
		path.setAutoReverse(true);
		path.setCycleCount(Timeline.INDEFINITE); 
		path.play();
		
		Scene scene = new Scene (vb, 300, 300);
		stage.setScene(scene); 
		stage.setTitle("Pendulum Animation");
		stage.setWidth(650);
		stage.setHeight(500);
		stage.show();
	}

}
