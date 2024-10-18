package vn.viettuts.qlsv.view;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
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

        roomTable.setModel(new DefaultTableModel(data, columnNames));
        jScrollPaneRoomTable.setViewportView(roomTable);
        jScrollPaneRoomTable.setPreferredSize(new Dimension(480, 300));

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneRoomTable);

        panel.add(addRoomBtn);
        panel.add(editRoomBtn);
        panel.add(deleteRoomBtn);
        panel.add(clearBtn);
        panel.add(assignClassesBtn);

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
        layout.putConstraint(SpringLayout.WEST, assignClassesBtn, 60, SpringLayout.WEST, clearBtn);
        layout.putConstraint(SpringLayout.NORTH, assignClassesBtn, 200, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Room Information");
        this.setSize(800, 420);
        editRoomBtn.setEnabled(false);
        deleteRoomBtn.setEnabled(false);
        addRoomBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showListRooms(List<Room> list) {
        int size = list.size();
        Object[][] rooms = new Object[size][5];
        for (int i = 0; i < size; i++) {
            rooms[i][0] = list.get(i).getRoomName();
            rooms[i][1] = list.get(i).getMachineCount();
            rooms[i][2] = list.get(i).hasProjector();
            rooms[i][3] = list.get(i).hasWhiteboard();
            rooms[i][4] = list.get(i).hasInternet();
        }
        roomTable.setModel(new DefaultTableModel(rooms, columnNames));
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
        } catch (Exception e) {
            showMessage("Invalid input: " + e.getMessage());
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
}
