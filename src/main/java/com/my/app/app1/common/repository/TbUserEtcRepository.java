package com.my.app.app1.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.app.app1.domain.TbUserEtc;
import com.my.app.app1.domain.TbUserEtcId;

public interface TbUserEtcRepository extends JpaRepository<TbUserEtc, TbUserEtcId> {

}
