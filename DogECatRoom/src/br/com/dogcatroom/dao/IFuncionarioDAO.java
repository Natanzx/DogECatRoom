package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.FuncionarioDTO;

public interface IFuncionarioDAO {
	
	void cadastrarFuncionario(FuncionarioDTO funcionarioDTO);
    void alterarFuncionario(FuncionarioDTO funcionarioDTO);
    List<FuncionarioDTO> buscarTodos();
}
