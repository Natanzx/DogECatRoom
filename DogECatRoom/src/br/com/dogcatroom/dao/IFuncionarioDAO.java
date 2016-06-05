package br.com.dogcatroom.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.dto.FuncionarioDTO;

public interface IFuncionarioDAO {
	
	void cadastrarFuncionario(FuncionarioDTO funcionarioDTO);
    void alterarFuncionario(FuncionarioDTO funcionarioDTO);
    List<FuncionarioDTO> buscarTodosFuncionariosAtivo();
    FuncionarioDTO buscarFuncionarioPorID(FuncionarioDTO funcionarioDTO) throws SQLException;
}
