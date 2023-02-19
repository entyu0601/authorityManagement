package com.example.authorityManagement.vo;

import java.util.List;

import com.example.authorityManagement.entity.AuthorityGroupMember;
import com.example.authorityManagement.entity.Authoritygroupedit;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorityManagementRes {

	private Authoritygroupedit authoritygroupedit;

	private AuthorityGroupMember authoritygroupmember;

	private List<Authoritygroupedit> authoritygrouplist;

	private List<AuthorityGroupMember> authorityGroupMemberlist;

	private String message;

	public AuthorityManagementRes() {

	}

	public AuthorityManagementRes(String message) {
		this.message = message;
	}

	public AuthorityManagementRes(Authoritygroupedit authoritygroupedit, String message) {
		this.authoritygroupedit = authoritygroupedit;
		this.message = message;
	}

	public AuthorityManagementRes(AuthorityGroupMember authoritygroupmember, String message) {
		this.authoritygroupmember = authoritygroupmember;
		this.message = message;
	}

	public AuthorityManagementRes(List<Authoritygroupedit> authoritygrouplist, String message) {
		this.authoritygrouplist = authoritygrouplist;
		this.message = message;
	}

	public AuthorityManagementRes(List<AuthorityGroupMember> authorityGroupMemberlist) {
		this.authorityGroupMemberlist = authorityGroupMemberlist;
	}

	public Authoritygroupedit getAuthoritygroupedit() {
		return authoritygroupedit;
	}

	public void setAuthoritygroupedit(Authoritygroupedit authoritygroupedit) {
		this.authoritygroupedit = authoritygroupedit;
	}

	public AuthorityGroupMember getAuthoritygroupmember() {
		return authoritygroupmember;
	}

	public void setAuthoritygroupmember(AuthorityGroupMember authoritygroupmember) {
		this.authoritygroupmember = authoritygroupmember;
	}

	public List<Authoritygroupedit> getAuthoritygrouplist() {
		return authoritygrouplist;
	}

	public void setAuthoritygrouplist(List<Authoritygroupedit> authoritygrouplist) {
		this.authoritygrouplist = authoritygrouplist;
	}

	public List<AuthorityGroupMember> getAuthorityGroupMemberlist() {
		return authorityGroupMemberlist;
	}

	public void setAuthorityGroupMemberlist(List<AuthorityGroupMember> authorityGroupMemberlist) {
		this.authorityGroupMemberlist = authorityGroupMemberlist;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
