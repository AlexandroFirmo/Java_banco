package cliente;

public class Cliente {
	//mvc modelo de visão controle;
	String cpf;
	String nome;
	String dataNasc;
	
	public Cliente(String cpf, String nome, String dataNasc){
		this.cpf= cpf;
		this.nome = nome;
		this.dataNasc= dataNasc;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	

}
