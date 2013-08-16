package net.slipp.service.answer;

import java.sql.SQLException;
import java.util.ArrayList; 
 
import javax.annotation.Resource;

import net.slipp.dao.answer.AnswerDao;
import net.slipp.dao.question.QuestionDao;
import net.slipp.domain.answer.Answer;
import net.slipp.domain.question.Question;
import net.slipp.domain.user.User; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional 
public class AnswerService {
 
	@Resource(name="answerDao")
	private AnswerDao answerDao;

	@Resource(name = "questionDao")
	private QuestionDao questionDao;
	
	public void setAnswerDao(AnswerDao answerDao){
		this.answerDao = answerDao;
	}
  
	public ArrayList<Answer> getArticleList(int idx) throws SQLException {
 
		return answerDao.getArticleList(idx);
	}


	public Answer createAnswer(User user, Integer questionId, Answer answer) throws SQLException {
   
		@SuppressWarnings("unused")
		Question question = null;
		question = questionDao.findByIdx(questionId);
		
		answer.setUserId(user.getUserId());
		answer.setQnaidx(questionId);
		
		return answerDao.add(answer);
				
	}
	
}
