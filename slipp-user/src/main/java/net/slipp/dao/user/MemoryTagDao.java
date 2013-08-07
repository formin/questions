package net.slipp.dao.user;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import net.slipp.domain.user.Tag;
import net.slipp.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("memoryTagDao")
public class MemoryTagDao implements TagDao {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	private static Set<Tag> tagcnt = new HashSet<Tag>();   // 태그 카운트를 위한 set
	private static Set<Tag> taglist = new HashSet<Tag>();  // 연관 태크를 위한 set 
 
    public void add(Tag tag) {

    	 tag.setIdx( tagcnt.size()+1 );

         tag.setCount(1);
 
         
         // 태그 카운트 set START ==>
         // 태크에 중복 된 내용을 카운트 후 삭제.
         for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
       	  		
         	Tag tagCnt = (Tag)it.next();
                   
       	  if (tagCnt.getContents().equals(tag.getContents())){
              try{
            	  
            	  if (!tagCnt.getQnaidx().equals(tag.getQnaidx()))
            		  tag.setCount(tagCnt.getCount()+1);  
	              
            	  tagcnt.remove(tagCnt);
	              break;
              }catch(Exception e){ 
          		log.debug("알수 없는 예외입니다.");
              }
       	  }
       	  		
         }

         // 태그 업데이트의 경우는 위에 내용으로 카운트가 불가능 하므로.
         // 태크에 중복 된 게시물 번호 카운트 후 삭제.
         for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
       	  		
         	Tag tagCntSet = (Tag)it.next();
                   
       	  if (tagCntSet.getQnaidx().equals(tag.getQnaidx()) && tagCntSet.getContents().equals(tag.getContents())){
              try{
	              //tag.setCount(tagCntSet.getCount()+1);  
            	  //업데이트의 경우 태그 카운트를 하지 않는다.
	              tagcnt.remove(tagCntSet);
	              break;
              }catch(Exception e){ 
          		log.debug("알수 없는 예외입니다.");
              }
       	  }
       	  		
         }
         
         tagcnt.add(tag);  
         // 태그 카운트 set END ==>

         // 연관 태그 set START ==>
         // 태크에 중복 된 내용을 카운트 후 삭제.
         for(Iterator<Tag> it = taglist.iterator(); it.hasNext();) {
       	  		
         	Tag tagCnt = (Tag)it.next();
                   
       	  if (tagCnt.getContents().equals(tag.getContents())){
              try{
            	  
            	  if(!tagCnt.getQnaidx().equals(tag.getQnaidx()))
            		  tag.setCount(tagCnt.getCount()+1);  
            	  
	              taglist.remove(tagCnt);
	              break;
              }catch(Exception e){ 
          		log.debug("알수 없는 예외입니다.");
              }
       	  }
       	  		
         }

         // 태그 업데이트의 경우는 위에 내용으로 카운트가 불가능 하므로.
         // 태크에 중복 된 게시물 번호 카운트 후 삭제.
         for(Iterator<Tag> it = taglist.iterator(); it.hasNext();) {
       	  		
         	Tag tagListSet = (Tag)it.next();
                   
       	  if (tagListSet.getQnaidx().equals(tag.getQnaidx()) && tagListSet.getContents().equals(tag.getContents())){
              try{
	              //tag.setCount(tagListSet.getCount()+1);   
            	  //업데이트의 경우 태그 카운트를 하지 않는다. 
	              taglist.remove(tagListSet);
	              break;
              }catch(Exception e){ 
          		log.debug("알수 없는 예외입니다.");
              }
       	  }
       	  		
         }

         taglist.add(tag);
         // 연관 태그 set END ==>
         
 
    }

    public void del(Tag tag){
 
    	Set<Tag> removeTagcnt = new HashSet<Tag>();  
    	Set<Tag> removeTaglist = new HashSet<Tag>();  
    	
        // 태그 카운트 set START ==> 
        // 태크에 중복 된 게시물 번호 카운트 후 삭제.
        for(Iterator<Tag> it = tagcnt.iterator(); it.hasNext();) {
      	  		
        	Tag tagCntSet = (Tag)it.next();
                  
      	  if (tagCntSet.getQnaidx().equals(tag.getQnaidx())){
             try{  
            	 removeTagcnt.add(tagCntSet);
             }catch(Exception e){ 
         		log.debug("알수 없는 예외입니다.");
             }
      	  }
      	  		
        } 
        tagcnt.removeAll(removeTagcnt); 
        // 태그 카운트 set END ==>

        // 연관 태그 set START ==> 
        // 태크에 중복 된 게시물 번호 카운트 후 삭제.
        for(Iterator<Tag> it = taglist.iterator(); it.hasNext();) {
      	  		
        	Tag tagListSet = (Tag)it.next();
                  
      	  if (tagListSet.getQnaidx().equals(tag.getQnaidx())){
             try{ 
            	 removeTaglist.add(tagListSet);
             }catch(Exception e){ 
         		log.debug("알수 없는 예외입니다.");
             }
      	  }
      	  		
        } 
        taglist.removeAll(removeTaglist); 
        // 연관 태그 set END ==>
        
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

		//Collections.reverse(valueList);
		
		return valueList;
	}
	
