package net.slipp.dao.tag;

import java.sql.SQLException;
import java.util.ArrayList; 

import net.slipp.domain.tag.Tag;

public interface TagDao {

	public Tag add(Tag tag) throws SQLException;
	void del(Tag tag) throws SQLException;
	ArrayList<Tag> getTagByIdx(Integer Idx) throws SQLException;
	ArrayList<Tag> getArticleList(Integer Idx) throws SQLException; 
	ArrayList<Tag> getTagList() throws SQLException;
}
