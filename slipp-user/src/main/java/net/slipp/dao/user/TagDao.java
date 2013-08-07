package net.slipp.dao.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import net.slipp.domain.user.Tag;

public interface TagDao {

	void add(Tag tag) throws SQLException;
	void del(Tag tag) throws SQLException;
	Set<Tag> getTagByIdx(Integer Idx) throws SQLException;
	ArrayList<String> getArticleList(Integer Idx) throws SQLException;
	ArrayList<Tag> getList() throws SQLException;
	Set<Tag> getTagList() throws SQLException;
}
