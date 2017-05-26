package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Pressure;

public class PressureDao extends BaseDao {
	
	public void insertPressure(Pressure pressure) {
		getJdbcTemplate();
		try{
		String sql="insert into dbo.Pressure values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{pressure.getPat_id(), pressure.getPressure_Systolic(), pressure.getPressure_Diastolic(), pressure.getPressure_RecordTime()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Pressure findByTime(Timestamp timestamp){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where timestamp=?";
			List query = jdbcTemplate.query(sql, new Object[]{timestamp}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPressure_id("pressure_id");
					pressure.setPat_id("pat_id");
					pressure.setPressure_Systolic("pressure_Systolic");
					pressure.setPressure_Diastolic("pressure_Diastolic");
					pressure.setPressure_RecordTime(timestamp);
					return pressure;
				}
			});
			if(query.size() == 0){
				return null;
			}
			return (Pressure) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Pressure findByPatID(String pat_id){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPressure_id("pressure_id");
					pressure.setPat_id(pat_id);
					pressure.setPressure_Systolic("pressure_Systolic");
					pressure.setPressure_Diastolic("pressure_Diastolic");
					//pressure.setPressure_RecordTime("pressure_RecordTime");
					return pressure;
				}
			});
			if(query.size() == 0){
				return null;
			}
			return (Pressure) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}