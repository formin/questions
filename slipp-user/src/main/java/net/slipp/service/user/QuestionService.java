package net.slipp.service.user;

import java.sql.SQLException;

import net.slipp.dao.user.QuestionDao; 
import net.slipp.dao.user.UserDao;
import net.slipp.domain.user.Question; 
import net.slipp.domain.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	public Question join(Question question) throws SQLException, ExistedUserException {
		log.debug("Question : {}", question);
		QuestionDao questionDao = new QuestionDao();
		Question existedUser = questionDao.findByUserId(question.getUserId());
		if (existedUser != null) {
			throw new ExistedUserException(question.getUserId());
		}

		questionDao.insert(question);
		return question;
	}

	public Question login(String userId, String password) throws SQLException, PasswordMismatchException {
		QuestionDao questionDao = new QuestionDao();
		Question question = questionDao.findByUserId(userId);
		if (question == null) {
			throw new PasswordMismatchException();
		}
		
		if (!question.matchid(userId)) {
			throw new PasswordMismatchException();
		}

		return question;
	}

	public Question findByUserId(String userId) throws SQLException {
		QuestionDao questionDao = new QuestionDao();
		return questionDao.findByUserId(userId);
	}

	public void update(String userId, Question updateQuestion) throws SQLException, PasswordMismatchException {
		Question question = findByUserId(userId);
		if (question == null) {
			throw new NullPointerException(userId + " question doesn't existed.");
		}
		question.update(updateQuestion);
	}
	
}
