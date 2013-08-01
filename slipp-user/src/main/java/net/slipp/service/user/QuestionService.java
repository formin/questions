package net.slipp.service.user;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;  

import net.slipp.dao.user.QuestionDao;  
import net.slipp.domain.user.Question; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	public Question insert(Question question) throws SQLException, ExistedUserException {
		QuestionDao questionDao = new QuestionDao();
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
         
		question.setInsertdates(today);
		
		int maxIdx = questionDao.maxIdx();
		question.setIdx(maxIdx);
		
		questionDao.insert(question);
		
		log.debug("Question : {}", question);
		return question;
	}
 
	public Integer maxIdx() throws SQLException {
		QuestionDao questionDao = new QuestionDao(); 
		return questionDao.maxIdx();
	}

	public void update(Question updateQuestion) throws SQLException, PasswordMismatchException {

		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        
        updateQuestion.setUpdatedates(today);
        
		updateQuestion.update(updateQuestion); 
	}

	/*
	 * 게시판 목록
	 */
	public ArrayList<Question> getArticleList() {
		QuestionDao questionDao = new QuestionDao();  
		return questionDao.getArticleList();
	}

	/*
	 * 게시판 보기.
	 */
	public Question view(int idx) {
		QuestionDao questionDao = new QuestionDao();  
		return questionDao.view(idx);
	}
	
}
