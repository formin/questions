package net.slipp.dao.question;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.slipp.domain.question.Question; 
import net.slipp.support.AbstractDaoSupport;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("questionDao")
public class SpringJdbcQuestionDao extends AbstractDaoSupport implements QuestionDao {

	@Override
	public int insert(Question question) throws SQLException {
		String sql = "INSERT INTO QUESTION VALUES (?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, null, question.getUserId(), question.getTitle(), question.getContents(), question.getInsertdates(), question.getUpdatedates(), question.getPlaintags());
		
		sql = "SELECT MAX(IDX) FROM QUESTION";
		int total = getJdbcTemplate().queryForInt(sql);
	 
		return total;
		
	}


	@Override
	public void delete(Integer idx) throws SQLException{

		String sql = "DELETE FROM QUESTION WHERE IDX=?";
		getJdbcTemplate().update(sql, idx);
		
	};
	
	
	@Override
	public ArrayList<Question> getArticleList() throws SQLException {
		
		String sql = "SELECT IDX, USERID, TITLE FROM QUESTION";
		

		ArrayList<Question> qustion  = (ArrayList<Question>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Question>(Question.class));
	 
		return qustion;
		 
	}
	
	@Override
	public Question view(Integer idx) throws SQLException {
		String sql = "SELECT IDX, USERID, TITLE, CONTENTS, INSERTDATES, UPDATEDATES, PLAINTAGS FROM QUESTION WHERE IDX=?";
		RowMapper<Question> rowMapper = new RowMapper<Question> () {
			@Override
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Question(
						Integer.parseInt(rs.getString("IDX")), 
						rs.getString("USERID"), 
						rs.getString("TITLE"),
						rs.getString("CONTENTS"),
						rs.getString("INSERTDATES"),
						rs.getString("UPDATEDATES"),
						rs.getString("PLAINTAGS"));
			}
			
		};
		return DataAccessUtils.uniqueResult(getJdbcTemplate().query(sql, rowMapper, idx));
	}

	@Override
	public Question findByIdx(Integer idx) throws SQLException{
		String sql = "SELECT IDX, USERID, TITLE, CONTENTS, INSERTDATES, UPDATEDATES, PLAINTAGS FROM QUESTION WHERE IDX=?";
		RowMapper<Question> rowMapper = new RowMapper<Question> () {
			@Override
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Question(
						Integer.parseInt(rs.getString("IDX")), 
						rs.getString("USERID"), 
						rs.getString("TITLE"),
						rs.getString("CONTENTS"),
						rs.getString("INSERTDATES"),
						rs.getString("UPDATEDATES"),
						rs.getString("PLAINTAGS"));
			}
			
		};
		return DataAccessUtils.uniqueResult(getJdbcTemplate().query(sql, rowMapper, idx));
		
	}

	@Override
	public void update(Question question) throws SQLException {
		String sql = "UPDATE QUESTION SET TITLE=?, CONTENTS=?, PLAINTAGS=?, UPDATEDATES=? WHERE IDX=?";
		getJdbcTemplate().update(sql, question.getTitle(), question.getContents(), question.getPlaintags(), question.getUpdatedates(), question.getIdx());
	}
	
}
