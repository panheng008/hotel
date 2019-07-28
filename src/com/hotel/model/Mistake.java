package com.hotel.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_mistake")
public class Mistake {
    
	private int id;
	private String type;//异常类型
	private String detail;//详情描述
	private String remark;//备注
	private int isRepair;//是否修理1：未修理 2.已修理
    
	@Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    
    public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public int getIsRepair() {
		return isRepair;
	}

	public void setIsRepair(int isRepair) {
		this.isRepair = isRepair;
	}

    
  
   
	
	
}
