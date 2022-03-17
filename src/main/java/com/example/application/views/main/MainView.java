package com.example.application.views.main;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.AxisType;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataProviderSeries;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.ChartsData;
import com.ChartsData.WeatherInfo;

@PageTitle("Main")
@Route(value = "/")
public class MainView extends VerticalLayout {

    public MainView() {
        ChartsData data = new ChartsData();
        Chart humidChart = getHumidityChart(data);
        Chart tempChart = getTemperatureChart(data);
        setMargin(true);
        //setVerticalComponentAlignment(Alignment.END, tempChart, humidChart);

        add(tempChart, humidChart);
    }

    public Chart getHumidityChart(ChartsData data){
    
        Chart HumidityChart = new Chart();
        Configuration HumidChartConf = HumidityChart.getConfiguration();
        HumidChartConf.setTitle("Humidity");
        HumidChartConf.getChart().setType(ChartType.LINE);
    
        ListDataProvider<WeatherInfo> dataProvider = new ListDataProvider<>(data.getWeatherData());
        DataProviderSeries<WeatherInfo> humidity = new DataProviderSeries<>(dataProvider);
        
        humidity.setName("Humidity");
        humidity.setX(WeatherInfo::getInstant);
        humidity.setY(WeatherInfo::getHumidity);

        HumidChartConf.addSeries(humidity);

        HumidChartConf.getxAxis().setTitle("Time");
        HumidChartConf.getxAxis().setType(AxisType.DATETIME);
        HumidChartConf.getyAxis().setTitle("Humidity (%)");

        return HumidityChart;
    }

    public Chart getTemperatureChart(ChartsData data){
        Chart TemperatureChart = new Chart();
        Configuration TempChartConf = TemperatureChart.getConfiguration();
        TempChartConf.setTitle("Temperature");
        TempChartConf.getChart().setType(ChartType.LINE);
        
        ListDataProvider<WeatherInfo> dataProvider = new ListDataProvider<>(data.getWeatherData());
        DataProviderSeries<WeatherInfo> temp = new DataProviderSeries<>(dataProvider);

        temp.setName("Temperature");
        temp.setX(WeatherInfo::getInstant);
        temp.setY(WeatherInfo::getTemperature);

        TempChartConf.addSeries(temp);

        TempChartConf.getxAxis().setTitle("Time");
        TempChartConf.getxAxis().setType(AxisType.DATETIME);
        TempChartConf.getyAxis().setTitle("Temperature (\u2103)");

        return TemperatureChart;
    }
}
