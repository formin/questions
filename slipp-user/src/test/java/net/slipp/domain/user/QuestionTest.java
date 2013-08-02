package net.slipp.domain.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.slipp.service.user.PasswordMismatchException;

import org.junit.Test;

public class QuestionTest {

	@Test
	public void 게시물업데이트를확인한다() {
		User user = new User("userId", "password", "name", "javajigi@email.com");
		assertThat(user.matchPassword("password"), is(true)); 
		 
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        Question question = new Question();
        
        question.setIdx(0);
        question.setTitle("test");
        question.setContents("test");
        question.setUserId("test");
        question.setInsertdates(today);
        
        Question updatequestion = new Question(0, "test", "test1", "test1", "", today); 
        try {
			question.update(updatequestion);
		} catch (PasswordMismatchException e) { 
			e.printStackTrace();
		}
        
		assertThat(question, is(updatequestion));
	}
	
}
