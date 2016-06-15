package br.com.dogcatroom.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.dto.FuncionarioDTO;

public interface IFuncionarioDAO {
	
	public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO);
	public void alterarFuncionario(FuncionarioDTO funcionarioDTO);
    public List<FuncionarioDTO> buscarTodosFuncionariosAtivo();
    public FuncionarioDTO buscarFuncionarioPorID(FuncionarioDTO funcionarioDTO) throws SQLException;
    public FuncionarioDTO validaLogin(FuncionarioDTO func);
    public FuncionarioDTO recuperarSenha(FuncionarioDTO func);
}
