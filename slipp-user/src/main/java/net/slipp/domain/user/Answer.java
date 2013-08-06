package net.slipp.domain.user;
 

public class Answer {

	private Integer idx;		// 	게시물번호.
	private Integer qnaidx;		// 	게시물번호.
	private String userId; 		//	사용자아이디. 
	private String contents; 	//	본문.
	private String insertdates; //	입력날짜.
	
	public Answer() { 
	}

	public Answer(Integer idx, Integer qnaidx, String userId, String contents, String insertdates) {
		this.idx = idx;
		this.qnaidx = qnaidx;
		this.userId = userId; 
		this.contents = contents;
		this.insertdates = insertdates; 
	}
 

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Integer getQnaidx() {
		return qnaidx;
	}

	public void setQnaidx(Integer qnaidx) {
		this.qnaidx = qnaidx;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public void answerTo(Question question) {
		//this.question = question;
		//question.newAnswered(this);
	}
	
	public boolean matchid(String loginId) {
		if (loginId == null) {
			return false;
		}
		
		return loginId.equals(userId);
	}
 
	@Override
	public String toString() {
		return "Answer [userId=" + userId + ", insertdates=" + insertdates + ", contents=" + contents + ", idx=" + idx + "]";
	}
}
