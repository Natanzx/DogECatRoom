package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IFuncionarioDAO;
import br.com.dogcatroom.dto.FuncionarioDTO;

public class FuncionarioDAO implements IFuncionarioDAO {

	private Connection con = ConnectionFactory.getConnection();

	@Override
	public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {

		String sql = "INSERT INTO funcionario (nome,cpf,endereco,numero,complemento,bairro,cidade,estado,celular,fixo,escolaridade,ocupacao,salario,ativo,matricula) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, funcionarioDTO.getNome());
			preparador.setString(2, funcionarioDTO.getCpf());
			preparador.setString(3, funcionarioDTO.getNumero());
			preparador.setString(4, funcionarioDTO.getComplemento());
			preparador.setString(5, funcionarioDTO.getBairro());
			preparador.setString(6, funcionarioDTO.getCidade());
			preparador.setString(7, funcionarioDTO.getTelCelular());
			preparador.setString(8, funcionarioDTO.getTelFixo());
			preparador.setString(9, funcionarioDTO.getEscolaridade());
			preparador.setString(10, funcionarioDTO.getOcupacao());
			preparador.setBoolean(12, funcionarioDTO.isAtivo());
			preparador.setInt(13, funcionarioDTO.getMatricula());

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Parabéns!!! Cadastrado com sucesso!");

	}

	@Override
	public void alterarFuncionario(FuncionarioDTO funcionarioDTO) {
		// TODO Auto-generated method stub
		
	}

}
