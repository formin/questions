package net.slipp.dao.user;
 
import java.sql.SQLException;
import java.util.ArrayList;  

import net.slipp.domain.user.Question;   
 
 
public interface QuestionDao {

	void insert(Question question) throws SQLException;
	Integer maxIdx() throws SQLException;
	ArrayList<Question> getArticleList() throws SQLException;
	Question view(Integer idx) throws SQLException;
	Question findByIdx(Integer idx) throws SQLException;
	Question delete(Integer idx) throws SQLException;
	
}
