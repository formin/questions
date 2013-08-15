package net.slipp.service.answer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import net.slipp.dao.answer.AnswerDao;
import net.slipp.domain.answer.Answer;
import net.slipp.service.user.PasswordMismatchException;
import net.slipp.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional 
public class AnswerService {
 
	@Resource(name="answerDao")
	private AnswerDao answerDao;

	public void setAnswerDao(AnswerDao answerDao){
		this.answerDao = answerDao;
	}
  
	public ArrayList<Answer> getArticleList(int idx) throws SQLException {
 
		return answerDao.getArticleList(idx);
	}
 
}
