package com.my.app.app1.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.app.app1.domain.TbUser;

public interface TbUserRepository extends JpaRepository<TbUser, String> {

}
