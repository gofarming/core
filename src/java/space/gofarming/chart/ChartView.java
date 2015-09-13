/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.chart;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author aida
 */
@ManagedBean
@SessionScoped
public class ChartView implements Serializable {

    private LineChartModel areaModel;

    @PostConstruct
    public void init() {
        createAreaModel();
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    private void createAreaModel() {
        areaModel = new LineChartModel();

        LineChartSeries bids = new LineChartSeries();
        bids.setFill(true);
        bids.setLabel("Bids");
        bids.set("2004", 120);
        bids.set("2005", 100);
        bids.set("2006", 44);
        bids.set("2007", 150);
        bids.set("2008", 25);

        LineChartSeries offers = new LineChartSeries();
        offers.setFill(true);
        offers.setLabel("Offers");
        offers.set("2004", 52);
        offers.set("2005", 60);
        offers.set("2006", 110);
        offers.set("2007", 90);
        offers.set("2008", 120);

        areaModel.addSeries(bids);
        areaModel.addSeries(offers);

        areaModel.setTitle("Bids Chart");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        CategoryAxis xAxis = new CategoryAxis("Years");
        areaModel.getAxes().put(AxisType.X, xAxis);
        org.primefaces.model.chart.Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Bids and Offers");
        yAxis.setMin(0);
        yAxis.setMax(300);
    }

}
