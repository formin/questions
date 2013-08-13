package net.slipp.web.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import net.slipp.domain.user.Answer;
import net.slipp.domain.user.User;
import net.slipp.service.user.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(HttpSession session, Model model, @PathVariable Integer questionId, Answer answer) throws Exception { 

		User user = (User) session.getAttribute("loginUser");
		  
		if (user == null)
		{ 
			return "question/list";
		}

		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        answer.setInsertdates(today);
        
		questionService.createAnswer(user, questionId, answer);
		return String.format("redirect:/questions/%d", questionId);
	}
	
}
 
