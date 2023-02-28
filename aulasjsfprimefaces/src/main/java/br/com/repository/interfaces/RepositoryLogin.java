package br.com.repository.interfaces;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository //Spring framework
public interface RepositoryLogin extends Serializable {

	boolean autentico(String login, String senha) throws Exception;
	
}
