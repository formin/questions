package net.slipp.service.user;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;  

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import net.slipp.dao.user.AnswerDao;
import net.slipp.dao.user.AnswerDaoFactory;
import net.slipp.dao.user.QuestionDao;   
import net.slipp.dao.user.QuestionDaoFactory;  
import net.slipp.domain.user.Answer;
import net.slipp.domain.user.Question;  
import net.slipp.domain.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service; 

@Service 
public class QuestionService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Resource(name = "memoryQuestionDao")
	private QuestionDao questionDao;

	@Resource(name = "memoryAnswerDao")
	private AnswerDao answerDao;
	
	@PostConstruct
	public void initialize() {
		log.debug("initialize");
	}
	
	@PreDestroy
	public void destroy() {
		log.debug("destroy");
	}	
	
	/*
	 * QnA 게시물입력.
	 * 
	 * @param question : 입력 게시물.
	 */
	public Question insert(Question question) throws SQLException, ExistedUserException {
		 
		QuestionDao questionDao = QuestionDaoFactory.create();
		
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
		 
		QuestionDao questionDao = QuestionDaoFactory.create();
		return questionDao.maxIdx();
	}

	/*
	 * QnA 게시물번호로 게시물 조회.
	 * 
	 * @param Idx : 게시물번호.
	 */
	public Question findByIdx(Integer Idx) throws SQLException {
		 
		QuestionDao questionDao = QuestionDaoFactory.create();
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
		 
		QuestionDao questionDao = QuestionDaoFactory.create();
		questionDao.delete(Idx);
		 
	}
	
	/*
	 * 게시판 목록
	 */
	public ArrayList<Question> getArticleList() throws SQLException {
		 
		QuestionDao questionDao = QuestionDaoFactory.create();
		return questionDao.getArticleList();
	}

	/*
	 * 게시판 보기.
	 */
	public Question view(int idx) throws SQLException, PasswordMismatchException {
		 
		QuestionDao questionDao = QuestionDaoFactory.create(); 
		return questionDao.view(idx);
	}

	public void createAnswer(User user, Integer questionId, Answer answer) throws SQLException {

		AnswerDao answerDao = AnswerDaoFactory.create();
		QuestionDao questionDao = QuestionDaoFactory.create();
		
		@SuppressWarnings("unused")
		Question question = null;
		try {
			question = questionDao.findByIdx(questionId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		answer.setUserId(user.getUserId());
		answer.setQnaidx(questionId);
		
		//answer.answerTo(question);
		//final Answer savedAnswer = questionDao.save(answer);
		answerDao.add(answer);
		
	}

}
