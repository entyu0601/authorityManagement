package com.example.authorityManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authorityManagement.entity.AuthorityGroupMember;

public interface AuthorityGroupMemberDao extends JpaRepository<AuthorityGroupMember, Integer> {

	public AuthorityGroupMember findByAuthorityGroupMemberId(int authorityGroupMemberId);

	List<AuthorityGroupMember> findAllByAuthorityGroupEditAutoId(int authorityGroupEditAutoId);

	/* ============================= */

//	List<AuthorityGroupMember> findByFirstNameENContainingAndLastNameENContainingAndFirstNameCNContainingAndLastNameCNContaining(
//			String firstNameEN, String lastNameEN, String firstNameCN, String lastNameCN);
//
//	List<AuthorityGroupMember> findByFirstNameENContainingAndLastNameENContainingAndFirstNameCNContainingAndLastNameCNContainingAndGender(
//			String firstNameEN, String lastNameEN, String firstNameCN, String lastNameCN, boolean gender);
//
//	List<AuthorityGroupMember> findByFirstNameENContainingAndLastNameENContainingAndFirstNameCNContainingAndLastNameCNContainingAndBirthDate(
//			String firstNameEN, String lastNameEN, String firstNameCN, String lastNameCN, int birthDate);
//
//	List<AuthorityGroupMember> findByFirstNameENContainingAndLastNameENContainingAndFirstNameCNContainingAndLastNameCNContainingAndGenderAndBirthDate(
//			String firstNameEN, String lastNameEN, String firstNameCN, String lastNameCN, boolean gender,
//			int birthDate);
//
//	List<AuthorityGroupMember> findByGender(boolean gender);
//
//	List<AuthorityGroupMember> findByGenderAndBirthDate(boolean gender, int birthDate);
//
//	List<AuthorityGroupMember> findByBirthDate(int birthDate);

}
