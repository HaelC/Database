package experi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import experi.entity.Message;
//import experi.entity.Message;
import experi.entity.Suggestion;

public class SuggestionDao extends BaseDao {
	public void addSuggestion(Suggestion suggestion) {
		getJdbcTemplate();
		try{
			String sql="insert into dbo.Suggestion values(?,?,?)";
			jdbcTemplate.update(sql,new Object[]{suggestion.getPat_id(), suggestion.getSug_main(), suggestion.getSug_time()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int countSuggestions(String pat_id) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Suggestion where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					//Patient patient = new Patient();
					//patient.setDoc_id(doc_id);
					//return patient;
					//Message message = new Message();
					//message.setPat_id(pat_id);
					//message.setDoc_id(doc_id);
					Suggestion suggestion = new Suggestion();
					suggestion.setPat_id(pat_id);
					return suggestion;
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
	
	public Suggestion findSuggestion(String pat_id, int index) {
		getJdbcTemplate();
		try{
			String sql="select * from dbo.Suggestion where pat_id=?";
			List query = jdbcTemplate.query(sql, new Object[]{pat_id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet set, int rownum)
						throws SQLException {
					//Message message = new Message();
					//message.setDoc_id(doc_id);
					//message.setPat_id(pat_id);
					//message.setMes_text(set.getString("mes_text"));
					//message.setMes_time(set.getString("mes_time"));
					//message.setMes_sentByDoc(set.getInt("mes_sentByDoc"));
					//return message;
					Suggestion suggestion = new Suggestion();
					suggestion.setPat_id(pat_id);
					suggestion.setSug_main(set.getString("sug_main"));
					suggestion.setSug_time(set.getString("sug_time"));
					return suggestion;
				}
			});
			if(query.size() == 0){
				return null;
			}
			return (Suggestion) query.get(index);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}