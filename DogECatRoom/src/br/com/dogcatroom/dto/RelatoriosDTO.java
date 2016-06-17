package br.com.dogcatroom.dto;

import java.util.ArrayList;

public class RelatoriosDTO {
	
	public ClienteDTO cliente;
	public ServicoDTO servico;
	public AtendimentoDTO atendimento;
	public FuncionarioDTO funcionario;
	public AnimalDTO animal;
	public Integer countClientes;
	public Integer countServicos;
	public Integer countFuncionarios;
	public Integer countAnimais;
	public Integer countAtendimentos;
	public ArrayList<String> HoraAtendimento;
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public ServicoDTO getServico() {
		return servico;
	}
	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}
	public AtendimentoDTO getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(AtendimentoDTO atendimento) {
		this.atendimento = atendimento;
	}
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}
	public AnimalDTO getAnimal() {
		return animal;
	}
	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}
	public Integer getCountClientes() {
		return countClientes;
	}
	public void setCountClientes(Integer countClientes) {
		this.countClientes = countClientes;
	}
	public Integer getCountServicos() {
		return countServicos;
	}
	public void setCountServicos(Integer countServicos) {
		this.countServicos = countServicos;
	}
	public Integer getCountFuncionarios() {
		return countFuncionarios;
	}
	public void setCountFuncionarios(Integer countFuncionarios) {
		this.countFuncionarios = countFuncionarios;
	}
	public Integer getCountAnimais() {
		return countAnimais;
	}
	public void setCountAnimais(Integer countAnimais) {
		this.countAnimais = countAnimais;
	}
	public Integer getCountAtendimentos() {
		return countAtendimentos;
	}
	public void setCountAtendimentos(Integer countAtendimentos) {
		this.countAtendimentos = countAtendimentos;
	}
	/*
	public String getHoraAtendimento() {
		return HoraAtendimento;
	}
	public void setHoraAtendimento(String horaAtendimento) {
		HoraAtendimento = horaAtendimento;
	}
	*/
	
	
}
