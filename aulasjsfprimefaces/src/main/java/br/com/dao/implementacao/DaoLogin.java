package br.com.dao.implementacao;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.repository.interfaces.RepositoryLogin;

@Repository //n é obrigatorio pq ja ta na interface, porem, pra ficar mais explicito botei
public class DaoLogin extends ImplementacaoCrud<Object> implements RepositoryLogin {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean autentico(String login, String senha) throws Exception {
		String sql="select count(1) as autentica from entidade where ent_login=? and ent_senha=? ";
		SqlRowSet sqlRowSet=super.getJdbcTemplate().queryForRowSet(sql, new Object[]{login, senha}); //JDBC do Spring
		return sqlRowSet.next() ? sqlRowSet.getInt("autentica") > 0 : false;
	}

}
