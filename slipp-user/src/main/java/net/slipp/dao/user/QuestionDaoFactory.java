package net.slipp.dao.user;

public class QuestionDaoFactory {
	public static QuestionDao create()
	{
		return new MemoryQuestionDao();
	}
}
