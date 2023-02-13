package com.example.authorityManagement.vo;

import java.util.Date;

public class AuthorityManagementReq {

	private int authorityGroupEditAutoId;

	private Date createDate;

	private String groupName;

	private String groupID;

	private String comment;

	private boolean delFlg;

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

}
