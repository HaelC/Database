package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Doctor;
import experi.entity.Patient;
import experi.entity.Pressure;



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
	public void setDocInfo(Doctor doctor) {
		getJdbcTemplate();
		try {
			String sql = "update doctor set doc_name=?, doc_phone=?, doc_qq=?, doc_workday=? where doc_id=?";
			jdbcTemplate.update(sql,new Object[]{doctor.getDoctor_name(), doctor.getDoc_phone(), doctor.getDoc_QQ(), doctor.getWorkTime(), doctor.getDoctor_id()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeDoctorPassword(Doctor doctor){
		getJdbcTemplate();
		try{
		String sql="update doctor set doc_password=? where doc_id=?";
		jdbcTemplate.update(sql,new Object[]{doctor.getPassword(),doctor.getDoctor_id()});
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
					doctor.setDoctor_id(doc_id);
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
	
	public Doctor findByIdComplete(String doc_id){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Doctor where doc_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Doctor doctor=new Doctor();
					doctor.setDoctor_id(doc_id);
					doctor.setDoctor_name(set.getString("doc_name"));
					doctor.setPassword(set.getString("doc_password"));
					doctor.setMobile(set.getString("doc_mobile"));
					doctor.setDoc_phone(set.getString("doc_phone"));
					doctor.setDoc_QQ(set.getString("doc_QQ"));
					String workday= set.getString("doc_workday");
					if(workday.contains("Monday")) {
						doctor.setWorkOnMon(true);
					}
					else {
						doctor.setWorkOnMon(false);
					}
					if(workday.contains("Tuesday")) {
						doctor.setWorkOnTue(true);
					}
					else {
						doctor.setWorkOnTue(false);
					}
					if(workday.contains("Wednesday")) {
						doctor.setWorkOnWed(true);
					}
					else {
						doctor.setWorkOnWed(false);
					}
					if(workday.contains("Thursday")) {
						doctor.setWorkOnThu(true);
					}
					else {
						doctor.setWorkOnThu(false);
					}
					if(workday.contains("Friday")) {
						doctor.setWorkOnFri(true);
					}
					else {
						doctor.setWorkOnFri(false);
					}
					if(workday.contains("Saturday")) {
						doctor.setWorkOnSat(true);
					}
					else {
						doctor.setWorkOnSat(false);
					}
					if(workday.contains("Sunday")) {
						doctor.setWorkOnSun(true);
					}
					else {
						doctor.setWorkOnSun(false);
					}
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
	
	public Doctor findByNameAndIndex(String doc_name, int index){
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
					//doctor.setPassword(set.getString("doc_password"));
					doctor.setMobile(set.getString("doc_mobile"));
					String workday= set.getString("doc_workday");
					if(workday.contains("Monday")) {
						doctor.setWorkOnMon(true);
					}
					else {
						doctor.setWorkOnMon(false);
					}
					if(workday.contains("Tuesday")) {
						doctor.setWorkOnTue(true);
					}
					else {
						doctor.setWorkOnTue(false);
					}
					if(workday.contains("Wednesday")) {
						doctor.setWorkOnWed(true);
					}
					else {
						doctor.setWorkOnWed(false);
					}
					if(workday.contains("Thursday")) {
						doctor.setWorkOnThu(true);
					}
					else {
						doctor.setWorkOnThu(false);
					}
					if(workday.contains("Friday")) {
						doctor.setWorkOnFri(true);
					}
					else {
						doctor.setWorkOnFri(false);
					}
					if(workday.contains("Saturday")) {
						doctor.setWorkOnSat(true);
					}
					else {
						doctor.setWorkOnSat(false);
					}
					if(workday.contains("Sunday")) {
						doctor.setWorkOnSun(true);
					}
					else {
						doctor.setWorkOnSun(false);
					}
					return doctor;
				}
			});
			if(query.size() == 0 || index > query.size()){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Doctor) query.get(index - 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int countYourPatients(String doc_id) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Patient where doc_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Patient patient = new Patient();
					patient.setDoc_id(doc_id);
					return patient;
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
	
	public Patient findYourPatients(String doc_id, int index) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Patient where doc_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_id}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Patient patient = new Patient();
					patient.setPat_id(set.getString("pat_id"));
					patient.setPat_name(set.getString("pat_name"));
					return patient;
				}
			});
			if(query.size() == 0 || index > query.size()){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Patient) query.get(index);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//DoctorDao dao=new DoctorDao();
		//Doctor doctor = dao.findById("1111");
		//System.out.println(doctor.getDoctor_name());
		//System.out.println(doctor.getWorkTime());
	}

}

