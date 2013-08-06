package net.slipp.dao.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.slipp.domain.user.Question; 

import org.junit.Test;

public class QuestionDaoTest {

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

		//QuestionDao questionDao = new QuestionDao(); 
		QuestionDao questionDao = QuestionDaoFactory.create();
		questionDao.insert(question);
		 
        Question actual = questionDao.findByIdx(0);
		
		assertThat(actual, is(question));
		
	}
}
