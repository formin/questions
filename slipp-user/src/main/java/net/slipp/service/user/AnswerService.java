package net.slipp.service.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import net.slipp.dao.user.AnswerDao; 
import net.slipp.dao.user.AnswerDaoFactory; 
import net.slipp.domain.user.Answer; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Resource(name="memoryAnswerDao")
	private AnswerDao answerDao;

	public void setAnswerDao(AnswerDao AnswerDao){
		this.answerDao = AnswerDao;
	}

	@PostConstruct
	public void initialize() {
		log.debug("AnswerService initialize");
	}
	
	@PreDestroy
	public void destroy() {
		log.debug("AnswerService destroy");
	}	

	public HashSet<?> view(int idx) throws SQLException, PasswordMismatchException {
		 
		AnswerDao answerDao = AnswerDaoFactory.create(); 
		return (HashSet<?>) answerDao.getAnswerByIdx(idx);
	}

	public ArrayList<Answer> getArticleList(int idx) throws SQLException {

		AnswerDao answerDao = AnswerDaoFactory.create(); 
		return answerDao.getArticleList(idx);
	}
 
}
