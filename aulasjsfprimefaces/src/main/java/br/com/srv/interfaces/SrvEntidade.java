package br.com.srv.interfaces;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface SrvEntidade extends Serializable {

	Date getUltimoAcessoEntidadeLogada(String name);
	void updateUltimoAcessoUser(String login);
	boolean exiteUsuario(String ent_login);
	
}
