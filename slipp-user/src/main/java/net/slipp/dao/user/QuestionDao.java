package net.slipp.dao.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.slipp.domain.user.Question; 

public class QuestionDao {
 
	private static Map<String, Question> questions = new HashMap<String, Question>();
	 
	public void insert(Question question) throws SQLException {
		questions.put(question.getUserId(), question);
	}

	public Question findByUserId(String userId) throws SQLException {
		return questions.get(userId);
	}
 
}
