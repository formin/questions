package net.slipp.domain.user;

public class Tag {

	private Integer idx;		// 	게시물번호.
	private Integer qnaidx;		// 	게시물번호.
	private String userId; 		//	사용자아이디. 
	private String contents; 	//	본문.
	private String insertdates; //	입력날짜.
	private Integer count;		//	태그카운트.
	
	public Tag() { 
	}

	public Tag(Integer idx, Integer qnaidx, String userId, String contents, String insertdates, Integer count) {
		this.idx = idx;
		this.qnaidx = qnaidx;
		this.userId = userId; 
		this.contents = contents;
		this.insertdates = insertdates; 
		this.count = count;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
 
	@Override
	public String toString() {
		return "Tag [userId=" + userId + ", insertdates=" + insertdates + ", contents=" + contents + ", count=" + count + ", qnaidx=" + qnaidx + ", idx=" + idx + "]";
	}
	
}
