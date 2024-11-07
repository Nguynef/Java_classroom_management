package vn.viettuts.qlsv.service;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import vn.viettuts.qlsv.entity.Room;

import javax.swing.*;
import java.util.List;

public class ChartService {

    public JPanel createAmenitiesChart(List<Room> rooms) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        StatisticsService statsService = new StatisticsService();

        dataset.addValue(statsService.getRoomsWithProjectors(rooms), "Rooms", "Projector");
        dataset.addValue(statsService.getRoomsWithWhiteboards(rooms), "Rooms", "Whiteboard");
        dataset.addValue(statsService.getRoomsWithInternet(rooms), "Rooms", "Internet");

        JFreeChart chart = ChartFactory.createBarChart(
            "Room Amenities",
            "Amenity",
            "Number of Rooms",
            dataset,
            PlotOrientation.VERTICAL,
            false, true, false
        );

        return new ChartPanel(chart);
    }
}
