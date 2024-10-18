package vn.viettuts.qlsv.view;

import vn.viettuts.qlsv.entity.ClassSchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AssignClassesView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> roomComboBox;
    private JTextField classNameField;
    private JComboBox<String> dayOfWeekComboBox;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JButton addClassBtn;
    private JTable classesTable;
    private JScrollPane jScrollPaneClassesTable;

    private String[] columnNames = {"Class Name", "Room", "Day", "Start Time", "End Time"};
    private Object[][] data = {};

    public AssignClassesView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assign Classes to Rooms");

        roomComboBox = new JComboBox<>();
        classNameField = new JTextField(15);
        dayOfWeekComboBox = new JComboBox<>(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
        startTimeField = new JTextField(5);
        endTimeField = new JTextField(5);
        addClassBtn = new JButton("Add Class");
        classesTable = new JTable();
        jScrollPaneClassesTable = new JScrollPane(classesTable);
        classesTable.setModel(new DefaultTableModel(data, columnNames));

        jScrollPaneClassesTable.setPreferredSize(new Dimension(480, 300));
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.add(new JLabel("Class Name:"));
        panel.add(classNameField);
        panel.add(new JLabel("Room:"));
        panel.add(roomComboBox);
        panel.add(new JLabel("Day:"));
        panel.add(dayOfWeekComboBox);
        panel.add(new JLabel("Start Time (HH:MM):"));
        panel.add(startTimeField);
        panel.add(new JLabel("End Time (HH:MM):"));
        panel.add(endTimeField);
        panel.add(addClassBtn);
        
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(jScrollPaneClassesTable, BorderLayout.CENTER);
        pack();
        setSize(600, 400);
    }

    // Method to add listener for adding a class
    public void addClassListener(ActionListener listener) {
        addClassBtn.addActionListener(listener);
    }

    // Getter methods for retrieving user input
    public String getClassName() {
        return classNameField.getText();
    }

    public String getSelectedRoom() {
        return (String) roomComboBox.getSelectedItem();
    }

    public String getSelectedDay() {
        return (String) dayOfWeekComboBox.getSelectedItem();
    }

    public String getStartTime() {
        return startTimeField.getText();
    }

    public String getEndTime() {
        return endTimeField.getText();
    }

    // Method to update the table with the provided data
    public void updateClassesTable(Object[][] tableData) {
        classesTable.setModel(new DefaultTableModel(tableData, columnNames));
    }

    // Method to set room options in the combo box
    public void setRoomOptions(List<String> roomNames) {
        roomComboBox.removeAllItems();
        for (String roomName : roomNames) {
            roomComboBox.addItem(roomName);
        }
    }

    // Method to display messages to the user
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // New method to set class schedules in the table
    public void setClassSchedules(List<ClassSchedule> classSchedules) {
        Object[][] tableData = new Object[classSchedules.size()][5];
        for (int i = 0; i < classSchedules.size(); i++) {
            ClassSchedule schedule = classSchedules.get(i);
            tableData[i][0] = schedule.getClassName();
            tableData[i][1] = schedule.getRoom();
            tableData[i][2] = schedule.getDay();
            tableData[i][3] = schedule.getStartTime();
            tableData[i][4] = schedule.getEndTime();
        }
        updateClassesTable(tableData);
    }
}
