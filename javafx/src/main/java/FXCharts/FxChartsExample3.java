package FXCharts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FxChartsExample3 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the X-Axis
		CategoryAxis xAxis = new CategoryAxis();
		// Set the Label for the Axis
		xAxis.setLabel("Country");
		// Add the Categories to the Axis
		xAxis.getCategories().addAll("China", "India", "Brazil", "UK", "USA");

		// Create the Y-Axis
		NumberAxis yAxis = new NumberAxis();
		// Set the Label for the Axis
		yAxis.setLabel("Population (in millions)");

		// Create the Chart
		StackedBarChart<String, Number> chart = new StackedBarChart<>(xAxis, yAxis);
		// Set the Title for the Chart
		chart.setTitle("Population by Country and Year");
		// Set the data for the chart
		ObservableList<XYChart.Series<String, Number>> chartData = FxChartUtil.getYearSeries();
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
		scene.getStylesheets().add(getClass().getResource("stackbarchart.css").toExternalForm());
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("A Vertical Stacked Bar Chart Example");
		// Display the Stage
		stage.show();
	}
}
