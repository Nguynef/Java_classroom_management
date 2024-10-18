package vn.viettuts.qlsv.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomXML {
    
    private List<Room> room;

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}
