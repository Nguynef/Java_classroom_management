package vn.viettuts.qlsv.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import vn.viettuts.qlsv.entity.Room;

public class RoomView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton addRoomBtn;
    private JButton editRoomBtn;
    private JButton deleteRoomBtn;
    private JButton clearBtn;
    private JButton assignClassesBtn;
    private JButton searchRoomBtn;
    private JButton showChartBtn;
    private JButton exportReportBtn;
    private JScrollPane jScrollPaneRoomTable;
    private JTable roomTable;

    private JLabel roomNumberLabel;
    private JLabel machineCountLabel;
    private JLabel projectorLabel;
    private JLabel whiteboardLabel;
    private JLabel internetLabel;

    private JTextField roomNumberField;
    private JTextField machineCountField;
    private JCheckBox projectorCheckbox;
    private JCheckBox whiteboardCheckbox;
    private JCheckBox internetCheckbox;

    private JTextField searchMachineCountField;
    private JCheckBox searchProjectorCheckbox;
    private JCheckBox searchWhiteboardCheckbox;
    private JCheckBox searchInternetCheckbox;

    private String[] columnNames = new String[]{
        "Room Number", "Machine Count", "Projector", "Whiteboard", "Internet"
    };
    private Object[][] data = new Object[][]{};

    public RoomView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addRoomBtn = new JButton("Add");
        editRoomBtn = new JButton("Edit");
        deleteRoomBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        assignClassesBtn = new JButton("Assign Classes");
        searchRoomBtn = new JButton("Search Room");
        showChartBtn = new JButton("Show chart");
        exportReportBtn = new JButton("Export PDF");

        jScrollPaneRoomTable = new JScrollPane();
        roomTable = new JTable();

        roomNumberLabel = new JLabel("Room Number");
        machineCountLabel = new JLabel("Machine Count");
        projectorLabel = new JLabel("Projector");
        whiteboardLabel = new JLabel("Whiteboard");
        internetLabel = new JLabel("Internet");

        roomNumberField = new JTextField(6);
        machineCountField = new JTextField(15);
        projectorCheckbox = new JCheckBox();
        whiteboardCheckbox = new JCheckBox();
        internetCheckbox = new JCheckBox();

        searchMachineCountField = new JTextField(5);
        searchProjectorCheckbox = new JCheckBox("Projector");
        searchWhiteboardCheckbox = new JCheckBox("Whiteboard");
        searchInternetCheckbox = new JCheckBox("Internet");

        roomTable.setModel(new DefaultTableModel(data, columnNames));
        jScrollPaneRoomTable.setViewportView(roomTable);
        jScrollPaneRoomTable.setPreferredSize(new Dimension(480, 300));

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 500);
        panel.setLayout(layout);
        panel.add(jScrollPaneRoomTable);

        panel.add(addRoomBtn);
        panel.add(editRoomBtn);
        panel.add(deleteRoomBtn);
        panel.add(clearBtn);
        panel.add(assignClassesBtn);
        panel.add(showChartBtn);
        panel.add(exportReportBtn);

        panel.add(roomNumberLabel);
        panel.add(machineCountLabel);
        panel.add(projectorLabel);
        panel.add(whiteboardLabel);
        panel.add(internetLabel);

        panel.add(roomNumberField);
        panel.add(machineCountField);
        panel.add(projectorCheckbox);
        panel.add(whiteboardCheckbox);
        panel.add(internetCheckbox);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Machine Count:"));
        searchPanel.add(searchMachineCountField);
        searchPanel.add(searchProjectorCheckbox);
        searchPanel.add(searchWhiteboardCheckbox);
        searchPanel.add(searchInternetCheckbox);
        searchPanel.add(searchRoomBtn);
        panel.add(searchPanel);

        layout.putConstraint(SpringLayout.WEST, roomNumberLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, roomNumberLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, machineCountLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, machineCountLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, projectorLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, projectorLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, whiteboardLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, whiteboardLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, internetLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, internetLabel, 130, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, roomNumberField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, roomNumberField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, machineCountField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, machineCountField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, projectorCheckbox, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, projectorCheckbox, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, whiteboardCheckbox, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, whiteboardCheckbox, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, internetCheckbox, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, internetCheckbox, 130, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneRoomTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneRoomTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addRoomBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addRoomBtn, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editRoomBtn, 60, SpringLayout.WEST, addRoomBtn);
        layout.putConstraint(SpringLayout.NORTH, editRoomBtn, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteRoomBtn, 60, SpringLayout.WEST, editRoomBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteRoomBtn, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 60, SpringLayout.WEST, deleteRoomBtn);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, assignClassesBtn, -180, SpringLayout.WEST, clearBtn);
        layout.putConstraint(SpringLayout.NORTH, assignClassesBtn, 230, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, showChartBtn,20 ,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, showChartBtn, 20, SpringLayout.SOUTH, assignClassesBtn);
        layout.putConstraint(SpringLayout.WEST, exportReportBtn, 60, SpringLayout.EAST, showChartBtn);
        layout.putConstraint(SpringLayout.NORTH,exportReportBtn, 20, SpringLayout.SOUTH, assignClassesBtn);
        
        layout.putConstraint(SpringLayout.WEST, searchPanel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchPanel, 300, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Room Information");
        this.setSize(800, 500);
        editRoomBtn.setEnabled(false);
        deleteRoomBtn.setEnabled(false);
        addRoomBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showListRooms(List<Room> rooms) {
        DefaultTableModel model = (DefaultTableModel) roomTable.getModel();
        model.setRowCount(0); // Xóa các hàng cũ trong bảng
        for (Room room : rooms) {
            model.addRow(new Object[]{
                room.getRoomName(),
                room.getMachineCount(),
                room.hasProjector(),
                room.hasWhiteboard(),
                room.hasInternet()
            });
        }
    }

    public void fillRoomFromSelectedRow() {
        int row = roomTable.getSelectedRow();
        if (row >= 0) {
            roomNumberField.setText(roomTable.getModel().getValueAt(row, 0).toString());
            machineCountField.setText(roomTable.getModel().getValueAt(row, 1).toString());
            projectorCheckbox.setSelected((boolean) roomTable.getModel().getValueAt(row, 2));
            whiteboardCheckbox.setSelected((boolean) roomTable.getModel().getValueAt(row, 3));
            internetCheckbox.setSelected((boolean) roomTable.getModel().getValueAt(row, 4));
            editRoomBtn.setEnabled(true);
            deleteRoomBtn.setEnabled(true);
            addRoomBtn.setEnabled(false);
        }
    }

    public void clearRoomInfo() {
        roomNumberField.setText("");
        machineCountField.setText("");
        projectorCheckbox.setSelected(false);
        whiteboardCheckbox.setSelected(false);
        internetCheckbox.setSelected(false);
        editRoomBtn.setEnabled(false);
        deleteRoomBtn.setEnabled(false);
        addRoomBtn.setEnabled(true);
    }

    public Room getRoomInfo() {
        try {
            String roomName = roomNumberField.getText().trim();
            int machineCount = Integer.parseInt(machineCountField.getText().trim());
            boolean projector = projectorCheckbox.isSelected();
            boolean whiteboard = whiteboardCheckbox.isSelected();
            boolean internet = internetCheckbox.isSelected();

            return new Room(roomName, machineCount, projector, whiteboard, internet);
        } catch (NumberFormatException e) {
            showMessage("Please enter valid data.");
            return null;
        }
    }

    public void addAddRoomListener(ActionListener listener) {
        addRoomBtn.addActionListener(listener);
    }

    public void editRoomListener(ActionListener listener) {
        editRoomBtn.addActionListener(listener);
    }

    public void deleteRoomListener(ActionListener listener) {
        deleteRoomBtn.addActionListener(listener);
    }

    public void clearRoomListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addListRoomSelectionListener(ListSelectionListener listener) {
        roomTable.getSelectionModel().addListSelectionListener(listener);
    }

    public void addAssignClassesListener(ActionListener listener) {
        assignClassesBtn.addActionListener(listener);
    }

    public void addSearchRoomListener(ActionListener listener) {
        searchRoomBtn.addActionListener(listener);
    }

    // Các phương thức cho tìm kiếm
    public int getMachineCountCriteria() {
        try {
            return searchMachineCountField.getText().isEmpty() ? -1 : Integer.parseInt(searchMachineCountField.getText().trim());
        } catch (NumberFormatException e) {
            showMessage("Invalid machine count criteria");
            return -1;
        }
    }

    public boolean isProjectorRequired() {
        return searchProjectorCheckbox.isSelected();
    }

    public boolean isWhiteboardRequired() {
        return searchWhiteboardCheckbox.isSelected();
    }

    public boolean isInternetRequired() {
        return searchInternetCheckbox.isSelected();
    }
    
    public void addShowChartListener(ActionListener listener){
        showChartBtn.addActionListener(listener);
    }
    public void addExportReportListener(ActionListener listener){
        exportReportBtn.addActionListener(listener);
    }
}
