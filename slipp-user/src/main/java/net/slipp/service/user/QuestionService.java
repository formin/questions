package net.slipp.service.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import net.slipp.dao.user.QuestionDao; 
import net.slipp.dao.user.UserDao;
import net.slipp.domain.user.Question; 
import net.slipp.domain.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	public Question insert(Question question) throws SQLException, ExistedUserException {
		log.debug("Question : {}", question);
		QuestionDao questionDao = new QuestionDao();

		int maxIdx = questionDao.maxIdx();
		question.setIdx(maxIdx);
		
		questionDao.insert(question);
		return question;
	}
 
	public Integer maxIdx() throws SQLException {
		QuestionDao questionDao = new QuestionDao(); 
		return questionDao.maxIdx();
	}

	public void update(String userId, Question updateQuestion) throws SQLException, PasswordMismatchException {
		int maxIdx = maxIdx();
		updateQuestion.setIdx(maxIdx); 
		updateQuestion.update(updateQuestion); 
	}

	/*
	 * 게시판 목록
	 */
	public ArrayList<Question> getArticleList() {
		QuestionDao questionDao = new QuestionDao();  
		return questionDao.getArticleList();
	}
	 
}
