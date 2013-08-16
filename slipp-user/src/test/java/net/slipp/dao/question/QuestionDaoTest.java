package net.slipp.dao.question;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
import net.slipp.dao.question.QuestionDao; 
import net.slipp.domain.question.Question;
import net.slipp.service.question.QuestionService;
import net.slipp.service.user.ExistedUserException; 

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoTest {

	private QuestionService questionService;

	@Mock private QuestionDao questionDao;

	@Before
	public void setup() throws SQLException, ExistedUserException {
		questionService = new QuestionService();
		questionService.setQuestionDao(questionDao);
	}
	
	@Test
	public void crud() throws Exception {
		 
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        Question question = new Question();
         
        question.setTitle("test");
        question.setContents("test");
        question.setUserId("test");
        question.setInsertdates(today);
  
        Question insertedQuestion = questionService.insert(question); 
		    
		assertThat(insertedQuestion, is(question));
		
	}
}
