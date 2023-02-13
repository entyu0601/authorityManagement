package com.example.authorityManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authorityManagement.entity.Authoritygroupedit;

//K2025
@Repository
public interface AuthoritygroupeditDao extends JpaRepository<Authoritygroupedit, Integer> {

	public Authoritygroupedit findByAuthorityGroupEditAutoId(int authorityGroupEditAutoId);

	public Optional<Authoritygroupedit> findByGroupID(String groupID);

	public Optional<Authoritygroupedit> findByGroupName(String groupName);
}
