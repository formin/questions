package net.slipp.web.question; 
  
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import net.slipp.domain.question.Question;
import net.slipp.domain.user.User;
import net.slipp.service.answer.AnswerService;
import net.slipp.service.question.QuestionService;
import net.slipp.service.tag.TagService;
import net.slipp.service.user.PasswordMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @class QuestionController
 * @brief QnA 게시물클래스.
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private TagService tagService;
	
	/*
	 * QnA 게시물보기.
	 *
	 * @param idx : 게시물번호. 
	 */
	@RequestMapping("{idx}")
	public String show(@PathVariable int idx, Model model) throws SQLException, PasswordMismatchException { 

		Question question = questionService.view(idx);
		
		model.addAttribute("qestion", question);
		model.addAttribute("Answer", answerService.view(idx));  
		model.addAttribute("list", answerService.getArticleList(idx));	
		model.addAttribute("taglist", tagService.getArticleList(idx));		
		return "question/view"; 
	}

	/*
	 * QnA 게시물쓰기폼.
	 *
	 * @param session : 세션체크로 로그인 여부 확인. 
	 */
	@RequestMapping("/form_write")
	public String form_write(HttpSession session, Model model) throws Exception {

		User user = (User) session.getAttribute("loginUser");
		  
		if (user == null)
		{ 
			model.addAttribute("list", questionService.getArticleList());
			model.addAttribute("taglist", tagService.getList());
			return "question/list";
		}
 
		model.addAttribute("question", new Question());
		return "question/form_write";
	}
	
	/*
	 * QnA 게시물쓰기.
	 *
	 * @param userId : 사용자아이디.
	 * @param question : 게시물.
	 */
	@RequestMapping(value = "/{userId}/questioninsert", method = RequestMethod.POST)
	public String questioninsert(@PathVariable String userId, String plainTags, Question question, Model model) throws Exception { 
		
		questionService.insert(question);

		model.addAttribute("list", questionService.getArticleList());
		model.addAttribute("taglist", tagService.getList());
		model.addAttribute("taglistCnt", tagService.getTagList());
		return "question/list"; 
	} 

	/*
	 * QnA 게시물리스트.
	 * 
	 */
	@RequestMapping(value = "/list")
	public String list(Model model) throws Exception {    
		model.addAttribute("list", questionService.getArticleList());
		model.addAttribute("taglist", tagService.getList());
		model.addAttribute("taglistCnt", tagService.getTagList());
		return "question/list"; 
	} 

	/*
	 * QnA 게시물업데이트폼.
	 *
	 * @param idx : 게시물번호.
	 * @param session : 세션체크로 로그인여부 확인.
	 */
	@RequestMapping(value = "/questionupdateform", method = RequestMethod.POST) 
	public String updateForm(Integer idx, HttpSession session, Model model) throws Exception {

		User user = (User) session.getAttribute("loginUser");
		  
		if (user == null)
		{ 
			model.addAttribute("taglist", tagService.getList());
			model.addAttribute("list", questionService.getArticleList());
			return "question/list";
		}

		Question question = questionService.view(idx);
		
		model.addAttribute("qestion", question);
		
		return "question/form_write";
	}

	/*
	 * QnA 게시물업데이트.
	 *
	 * @param idx : 게시물번호.
	 * @param question : 업데이트게시물.
	 */
	@RequestMapping(value = "/{userId}/questionupdate", method = RequestMethod.POST)
	public String questionupdate(Integer idx, HttpSession session, Question question, Model model) throws Exception {  
		  

		User user = (User) session.getAttribute("loginUser");
		  
		if (user == null)
		{ 
			model.addAttribute("taglist", tagService.getList());
			model.addAttribute("list", questionService.getArticleList());
			return "question/list";
		}
	 
		question.setIdx(idx); 
		questionService.update(idx, question);		
		
		return "redirect:/";
		 
	} 

	/*
	 * QnA 게시물삭제.
	 *
	 * @param idx : 게시물번호.
	 * @param session : 세션체크로 로그인여부화인.
	 * @param question : 삭제할 게시물.
	 */
	@RequestMapping(value = "/questiondelete", method = RequestMethod.POST) 
	public String delete(Integer idx, HttpSession session, Question question, Model model) throws Exception {
		  

			User user = (User) session.getAttribute("loginUser");
			  
			if (user == null)
			{ 
				model.addAttribute("list", questionService.getArticleList());
				model.addAttribute("taglist", tagService.getList());
				return "question/list";
			}
			
			question.setIdx(idx); 
			return "redirect:/"; 
	}
	
	
}
