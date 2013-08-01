package net.slipp.dao.user;
 
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map; 
import java.util.TreeSet;

import net.slipp.domain.user.Question;  

public class QuestionDao {
 
	private static Map<Integer, Question> questions = new HashMap<Integer, Question>();
	 
	public void insert(Question question) throws SQLException { 
		questions.put(question.getIdx(), question);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Integer maxIdx() throws SQLException {

        if(questions.isEmpty())
        {
          return 0;
        }
         
        return ( ( (Integer) new TreeSet(questions.keySet()).last() ) + 1 );  
	}

	/*
	 * 게시판 목록
	 */ 
	public ArrayList<Question> getArticleList() { 
	
		ArrayList<Question> valueList = new ArrayList<Question>(questions.values()); 
		Collections.reverse(valueList);
		
		return valueList;
	}

	/*
	 * 게시판 보기.
	 */ 
	public Question view(int idx) { 
		 
		return questions.get(idx);
	}
	
}
