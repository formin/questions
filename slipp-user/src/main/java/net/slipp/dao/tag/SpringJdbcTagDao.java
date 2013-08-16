package net.slipp.dao.tag;

import java.sql.SQLException;
import java.util.ArrayList; 

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
 
import net.slipp.domain.tag.Tag;
import net.slipp.support.AbstractDaoSupport;

@Repository("tagDao")
public class SpringJdbcTagDao extends AbstractDaoSupport implements TagDao {


	@Override
	public Tag add(Tag tag) throws SQLException{
		String sql = "INSERT INTO TAG VALUES (?, ?, ?, ?, ?, ?)"; 
		getJdbcTemplate().update(sql, null, tag.getQnaidx(), 1, tag.getUserId(), tag.getContents(), tag.getInsertdates());
		
		return tag;
	};
	

	@Override
	public void del(Tag tag) throws SQLException{ 
		String sql = "DELETE FROM TAG WHERE qnaidx = ?";
		getJdbcTemplate().update(sql, tag.getQnaidx());
	};
	

	@Override
	public ArrayList<Tag> getTagByIdx(Integer Idx) throws SQLException{

		String sql = "SELECT idx, qnaidx, userId, contents, insertdates, count FROM TAG WHERE qnaidx='"+Idx+"'";

		ArrayList<Tag> tags  = (ArrayList<Tag>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Tag>(Tag.class));
	 
		return tags;
	};
	
	@Override
	public ArrayList<Tag> getArticleList(Integer Idx) throws SQLException{

		String sql = "SELECT idx, qnaidx, userId, contents, insertdates, count FROM TAG WHERE qnaidx='"+Idx+"'";

		ArrayList<Tag> tags  = (ArrayList<Tag>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Tag>(Tag.class));
	 
		return tags;
		
	};
	 

	// 첫 페이지에서 태그카운트 리스트.
	@Override
	public ArrayList<Tag> getTagList() throws SQLException{

		String sql = "SELECT CONTENTS, COUNT(CONTENTS) as count FROM TAG GROUP BY CONTENTS ORDER BY COUNT(CONTENTS) DESC";

		ArrayList<Tag> answer  = (ArrayList<Tag>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Tag>(Tag.class));
	 
		return answer;
	};
	
}
