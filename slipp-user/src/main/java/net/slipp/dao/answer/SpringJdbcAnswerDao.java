	package net.slipp.dao.answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import net.slipp.domain.answer.Answer; 
import net.slipp.support.AbstractDaoSupport;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
 
@Repository("answerDao")
public class SpringJdbcAnswerDao extends AbstractDaoSupport implements AnswerDao {

	@Override
	public void add(Answer answer) throws SQLException{
		String sql = "INSERT INTO ANSWER VALUES (?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, null, answer.getQnaidx(), answer.getUserId(), answer.getContents(), answer.getInsertdates());
	}
 
	@Override
	public ArrayList<Answer> getArticleList(Integer Idx) throws SQLException {
     
		String sql = "SELECT idx, qnaidx, userId, contents, insertdates FROM ANSWER WHERE qnaidx='"+Idx+"'";

		ArrayList<Answer> answer  = (ArrayList<Answer>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Answer>(Answer.class));
	  
		return answer;
	 
	}
	
}
