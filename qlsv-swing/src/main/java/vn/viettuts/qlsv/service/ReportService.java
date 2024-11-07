package vn.viettuts.qlsv.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.viettuts.qlsv.entity.Room;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    public void generateReport(List<Room> rooms) {
        try {
            // Đường dẫn tới file .jrxml của bạn
            JasperReport jasperReport = JasperCompileManager.compileReport("path/to/RoomReport.jrxml");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(rooms);

            // Đường dẫn tới thư mục Desktop của người dùng
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "RoomReport.pdf";

            Map<String, Object> parameters = new HashMap<>();
            StatisticsService statsService = new StatisticsService();
            parameters.put("totalRooms", statsService.getTotalRooms(rooms));
            parameters.put("totalMachines", statsService.getTotalMachines(rooms));
            parameters.put("roomsWithProjectors", statsService.getRoomsWithProjectors(rooms));
            parameters.put("roomsWithWhiteboards", statsService.getRoomsWithWhiteboards(rooms));
            parameters.put("roomsWithInternet", statsService.getRoomsWithInternet(rooms));

            // Tạo file PDF và lưu trên Desktop
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, desktopPath);
            System.out.println("PDF saved at: " + desktopPath);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
