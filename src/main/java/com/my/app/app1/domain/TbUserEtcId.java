package com.my.app.app1.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class TbUserEtcId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private String id;
	private BigDecimal userEtcSeq;
	
}
