package net.slipp.dao.answer;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Set;

import net.slipp.domain.answer.Answer;

public interface AnswerDao {
 
	void add(Answer answer) throws SQLException; 
	ArrayList<Answer> getArticleList(Integer Idx) throws SQLException;
}
