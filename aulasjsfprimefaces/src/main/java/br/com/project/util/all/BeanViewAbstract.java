package br.com.project.util.all;

//abstract; n pode instanciar, principal nesse caso: obriga que as outras classes implementem
public abstract class BeanViewAbstract implements ActionViewPadrao {

	@Override
	public void limparLista() throws Exception {

	}

	@Override
	public String save() throws Exception {
		return null;
	}

	@Override
	public void saveNotReturn() throws Exception {

	}

	@Override
	public void saveEdit() throws Exception {

	}

	@Override
	public void excluir() throws Exception {

	}

	@Override
	public String ativar() throws Exception {
		return null;
	}

	@Override
	public String novo() throws Exception {
		return null;
	}

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public void setarVariaveisNulas() throws Exception {

	}

	@Override
	public void consultarEntidade() throws Exception {

	}

	@Override
	public void statusOperation(StatusPersistencia a) throws Exception {
		Messages.responseOperation(a);
	}

	//so quem sobreescrever tera acesso *
	protected void sucesso() throws Exception {
		statusOperation(StatusPersistencia.SUCESSO);
	}
	
	protected void error() throws Exception {
		statusOperation(StatusPersistencia.ERRO);
	}
	
	@Override
	public String redirecionarNewEntidade() throws Exception {
		return null;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {
		return null;
	}

	@Override
	public void addMsg(String msg) throws Exception {
		Messages.msg(msg);
	}

}
