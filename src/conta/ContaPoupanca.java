package conta;

import cliente.Cliente;

public class ContaPoupanca extends Conta{
	public ContaPoupanca(Cliente titular,double valor){
		super(titular,valor);
	}
	
	public ContaPoupanca(){
		super();
	}
}
