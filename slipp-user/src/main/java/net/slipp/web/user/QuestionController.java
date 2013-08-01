package net.slipp.web.user; 
  
import javax.servlet.http.HttpSession;

import net.slipp.domain.user.Question; 
import net.slipp.domain.user.User;
import net.slipp.service.user.PasswordMismatchException;
import net.slipp.service.user.QuestionService; 
import net.slipp.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/questions")
public class QuestionController {
 
	private static Logger log = LoggerFactory.getLogger(UserController.class);
 
	private QuestionService questionService = new QuestionService();
	private UserService userService = new UserService();
	
	@RequestMapping("{id}")
	public String show(@PathVariable int id, HttpSession session, Question question, Model model) { 
		/*
		User user = (User) session.getAttribute("loginUser");
		  
		if (user == null)
		{
			model.addAttribute("list", questionService.getArticleList());
			return "question/list";
		}
		 
		model.addAttribute("user", user); 
		*/
		model.addAttribute("Question", questionService.view(id)); 
		log.debug("questionService : {}", questionService.view(id)); 
		
		return "question/view"; 
	}

	@RequestMapping("/form_write")
	public String form_write(HttpSession session, Model model) throws Exception {

		User user = (User) session.getAttribute("loginUser");
		  
		if (user == null)
		{
			model.addAttribute("list", questionService.getArticleList());
			return "question/list";
		}
 
		model.addAttribute("question", new Question());
		return "question/form_write";
	}

	@RequestMapping(value = "/{userId}/questioninsert", method = RequestMethod.POST)
	public String questioninsert(@PathVariable String userId, Question question, Model model) throws Exception {   
		questionService.insert(question);
		log.debug("question : {}", question); 
		model.addAttribute("list", questionService.getArticleList());
		return "question/list"; 
	} 

	@RequestMapping(value = "/list")
	public String list(Model model) throws Exception {   
		model.addAttribute("list", questionService.getArticleList());
		return "question/list"; 
	} 

	@RequestMapping(value = "/questionupdateform", method = RequestMethod.POST) 
	public String updateForm(Integer idx, HttpSession session, Model model) throws Exception {
 
		model.addAttribute("Question", questionService.view(idx)); 
		return "question/form_write";
	}
	
	@RequestMapping(value = "/{userId}/questionupdate", method = RequestMethod.POST)
	public String questionupdate(Integer idx, Question question, Model model) throws Exception {  
		log.debug("question : {}", question);
		try {
			
			question.setIdx(idx);
			questionService.update(question);
			return "redirect:/";
		} catch (PasswordMismatchException e) { 
			model.addAttribute("errorMessage", " 확인해 주세요.");
			return "question/list"; 
		}
	} 
}
