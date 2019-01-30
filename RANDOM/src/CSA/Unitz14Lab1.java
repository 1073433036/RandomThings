/**
 * This program calculates loans
 * 
 * @author Justin Kim
 */

package CSA;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Unitz14Lab1 extends Application {

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Loan Calculator");
		GridPane rootNode = new GridPane();
		rootNode.setPadding(new Insets(30));
		rootNode.setHgap(5);
		rootNode.setVgap(5);

		Scene scene = new Scene(rootNode, 500, 300);

		// fields and button
		TextField annualInterestRate = new TextField();
		rootNode.add(new Label("Annual Interest Rate: "), 0, 0);
		rootNode.add(annualInterestRate, 5, 0);
		TextField numYears = new TextField();
		rootNode.add(new Label("Number of Years: "), 0, 1);
		rootNode.add(numYears, 5, 1);
		TextField loanAmt = new TextField();
		rootNode.add(new Label("Loan Amount: "), 0, 2);
		rootNode.add(loanAmt, 5, 2);
		TextField monthlyPayment = new TextField();
		rootNode.add(new Label("Monthly Payment: "), 0, 3);
		rootNode.add(monthlyPayment, 5, 3);
		TextField totalPayment = new TextField();
		totalPayment.setEditable(false);
		rootNode.add(new Label("Total Payment: "), 0, 4);
		rootNode.add(totalPayment, 5, 4);
		Button submit = new Button("submit");
		rootNode.add(submit, 6, 5);

		// show screen
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
