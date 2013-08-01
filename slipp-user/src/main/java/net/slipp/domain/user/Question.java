package net.slipp.domain.user; 
 
import net.slipp.service.user.PasswordMismatchException;
 
public class Question {
	private Integer idx;
	private String userId; 
	private String title; 
	private String contents; 
	private String insertdates; 
	private String updatedates;
	private String tag;
	
	public Question() { 
	}

	public Question(Integer idx, String userId, String title, String contents, String insertdates, String updatedates, String tag) {
		this.idx = idx;
		this.userId = userId;
		this.title = title;
		this.contents = contents;
		this.insertdates = insertdates;
		this.updatedates = updatedates;
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
	
	public void update(Question updateQuestion) throws PasswordMismatchException {
		if (!matchid(updateQuestion.getUserId())) {
			throw new PasswordMismatchException();
		}
 
		this.title = updateQuestion.title;
		this.contents = updateQuestion.contents; 
		this.updatedates = updateQuestion.updatedates; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 41;
		int result = 1;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((updatedates == null) ? 0 : updatedates.hashCode());
		result = prime * result + ((insertdates == null) ? 0 : insertdates.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		return "Question [userId=" + userId + ", insertdates=" + insertdates + ", updatedates=" + updatedates + ", title=" + title + ", contents=" + contents + ", idx=" + idx + "]";
	}
}
