package net.slipp.domain.user; 

import net.slipp.service.user.PasswordMismatchException;
 
public class Question {
	private String userId; 
	private String title; 
	private String memo; 
	private String date; 
	private String tag;
	
	public Question() {
	}

	public Question(String userId, String title, String memo, String date, String tag) {
		this.userId = userId;
		this.title = title;
		this.memo = memo;
		this.date = date;
		this.tag = tag;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
		
		this.title = updateQuestion.title;
		this.memo = updateQuestion.memo;
		this.date = updateQuestion.date;
		this.tag = updateQuestion.tag;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		} else if (!title.equals(other.title))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", title=" + title + ", memo=" + memo + ", tag=" + tag + "]";
	}
}
