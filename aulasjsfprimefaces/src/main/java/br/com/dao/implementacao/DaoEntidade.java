package br.com.dao.implementacao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Entidade;
import br.com.repository.interfaces.RepositoryEntidade;

@Repository
public class DaoEntidade extends ImplementacaoCrud<Entidade> implements RepositoryEntidade {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositoryEntidade repositoryEntidade;
	
	@Override
	public Date getUltimoAcessoEntidadeLogada(String name) {
		return null;
	}

	@Override
	public void updateUltimoAcessoUser(String login) {
		repositoryEntidade.updateUltimoAcessoUser(login);
	}

	@Override
	public boolean exiteUsuario(String ent_login) {
		return repositoryEntidade.exiteUsuario(ent_login);
	}

}
