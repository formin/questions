package net.slipp.dao.tag;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import net.slipp.domain.tag.Tag;

public interface TagDao {

	void add(Tag tag) throws SQLException;
	void del(Tag tag) throws SQLException;
	ArrayList<Tag> getTagByIdx(Integer Idx) throws SQLException;
	ArrayList<Tag> getArticleList(Integer Idx) throws SQLException; 
	ArrayList<Tag> getTagList() throws SQLException;
}
