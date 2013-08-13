package net.slipp.service.user;

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

import net.slipp.dao.user.AnswerDao; 
import net.slipp.dao.user.QuestionDao;    
import net.slipp.dao.user.TagDao;
import net.slipp.dao.user.UserDao;
import net.slipp.domain.user.Answer;
import net.slipp.domain.user.Question;  
import net.slipp.domain.user.Tag;
import net.slipp.domain.user.User;

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

	@Resource(name = "memoryAnswerDao")
	private AnswerDao answerDao;

	@Resource(name = "memoryTagDao")
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
 

		questionDao.insert(question); 

		Set<String> parsedTags = parseTags(question.getPlaintags());
         
        for (String each : parsedTags) {
 
    		Tag tag = new Tag();
    		tag.setQnaidx(1);
    		tag.setInsertdates(today);
    		tag.setUserId(question.getUserId());
    		tag.setContents(each);
    		
    		tagDao.add(tag);
    		
    		log.debug("tag : {}", tag);
    		
        }
        
		return question;
	}
	
	static Set<String> parseTags(String plainTags) {
        Set<String> parsedTags = new HashSet<String>();   
        StringTokenizer tokenizer = new StringTokenizer(plainTags, " |,");
        while (tokenizer.hasMoreTokens()) {
            parsedTags.add(tokenizer.nextToken());
        }
        return parsedTags;
    }
	  
 

	public void createAnswer(User user, Integer questionId, Answer answer) throws SQLException {
   
		
	}

}
