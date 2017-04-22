package conta;

import cliente.Cliente;

public class Conta {
	static int contador=1000;
	public double saldo;
	public Cliente titular;
	private int numConta;
	
	public Conta(Cliente titular,double valor) {
		this.saldo =valor;
		this.titular = titular;
		this.numConta = Conta.contador++;
	}
	
	public Conta(int numConta1){
		this.numConta= numConta1;
	}
	
	public Conta(){
		
	}
	
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Conta.contador = contador;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	

}
