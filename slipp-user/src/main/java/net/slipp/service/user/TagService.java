package net.slipp.service.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
 
import net.slipp.dao.user.TagDao; 
import net.slipp.domain.user.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TagService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Resource(name="memoryTagDao")
	private TagDao tagDao;

	public void setTagDao(TagDao TagDao){
		this.tagDao = TagDao;
	}

	@PostConstruct
	public void initialize() {
		log.debug("TagService initialize");
	}
	
	@PreDestroy
	public void destroy() {
		log.debug("TagService destroy");
	}	

	public HashSet<?> view(int idx) throws SQLException, PasswordMismatchException {
		  
		return (HashSet<?>) tagDao.getTagByIdx(idx);
	}

	public ArrayList<String> getArticleList(int idx) throws SQLException {
 
		return tagDao.getArticleList(idx);
	}

	public ArrayList<Tag> getList() throws SQLException {
 
		return tagDao.getList();
	}

	public HashSet<?> getTagList() throws SQLException {
 
		return (HashSet<?>) tagDao.getTagList();
	}
}
