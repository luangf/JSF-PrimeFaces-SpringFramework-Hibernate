package br.com.framework.implementacao.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.framework.interfac.crud.InterfaceCrud;

@Component
@Transactional // classe de transação com o BD
public class ImplementacaoCrud<T> implements InterfaceCrud<T> {

	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Autowired
	private JdbcTemplateImpl jdbcTemplate;

	@Autowired // pro spring injetar dependencia
	private SimpleJdbcTemplateImpl simpleJdbcTemplate;

	@Autowired // do spring, para injetar dependência
	private SimpleJdbcInsertImpl simpleJdbcInsert;

	@Autowired
	private SimpleJdbcClassImpl simpleJdbcClassImpl;

	public SimpleJdbcClassImpl getSimpleJdbcClassImpl() {
		return simpleJdbcClassImpl;
	}

	@Override
	public void save(T obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().save(obj);
		executeFlushSession();
	}

	@Override
	// basicamente nenhuma dif, so por didatica, de dois nomes para salvar, save e
	// persist
	public void persist(T obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().persist(obj);
		executeFlushSession();
	}

	@Override
	public void saveOrUpdate(T obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		executeFlushSession();
	}

	@Override
	public void update(T obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().update(obj);
		executeFlushSession();
	}

	@Override
	public void delete(T obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().delete(obj);
		executeFlushSession();
	}

	@Override
	public T merge(T obj) throws Exception {
		validaSessionFactory();
		obj = (T) sessionFactory.getCurrentSession().merge(obj);
		executeFlushSession();
		return obj;
	}

	@Override
	public List<T> findList(Class<T> entidade) throws Exception {
		validaSessionFactory();
		StringBuilder query = new StringBuilder();
		query.append(" select distinct(entity) from ").append(entidade.getSimpleName()).append(" entity ");
		List<T> lista = sessionFactory.getCurrentSession().createQuery(query.toString()).list();
		return null;
	}

	@Override
	public Object findById(Class<T> entidade, Long id) throws Exception {
		validaSessionFactory();
		Object obj = sessionFactory.getCurrentSession().load(getClass(), id);
		return obj;
	}

	@Override
	public T findPorId(Class<T> entidade, Long id) throws Exception {
		validaSessionFactory();
		T obj = (T) sessionFactory.getCurrentSession().load(getClass(), id);
		return obj;
	}

	@Override
	public List<T> findListByQueryDinamica(String hql) throws Exception {
		validaSessionFactory();
		List<T> lista = new ArrayList<T>();
		lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		return lista;
	}

	@Override
	public List<?> findListBySQLDinamica(String sql) throws Exception {
		validaSessionFactory();
		List<?> lista = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return lista;
	}

	public List<Object[]> getListSQLDinamicaArray(String sql) throws Exception {
		validaSessionFactory();
		List<Object[]> lista = (List<Object[]>) sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return lista;
	}

	@Override
	public void executeUpdateQueryDinamica(String hql) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		executeFlushSession();
	}

	@Override
	public void executeUpdateSQLDinamica(String sql) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
		executeFlushSession();
	}

	@Override
	public void clearSession() throws Exception {
		sessionFactory.getCurrentSession().clear();
	}

	@Override
	public void evict(Object obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().evict(obj);
	}

	@Override
	public Session getSession() throws Exception {
		validaSessionFactory();
		return sessionFactory.getCurrentSession();
	}

	@Override
	public JdbcTemplate getJdbcTemplate() throws Exception {
		return jdbcTemplate;
	}

	@Override
	public SimpleJdbcTemplate getSimpleJdbcTemplate() throws Exception {
		return simpleJdbcTemplate;
	}

	@Override
	public SimpleJdbcInsert getSimpleJdbcInsert() throws Exception {
		return simpleJdbcInsert;
	}

	@Override
	public Long totalRegistros(String table) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(1) from ").append(table);
		return jdbcTemplate.queryForLong(sql.toString());
	}

	@Override
	public Query obterQuery(String query) throws Exception {
		validaSessionFactory();
		Query queryReturn = sessionFactory.getCurrentSession().createQuery(query.toString());
		return queryReturn;
	}

	@Override
	public List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception {
		validaSessionFactory();
		List<T> lista = new ArrayList<T>();
		lista = sessionFactory.getCurrentSession().createQuery(query).setFirstResult(iniciaNoRegistro)
				.setMaxResults(maximoResultado).list();
		return lista;
	}

	private void validaSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		validarTransaction();
	}

	private void validarTransaction() {
		if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
			sessionFactory.getCurrentSession().beginTransaction();
		}
	}

	private void commitProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().commit();
	}

	private void rollbackProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().rollback();
	}

	/**
	 * Roda instantaneamente o SQL no banco de dados
	 */
	private void executeFlushSession() {
		sessionFactory.getCurrentSession().flush();
	}

}
