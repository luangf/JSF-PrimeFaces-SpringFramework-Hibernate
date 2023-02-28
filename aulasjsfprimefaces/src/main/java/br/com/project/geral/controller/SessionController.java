package br.com.project.geral.controller;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped /*Apenas uma instância na memória*/
public interface SessionController extends Serializable {

	//HttpSession: pegar a sessão do user
	void addSession(String keyLoginUser, HttpSession httpSession);
	
	void invalidateSession(String keyLoginUser);
	
}