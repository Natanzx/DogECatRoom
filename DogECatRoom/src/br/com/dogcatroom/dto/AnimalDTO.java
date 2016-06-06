package br.com.dogcatroom.dto;

public class AnimalDTO {

	private int idAnimal;
	private int idCliente;
	private String nome;
	private String tipo;
	private String raca;
	private String cor;
	private String dataNasc;
	private String sexo;
	private int pedigre;
	private int numPedigre;
	private int ativo;
	
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getPedigre() {
		return pedigre;
	}
	public void setPedigre(int pedigre) {
		this.pedigre = pedigre;
	}
	public int getNumPedigre() {
		return numPedigre;
	}
	public void setNumPedigre(int numPedigre) {
		this.numPedigre = numPedigre;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	
	
}
