package com.kasi.preparation.model;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoSupportImpl extends JdbcDaoSupport {
	
	public int getCircleCount() {
		String sql="Select count(*) from circle";
		return this.getJdbcTemplate().queryForObject(sql, null, Integer.class);
	}

}
