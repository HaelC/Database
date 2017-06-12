package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Doctor;
import experi.entity.Patient;

public class PatientDao extends BaseDao{
	
	/**
	 *将病人插入数据库
	 */
	/*
	public void insertPatient(Patient patient){
		getJdbcTemplate();
		try{
		String sql="insert into dbo.Patient(pat_name,pat_password,pat_mobile) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[]{patient.getPat_name(),patient.getPassword(), patient.getPat_mobile()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
	public void insertPatient(Patient patient) {
		getJdbcTemplate();
		try {
			String sql = "insert into dbo.Patient(pat_name, pat_password, pat_mobile, pat_sex, pat_age, pat_height, pat_weight, pat_familialDisease, pat_historyDisease) values(?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql,new Object[]{patient.getPat_name(), patient.getPassword(), patient.getPat_mobile(), patient.getPat_sex(), patient.getPat_age(), patient.getPat_height(), patient.getPat_weight(), patient.getPat_familialDisease(), patient.getPat_historyDisease()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * complete patient's info
	 * @param patient
	 */
	public void completePatient(Patient patient) {
		getJdbcTemplate();
		try{
			String sql = "update dbo.Patient set pat_sex=?, pat_age=?, pat_height=?, pat_weight=?, pat_familialDisease=?, pat_historyDisease=? where pat_id =?";
			jdbcTemplate.update(sql,new Object[]{patient.getPat_sex(), patient.getPat_age(), patient.getPat_height(), patient.getPat_weight(), patient.getPat_familialDisease(), patient.getPat_historyDisease()}, patient.getPat_id());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新病人信息
	 * @param patient
	 */
	public void updatePatient(Patient patient,String doc_id){
		getJdbcTemplate();
		try{
		String sql="update patient set doc_id=? where pat_id=?";
		jdbcTemplate.update(sql,new Object[]{doc_id,patient.getPat_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cancelPatient(Patient patient){
		getJdbcTemplate();
		try{
		String sql="update patient set doc_id=? where pat_id=?";
		jdbcTemplate.update(sql,new Object[]{null,patient.getPat_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void changePatientPassword(Patient patient){
		getJdbcTemplate();
		try{
		String sql="update patient set pat_password=? where pat_id=?";
		jdbcTemplate.update(sql,new Object[]{patient.getPassword(),patient.getPat_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setPatient(Patient patient) {
		getJdbcTemplate();
		try{
		String sql="update patient set pat_name=?, pat_age=?, pat_height=?, pat_weight=?, pat_familialDisease=?, pat_historyDisease=?, pat_QQ=? where pat_id=?";
		jdbcTemplate.update(sql,new Object[]{patient.getPat_name(), patient.getPat_age(), patient.getPat_height(), patient.getPat_weight(), patient.getPat_familialDisease(), patient.getPat_historyDisease(),patient.getPat_QQ(),patient.getPat_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除
	 * @param patient
	 */
	public void deletePatient(Patient patient){
		getJdbcTemplate();
		try{
			String sql="delete from dbo.patient where pat_id=?";
			jdbcTemplate.update(sql, new Object[]{patient.getPat_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 查找对应医生
	 */

	public Doctor findDoc(Patient patient){
		getJdbcTemplate();
		try{
			String sql="select * from dbo.doctor where doctor_name=?";
			List query = jdbcTemplate.query(sql, new Object[]{patient.getDoctor()}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Doctor doctor=new Doctor();
					doctor.setDoctor_id("doctor_id");
					doctor.setDoctor_name(set.getString("doctor_name"));
					doctor.setPassword(set.getString("password"));
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
	
	/*
	public Doctor findDoctor(String name){
		getJdbcTemplate();
		try{
			String sql = "select * from dbo.doctor where doc_name=?";
			List query = jdbcTemplate.query(sql, new Object[]{name},new RowMapper()) {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Doctor doctor=new Doctor();
					doctor.setDoctor_id("doctor_id");
					doctor.setDoctor_name(set.getString("doctor_name"));
					doctor.setPassword(set.getString("password"));
					return doctor;
				}
			});
			if(query.size() == 0) {
				return null;
			}
			return (Doctor) query.get(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
	
	public Patient findByMobile(String pat_mobile) {
		getJdbcTemplate();
		try {
			String sql = "select * from dbo.Patient where pat_mobile=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_mobile}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Patient patient=new Patient();
					patient.setPat_id(set.getString("pat_id"));
					patient.setPat_name(set.getString("pat_name"));
					patient.setPassword(set.getString("pat_password"));
					patient.setPat_mobile(pat_mobile);
					patient.setDoc_id(set.getString("doc_id"));
					return patient;
				}
		});
			if(query.size() == 0){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Patient) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Patient findById(String pat_id) {
		getJdbcTemplate();
		try {
			String sql = "select * from dbo.Patient where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Patient patient=new Patient();
					patient.setPat_id(pat_id);
					patient.setPat_name(set.getString("pat_name"));
					patient.setPassword(set.getString("pat_password"));
					patient.setPat_mobile(set.getString("pat_mobile"));
					patient.setDoc_id(set.getString("doc_id"));
					return patient;
				}
		});
			if(query.size() == 0){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Patient) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Patient findByIdComplete(String pat_id) {
		getJdbcTemplate();
		try {
			String sql = "select * from dbo.Patient where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Patient patient=new Patient();
					patient.setPat_id(pat_id);
					patient.setPat_name(set.getString("pat_name"));
					patient.setPassword(set.getString("pat_password"));
					patient.setPat_mobile(set.getString("pat_mobile"));
					patient.setPat_sex(set.getString("pat_sex"));
					patient.setDoc_id(set.getString("doc_id"));
					patient.setPat_age(set.getString("pat_age"));
					patient.setPat_height(set.getString("pat_height"));
					patient.setPat_weight(set.getString("pat_weight"));
					patient.setPat_familialDisease(set.getString("pat_familialDisease"));
					patient.setPat_historyDisease(set.getString("pat_historyDisease"));
					patient.setPat_QQ(set.getString("pat_QQ"));
					return patient;
				}
		});
			if(query.size() == 0){				//Modify it by pretty teaching assistant's advice.
				return null;
			}
			return (Patient) query.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//PatientDao dao=new PatientDao();
		//Patient patient=new Patient("1100", "小白", "1234", "16", "张三");
		//dao.insertPatient(patient);
		//dao.updatePatient(patient, "2222");
	}
}
