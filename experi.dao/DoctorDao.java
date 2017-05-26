package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Doctor;



public class DoctorDao extends BaseDao {
	/**
	 *将医生插入数据库
	 */
	public void insertDoctor(Doctor doctor){
		getJdbcTemplate();
		try{
		String sql="insert into dbo.Doctor values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{doctor.getDoctor_name(), doctor.getPassword(), doctor.getWorkTime(), doctor.getDoctor_mobile(), null, null});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 删除
	 * @param doctor
	 */
	public void deleteDoctor(Doctor doctor){
		getJdbcTemplate();
		try{
			String sql="delete from dbo.Doctor where doc_id=?";
			jdbcTemplate.update(sql, new Object[]{doctor.getDoctor_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 查找固定医生
	 */

	public Doctor findById(String doc_id){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Doctor where doc_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Doctor doctor=new Doctor();
					doctor.setDoctor_id("doc_id");
					doctor.setDoctor_name(set.getString("doc_name"));
					doctor.setPassword(set.getString("doc_password"));
					doctor.setMobile(set.getString("doc_mobile"));
					return doctor;
				}
			});
			if(query.size() == 0){
				return null;
			}
			return (Doctor) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	public Doctor findByMobile(String doc_mobile){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Doctor where doc_mobile=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_mobile}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Doctor doctor=new Doctor();
					doctor.setDoctor_id(set.getString("doc_id"));
					doctor.setDoctor_name(set.getString("doc_name"));
					doctor.setPassword(set.getString("doc_password"));
					doctor.setMobile(doc_mobile);
					return doctor;
				}
			});
			if(query.size() == 0){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Doctor) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Doctor findByName(String doc_name){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Doctor where doc_name=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_name}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Doctor doctor=new Doctor();
					doctor.setDoctor_id(set.getString("doc_id"));
					doctor.setDoctor_name(doc_name);
					doctor.setPassword(set.getString("doc_password"));
					doctor.setMobile(set.getString("doc_mobile"));
					return doctor;
				}
			});
			if(query.size() == 0){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Doctor) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		DoctorDao dao=new DoctorDao();
		Doctor doctor = dao.findById("1111");
		System.out.println(doctor.getDoctor_name());
		System.out.println(doctor.getWorkTime());
	}

}

