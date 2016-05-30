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

		String sql = "INSERT INTO funcionario (nome,cpf,matricula,endereco,numero,complemento,bairro,cidade,estado,telcelular,telfixo,escolaridade,ocupacao,salario,ativo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, funcionarioDTO.getNome());
			preparador.setString(2, funcionarioDTO.getCpf());
			preparador.setInt(3, funcionarioDTO.getMatricula());
			preparador.setString(4, funcionarioDTO.getEndereco());
			preparador.setString(5, funcionarioDTO.getNumero());
			preparador.setString(6, funcionarioDTO.getComplemento());
			preparador.setString(7, funcionarioDTO.getBairro());
			preparador.setString(8, funcionarioDTO.getCidade());
			preparador.setString(9, funcionarioDTO.getEstado());
			preparador.setString(10, funcionarioDTO.getTelCelular());
			preparador.setString(11, funcionarioDTO.getTelFixo());
			preparador.setString(12, funcionarioDTO.getEscolaridade());
			preparador.setString(13, funcionarioDTO.getOcupacao());
			preparador.setDouble(14, funcionarioDTO.getSalario());
			preparador.setBoolean(15, funcionarioDTO.isAtivo());

			preparador.execute();
			preparador.close();
			System.out.println("Parabéns!!! Cadastrado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterarFuncionario(FuncionarioDTO funcionarioDTO) {
		// TODO Auto-generated method stub

	}

}
