package net.slipp.service.tag;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Calendar;
 
import net.slipp.dao.tag.TagDao; 
import net.slipp.domain.tag.Tag; 

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {

	private TagService tagService;
	
	@Mock private TagDao tagDao;
	
	@Before
	public void setup() {
		tagService = new TagService();
		tagService.setTagDao(tagDao);
	}
	
	@Test
	public void 정상적으로_태그를등록한다() throws Exception {

		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)); 
        
        Tag tag = new Tag();

		tag.setQnaidx(1);
		tag.setInsertdates(today);
		tag.setUserId("formin");
		tag.setContents("test");
		
		Tag insertedTag = tagService.add(tag);
        verify(tagDao).add(tag);
        assertThat(insertedTag, is(tag));
		 
	}
}
