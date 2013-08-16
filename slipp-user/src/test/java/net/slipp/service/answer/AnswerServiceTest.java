package net.slipp.service.answer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.slipp.dao.answer.AnswerDao; 
import net.slipp.domain.answer.Answer;
import net.slipp.domain.tag.Tag;
import net.slipp.domain.user.User; 

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnswerServiceTest {

	private AnswerService answerService;
	
	@Mock private AnswerDao answerDao;
	
	@Before
	public void setup() {
		answerService = new AnswerService();
		answerService.setAnswerDao(answerDao);
	}
	
	@Test
	public void 정상적으로_답변을등록한다() throws Exception {

		User user = new User("userId", "password", "name", "javajigi@email.com");  
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 

        Tag tag = new Tag();

		tag.setQnaidx(1);
		tag.setInsertdates(today);
		tag.setUserId("formin");
		tag.setContents("test");
		
        Answer answer = new Answer();

		answer.setUserId(user.getUserId());
		answer.setQnaidx(1);
		answer.setContents("test");
		answer.setInsertdates(today);
		
		Answer insertedAnswer = answerService.createAnswer(user, 1, answer);
        verify(answerDao).add(answer); 
        assertThat(insertedAnswer, is(answer));
		 
	}
}
