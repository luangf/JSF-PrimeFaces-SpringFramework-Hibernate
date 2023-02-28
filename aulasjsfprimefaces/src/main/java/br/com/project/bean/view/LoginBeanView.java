package br.com.project.bean.view;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.project.bean.geral.BeanManagedViewAbstract;

@Controller
@Scope(value = "request")
@ManagedBean(name = "loginBeanView") // faces.bean
public class LoginBeanView extends BeanManagedViewAbstract {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public void invalidar(ActionEvent actionEvent) {
		RequestContext context=RequestContext.getCurrentInstance();
		context.addCallbackParam("msgRetorno", "teste");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
