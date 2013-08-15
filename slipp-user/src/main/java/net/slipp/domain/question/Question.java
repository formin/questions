package net.slipp.domain.question; 

import net.slipp.service.user.PasswordMismatchException;
  
 
/*
 * @class Question
 * @brief QnA 게시물클래스.
 */
public class Question {
	
	private Integer idx;		// 	게시물번호.
	private String userId; 		//	사용자아이디.
	private String title; 		//	제목.
	private String contents; 	//	본문.
	private String insertdates; //	입력날짜.
	private String updatedates; //	수정날짜.
	private String plaintags;	//	tag
	 
	public Question() { 
		
	}

	public Question(Integer idx, String userId, String title, String contents, String insertdates, String updatedates, String plainTags) {
		this.idx = idx;
		this.userId = userId;
		this.title = title;
		this.contents = contents;
		this.insertdates = insertdates;
		this.updatedates = updatedates; 
		this.plaintags = plainTags;
	}
 

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlaintags() {
		return plaintags;
	}

	public void setPlaintags(String plainTags) {
		this.plaintags = plainTags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getInsertdates() {
		return insertdates;
	}

	public void setInsertdates(String insertdates) {
		this.insertdates = insertdates;
	} 

	public String getUpdatedates() {
		return updatedates;
	}

	public void setUpdatedates(String updatedates) {
		this.updatedates = updatedates;
	}
	
	public boolean matchid(String loginId) {
		if (loginId == null) {
			return false;
		}
		
		return loginId.equals(userId);
	}

	/*
	 * QnA 게시물업데이트.
	 *
	 * @param updateQuestion : 업데이트 될 게시물 내용.
	 */
	public void update(Question updateQuestion) throws PasswordMismatchException {
		if (!matchid(updateQuestion.getUserId())) {
			throw new PasswordMismatchException();
		}
 
		this.title = updateQuestion.title;
		this.contents = updateQuestion.contents; 
		this.updatedates = updateQuestion.updatedates; 
		this.plaintags = updateQuestion.plaintags;
	}
 
    
	@Override
	public int hashCode() {
		final int prime = 41;
		int result = 1;  
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((plaintags == null) ? 0 : plaintags.hashCode());
		result = prime * result + ((idx == null) ? 0 : idx.hashCode());
		return result;
	} 
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Question other = (Question) obj;
		
		if (title == null) {
			if (other.title != null)
				return false;
		} 

		if (contents == null) {
			if (other.contents != null)
				return false;
		} 

		return true;
	}

	@Override
	public String toString() {
		return "Question [userId=" + userId + ", insertdates=" + insertdates + ", updatedates=" + updatedates + ", title=" + title + ", contents=" + contents + ", plaintags=" + plaintags + ", idx=" + idx + "]";
	}
}
