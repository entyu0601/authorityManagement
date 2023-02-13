package com.example.authorityManagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.authorityManagement.entity.Authoritygrouplist;

@Service
public class BaseDao {

	// JPA專有注釋
	@PersistenceContext
	private EntityManager entityManager;

	// insertIntoAuthorityGroupList (K2025的資料 insert 進 K2024)
	@Transactional
	public List<Authoritygrouplist> insertIntoAuthorityGroupList() {
		Query query = entityManager.createNativeQuery(
				"INSERT INTO authoritygrouplist (Authority_Group_Name, Authority_Group_ID, Del_Flg) SELECT Group_Name, Group_ID, Del_Flg FROM authoritygroupedit");
		query.executeUpdate();
		return entityManager.createQuery("SELECT a FROM Authoritygrouplist a", Authoritygrouplist.class)
				.getResultList();
	}

//	// markAuthorityGroupDeleted 並不是真的刪除
//	@Transactional
//	public boolean markAuthorityGroupDeleted(Integer authorityGroupEditAutoId) {
//		Query query = entityManager.createNativeQuery(
//				"UPDATE Authoritygroupedit SET Del_Flg = 1 WHERE Authority_Group_Edit_Auto_Id = :authorityGroupEditAutoId");
//		query.setParameter("authorityGroupEditAutoId", authorityGroupEditAutoId);
//		int result = query.executeUpdate();
//		return result > 0;
//	}

}
