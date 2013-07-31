package net.slipp.web.user; 

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.HandlerMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {
 
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	 
	@RequestMapping(value="/**", method = RequestMethod.GET)
	public String questions(HttpServletRequest request) throws Exception { 
		
		String remainingPaths = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
	    String strIdx = (String) request.getRequestURI();
	     
		log.debug("strIdxw = ", strIdx.toString());
		log.debug("remainingPaths = ", remainingPaths.toString());
	    
		return "question/view"; 
	}
 
}