/*
	public ArrayList<String> getArticleList(Integer Idx) { 

        Set<Tag> s = new HashSet<Tag>();
        
        for(Iterator<Tag> it = set.iterator(); it.hasNext();) {
      	  		
        	Tag tag = (Tag)it.next();
                  
      	  if (tag.getQnaidx().equals(Idx))        
                 s.add(tag);
      	  		
        }
         
		
		ArrayList<Tag> data = new ArrayList<Tag>(s);
 
		 
        ArrayList<String> itemList = new ArrayList<String>();
     
        ArrayList<Integer> cntList = new ArrayList<Integer>();
        
        //1. 데이터 유형 및 개수를 설정한다.
        for(int index = 0 ; index < data.size() ; index++){
            //item이 등록되었는지 확인한다.
            //1.1 등록되지 않았을 때 처리
            if(!itemList.contains(data.get(index).getContents())){
                
                //1.1.1 item을 itemList에 추가한다.
                itemList.add(data.get(index).getContents());
                
                //1.1.2 item이 몇개 들어있는지 세어서 cntList에 추가한다.
                int cnt = 0;
                for(int searchIndex = index; searchIndex < data.size(); searchIndex++){
                    if(data.get(index) == data.get(searchIndex)){
                        cnt++;
                    }
                }
                cntList.add(cnt);
                
                //1.1.3 cnt를 비교하여 itemList와 cntList를 높은순으로 정렬한다.
                for(int sourceIndex = 0 ; sourceIndex < cntList.size()-1 ; sourceIndex++){
                    for(int targetIndex = sourceIndex+1 ; targetIndex < cntList.size() ; targetIndex++){
                        if(cntList.get(sourceIndex) < cntList.get(targetIndex)){
                            int moveItem = 0;
                            String strmoveItem = "";
                            
                            //cntList 위치 변경
                            moveItem = cntList.get(targetIndex);
                            cntList.set(targetIndex, cntList.get(sourceIndex));
                            cntList.set(sourceIndex, moveItem);
                            
                            //itemList 위치 변경
                            strmoveItem = itemList.get(targetIndex);
                            itemList.set(targetIndex, itemList.get(sourceIndex));
                            itemList.set(sourceIndex, strmoveItem);
                            
                        }
                    }
                }
                
            //1.2 등록되어 있을 경우 처리
            }else{
                continue;
            }            
            
        }//end 데이터 유형 및 개수를 설정
         
		return itemList;
	}

	public ArrayList<String> getList() { 

        Set<Tag> s = new HashSet<Tag>();
        
        for(Iterator<Tag> it = set.iterator(); it.hasNext();) {
      	  		
        	Tag tag = (Tag)it.next();
                         
                 s.add(tag);
      	  		
        }
         
		
		ArrayList<Tag> data = new ArrayList<Tag>(s);
 
		 
        ArrayList<String> itemList = new ArrayList<String>(); 
        ArrayList<Integer> cntList = new ArrayList<Integer>();
        
        //1. 데이터 유형 및 개수를 설정한다.
        for(int index = 0 ; index < data.size() ; index++){
            //item이 등록되었는지 확인한다.
            //1.1 등록되지 않았을 때 처리
            if(!itemList.contains(data.get(index).getContents())){
                
                //1.1.1 item을 itemList에 추가한다.
                itemList.add(data.get(index).getContents());
                
                //1.1.2 item이 몇개 들어있는지 세어서 cntList에 추가한다.
                int cnt = 0;
                for(int searchIndex = index; searchIndex < data.size(); searchIndex++){
                    if(data.get(index) == data.get(searchIndex)){
                        cnt++;
                    }
                }
                cntList.add(cnt);
                
                //1.1.3 cnt를 비교하여 itemList와 cntList를 높은순으로 정렬한다.
                for(int sourceIndex = 0 ; sourceIndex < cntList.size()-1 ; sourceIndex++){
                    for(int targetIndex = sourceIndex+1 ; targetIndex < cntList.size() ; targetIndex++){
                        if(cntList.get(sourceIndex) < cntList.get(targetIndex)){
                            int moveItem = 0;
                            String strmoveItem = "";
                            
                            //cntList 위치 변경
                            moveItem = cntList.get(targetIndex);
                            cntList.set(targetIndex, cntList.get(sourceIndex));
                            cntList.set(sourceIndex, moveItem);
                            
                            //itemList 위치 변경
                            strmoveItem = itemList.get(targetIndex);
                            itemList.set(targetIndex, itemList.get(sourceIndex)+""+cntList.get(targetIndex));
                            itemList.set(sourceIndex, strmoveItem);
                            
                        }
                    }
                }
                
            //1.2 등록되어 있을 경우 처리
            }else{
                continue;
            }            
            
        }//end 데이터 유형 및 개수를 설정
         
         
		return itemList;
		
	}
*/

 
}
