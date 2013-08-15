package net.slipp.dao.user;
 
import java.util.ArrayList; 
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator; 
import java.util.Set;

import net.slipp.dao.tag.TagDao;
import net.slipp.domain.tag.Tag;

import org.springframework.stereotype.Repository;

@Repository("memoryTagDao")
public class MemoryTagDao implements TagDao {
 
	private static Set<Tag> tagcnt = new HashSet<Tag>();   // 태그 카운트를 위한 set
	private static Set<Tag> taglist = new HashSet<Tag>();  // 연관 태크를 위한 set 
 

    // 태그 내용에 대한 카운트 증감 처리 - 리스트페이지의 전체 태그.	
    public void listTagAdd(Tag tag){
    	   
        // 태그 카운트 set  
        for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
      	  		
        	Tag tmpTagCnt = (Tag)it.next();
	          
        	// 기존에 기록 된 태그 내용이 있는지 검사.
	       	if (tmpTagCnt.getContents().equals(tag.getContents())){
	         
	   			  // 태그 내용이 동일한 경우라도 기존 게시물에서 수정하는 경우는 카운트 증가 제외.
	        	  if (!tmpTagCnt.getQnaidx().equals(tag.getQnaidx()))
	        		  tag.setCount(tmpTagCnt.getCount()+1);  
	              
	        	  // 태그 카운트는 기존 기록 된 태그 내용이 존재하는 경우 앞서 태그를 지우고 이후 태그에 카운트를 합산한다.
	        	  tagcnt.remove(tmpTagCnt); 
	              
	        	  break;
	               
	       	  }

        }

	    tagcnt.add(tag);  	     
	     
    }

    // 태그 내용에 대한 카운트 증감 처리 - 내용보기페이지의 연관 태그.	
    public void viewTagAdd(Tag tag){

        // 연관 태그 set  
        for(Iterator<Tag> it = taglist.iterator(); it.hasNext();) {
      	  		
        	Tag tmpTagList = (Tag)it.next();

        	// 기존에 기록 된 태그 내용이 있는지 검사.           
	       	if (tmpTagList.getContents().equals(tag.getContents())){
      		 
      			  // 태그 내용이 동일한 경우라도 기존 게시물에서 수정하는 경우는 카운트 증가 제외.
           	  if(!tmpTagList.getQnaidx().equals(tag.getQnaidx()))
           		  tag.setCount(tmpTagList.getCount()+1);  

           	  // 기존 게시물의 태그 내용과 동일한 경우 뒤에 게시물이 내용을 추가하더라도 기존 태그를 지우지 않음.
           	  if (tmpTagList.getQnaidx().equals(tag.getQnaidx()))
           		  taglist.remove(tmpTagList);
	              
	              break;
		              
	       	  }
      	  		
        }

        taglist.add(tag);
    }
    
    public void add(Tag tag) {

    	 // 현재 기록 될 태그의 유일키번호 할당.
    	 tag.setIdx( tagcnt.size()+1 );

    	 // 현재 기록 될 태크의 카운트 값 할당.
         tag.setCount(1);
         
         // 태그 내용에 대한 카운트 증감 처리 - 리스트페이지의 전체 태그.			
         listTagAdd(tag);
         
         // 태그 내용에 대한 카운트 증감 처리 - 내용보기페이지의 연관 태그.
         viewTagAdd(tag);
         
    }

    // 태그 내용에 대한 카운트 차감 처리.	
    public void chkTagDel(Tag tmpTagList){

    	Set<Tag> removeTagcnt = new HashSet<Tag>();  

        for(Iterator<Tag> itcnt = tagcnt.iterator(); itcnt.hasNext();) {
      	  		
        	Tag tmpTagCnt = (Tag)itcnt.next();
                     
        	  // 해당 게시물의 삭제 태그.	
          	  if (tmpTagCnt.getContents().equals(tmpTagList.getContents())){
                 
            	 //삭제 된 태그 카운트 차감.
            	 tmpTagCnt.setCount(tmpTagCnt.getCount() - 1);
            	 
            	 // 차감 된 태그가 0 이면 태그를 삭제.
            	 if(tmpTagCnt.getCount() <= 0){
                	 removeTagcnt.add(tmpTagCnt); 
                     tagcnt.removeAll(removeTagcnt); 
                     break;
            	 }
            
            	 // 차감 된 태그 카운트 반영.
            	 removeTagcnt.add(tmpTagCnt); 
                tagcnt.removeAll(removeTagcnt); 
                tagcnt.addAll(removeTagcnt);
                 
                break;
        		  
          	  }
      	  		
        }
        
    }
    
    public void del(Tag tag){
  
    	Set<Tag> removeTaglist = new HashSet<Tag>();  
    	   
        // 태크에 중복 된 게시물 번호 카운트 후 삭제.
        for(Iterator<Tag> it = taglist.iterator(); it.hasNext();) {
      	  		
        	Tag tmpTagList = (Tag)it.next();
            
        	// 삭제 될 게시물에 포함 태그 확인.
      	    if (tmpTagList.getQnaidx().equals(tag.getQnaidx())){
      		   
      	    	 // 삭제 될 태그.
            	 removeTaglist.add(tmpTagList);
            	 
            	 // 태그 내용에 대한 카운트 차감 처리.
            	 chkTagDel(tmpTagList);
	               
      	    }
      	  		
        } 
        
        taglist.removeAll(removeTaglist);  
        
    }
 
	public Set<Tag> getTagByIdx(Integer Idx) {
   
          Set<Tag> s = new HashSet<Tag>();
          
          for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
        	  		
        	  Tag tag = (Tag)it.next();
                    
        	  if (tag.getQnaidx().equals(Idx))        
                   s.add(tag);
        	  		
          }
          
          return s;
                  
    }

	public ArrayList<String> getArticleList(Integer Idx) { 

        Set<Tag> s = new HashSet<Tag>();
        
        for(Iterator<Tag> it = taglist.iterator(); it.hasNext();) {
      	  		
        	Tag tag = (Tag)it.next();
                  
      	  if (tag.getQnaidx().equals(Idx))        
                 s.add(tag);
      	  		
        }

		ArrayList<Tag> data = new ArrayList<Tag>(s);

		Collections.reverse(data);

        ArrayList<String> itemList = new ArrayList<String>();

        //1. 데이터 유형 및 개수를 설정한다.
        for(int index = 0 ; index < data.size() ; index++){
        	
            //item이 등록되었는지 확인한다.
            //1.1 등록되지 않았을 때 처리
            if(!itemList.contains(data.get(index).getContents())){
                
                //1.1.1 item을 itemList에 추가한다.
                itemList.add(data.get(index).getContents());
                  
            }           
            
        }//end 데이터 유형 및 개수를 설정
        
        
		return itemList;
	}

	public Set<Tag> getTagList() {
   
          Set<Tag> s = new HashSet<Tag>();
          
          for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
        	  		
        	  Tag tag = (Tag)it.next();
                         
              s.add(tag);
        	  		
          }
          
          return s;
                  
    }
	
	public ArrayList<Tag> getList() { 

        Set<Tag> s = new HashSet<Tag>();
        
        for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
      	  		
        	Tag tag = (Tag)it.next();
                       
            s.add(tag);
      	  		
        }

		ArrayList<Tag> valueList = new ArrayList<Tag>(s);
 
		return valueList;
	}
	  
}
