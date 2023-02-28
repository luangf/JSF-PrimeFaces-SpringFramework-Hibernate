package br.com.srv.interfaces;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service //Spring
public interface SrvLogin extends Serializable{

	boolean autentico(String login, String senha) throws Exception;
	
}
