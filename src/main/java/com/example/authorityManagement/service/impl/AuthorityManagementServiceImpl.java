package com.example.authorityManagement.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.authorityManagement.constants.MessageInfo;
import com.example.authorityManagement.entity.AuthorityGroupMember;
import com.example.authorityManagement.entity.Authoritygroupedit;
import com.example.authorityManagement.repository.AuthorityGroupMemberDao;
import com.example.authorityManagement.repository.AuthoritygroupeditDao;
import com.example.authorityManagement.service.ifs.AuthorityManagementService;
import com.example.authorityManagement.vo.AuthorityManagementRes;

@Service
public class AuthorityManagementServiceImpl implements AuthorityManagementService {

	@Autowired
	private AuthoritygroupeditDao authoritygroupeditDao;

	@Autowired
	private AuthorityGroupMemberDao authorityGroupMemberDao;

	@PersistenceContext
	private EntityManager entityManager;

	/* 権限グループの新規登録 ok */
	@Override
	public AuthorityManagementRes createAuthorityGroup(String groupName, String groupID, String comment)
			throws ParseException {

		// ｛グループ名称/グループID｝を入力する判断
		if (!StringUtils.hasText(groupName)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_001.getMessage());
		} else if (!StringUtils.hasText(groupID)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_001.getMessage());
		}

		// 「グループID」英字以外の文字を入力場合の判断
		if (!groupID.matches("^[a-zA-Z0-9]+$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_001.getMessage());
		}

		// ｛グループ名称/グループID｝を重複しない判断
		Optional<Authoritygroupedit> groupIdOp = authoritygroupeditDao.findByGroupID(groupID);
		if (groupIdOp.isPresent()) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_002.getMessage());
		}

		Optional<Authoritygroupedit> groupNameOp = authoritygroupeditDao.findByGroupName(groupName);
		if (groupNameOp.isPresent()) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_002.getMessage());
		}

		// 権限グループの新規登録
		Authoritygroupedit authoritygroupedit = new Authoritygroupedit(groupName, groupID, comment);

		// CreateDateのフォーマット判断
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = format.format(new Date());
		authoritygroupedit.setCreateDate(format.parse(formattedDate));

		authoritygroupeditDao.save(authoritygroupedit);

		return new AuthorityManagementRes(authoritygroupedit, MessageInfo.CREATE_SUCCESSFUL.getMessage());

	}

	/* 権限グループの更新 ok */
	@Override
	public AuthorityManagementRes updateAuthorityGroup(int authorityGroupEditAutoId, String groupName, String comment)
			throws ParseException {

		// authorityGroupEditAutoIdで、該当データ情報を取得
		Optional<Authoritygroupedit> authoritygroupeOp = authoritygroupeditDao.findById(authorityGroupEditAutoId);
		Authoritygroupedit authoritygroupedit = authoritygroupeOp.get();

		// ｛グループ名称｝を入力する判断
		if (!StringUtils.hasText(groupName)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_001.getMessage());
		}

		// ｛グループ名称｝を重複しない判断
		if (!authoritygroupedit.getGroupName().equalsIgnoreCase(groupName)) {
			Optional<Authoritygroupedit> groupNameOp = authoritygroupeditDao.findByGroupName(groupName);
			if (groupNameOp.isPresent()) {
				return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_002.getMessage());
			}
		}

		// CreateDateのフォーマット判断
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = format.format(new Date());
		authoritygroupedit.setCreateDate(format.parse(formattedDate));

		// 権限グループの更新
		authoritygroupedit.updateAuthoritygroupedit(authoritygroupedit.getCreateDate(), groupName, comment);
		authoritygroupeditDao.save(authoritygroupedit);

		return new AuthorityManagementRes(authoritygroupedit, MessageInfo.UPDATE_SUCCESSFUL.getMessage());

	}

	/* 権限グループの該当データ情報を取得 ok */
	@Override
	public AuthorityManagementRes getAuthorityGroupInfo(int authorityGroupEditAutoId) {

		// authorityGroupEditAutoIdで、該当データ情報を取得
		Authoritygroupedit authoritygroupedit = authoritygroupeditDao
				.findByAuthorityGroupEditAutoId(authorityGroupEditAutoId);
		return new AuthorityManagementRes(authoritygroupedit, MessageInfo.GET_ID_SUCCESSFUL.getMessage());
	}

	/* 権限グループの削除 ok */
	@Override
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroup(int authorityGroupEditAutoId) {

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

		// 添加過濾條件+ 按照創建時間排序
		authoritygroupList = authoritygroupList.stream().filter(ag -> !ag.isDelFlg()) // DelFlg為0才能顯示
				.sorted(Comparator.comparing(Authoritygroupedit::getCreateDate).reversed())
				.collect(Collectors.toList());

		// 「authoritygroupList」がnullかどうかを判断。
		if (CollectionUtils.isEmpty(authoritygroupList)) {
			return new AuthorityManagementRes(MessageInfo.DATA_IS_NOT_FOUND.getMessage());
		}
		return new AuthorityManagementRes(authoritygroupList, MessageInfo.DATA_IS_FOUND.getMessage());
	}

	/*
	 * ----k2024/ k2025/
	 * ----02.16-end----------------------------------------------------------------
	 * 
	 */

	/* 権限グループ対象の新規登録 */
	@Override
	public AuthorityManagementRes createAuthorityGroupMember(String firstNameEN, String lastNameEN, String firstNameCN,
			String lastNameCN, boolean gender, int birthDate, int authorityGroupEditAutoId) {

		// authorityGroupEditAutoIdで、該当グループのデータを取得
		Authoritygroupedit authoritygroup = authoritygroupeditDao
				.findByAuthorityGroupEditAutoId(authorityGroupEditAutoId);

		// ｛0｝を入力する判断
		if (!StringUtils.hasText(firstNameEN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		} else if (!StringUtils.hasText(lastNameEN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		} else if (!StringUtils.hasText(firstNameCN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		} else if (!StringUtils.hasText(lastNameCN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		}

		// ｛0｝のフォーマット判断
		if (!firstNameEN.matches("^[A-Za-z]+([\\s.]+[A-Za-z]+)*$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		} else if (!lastNameEN.matches("^[A-Za-z]+([\\s.]+[A-Za-z]+)*$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		} else if (!firstNameCN.matches("^[\u4e00-\u9fa5]{1,}$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		} else if (!lastNameCN.matches("^[\u4e00-\u9fa5]{1,}$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		}

		// 権限グループ対象の新規登録
		AuthorityGroupMember authorityGroupMember = new AuthorityGroupMember(firstNameEN, lastNameEN, firstNameCN,
				lastNameCN, gender, birthDate, authoritygroup.getAuthorityGroupEditAutoId());

		authorityGroupMemberDao.save(authorityGroupMember);

		return new AuthorityManagementRes(authorityGroupMember, MessageInfo.CREATE_SUCCESSFUL.getMessage());
	}

	/* 権限グループ対象の更新 */
	@Override
	public AuthorityManagementRes updateAuthorityGroupMember(int authorityGroupMemberId, String firstNameEN,
			String lastNameEN, String firstNameCN, String lastNameCN, boolean gender, int birthDate) {

		// authorityGroupMemberIdで、該当グループ対象のデータ情報を取得
		Optional<AuthorityGroupMember> authorityGroupMemberOp = authorityGroupMemberDao
				.findById(authorityGroupMemberId);
		AuthorityGroupMember authorityGroupMember = authorityGroupMemberOp.get();

		// ｛0｝を入力する判断
		if (!StringUtils.hasText(firstNameEN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		} else if (!StringUtils.hasText(lastNameEN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		} else if (!StringUtils.hasText(firstNameCN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		} else if (!StringUtils.hasText(lastNameCN)) {
			return new AuthorityManagementRes(MessageInfo.NOT_ENTER_ERROR_003.getMessage());
		}

		// ｛0｝のフォーマット判断
		if (!firstNameEN.matches("^[A-Za-z]+([\\s.]+[A-Za-z]+)*$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		} else if (!lastNameEN.matches("^[A-Za-z]+([\\s.]+[A-Za-z]+)*$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		} else if (!firstNameCN.matches("^[\u4e00-\u9fa5]{1,}$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		} else if (!lastNameCN.matches("^[\u4e00-\u9fa5]{1,}$")) {
			return new AuthorityManagementRes(MessageInfo.NAME_ERROR_002.getMessage());
		}

		// 権限グループ対象の更新
		authorityGroupMember.updateAuthorityGroupMember(firstNameEN, lastNameEN, firstNameCN, lastNameCN, gender,
				birthDate);

		authorityGroupMemberDao.save(authorityGroupMember);
		return new AuthorityManagementRes(authorityGroupMember, MessageInfo.UPDATE_SUCCESSFUL.getMessage());
	}

	/* 権限グループ対象の該当データ情報を取得 */
	@Override
	public AuthorityManagementRes getAuthorityGroupMemberInfo(int authorityGroupMemberId) {

		// authorityGroupMemberIdで、該当グループ対象のデータ情報を取得
		AuthorityGroupMember authorityGroupMember = authorityGroupMemberDao
				.findByAuthorityGroupMemberId(authorityGroupMemberId);
		return new AuthorityManagementRes(authorityGroupMember, MessageInfo.GET_ID_SUCCESSFUL.getMessage());

	}

	/* 権限グループ対象の削除 */
	@Override
	public AuthorityManagementRes setIsDelFlgedOfAuthorityGroupMember(int authorityGroupMemberId) {

		AuthorityGroupMember authorityGroupMember = authorityGroupMemberDao
				.findByAuthorityGroupMemberId(authorityGroupMemberId);
		authorityGroupMember.setDelFlg(true);

		authorityGroupMemberDao.save(authorityGroupMember);
		return new AuthorityManagementRes(authorityGroupMember, MessageInfo.DELETE_SUCCESSFUL.getMessage());
	}

	/* 権限グループ対象のリスト */
	@Override
	public AuthorityManagementRes queryAuthorityMemberGroupList(int authorityGroupEditAutoId) {

		List<AuthorityGroupMember> authorityGroupMemberList = authorityGroupMemberDao
				.findAllByAuthorityGroupEditAutoId(authorityGroupEditAutoId);

		// 添加過濾條件
		authorityGroupMemberList = authorityGroupMemberList.stream().filter(ag -> !ag.isDelFlg()) // DelFlg為0才能顯示
//						.sorted(Comparator.comparing(authorityGroupMemberList::getCreateDate).reversed())
				.collect(Collectors.toList());

		// 「authorityGroupMemberList」がnullかどうかを判断。
		if (CollectionUtils.isEmpty(authorityGroupMemberList)) {
			return new AuthorityManagementRes(MessageInfo.DATA_IS_NOT_FOUND.getMessage());
		}
		return new AuthorityManagementRes(authorityGroupMemberList);
	}

	/* (検索)権限グループ対象のリスト */
	@Override
	public AuthorityManagementRes searchAuthorityMemberGroupList(String firstNameEN, String lastNameEN,
			String firstNameCN, String lastNameCN, boolean gender, int birthDate) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AuthorityGroupMember> query = cb.createQuery(AuthorityGroupMember.class);
		Root<AuthorityGroupMember> root = query.from(AuthorityGroupMember.class);
		List<Predicate> predicates = new ArrayList<>();

		// 對DelFlg的限制
		predicates.add(cb.equal(root.get("delFlg"), 0));

		if (StringUtils.hasText(firstNameEN)) {
			predicates.add(cb.like(root.get("firstNameEN"), "%" + firstNameEN + "%"));
		}
		if (StringUtils.hasText(lastNameEN)) {
			predicates.add(cb.like(root.get("lastNameEN"), "%" + lastNameEN + "%"));
		}
		if (StringUtils.hasText(firstNameCN)) {
			predicates.add(cb.like(root.get("firstNameCN"), "%" + firstNameCN + "%"));
		}
		if (StringUtils.hasText(lastNameCN)) {
			predicates.add(cb.like(root.get("lastNameCN"), "%" + lastNameCN + "%"));
		}
		if (birthDate != 0) {
			predicates.add(cb.equal(root.get("birthDate"), birthDate));
		}
		if (gender) {
			predicates.add(cb.isTrue(root.get("gender")));
		} else {
			predicates.add(cb.isFalse(root.get("gender")));
		}

		query.where(predicates.toArray(new Predicate[0]));

		List<AuthorityGroupMember> resultList = entityManager.createQuery(query).getResultList();
		return new AuthorityManagementRes(resultList);
	}

}
