package conta;

import cliente.Cliente;

public class ContaBonificada extends Conta {
	public ContaBonificada(Cliente titular,double valor){
		super(titular,valor);
	}
	
	public ContaBonificada(){
		super();
	}
}
