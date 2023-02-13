package com.example.authorityManagement.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.authorityManagement.constants.MessageInfo;
import com.example.authorityManagement.entity.Authoritygroupedit;
import com.example.authorityManagement.repository.AuthoritygroupeditDao;
import com.example.authorityManagement.service.ifs.AuthorityManagementService;
import com.example.authorityManagement.vo.AuthorityManagementRes;

@Service
public class AuthorityManagementServiceImpl implements AuthorityManagementService {

	@Autowired
	private AuthoritygroupeditDao authoritygroupeditDao;

	/* 権限グループの新規登録 ok */
	@Override
	public AuthorityManagementRes createAuthorityGroup(String groupName, String groupID, String comment)
			throws ParseException {

		// 権限グループの新規登録
		Authoritygroupedit authoritygroupedit = new Authoritygroupedit(groupName, groupID, comment);

		// CreateDateのフォーマット判断
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = format.format(new Date());
		authoritygroupedit.setCreateDate(format.parse(formattedDate));

		authoritygroupeditDao.save(authoritygroupedit);

		return new AuthorityManagementRes(authoritygroupedit, MessageInfo.CREATE_SUCCESSFUL.getMessage());

	}

	/* 権限グループの更新 */
	@Override
	public AuthorityManagementRes updateAuthorityGroup(int authorityGroupEditAutoId, String groupName, String comment)
			throws ParseException {

		// authorityGroupEditAutoIdで、該当データ情報を取得
		Optional<Authoritygroupedit> authoritygroupeOp = authoritygroupeditDao.findById(authorityGroupEditAutoId);
		Authoritygroupedit authoritygroupedit = authoritygroupeOp.get();

		// CreateDateのフォーマット判断
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = format.format(new Date());
		authoritygroupedit.setCreateDate(format.parse(formattedDate));

		// 権限グループの更新
		Authoritygroupedit newAuthoritygroupedit = new Authoritygroupedit(
				authoritygroupedit.getAuthorityGroupEditAutoId(), authoritygroupedit.getCreateDate(), groupName,
				authoritygroupedit.getGroupID(), comment);

		authoritygroupeditDao.save(newAuthoritygroupedit);

		return new AuthorityManagementRes(newAuthoritygroupedit, MessageInfo.UPDATE_SUCCESSFUL.getMessage());

	}

	/* 権限グループの該当データ情報を取得 ok */
	@Override
	public AuthorityManagementRes getAuthorityGroupInfo(int authorityGroupEditAutoId) {

		Authoritygroupedit authoritygroupedit = authoritygroupeditDao
				.findByAuthorityGroupEditAutoId(authorityGroupEditAutoId);
		return new AuthorityManagementRes(authoritygroupedit, MessageInfo.GET_ID_SUCCESSFUL.getMessage());
	}

	/* 権限グループの削除 */
	@Override
	public AuthorityManagementRes deleteAuthorityGroup(int authorityGroupEditAutoId) {

		Authoritygroupedit authoritygroupedit = authoritygroupeditDao
				.findByAuthorityGroupEditAutoId(authorityGroupEditAutoId);
		authoritygroupedit.setDelFlg(true);

		authoritygroupeditDao.save(authoritygroupedit);
		return new AuthorityManagementRes(authoritygroupedit, MessageInfo.DELETE_SUCCESSFUL.getMessage());
	}

	/* 権限グループリスト ok */
	@Override
	public AuthorityManagementRes queryAuthorityGroupList() {
		List<Authoritygroupedit> authoritygroupList = authoritygroupeditDao.findAll();

		// 添加過濾條件
		authoritygroupList = authoritygroupList.stream().filter(ag -> ag.isDelFlg() == false)
				.collect(Collectors.toList());

		// 排序
		authoritygroupList
				.sort((a1, a2) -> Integer.compare(a2.getAuthorityGroupEditAutoId(), a1.getAuthorityGroupEditAutoId()));

		// 「authoritygroupList」がnullかどうかを判断。
		if (CollectionUtils.isEmpty(authoritygroupList)) {
			return new AuthorityManagementRes(MessageInfo.DATA_IS_NOT_FOUND.getMessage());
		}
		return new AuthorityManagementRes(authoritygroupList, MessageInfo.DATA_IS_FOUND.getMessage());
	}

//	/* 権限グループリスト->K2024　*/ BaseDaoで、insertIntoAuthorityGroupListのメソッド
//	public AuthorityManagementRes queryAuthorityGroupList();

}
