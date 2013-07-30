package net.slipp.domain.user; 

import net.slipp.service.user.PasswordMismatchException;
 
public class Question {
	private Integer idx;
	private String userId; 
	private String title; 
	private String contents; 
	private String insertdate; 
	private String updatedate;
	private String tag;
	
	public Question() {
	}

	public Question(Integer idx, String userId, String title, String contents, String insert_date, String update_date, String tag) {
		this.idx = idx;
		this.userId = userId;
		this.title = title;
		this.contents = contents;
		this.insertdate = insert_date;
		this.updatedate = update_date;
		this.tag = tag;
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

	public String getInsertDate() {
		return insertdate;
	}

	public void setInsertDate(String insertdate) {
		this.insertdate = insertdate;
	} 

	public String getUpdateDate() {
		return updatedate;
	}

	public void setUpdateDate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	public boolean matchid(String loginId) {
		if (loginId == null) {
			return false;
		}
		
		return loginId.equals(userId);
	}
	
	public void update(Question updateQuestion) throws PasswordMismatchException {
		if (!matchid(updateQuestion.getUserId())) {
			throw new PasswordMismatchException();
		}

		this.idx = updateQuestion.idx;
		this.title = updateQuestion.title;
		this.contents = updateQuestion.contents;
		this.insertdate = updateQuestion.insertdate;
		this.updatedate = updateQuestion.updatedate;
		this.tag = updateQuestion.tag;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idx == null) ? 0 : idx.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((insertdate == null) ? 0 : insertdate.hashCode());
		result = prime * result + ((updatedate == null) ? 0 : updatedate.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		return "Question [userId=" + userId + ", title=" + title + ", contents=" + contents + ", idx=" + idx + "]";
	}
}
