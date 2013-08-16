package net.slipp.dao.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.slipp.domain.user.User; 
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
 
	
	@Mock private UserDao userDao;
	 
	
	@Test
	public void crud() throws Exception {
		User expected = new User("userId", "password", "name", "javajigi@email.com"); 
		userDao.insert(expected);

		User actual = userDao.findByUserId(expected.getUserId());
		assertThat(actual, is(expected));
	}

}
