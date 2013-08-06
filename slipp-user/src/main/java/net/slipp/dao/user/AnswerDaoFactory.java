package net.slipp.dao.user;

public class AnswerDaoFactory {
	public static AnswerDao create()
	{
		return new MemoryAnswerDao();
	}
}
