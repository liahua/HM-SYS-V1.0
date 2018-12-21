package com.hm.sys.entity;

public class RoomInfo {
    private Integer id;

    private Integer rtId;

    private String roomName;

    private String roomAdd;

    private Integer bedNum;

    private Integer statId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getRoomAdd() {
        return roomAdd;
    }

    public void setRoomAdd(String roomAdd) {
        this.roomAdd = roomAdd == null ? null : roomAdd.trim();
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public Integer getStatId() {
        return statId;
    }

    public void setStatId(Integer statId) {
        this.statId = statId;
    }
}