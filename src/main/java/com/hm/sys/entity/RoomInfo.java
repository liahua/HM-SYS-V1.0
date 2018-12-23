package com.hm.sys.entity;

public class RoomInfo {
    private Integer id;

    private Integer rtId;

    private String roomName;

    private String roomAdd;

    private Integer bedNum;
    //房间类型
    private String rtName;
    //房间价格
    private Double priceUp;

    private Integer statId;
    //房间状态
    private String stat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRtId() {
        return rtId;
    }

    public String getRtName() {
		return rtName;
	}

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	public Double getPriceUp() {
		return priceUp;
	}

	public void setPriceUp(Double priceUp) {
		this.priceUp = priceUp;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
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

	@Override
	public String toString() {
		return "RoomInfo [id=" + id + ", rtId=" + rtId + ", roomName=" + roomName + ", roomAdd=" + roomAdd + ", bedNum="
				+ bedNum + ", statId=" + statId + "]";
	}
    
}