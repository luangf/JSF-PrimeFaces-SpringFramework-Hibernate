package br.com.repository.interfaces;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional //anota q fará as operações com o DB, CRUD, parte mais próxima do DB
@Repository
public interface RepositoryEntidade extends Serializable {

	Date getUltimoAcessoEntidadeLogada(String name);
	void updateUltimoAcessoUser(String login);
	boolean exiteUsuario(String ent_login);
	
}
