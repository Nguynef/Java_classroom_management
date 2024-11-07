package vn.viettuts.qlsv.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {
    @XmlElement
    private String roomName;
    
    @XmlElement
    private int machineCount;
    
    @XmlElement
    private boolean projector;
    
    @XmlElement
    private boolean whiteboard;
    
    @XmlElement
    private boolean internet;

    public Room() {}

    public Room(String roomName, int machineCount, boolean projector, boolean whiteboard, boolean internet) {
        this.roomName = roomName;
        this.machineCount = machineCount;
        this.projector = projector;
        this.whiteboard = whiteboard;
        this.internet = internet;
    }

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
