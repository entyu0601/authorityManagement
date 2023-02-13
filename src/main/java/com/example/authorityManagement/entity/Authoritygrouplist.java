package com.example.authorityManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authoritygrouplist")
public class Authoritygrouplist {

	// K2024 可能不需要這個entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Auto_Id")
	private int autoId;

	@Column(name = "Authority_Group_Name")
	private String authorityGroupName;

	@Column(name = "Authority_Group_ID")
	private String authorityGroupID;

	@Column(name = "Del_Flg")
	private boolean delFlg;

	public Authoritygrouplist() {

	}

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getAuthorityGroupName() {
		return authorityGroupName;
	}

	public void setAuthorityGroupName(String authorityGroupName) {
		this.authorityGroupName = authorityGroupName;
	}

	public String getAuthorityGroupID() {
		return authorityGroupID;
	}

	public void setAuthorityGroupID(String authorityGroupID) {
		this.authorityGroupID = authorityGroupID;
	}

	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

}
