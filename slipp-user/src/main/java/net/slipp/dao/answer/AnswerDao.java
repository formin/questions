package net.slipp.dao.answer;

import java.sql.SQLException; 
import java.util.ArrayList; 

import net.slipp.domain.answer.Answer;

public interface AnswerDao {
 
	public Answer add(Answer answer) throws SQLException; 
	ArrayList<Answer> getArticleList(Integer Idx) throws SQLException;
}
