package br.com.framework.implementacao.crud;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component // do Spring, essa classe tem relação com a geração de dependência
//do Spring, required, se n existir transação ele cria, da rollback para exception
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SimpleJdbcInsertImpl extends SimpleJdbcInsert implements Serializable {

	private static final long serialVersionUID = 1L;

	public SimpleJdbcInsertImpl(DataSource dataSource) {
		super(dataSource);
	}

}