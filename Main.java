// Azizul Hakim

import javafx.animation.*; 
import javafx.application.Application;
import javafx.scene.Scene;
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
		
		Arc arc = new Arc(340, 210, 130, 120, 0, -180);
		// Make transition line invisible
		arc.setStroke(Color.rgb(250, 250, 250));
		arc.setFill(null);		

		PathTransition path = new PathTransition();
		path.setInterpolator(Interpolator.LINEAR);
		path.setDuration(Duration.millis(5000));
		path.setPath(arc);
		path.setNode(pendulum);
		
		Pane paneAnimate = new Pane(); 
		paneAnimate.setMinSize(600, 400);
		paneAnimate.getChildren().addAll(pendulum, arc);
			
		VBox vb = new VBox();
		vb.getChildren().addAll(paneAnimate);
		
		// Make pendulum go back and forth
		path.setAutoReverse(true);
		path.setCycleCount(Timeline.INDEFINITE); 
		path.play();
		
		Scene scene = new Scene (vb, 300, 300);
		stage.setScene(scene); 
		stage.setTitle("Project 4");
		stage.setWidth(650);
		stage.setHeight(500);
		stage.show();
	}

}
