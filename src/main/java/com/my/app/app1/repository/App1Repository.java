package com.my.app.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.app.app1.domain.TbUser;

public interface App1Repository extends JpaRepository<TbUser, String> {

}
