package net.slipp.dao.user;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import net.slipp.domain.user.Question; 
import net.slipp.service.user.QuestionService;

public class QuestionDao {
 
	private static Map<Question, Integer> questions = new HashMap<Question, Integer>();
	 
	public void insert(Question question) throws SQLException { 
		questions.put(question, question.getIdx());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Integer maxIdx() throws SQLException {

        if(questions.isEmpty())
        {
          return 0;
        }
        
        return ( ( (Integer) new TreeSet(questions.values()).last() ) + 1 );
         
	}

	/*
	 * 게시판 목록
	 */ 
	public ArrayList<Question> getArticleList() { 
		
		ArrayList<Question> valueList = new ArrayList<Question>(questions.keySet()); 
 
		return valueList;
	}
}
