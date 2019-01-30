/**
 * This program is an adder
 * 
 * @author Justin Kim
 */

package CSA;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Unitz15Lab1 extends Application {

	private TextField val1;
	private TextField val2;
	private TextField sum;

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Simple Calculator");
		GridPane rootNode = new GridPane();
		rootNode.setPadding(new Insets(30));
		rootNode.setHgap(5);
		rootNode.setVgap(5);

		Scene scene = new Scene(rootNode, 500, 300);

		// fields and button
		val1 = new TextField();
		rootNode.add(new Label("First Value: "), 0, 0);
		rootNode.add(val1, 5, 0);
		val2 = new TextField();
		rootNode.add(new Label("Second Value: "), 0, 1);
		rootNode.add(val2, 5, 1);
		sum = new TextField();
		sum.setEditable(false);
		rootNode.add(new Label("Sum is: "), 0, 2);
		rootNode.add(sum, 5, 2);

		Button submit = new Button("Calculate");
		submit.setOnAction(new ButtonHandler());
		rootNode.add(submit, 6, 5);

		// show screen
		window.setScene(scene);
		window.show();
	}

	class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			sum.setText("" + (Integer.parseInt(val1.getText()) + Integer.parseInt(val2.getText())));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}