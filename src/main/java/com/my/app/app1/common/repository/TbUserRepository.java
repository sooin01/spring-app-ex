package com.my.app.app1.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.my.app.app1.domain.TbUser;

public interface TbUserRepository extends JpaRepository<TbUser, String> {

	@EntityGraph(attributePaths = "tbUserEtcs")
	@Override
	List<TbUser> findAll();

}
