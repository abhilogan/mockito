package com.pp.repositary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@Slf4j
public class WebServiceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int uid;

	@Column
	private String uname;

	@Column
	private String umail;

	@Column
	private String upassword;
}
