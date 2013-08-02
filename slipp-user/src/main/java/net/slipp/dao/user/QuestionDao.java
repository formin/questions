package net.slipp.dao.user;
 
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.HashMap; 
import java.util.Map; 
import java.util.TreeSet;

import net.slipp.domain.user.Question;  

/*
 * @class QuestionDao
 * @brief QnA 게시물클래스.
 */
public class QuestionDao {
 
	private static Map<Integer, Question> questions = new HashMap<Integer, Question>();
	
	/*
	 * QnA 게시물 입력.
	 * 
	 * @param question : 입력 게시물.
	 */
	public void insert(Question question) throws SQLException { 
		questions.put(question.getIdx(), question);
	}

	/*
	 * QnA 입력 될 게시물번호. 
	 *  
	 */
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
	public Question view(Integer idx) { 
		 
		return questions.get(idx);
	}

	/*
	 * 수정할 게시물 리턴.
	 */ 
	public Question findByIdx(Integer idx) throws SQLException {
		return questions.get(idx);
	}

	/*
	 * 게시물삭제.
	 */ 
	public Question delete(Integer idx) { 
		 
		return questions.remove(idx);
	}
	
}
