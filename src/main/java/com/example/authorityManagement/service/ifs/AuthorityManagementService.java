package com.example.authorityManagement.service.ifs;

import java.text.ParseException;

import com.example.authorityManagement.vo.AuthorityManagementRes;

public interface AuthorityManagementService {

	/* 権限グループの新規登録 ok */
	public AuthorityManagementRes createAuthorityGroup(String groupName, String groupID, String comment)
			throws ParseException;

	/* 権限グループの更新 ok */
	public AuthorityManagementRes updateAuthorityGroup(int authorityGroupEditAutoId, String groupName, String comment)
			throws ParseException;

	/* 権限グループの該当データ情報を取得 ok */
	public AuthorityManagementRes getAuthorityGroupInfo(int authorityGroupEditAutoId);

	/* 権限グループの削除 ok */
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroup(int authorityGroupEditAutoId);

	/* 権限グループリスト ok */
	public AuthorityManagementRes queryAuthorityGroupList();

	/*
	 * ----k2024/ k2025/ 0216
	 * end---------------------------------------------------------------------
	 */

	/* 権限グループ対象の新規登録 */
	public AuthorityManagementRes createAuthorityGroupMember(String firstNameEN, String lastNameEN, String firstNameCN,
			String lastNameCN, boolean gender, int birthDate, int authorityGroupEditAutoId);

	/* 権限グループ対象の更新 */
	public AuthorityManagementRes updateAuthorityGroupMember(int authorityGroupMemberId, String firstNameEN,
			String lastNameEN, String firstNameCN, String lastNameCN, boolean gender, int birthDate);

	/* 権限グループ対象の該当データ情報を取得 */
	public AuthorityManagementRes getAuthorityGroupMemberInfo(int authorityGroupMemberId);

	/* 権限グループ対象の削除 */
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroupMember(int authorityGroupMemberId);

	/* 権限グループ対象のリスト */
	public AuthorityManagementRes queryAuthorityMemberGroupList(int authorityGroupEditAutoId);

	/* (検索)権限グループ対象のリスト */
	public AuthorityManagementRes searchAuthorityMemberGroupList(String firstNameEN, String lastNameEN,
			String firstNameCN, String lastNameCN, boolean gender, int birthDate);
}
