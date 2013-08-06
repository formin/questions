package net.slipp.dao.user;

public class UserDaoFactory {
	public static UserDao create()
	{
		return new MemoryUserDao();
	}

}
