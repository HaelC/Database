package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Appointment;;

public class AppointmentDao extends BaseDao {
	
	public void insertAppointment(Appointment appointment) {
		getJdbcTemplate();
		try{
			String sql="insert into dbo.Appointment values(?,?,?,?)";
			jdbcTemplate.update(sql,new Object[]{appointment.getDoc_id(), appointment.getPat_id(), appointment.getAppointmentDate(), appointment.getAppointmentNote()});
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}