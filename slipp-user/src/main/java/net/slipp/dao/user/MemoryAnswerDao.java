package net.slipp.dao.user;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.slipp.dao.answer.AnswerDao;
import net.slipp.domain.answer.Answer;

import org.springframework.stereotype.Repository;

@Repository("memoryAnswerDao")
public class MemoryAnswerDao implements AnswerDao { 
	
	private static Set<Answer> set = new HashSet<Answer>();  
 
    public void add(Answer answer) {
    	 answer.setIdx( set.size()+1 );
         set.add(answer);                                   
    }

 
	public Set<Answer> getAnswerByIdx(Integer Idx) {
   
          Set<Answer> s = new HashSet<Answer>();
          
          for(Iterator<Answer> it = set.iterator(); it.hasNext();) {
        	  		
        	  Answer answer = (Answer)it.next();
                    
        	  if (answer.getQnaidx().equals(Idx))        
                   s.add(answer);
        	  		
          }
          
          return s;
                  
    }

	public ArrayList<Answer> getArticleList(Integer Idx) { 

        Set<Answer> s = new HashSet<Answer>();
        
        for(Iterator<Answer> it = set.iterator(); it.hasNext();) {
      	  		
      	  Answer answer = (Answer)it.next();
                  
      	  if (answer.getQnaidx().equals(Idx))        
                 s.add(answer);
      	  		
        }
         
		
		ArrayList<Answer> valueList = new ArrayList<Answer>(s);

		Collections.reverse(valueList);
		
		return valueList;
	}

	
}
