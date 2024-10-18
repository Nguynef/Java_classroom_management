/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.viettuts.qlsv.entity;

/**
 *
 * @author Lenovo
 */
public class Room {
    private String roomName;
    private int machineCount;
    private boolean projector;
    private boolean whiteboard;
    private boolean internet;

    // Constructor
    public Room(String roomName, int machineCount, boolean projector, boolean whiteboard, boolean internet) {
        this.roomName = roomName;
        this.machineCount = machineCount;
        this.projector = projector;
        this.whiteboard = whiteboard;
        this.internet = internet;
    }

    // Getters and setters
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMachineCount() {
        return machineCount;
    }

    public void setMachineCount(int machineCount) {
        this.machineCount = machineCount;
    }

    public boolean hasProjector() {
        return projector;
    }

    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    public boolean hasWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(boolean whiteboard) {
        this.whiteboard = whiteboard;
    }

    public boolean hasInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }
}
