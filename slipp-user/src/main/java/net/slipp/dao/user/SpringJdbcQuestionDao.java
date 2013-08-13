package net.slipp.dao.user;


import java.sql.ResultSet;
import java.sql.SQLException;

import net.slipp.domain.user.Question; 
import net.slipp.support.AbstractDaoSupport;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("questionDao")
public class SpringJdbcQuestionDao extends AbstractDaoSupport implements QuestionDao {

	@Override
	public void insert(Question question) throws SQLException {
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
		getJdbcTemplate().update(sql, question.getUserId());
	}
 
}
