package com.example.authorityManagement.vo;

import java.util.List;

import com.example.authorityManagement.entity.Authoritygroupedit;
import com.example.authorityManagement.entity.Authoritygrouplist;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorityManagementRes {

	private Authoritygroupedit authoritygroupedit;

//	private Authoritygrouplist authoritygroup;

	private List<Authoritygroupedit> authoritygrouplist;

//	private List<Authoritygrouplist> authoritygrouplist;

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

//	public AuthorityManagementRes(Authoritygrouplist authoritygroup, String message) {
//		this.authoritygroup = authoritygroup;
//		this.message = message;
//	}

	public AuthorityManagementRes(List<Authoritygroupedit> authoritygrouplist, String message) {
		this.authoritygrouplist = authoritygrouplist;
		this.message = message;
	}

	public Authoritygroupedit getAuthoritygroupedit() {
		return authoritygroupedit;
	}

	public void setAuthoritygroupedit(Authoritygroupedit authoritygroupedit) {
		this.authoritygroupedit = authoritygroupedit;
	}

//	public Authoritygrouplist getAuthoritygroup() {
//		return authoritygroup;
//	}
//
//	public void setAuthoritygroup(Authoritygrouplist authoritygroup) {
//		this.authoritygroup = authoritygroup;
//	}

	public List<Authoritygroupedit> getAuthoritygrouplist() {
		return authoritygrouplist;
	}

	public void setAuthoritygrouplist(List<Authoritygroupedit> authoritygrouplist) {
		this.authoritygrouplist = authoritygrouplist;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
