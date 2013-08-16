	package net.slipp.dao.answer;
 
import java.sql.SQLException;
import java.util.ArrayList; 

import net.slipp.domain.answer.Answer; 
import net.slipp.support.AbstractDaoSupport;
 
import org.springframework.jdbc.core.BeanPropertyRowMapper; 
import org.springframework.stereotype.Repository;
 
@Repository("answerDao")
public class SpringJdbcAnswerDao extends AbstractDaoSupport implements AnswerDao {

	@Override
	public Answer add(Answer answer) throws SQLException{
		String sql = "INSERT INTO ANSWER VALUES (?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, null, answer.getQnaidx(), answer.getUserId(), answer.getContents(), answer.getInsertdates());
		
		return answer;
	}
 
	@Override
	public ArrayList<Answer> getArticleList(Integer Idx) throws SQLException {
     
		String sql = "SELECT idx, qnaidx, userId, contents, insertdates FROM ANSWER WHERE qnaidx='"+Idx+"'";

		ArrayList<Answer> answer  = (ArrayList<Answer>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Answer>(Answer.class));
	  
		return answer;
	 
	}
	
}
