package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/*CRUD, ai Serializable, modificação/mecher BD
extends q é uma interface já, ai extends de outra*/
@Component
@Transactional
//<T> dizendo para interface q vamos trabalhar com objetos genericos, entende os T dos param
public interface InterfaceCrud<T> extends Serializable{ 
	
	//<>(chaves)
	//na impl os methods sao public por padrao
	//throws possivel em interface. Exception padrão..
	//permitindo a gente escolher a msg pro user...
	//botar esses Exception padrão de precaução de erros
	void save(T obj) throws Exception; //T->Classe genérica
	
	void persist(T obj) throws Exception;
	
	//se já tiver um obj igual, atualiza
	void saveOrUpdate(T obj) throws Exception;
	
	void update(T obj) throws Exception;
	
	void delete(T obj) throws Exception;
	
	//salva/atualiza o obj e retorna o obj
	T merge(T obj) throws Exception;
	
	//lista de determinada classe
	List<T> findList(Class<T> obj) throws Exception; //Class<T> comando classe generica
	
	Object findById(Class<T> entidade, Long id) throws Exception; //entidade/tabela/ex.:Pessoa/pessoa(bd)
	
	T findPorId(Class<T> entidade, Long id) throws Exception;
	
	//lista customizada pela query dinamica
	List<T> findListByQueryDinamica(String hql) throws Exception; //param: sql/hql
	
	List<?> findListBySQLDinamica(String sql) throws Exception;
	
	//atualizar dados especificos com HQL
	void executeUpdateQueryDinamica(String hql) throws Exception;
	
	//atualizar dados especificos com SQL
	void executeUpdateSQLDinamica(String sql) throws Exception;
	
	//limpa a sessão do Hibernate, util por exemplo quando tem mt coisa em cache
	void clearSession() throws Exception;
	
	//retira um objeto da sessão do hibernate.As vezes um objeto ta em diferentes
	//transações ou ta na memória, podendo ocasionar problemas de persistencia
	void evict(Object obj) throws Exception;
	
	Session getSession() throws Exception;
	
	//função do Spring, junto com o Hibernate, parte de JDBC do Spring, parece hibernate, mas é com JDBC, com mais performance
	//3 metodos para isso, pra ter bastantao de funcoes/possibilidades
	//em suma pra trabalhar com JDBC no Spring
	JdbcTemplate getJdbcTemplate() throws Exception;
	
	SimpleJdbcTemplate getSimpleJdbcTemplate() throws Exception;
	
	SimpleJdbcInsert getSimpleJdbcInsert() throws Exception;
	
	Long totalRegistros(String table) throws Exception;

	Query obterQuery(String query) throws Exception;
	
	//Carregamento dinâmico com JSF e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
	
}