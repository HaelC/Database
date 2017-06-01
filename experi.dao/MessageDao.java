package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Message;
import experi.entity.Pressure;

public class MessageDao extends BaseDao {
	public void insertMessage(Message message) {
		getJdbcTemplate();
		try{
			String sql="insert into dbo.Message values(?,?,?,?)";
			jdbcTemplate.update(sql,new Object[]{message.getDoc_id(), message.getPat_id(), message.getMes_text(), message.getMes_time()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Message findMessage(String doc_id, String pat_id, int index) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Message where doc_id=? and pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{doc_id,pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					Message message = new Message();
					message.setDoc_id(doc_id);
					message.setPat_id(pat_id);
					message.setMes_text(set.getString("mes_time"));
					message.setMes_time(set.getString("mes_time"));
					return message;
				}
			});
			if(query.size() == 0){
				return null;
			}
			return (Message) query.get(index);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}