package com.example.authorityManagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authoritygroupedit")
public class Authoritygroupedit {

	// K2025
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Authority_Group_Edit_Auto_Id")
	private int authorityGroupEditAutoId;

	@Column(name = "Create_Date")
	private Date createDate;

	@Column(name = "Group_Name")
	private String groupName;

	@Column(name = "Group_ID")
	private String groupID;

	@Column(name = "Comment")
	private String comment;

	@Column(name = "Del_Flg")
	private boolean delFlg = false;

	public Authoritygroupedit() {

	}

	public Authoritygroupedit(int authorityGroupEditAutoId, Date createDate, String groupName, String groupID,
			String comment) {
		this.authorityGroupEditAutoId = authorityGroupEditAutoId;
		this.createDate = createDate;
		this.groupName = groupName;
		this.groupID = groupID;
		this.comment = comment;
	}

	public Authoritygroupedit(String groupName, String groupID, String comment) {
		this.groupName = groupName;
		this.groupID = groupID;
		this.comment = comment;
	}

	public int getAuthorityGroupEditAutoId() {
		return authorityGroupEditAutoId;
	}

	public void setAuthorityGroupEditAutoId(int authorityGroupEditAutoId) {
		this.authorityGroupEditAutoId = authorityGroupEditAutoId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

}
