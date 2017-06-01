package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Rate;

public class RateDao extends BaseDao {
	
	public void insertRate(Rate rate) {
		getJdbcTemplate();
		try{
			String sql="insert into dbo.Rate values(?,?,?,?)";
			jdbcTemplate.update(sql,new Object[]{rate.getPat_id(), rate.getRate_docID(), rate.getRate_score(), rate.getRate_date()});
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}