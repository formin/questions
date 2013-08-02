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

	/*
	 * QnA 게시물입력.
	 * 
	 * @param question : 입력 게시물.
	 */
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

	/*
	 * QnA 게시물번호 최대값 조회.
	 * 
	 * @param question : 입력 게시물.
	 */
	public Integer maxIdx() throws SQLException {
		QuestionDao questionDao = new QuestionDao(); 
		return questionDao.maxIdx();
	}

	/*
	 * QnA 게시물번호로 게시물 조회.
	 * 
	 * @param Idx : 게시물번호.
	 */
	public Question findByIdx(Integer Idx) throws SQLException {
		QuestionDao questionDao = new QuestionDao();
		return questionDao.findByIdx(Idx);
	}

	/*
	 * QnA 게시물 업데이트.
	 * 
	 * @param Idx : 게시물번호.
	 * @param updateQuestion : 갱신 할 게시물.
	 */
	public void update(Integer Idx, Question updateQuestion) throws SQLException, PasswordMismatchException {

		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        
        updateQuestion.setUpdatedates(today);
         
		Question question = findByIdx(Idx);
		if (question == null) {
			throw new NullPointerException(Idx + " Idx doesn't existed.");
		}
		question.update(updateQuestion);
		 
	}

	/*
	 * QnA 게시물 삭제.
	 * 
	 * @param Idx : 게시물번호. 
	 */
	public void delete(Integer Idx) throws SQLException, PasswordMismatchException {
  
		Question question = findByIdx(Idx);
		if (question == null) {
			throw new NullPointerException(Idx + " Idx doesn't existed.");
		}
		
		QuestionDao questionDao = new QuestionDao();
		questionDao.delete(Idx);
		 
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
