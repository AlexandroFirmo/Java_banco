package repositorio;

import java.util.ArrayList;

import cliente.Cliente;
import conta.Conta;

public class RepositorioConta {
	
	ArrayList<Conta> contas = new ArrayList<Conta>();
	public void inserirConta(Conta conta){
		contas.add(conta);
	}
	
	public String imprimir(){
		String lista= "";
		for(Conta c:contas){
			Cliente cliente = c.getTitular();
			lista+= "nome: "+cliente.getNome()+"\nSaldo: "+c.saldo+"\nNumero da conta: "+c.getNumConta(); 
		}
		return lista;
	}
	
	public boolean existir(int num){ 
		
		for(Conta c: contas){
			if(c.getNumConta()==num){
				return true;
			}
		}
		return false;
	}
	
	public double consultaSaldo(int num){
		double saldo =0;
		for(Conta c: contas){
			if(c.getNumConta()==num){
				saldo = c.getSaldo();
			}
		}
		return saldo;
	}
	
	public Conta consultaConta(int numConta){
		
		for(Conta c : contas){
			if(c.getNumConta()==numConta){
				return c;
			}
		}
		
		return null;
	}
	public boolean remover(int numConta){
		
		for(Conta c : contas){
			if(c.getNumConta()==numConta){
				contas.remove(c);
				return true;
			}
		}
		
		return false;
	}
	

}
