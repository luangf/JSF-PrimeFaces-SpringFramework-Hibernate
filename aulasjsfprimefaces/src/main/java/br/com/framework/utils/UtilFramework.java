package br.com.framework.utils;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UtilFramework implements Serializable{

	private static final long serialVersionUID = 1L;

	//usuario q ta agr, id user Long
	private static ThreadLocal<Long> threadLocal=new ThreadLocal<Long>();
	
	//pra n haver concorrencia
	//dois lugares no sistema n pode acessar no msm tempo
	public synchronized static ThreadLocal<Long> getThreadLocal(){
		return threadLocal;
	}
	
}
