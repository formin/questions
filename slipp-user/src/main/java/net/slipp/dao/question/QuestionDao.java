package net.slipp.dao.question;

import java.sql.SQLException;
import java.util.ArrayList;

import net.slipp.domain.question.Question; 

public interface QuestionDao {

	int insert(Question question) throws SQLException;
	ArrayList<Question> getArticleList() throws SQLException;
	Question view(Integer idx) throws SQLException;
	Question findByIdx(Integer idx) throws SQLException;
	void update(Question question) throws SQLException;
	void delete(Integer idx) throws SQLException;
	
}
