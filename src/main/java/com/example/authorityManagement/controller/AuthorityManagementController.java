package com.example.authorityManagement.controller;

import java.text.ParseException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.authorityManagement.constants.MessageInfo;
import com.example.authorityManagement.entity.Authoritygroupedit;

import com.example.authorityManagement.repository.AuthoritygroupeditDao;

import com.example.authorityManagement.service.ifs.AuthorityManagementService;
import com.example.authorityManagement.vo.AuthorityManagementReq;
import com.example.authorityManagement.vo.AuthorityManagementRes;

@CrossOrigin
@RestController
public class AuthorityManagementController {

	@Autowired
	private AuthorityManagementService authorityManagementService;

	@Autowired
	private AuthoritygroupeditDao authoritygroupeditDao;

	/* 権限グループの新規登録 */
	@PostMapping(value = "/api/createAuthorityGroup")
	public AuthorityManagementRes createAuthorityGroup(@RequestBody AuthorityManagementReq req) throws ParseException {

		// ｛グループ名称/グループID｝を入力する判断
		if (!StringUtils.hasText(req.getGroupName())) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_001.getMessage());
		} else if (!StringUtils.hasText(req.getGroupID())) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_001.getMessage());
		}

		// 「グループID」英字以外の文字を入力場合の判断
		if (!req.getGroupID().matches("^[a-zA-Z0-9]+$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_001.getMessage());
		}

		// ｛グループ名称/グループID｝を重複しない判断
		Optional<Authoritygroupedit> groupIdOp = authoritygroupeditDao.findByGroupID(req.getGroupID());
		if (groupIdOp.isPresent()) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_002.getMessage());
		}

		Optional<Authoritygroupedit> groupNameOp = authoritygroupeditDao.findByGroupName(req.getGroupName());
		if (groupNameOp.isPresent()) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_002.getMessage());
		}

		return authorityManagementService.createAuthorityGroup(req.getGroupName(), req.getGroupID(), req.getComment());
	}

	/* 権限グループの更新 */
	@PostMapping(value = "/api/updateAuthorityGroup")
	public AuthorityManagementRes updateAuthorityGroup(@RequestBody AuthorityManagementReq req) throws ParseException {

		// ｛グループ名称｝を入力する判断
		if (!StringUtils.hasText(req.getGroupName())) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_001.getMessage());
		}

		// ｛グループ名称｝を重複しない判断
		Optional<Authoritygroupedit> groupNameOp = authoritygroupeditDao.findByGroupName(req.getGroupName());
		if (groupNameOp.isPresent()) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_002.getMessage());
		}

		return authorityManagementService.updateAuthorityGroup(req.getAuthorityGroupEditAutoId(), req.getGroupName(),
				req.getComment());
	}

	/* 権限グループの該当データ情報を取得 */
	@PostMapping(value = "/api/getAuthorityGroupInfo")
	public AuthorityManagementRes getAuthorityGroupInfo(@RequestBody AuthorityManagementReq req) {
		return authorityManagementService.getAuthorityGroupInfo(req.getAuthorityGroupEditAutoId());
	}

	/* 権限グループの削除 */
	@PostMapping(value = "/api/deleteAuthorityGroup")
	public AuthorityManagementRes deleteAuthorityGroup(@RequestBody AuthorityManagementReq req) {
		return authorityManagementService.deleteAuthorityGroup(req.getAuthorityGroupEditAutoId());
	}

	/* 権限グループリスト */
	@PostMapping(value = "/api/queryAuthorityGroupList")
	public AuthorityManagementRes queryAuthorityGroupList() {
		return authorityManagementService.queryAuthorityGroupList();
	}

}
