package com.aya.spring.web.daos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("imagesDao")
public class ImagesDao {
	private NamedParameterJdbcTemplate  jdbc;
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	public ImagesDao(){
		System.out.println("dao loaded successfully by Listner and context param");
	}
	public boolean create(Image image) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(image);
		
		return jdbc.update("insert into image (name) values (:name)", params) == 1;
	}
	public List<Image> getImages() {
		return jdbc.query("select * from image", new RowMapper<Image>() {
			public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
				Image image = new Image();
				image.setName(rs.getString("name"));
				
				return image;
			}

		});

	}

}
