package net.slipp.dao.user;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Set;

import net.slipp.domain.user.Answer; 

public interface AnswerDao {
 
	void add(Answer answer) throws SQLException;
	@SuppressWarnings("rawtypes")
	Set getAnswerByIdx(Integer Idx) throws SQLException;
	ArrayList<Answer> getArticleList(Integer Idx) throws SQLException;
}
