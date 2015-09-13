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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;

/**
 *
 * @author aida
 */
@ManagedBean
@SessionScoped
public class BubbleView implements Serializable {

    private BubbleChartModel bubbleModel1;
    private BubbleChartModel bubbleModel2;

    @PostConstruct
    public void init() {
        createBubbleModels();
    }

    public BubbleChartModel getBubbleModel1() {
        return bubbleModel1;
    }

    public BubbleChartModel getBubbleModel2() {
        return bubbleModel2;
    }

    private void createBubbleModels() {
        bubbleModel1 = initBubbleModel();
        bubbleModel1.setTitle("Bubble Chart");
        bubbleModel1.getAxis(AxisType.X).setLabel("Price");
        Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(250);
        yAxis.setLabel("Labels");

        bubbleModel2 = initBubbleModel();
        bubbleModel2.setTitle("Custom Options");
        bubbleModel2.setShadow(false);
        bubbleModel2.setBubbleGradients(true);
        bubbleModel2.setBubbleAlpha(0.8);
        bubbleModel2.getAxis(AxisType.X).setTickAngle(-50);
        yAxis = bubbleModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(250);
        yAxis.setTickAngle(50);
    }

    private BubbleChartModel initBubbleModel() {
        BubbleChartModel model = new BubbleChartModel();

        model.add(new BubbleChartSeries("Apples", 70, 183, 55));
        model.add(new BubbleChartSeries("Appricot", 45, 92, 36));
        model.add(new BubbleChartSeries("Ruspberry", 24, 104, 40));
        model.add(new BubbleChartSeries("Pear", 50, 123, 60));

        return model;
    }

}
