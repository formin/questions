package net.slipp.service.question;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;  
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
 
import net.slipp.dao.answer.AnswerDao;

import net.slipp.dao.question.QuestionDao;
import net.slipp.dao.tag.TagDao; 
import net.slipp.domain.question.Question;
import net.slipp.domain.tag.Tag; 
import net.slipp.service.user.ExistedUserException;
import net.slipp.service.user.PasswordMismatchException;
import net.slipp.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;
 

@Service
@Transactional 
public class QuestionService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Resource(name = "questionDao")
	private QuestionDao questionDao;

	@Resource(name = "answerDao")
	private AnswerDao answerDao;

	@Resource(name = "tagDao")
	private TagDao tagDao;
	
	@PostConstruct
	public void initialize() {
		log.debug("initialize");
	}
	
	@PreDestroy
	public void destroy() {
		log.debug("destroy");
	}	
	 

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	/*
	 * QnA 게시물입력.
	 * 
	 * @param question : 입력 게시물.
	 */
	public Question insert(Question question) throws SQLException, ExistedUserException {

		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
         
		question.setInsertdates(today);  
		question.setUpdatedates(today);  
		
		int Idx = questionDao.insert(question); 

		Set<String> parsedTags = parseTags(question.getPlaintags());
         
        for (String each : parsedTags) {
 
    		Tag tag = new Tag();
    		tag.setQnaidx(Idx);
    		tag.setInsertdates(today);
    		tag.setUserId(question.getUserId());
    		tag.setContents(each);
    		
    		tagDao.add(tag);
    		
    		log.debug("tag : {}", tag);
    		
        }
        
		//return question;
		return findByIdx(Idx);
		
	}
	
	static Set<String> parseTags(String plainTags) {
        Set<String> parsedTags = new HashSet<String>();   
        StringTokenizer tokenizer = new StringTokenizer(plainTags, " |,");
        while (tokenizer.hasMoreTokens()) {
            parsedTags.add(tokenizer.nextToken());
        }
        return parsedTags;
    }
	  
 
	public ArrayList<Question> getArticleList() throws SQLException{
		
		return questionDao.getArticleList();
		
	}

	public Question view(int idx) throws SQLException{
		
		return questionDao.view(idx);
		
	}
	
	/*
	 * QnA 게시물번호로 게시물 조회.
	 * 
	 * @param Idx : 게시물번호.
	 */
	public Question findByIdx(Integer Idx) throws SQLException {

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
		questionDao.update(question);
 
		Set<String> parsedTags = parseTags(question.getPlaintags());

		Tag deltag = new Tag();
		deltag.setQnaidx(Idx); 

		tagDao.del(deltag);

        for (String each : parsedTags) {
 
    		Tag tag = new Tag();
    		tag.setQnaidx(Idx);
    		tag.setInsertdates(today);
    		tag.setUserId(question.getUserId());
    		tag.setContents(each);
    		
    		tagDao.add(tag);
    		
    		log.debug("tag : {}", tag);
    		
        }
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

		questionDao.delete(Idx);

		Tag tag = new Tag();
		tag.setQnaidx(Idx); 

		tagDao.del(tag);

		log.debug("tag : {}", tag);

	}
	
}
