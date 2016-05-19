package com.kasi.preparation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kasi.preparation.Circle;

@Component
public class JdbcDaoImpl {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	public Circle getCircle(int id) {
//
//		Connection conn = null;
//		Circle circle = null;
//		
//
//		try {
//
//			//conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement("select * FROM circle where id = ?");
//			ps.setInt(1, id);
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				circle = new Circle(id, rs.getString("name"));
//			}
//			rs.close();
//			ps.close();
//
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//			}
//		}
//		return circle;
//	}
	
	public int getCircleCount() {
		String sql="Select count(*) from circle";
		return jdbcTemplate.queryForObject(sql, null, Integer.class);
	}
	
	public String getCircleName(int id) {
		String sql="Select name from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
	}
	
	public Circle getCircleForId(int id) {
		String sql="Select * from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new CircleMapper());
	}
	
	public List<Circle> getAllCircle() {
		String sql="Select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}
	
}
