package net.slipp.dao.user;

import java.sql.SQLException;

import net.slipp.domain.user.Question;

public interface QuestionDao {

	void insert(Question question) throws SQLException;
}
