package net.slipp.support;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

public abstract class AbstractDaoSupport extends JdbcDaoSupport {
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initialize() {
		setDataSource(dataSource);
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("user.sql"));
		populator.addScript(new ClassPathResource("question.sql"));
		populator.addScript(new ClassPathResource("answer.sql"));
		populator.addScript(new ClassPathResource("tag.sql"));
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
}
