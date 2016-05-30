package br.com.dogcatroom.dao;

import br.com.dogcatroom.dto.FuncionarioDTO;

public interface IFuncionarioDAO {
	
	void cadastrarFuncionario(FuncionarioDTO funcionarioDTO);
    void alterarFuncionario(FuncionarioDTO funcionarioDTO);
}
