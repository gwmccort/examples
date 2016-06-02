package FXCharts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FxChartsExample5 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the X-Axis
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Year");
		// Customize the X-Axis, so points are scattered uniformly
		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(1900);
		xAxis.setUpperBound(2200);
		xAxis.setTickUnit(50);

		// Create the Y-Axis
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Population (in millions)");

		// Create the LineChart
		LineChart<Number,Number> chart = new LineChart<>(xAxis, yAxis);
		// Set the Title for the Chart
		chart.setTitle("Population by Year and Country");
		// Set the Data for the Chart
		ObservableList<XYChart.Series<Number,Number>> chartData = FxChartUtil.getCountrySeries();
		chart.setData(chartData);

		// Create the Stackpane
		StackPane root = new StackPane(chart);

		// Set the Style-properties of the Pane
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Stylesheet to the Scene
		scene.getStylesheets().add(getClass().getResource("linechart.css").toExternalForm());
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("A Line Chart Example");
		// Display the Stage
		stage.show();
	}
}
