package br.com.project.util.all;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Messages extends FacesContext implements Serializable {

	private static final long serialVersionUID = 1L;

	public Messages() {
	}
	
	public static void responseOperation(StatusPersistencia statusPersistencia) {
		if(statusPersistencia != null && statusPersistencia.equals(StatusPersistencia.SUCESSO)){
			sucesso();
		}else if(statusPersistencia != null && statusPersistencia.equals(StatusPersistencia.OBJETO_REFERENCIADO)){
			msgServerityFatal(StatusPersistencia.OBJETO_REFERENCIADO.toString());
		}else {
			erroNaOperacao();
		}
	}
	
	//msg generica
	public static void msg(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(msg)); //por padrão INFO
		}
	}
	 
	public static void sucesso() {
		msgServerityInfo(Constante.SUCESSO);
	}
	
	public static void erroNaOperacao() {
		if(facesContextValido()) {
			msgServerityFatal(Constante.ERRO_NA_OPERACAO);
		}
	}

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	private static boolean facesContextValido() {
		return getFacesContext() != null;
	}
	
	public static void msgServerityInfo(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		}
	}
	
	public static void msgServerityWarn(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
		}
	}
	
	public static void msgServerityError(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
	
	//tem ainda no primefaces?
	public static void msgServerityFatal(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
		}
	}
	
}
