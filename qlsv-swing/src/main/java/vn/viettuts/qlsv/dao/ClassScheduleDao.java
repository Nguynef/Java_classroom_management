package vn.viettuts.qlsv.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import vn.viettuts.qlsv.entity.ClassSchedule;
import vn.viettuts.qlsv.entity.ClassScheduleXML;
import vn.viettuts.qlsv.utils.FileUtils;

public class ClassScheduleDao {
    private static final String CLASS_SCHEDULE_FILE_NAME = "class_schedule.xml";
    private List<ClassSchedule> classSchedules;

    public ClassScheduleDao() {
        // Check if the file exists, and create it if it doesn't
        File file = new File(CLASS_SCHEDULE_FILE_NAME);
        if (!file.exists()) {
            createDefaultXMLFile(CLASS_SCHEDULE_FILE_NAME);
        }
        
        // Initialize classSchedules by reading from the XML file
        this.classSchedules = readClassSchedules();
        if (classSchedules == null) {
            classSchedules = new ArrayList<>();
        }
    }

    // Method to write class schedules to the XML file
    public void writeClassSchedules(List<ClassSchedule> schedules) {
        ClassScheduleXML classScheduleXML = new ClassScheduleXML();
        classScheduleXML.setClassSchedules(schedules);
        FileUtils.writeXMLtoFile(CLASS_SCHEDULE_FILE_NAME, classScheduleXML);
    }

    // Method to read class schedules from the XML file
    public List<ClassSchedule> readClassSchedules() {
        List<ClassSchedule> list = new ArrayList<>();
        ClassScheduleXML classScheduleXML = (ClassScheduleXML) FileUtils.readXMLFile(CLASS_SCHEDULE_FILE_NAME, ClassScheduleXML.class);
        if (classScheduleXML != null) {
            list = classScheduleXML.getClassSchedules();
        }
        return list;
    }

    // Method to add a new class schedule
    public void addClassSchedule(ClassSchedule schedule) {
        classSchedules.add(schedule);
        writeClassSchedules(classSchedules);
    }

    // Getter for the list of class schedules
    public List<ClassSchedule> getClassSchedules() {
        return classSchedules;
    }

    // Private method to create a default XML file if it doesn't exist
    private void createDefaultXMLFile(String filePath) {
        try {
            File file = new File(filePath);
            file.createNewFile(); // Create the file
            
            // Write default content to the file (an empty root element)
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<classSchedules></classSchedules>");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create the default XML file: " + filePath);
        }
    }
}
