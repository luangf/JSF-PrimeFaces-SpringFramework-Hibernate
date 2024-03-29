package br.com.framework.implementacao.crud;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//propagation = Propagation.REQUIRED; se n existir transa��o ele cria
@Component //Spring, geracao de dependencia...
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class JdbcTemplateImpl extends JdbcTemplate implements Serializable{

	private static final long serialVersionUID = 1L;

	public JdbcTemplateImpl(DataSource dataSource) {
		super(dataSource);
	}
	
}
