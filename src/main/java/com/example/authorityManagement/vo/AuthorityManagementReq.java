package com.example.authorityManagement.vo;

import java.util.Date;

import javax.persistence.Column;

public class AuthorityManagementReq {

	private int authorityGroupEditAutoId;

	private Date createDate;

	private String groupName;

	private String groupID;

	private String comment;

	private boolean delFlg;

	/* ================================ */

	private int authorityGroupMemberId;

	private String firstNameEN;

	private String lastNameEN;

	private String firstNameCN;

	private String lastNameCN;

	private boolean gender;

	private int birthDate;

	public AuthorityManagementReq() {

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

	public int getAuthorityGroupMemberId() {
		return authorityGroupMemberId;
	}

	public void setAuthorityGroupMemberId(int authorityGroupMemberId) {
		this.authorityGroupMemberId = authorityGroupMemberId;
	}

	public String getFirstNameEN() {
		return firstNameEN;
	}

	public void setFirstNameEN(String firstNameEN) {
		this.firstNameEN = firstNameEN;
	}

	public String getLastNameEN() {
		return lastNameEN;
	}

	public void setLastNameEN(String lastNameEN) {
		this.lastNameEN = lastNameEN;
	}

	public String getFirstNameCN() {
		return firstNameCN;
	}

	public void setFirstNameCN(String firstNameCN) {
		this.firstNameCN = firstNameCN;
	}

	public String getLastNameCN() {
		return lastNameCN;
	}

	public void setLastNameCN(String lastNameCN) {
		this.lastNameCN = lastNameCN;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

}
