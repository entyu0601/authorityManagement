package com.example.authorityManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authorityManagement.entity.Authoritygrouplist;

//K2024
@Repository
public interface AuthoritygrouplistDao extends JpaRepository<Authoritygrouplist, Integer>{

	

	
}
