package br.com.dogcatroom.bo;

import java.sql.ResultSet;

import br.com.dogcatroom.dao.IRelatoriosDAO;
import br.com.dogcatroom.dao.implementacao.RelatoriosDAO;
import br.com.dogcatroom.dto.RelatoriosDTO;

public class RelatoriosBO {

	RelatoriosDAO relatoriosDAO = new RelatoriosDAO();
	IRelatoriosDAO iRelatoriosDAO = relatoriosDAO;
	
	public void RelatorioQuantitativoClientes(RelatoriosDTO rel){
		iRelatoriosDAO.RelatorioQuantitativoClientes(rel);
	}
	
	public void RelatorioQuantitativoServicos(RelatoriosDTO rel){
		iRelatoriosDAO.RelatorioQuantitativoServicos(rel);
	}
	
	public void RelatorioQuantitativoFuncionarios(RelatoriosDTO rel){
		iRelatoriosDAO.RelatorioQuantitativoFuncionarios(rel);
	}
	
	public void RelatorioQuantitativoAtendimentos(RelatoriosDTO rel){
		iRelatoriosDAO.RelatorioQuantitativoAtendimentos(rel);
	}
	
	public void RelatorioAtendimentosPorHorario(RelatoriosDTO rel){
		iRelatoriosDAO.RelatorioAtendimentosPorHorario(rel);
	}
}
