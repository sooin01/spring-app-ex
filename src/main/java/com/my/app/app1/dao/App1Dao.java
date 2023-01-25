package com.my.app.app1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.app.app1.domain.TbUser;

public interface App1Dao extends JpaRepository<TbUser, String> {

}
