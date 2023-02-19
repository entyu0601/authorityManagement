package com.example.authorityManagement.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.authorityManagement.service.ifs.AuthorityManagementService;
import com.example.authorityManagement.vo.AuthorityManagementReq;
import com.example.authorityManagement.vo.AuthorityManagementRes;

@CrossOrigin
@RestController
public class AuthorityManagementController {

	@Autowired
	private AuthorityManagementService authorityManagementService;

	/* 権限グループの新規登録 */
	@PostMapping(value = "/api/createAuthorityGroup")
	public AuthorityManagementRes createAuthorityGroup(@RequestBody AuthorityManagementReq req) throws ParseException {
		return authorityManagementService.createAuthorityGroup(req.getGroupName(), req.getGroupID(), req.getComment());
	}

	/* 権限グループの更新 */
	@PostMapping(value = "/api/updateAuthorityGroup")
	public AuthorityManagementRes updateAuthorityGroup(@RequestBody AuthorityManagementReq req) throws ParseException {
		return authorityManagementService.updateAuthorityGroup(req.getAuthorityGroupEditAutoId(), req.getGroupName(),
				req.getComment());
	}

	/* 権限グループの該当データ情報を取得 */
	@PostMapping(value = "/api/getAuthorityGroupInfo")
	public AuthorityManagementRes getAuthorityGroupInfo(@RequestBody AuthorityManagementReq req) {
		return authorityManagementService.getAuthorityGroupInfo(req.getAuthorityGroupEditAutoId());
	}

	/* 権限グループの削除 */
	@PostMapping(value = "/api/setIsDelFlgedOfAuthorityGroup")
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroup(@RequestBody AuthorityManagementReq req) {
		return authorityManagementService.setIsDelFlgedOfAuthorityGroup(req.getAuthorityGroupEditAutoId());
	}

	/* 権限グループリスト */
	@PostMapping(value = "/api/queryAuthorityGroupList")
	public AuthorityManagementRes queryAuthorityGroupList() {
		return authorityManagementService.queryAuthorityGroupList();
	}

	/* 権限グループ対象の新規登録 */
	@PostMapping(value = "/api/createAuthorityGroupMember")
	public AuthorityManagementRes createAuthorityGroupMember(@RequestBody AuthorityManagementReq Memreq) {
		return authorityManagementService.createAuthorityGroupMember(Memreq.getFirstNameEN(), Memreq.getLastNameEN(),
				Memreq.getFirstNameCN(), Memreq.getLastNameCN(), Memreq.isGender(), Memreq.getBirthDate(),
				Memreq.getAuthorityGroupEditAutoId());
	}

	/* 権限グループ対象の更新 */
	@PostMapping(value = "/api/updateAuthorityGroupMember")
	public AuthorityManagementRes updateAuthorityGroupMember(@RequestBody AuthorityManagementReq Memreq) {
		return authorityManagementService.updateAuthorityGroupMember(Memreq.getAuthorityGroupMemberId(),
				Memreq.getFirstNameEN(), Memreq.getLastNameEN(), Memreq.getFirstNameCN(), Memreq.getLastNameCN(),
				Memreq.isGender(), Memreq.getBirthDate());
	}

	/* 権限グループ対象の該当データ情報を取得 */
	@PostMapping(value = "/api/getAuthorityGroupMemberInfo")
	public AuthorityManagementRes getAuthorityGroupMemberInfo(@RequestBody AuthorityManagementReq Memreq) {
		return authorityManagementService.getAuthorityGroupMemberInfo(Memreq.getAuthorityGroupMemberId());
	}

	/* 権限グループ対象の削除 */
	@PostMapping(value = "/api/setIsDelFlgedOfAuthorityGroupMember")
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroupMember(@RequestBody AuthorityManagementReq Memreq) {
		return authorityManagementService.setIsDelFlgedOfAuthorityGroupMember(Memreq.getAuthorityGroupMemberId());
	}

	/* 権限グループリスト */
	@PostMapping(value = "/api/queryAuthorityMemberGroupList")
	public AuthorityManagementRes queryAuthorityMemberGroupList(@RequestBody AuthorityManagementReq Memreq) {
		return authorityManagementService.queryAuthorityMemberGroupList(Memreq.getAuthorityGroupEditAutoId());
	}

	/* (検索)権限グループ対象のリスト */
	@PostMapping(value = "/api/searchAuthorityMemberGroupList")
	public AuthorityManagementRes searchAuthorityMemberGroupList(@RequestBody AuthorityManagementReq Memreq) {
		return authorityManagementService.searchAuthorityMemberGroupList(Memreq.getFirstNameEN(),
				Memreq.getLastNameEN(), Memreq.getFirstNameCN(), Memreq.getLastNameCN(), Memreq.isGender(),
				Memreq.getBirthDate());
	}

}
