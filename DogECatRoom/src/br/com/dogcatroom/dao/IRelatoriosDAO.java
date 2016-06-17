package br.com.dogcatroom.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dogcatroom.dto.RelatoriosDTO;

public interface IRelatoriosDAO {

	public void RelatorioQuantitativoClientes(RelatoriosDTO rel);
	public void RelatorioQuantitativoServicos(RelatoriosDTO rel);
	public void RelatorioQuantitativoFuncionarios(RelatoriosDTO rel);
	public void RelatorioQuantitativoAtendimentos(RelatoriosDTO rel);
	public void RelatorioAtendimentosPorHorario(RelatoriosDTO rel);
}
