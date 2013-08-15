package net.slipp.service.tag;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import net.slipp.dao.tag.TagDao;
import net.slipp.domain.tag.Tag;
import net.slipp.service.user.PasswordMismatchException;
import net.slipp.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional 
public class TagService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Resource(name="tagDao")
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

	public ArrayList<Tag> view(int idx) throws SQLException, PasswordMismatchException {
		  
		return tagDao.getTagByIdx(idx);
	}

	public ArrayList<Tag> getArticleList(int idx) throws SQLException {
 
		return tagDao.getArticleList(idx);
	}
 
	public ArrayList<Tag> getTagList() throws SQLException {
 
		return tagDao.getTagList();
	}
}
