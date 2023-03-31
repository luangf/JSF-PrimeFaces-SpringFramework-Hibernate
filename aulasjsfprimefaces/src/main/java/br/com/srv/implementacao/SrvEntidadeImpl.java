package br.com.srv.implementacao;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.srv.interfaces.SrvEntidade;

@Service //pode ou não anotar com @Service, pq já ta na interface
public class SrvEntidadeImpl implements SrvEntidade {

	private static final long serialVersionUID = 1L;

	
	
	@Override
	public Date getUltimoAcessoEntidadeLogada(String name) {
		return null;
	}

	@Override
	public void updateUltimoAcessoUser(String login) {
		
	}

	@Override
	public boolean exiteUsuario(String ent_login) {
		return false;
	}

}
