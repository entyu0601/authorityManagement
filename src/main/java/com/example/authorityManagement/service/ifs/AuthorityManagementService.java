package com.example.authorityManagement.service.ifs;

import java.text.ParseException;

import com.example.authorityManagement.vo.AuthorityManagementRes;

public interface AuthorityManagementService {

	/* 権限グループの新規登録 */
	public AuthorityManagementRes createAuthorityGroup(String groupName, String groupID, String comment)
			throws ParseException;

	/* 権限グループの更新 */
	public AuthorityManagementRes updateAuthorityGroup(int authorityGroupEditAutoId, String groupName, String comment)
			throws ParseException;

	/* 権限グループの該当データ情報を取得 */
	public AuthorityManagementRes getAuthorityGroupInfo(int authorityGroupEditAutoId);

	/* 権限グループの削除 */
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroup(int authorityGroupEditAutoId);

	/* 権限グループリスト */
	public AuthorityManagementRes queryAuthorityGroupList();

//	/* 権限グループリスト->K2024　*/ BaseDaoで、insertIntoAuthorityGroupListのメソッド
//	public AuthorityManagementRes queryAuthorityGroupList();

}
