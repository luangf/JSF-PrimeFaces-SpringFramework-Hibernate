package br.com.project.geral.controller;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped /*Apenas uma inst�ncia na mem�ria*/
public interface SessionController extends Serializable {

	//HttpSession: pegar a sess�o do user
	void addSession(String keyLoginUser, HttpSession httpSession);
	
	void invalidateSession(String keyLoginUser);
	
}