package net.slipp.service.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
 
import net.slipp.domain.user.Question; 

import org.junit.Test;

public class QuestionServiceTest {
	
	@Test
	public void 정상적으로_글을등록한다() throws Exception {
		 
		QuestionService questionService = new QuestionService(); 
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        Question question = new Question();
        
        question.setIdx(0);
        question.setTitle("test");
        question.setContents("test");
        question.setUserId("test");
        question.setInsertdates(today);
		 
		 
	}
	 
}
