package br.com.project.report.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Component;

import br.com.project.util.all.BeanViewAbstract;

@Component
public abstract class BeanReportView extends BeanViewAbstract {

	private static final long serialVersionUID = 1L;

	// StreamedContent;primefaces,responsavel retorno arquivo pronto pra web
	// protected: apenas quem extender dessa classe podera tem acesso
	protected StreamedContent arquivoReport;
	protected int tipoRelatorio;
	protected List<?> listDataBeanCollectionReport;
	protected HashMap<Object, Object> parametrosRelatorio;
	protected String nomeRelatorioJasper = "default";
	protected String nomeRelatorioSaida = "default";

	@Resource // ou autowired do spring pra injeção de dependencia
	private ReportUtil reportUtil;

	@SuppressWarnings("rawtypes")
	public BeanReportView() {
		parametrosRelatorio = new HashMap<Object, Object>();
		listDataBeanCollectionReport = new ArrayList();
	}

	// set e get para injecao de dependencia *
	public ReportUtil getReportUtil() {
		return reportUtil;
	}

	public void setReportUtil(ReportUtil reportUtil) {
		this.reportUtil = reportUtil;
	}

	public StreamedContent getArquivoReport() throws Exception {
		return getReportUtil().geraRelatorio(getListDataBeanCollectionReport(), getParametrosRelatorio(),
				getNomeRelatorioJasper(), getNomeRelatorioSaida(), getTipoRelatorio());
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public List<?> getListDataBeanCollectionReport() {
		return listDataBeanCollectionReport;
	}

	public void setListDataBeanCollectionReport(List<?> listDataBeanCollectionReport) {
		this.listDataBeanCollectionReport = listDataBeanCollectionReport;
	}

	public HashMap<Object, Object> getParametrosRelatorio() {
		return parametrosRelatorio;
	}

	public void setParametrosRelatorio(HashMap<Object, Object> parametrosRelatorio) {
		this.parametrosRelatorio = parametrosRelatorio;
	}

	public String getNomeRelatorioJasper() {
		return nomeRelatorioJasper;
	}

	public void setNomeRelatorioJasper(String nomeRelatorioJasper) {
		if (nomeRelatorioJasper == null || nomeRelatorioJasper.isEmpty()) {
			nomeRelatorioJasper = "default";
		}
		this.nomeRelatorioJasper = nomeRelatorioJasper;
	}

	public String getNomeRelatorioSaida() {
		return nomeRelatorioSaida;
	}

	public void setNomeRelatorioSaida(String nomeRelatorioSaida) {
		if (nomeRelatorioSaida == null || nomeRelatorioSaida.isEmpty()) {
			nomeRelatorioSaida = "default";
		}
		this.nomeRelatorioSaida = nomeRelatorioSaida;
	}

}
