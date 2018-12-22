package com.hm.sys.entity;

import java.util.Date;

public class StayInfo {
    private Integer id;

    private Integer orderId;

    private Integer roomId;

    private Integer customerId;

    private Date stayDate;

    private Integer stayDayCount;

    private Integer stayManCount;

    private Float cash;

    private Date leaveDate;

    private Integer isCheckout;

    private String operator;

    private Date createdtime;

    private Date modifiedtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getStayDate() {
        return stayDate;
    }

    public void setStayDate(Date stayDate) {
        this.stayDate = stayDate;
    }

    public Integer getStayDayCount() {
        return stayDayCount;
    }

    public void setStayDayCount(Integer stayDayCount) {
        this.stayDayCount = stayDayCount;
    }

    public Integer getStayManCount() {
        return stayManCount;
    }

    public void setStayManCount(Integer stayManCount) {
        this.stayManCount = stayManCount;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getIsCheckout() {
        return isCheckout;
    }

    public void setIsCheckout(Integer isCheckout) {
        this.isCheckout = isCheckout;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cash == null) ? 0 : cash.hashCode());
		result = prime * result + ((createdtime == null) ? 0 : createdtime.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isCheckout == null) ? 0 : isCheckout.hashCode());
		result = prime * result + ((leaveDate == null) ? 0 : leaveDate.hashCode());
		result = prime * result + ((modifiedtime == null) ? 0 : modifiedtime.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((stayDate == null) ? 0 : stayDate.hashCode());
		result = prime * result + ((stayDayCount == null) ? 0 : stayDayCount.hashCode());
		result = prime * result + ((stayManCount == null) ? 0 : stayManCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StayInfo other = (StayInfo) obj;
		if (cash == null) {
			if (other.cash != null)
				return false;
		} else if (!cash.equals(other.cash))
			return false;
		if (createdtime == null) {
			if (other.createdtime != null)
				return false;
		} else if (!createdtime.equals(other.createdtime))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCheckout == null) {
			if (other.isCheckout != null)
				return false;
		} else if (!isCheckout.equals(other.isCheckout))
			return false;
		if (leaveDate == null) {
			if (other.leaveDate != null)
				return false;
		} else if (!leaveDate.equals(other.leaveDate))
			return false;
		if (modifiedtime == null) {
			if (other.modifiedtime != null)
				return false;
		} else if (!modifiedtime.equals(other.modifiedtime))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (stayDate == null) {
			if (other.stayDate != null)
				return false;
		} else if (!stayDate.equals(other.stayDate))
			return false;
		if (stayDayCount == null) {
			if (other.stayDayCount != null)
				return false;
		} else if (!stayDayCount.equals(other.stayDayCount))
			return false;
		if (stayManCount == null) {
			if (other.stayManCount != null)
				return false;
		} else if (!stayManCount.equals(other.stayManCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StayInfo [id=" + id + ", orderId=" + orderId + ", roomId=" + roomId + ", customerId=" + customerId
				+ ", stayDate=" + stayDate + ", stayDayCount=" + stayDayCount + ", stayManCount=" + stayManCount
				+ ", cash=" + cash + ", leaveDate=" + leaveDate + ", isCheckout=" + isCheckout + ", operator="
				+ operator + ", createdtime=" + createdtime + ", modifiedtime=" + modifiedtime + "]";
	}
    
	
    
    
}