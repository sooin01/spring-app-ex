package com.my.app.app1.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUser {
	
	@Id
	private String userId;
	private String userName;
	private String createDt;
	private String updateDt;
	
}
