package net.slipp.dao.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import net.slipp.dao.question.QuestionDao;
import net.slipp.domain.question.Question;

import org.junit.Test;

public class QuestionDaoTest {

	@Resource(name = "memoryQuestionDao")
	private QuestionDao questionDao;
	
	@Test
	public void crud() throws Exception {
		 
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        Question question = new Question();
        
        question.setIdx(0);
        question.setTitle("test");
        question.setContents("test");
        question.setUserId("test");
        question.setInsertdates(today);
 
		questionDao.insert(question);
		  
		 
		
	}
}
