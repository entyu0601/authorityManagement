package com.example.authorityManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authoritygroupmember")
public class AuthorityGroupMember {

	// K2027
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHORITY_GROUP_MEMBER_ID")
	private int authorityGroupMemberId;

	@Column(name = "FIRST_NAME_EN")
	private String firstNameEN;

	@Column(name = "LAST_NAME_EN")
	private String lastNameEN;

	@Column(name = "FIRST_NAME_CN")
	private String firstNameCN;

	@Column(name = "LAST_NAME_CN")
	private String lastNameCN;

	@Column(name = "GENDER")
	private boolean gender;

	@Column(name = "BIRTH_DATE")
	private int birthDate;

	@Column(name = "DEL_FLG")
	private boolean delFlg;

	@Column(name = "AUTHORITY_GROUP_EDIT_AUTO_ID")
	private int authorityGroupEditAutoId;

	public AuthorityGroupMember() {

	}

	public AuthorityGroupMember(String firstNameEN, String lastNameEN, String firstNameCN, String lastNameCN,
			boolean gender, int birthDate, int authorityGroupEditAutoId) {
		this.firstNameEN = firstNameEN;
		this.lastNameEN = lastNameEN;
		this.firstNameCN = firstNameCN;
		this.lastNameCN = lastNameCN;
		this.gender = gender;
		this.birthDate = birthDate;
		this.authorityGroupEditAutoId = authorityGroupEditAutoId;
	}

	public void updateAuthorityGroupMember(String firstNameEN, String lastNameEN, String firstNameCN, String lastNameCN,
			boolean gender, int birthDate) {
		this.firstNameEN = firstNameEN;
		this.lastNameEN = lastNameEN;
		this.firstNameCN = firstNameCN;
		this.lastNameCN = lastNameCN;
		this.gender = gender;
		this.birthDate = birthDate;
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

	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

	public int getAuthorityGroupEditAutoId() {
		return authorityGroupEditAutoId;
	}

	public void setAuthorityGroupEditAutoId(int authorityGroupEditAutoId) {
		this.authorityGroupEditAutoId = authorityGroupEditAutoId;
	}

}
