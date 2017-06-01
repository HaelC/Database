package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Doctor;
import experi.entity.Patient;
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
	
	/*
	public Pressure findByTime(Timestamp timestamp){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where timestamp=?";
			List query = jdbcTemplate.query(sql, new Object[]{timestamp}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPressure_id(set.getString("pressure_id"));
					pressure.setPat_id("pat_id");
					pressure.setPressure_Systolic("pressure_Systolic");
					pressure.setPressure_Diastolic("pressure_Diastolic");
					pressure.setPressure_RecordTime("pressure_recordTime");
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
	*/
	
	public Pressure findByPatID(String pat_id){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPressure_id(set.getString("pressure_id"));
					pressure.setPat_id(pat_id);
					pressure.setPressure_Systolic(set.getString("pressure_Systolic"));
					pressure.setPressure_Diastolic(set.getString("pressure_Diastolic"));
					pressure.setPressure_RecordTime(set.getString("pressure_recordTime"));
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
	
	public Pressure findByPatIDLatest(String pat_id){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPressure_id(set.getString("pressure_id"));
					pressure.setPat_id(pat_id);
					pressure.setPressure_Systolic(set.getString("pressure_Systolic"));
					pressure.setPressure_Diastolic(set.getString("pressure_Diastolic"));
					pressure.setPressure_RecordTime(set.getString("pressure_recordTime"));
					return pressure;
				}
			});
			if(query.size() == 0){
				return null;
			}
			return (Pressure) query.get(query.size() - 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int countPatPressure(String pat_id) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPat_id(pat_id);
					return pressure;
				}
			});
			if(query.size() == 0){
				return 0;
			}
			return query.size();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public Pressure findByPatIDandIndex(String pat_id, int index) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Pressure where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Pressure pressure = new Pressure();
					pressure.setPat_id(pat_id);
					pressure.setPressure_Systolic(set.getString("pressure_Systolic"));
					pressure.setPressure_Diastolic(set.getString("pressure_Diastolic"));
					pressure.setPressure_RecordTime(set.getString("pressure_recordTime"));
					return pressure;
				}
			});
			if(query.size() == 0 || index >= query.size()){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Pressure) query.get(index);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
