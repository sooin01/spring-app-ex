package com.my.app.app1.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUserEtc implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonUnwrapped
	private TbUserEtcId tbUserEtcId;
	private String userEtc1;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	@JsonBackReference
	private TbUser tbUser;
	
}
