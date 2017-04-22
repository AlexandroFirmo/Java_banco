package apresentacao;

import javax.swing.JOptionPane;

import cliente.Cliente;
import conta.Conta;
import conta.ContaBonificada;
import conta.ContaPoupanca;
import execoes.ClienteInvalidoException;
import execoes.ClienteJaCadastradoException;
import execoes.ContaInvalidaException;
import execoes.SaldoInsuficenteException;
import execoes.ValorInvalidoException;
import repositorio.RepositorioCliente;
import repositorio.RepositorioConta;

public class FachadadoBanco {
	
	RepositorioCliente repCliente;
	RepositorioConta repConta;
	Cliente cliente;
	Conta conta,conta2, contaPoupanca,contaBonificada;
	
	public FachadadoBanco(){
		repCliente = new RepositorioCliente ();
		repConta = new RepositorioConta();
	}
	
	public void cadastrarCliente(String cpf,String nome, String dataNasc) throws ClienteJaCadastradoException{
		
		if(repCliente.existeCliente(cpf)){
			cliente = new Cliente( cpf,nome,dataNasc);
			repCliente.cadastrarClinte(cliente);
			
		}else{
			//instanceof
			
			throw new ClienteJaCadastradoException();
		}
	
	
	}
	
	public void listarCliente(){
		String listaCliente = repCliente.imprimir();
		JOptionPane.showConfirmDialog(null, listaCliente);
	}
	
	public void alterarCliente(String cpf,String nome, String dataNasc) throws ClienteInvalidoException{
		if(!repCliente.existeCliente(cpf)){
			repCliente.alterarClinete(cpf, nome, dataNasc);
			
		}else{
			throw new ClienteInvalidoException();
		}
	}
	
	
	public void inserirConta(Cliente titular,double valor) throws ClienteInvalidoException, ValorInvalidoException {
		
		if(!repCliente.existeCliente(titular.getCpf())){
			if(valor>0.0){
				conta = new Conta(titular,valor);
				repConta.inserirConta(conta);
				String saldo = String.format("%.2f", repConta.consultaSaldo(conta.getNumConta()));
				JOptionPane.showMessageDialog(null,"Conta Criada com sucesso Sr(sra): "+conta.getTitular().getNome()+"\nsaldo: "+saldo+"\nConta Corrente Numero: "+conta.getNumConta());
			}else{
				throw new ValorInvalidoException();
			}
			
		}else{
			throw new  ClienteInvalidoException();
		}
	
		
	}
	
	public Cliente consultaCliente(String cpf){
		Cliente cliente = repCliente.consultaCliente(cpf);
		return cliente;
	}
	
	public void inserirContaPoupanca(Cliente titular,double valor) throws ClienteInvalidoException, ValorInvalidoException {
		
		if(!repCliente.existeCliente(titular.getCpf())){
			if(valor>=100.0){
				contaPoupanca = new ContaPoupanca(titular,valor);
				repConta.inserirConta(contaPoupanca);
				String saldo = String.format("%.2f", repConta.consultaSaldo(contaPoupanca.getNumConta()));
				JOptionPane.showMessageDialog(null,"Conta Criada com sucesso Sr(sra): "+contaPoupanca.getTitular().getNome()+"\nsaldo: "+saldo+"\nConta Poupança Numero: "+contaPoupanca.getNumConta());

			}else{
				throw new ValorInvalidoException();
			}
			
		}else{
			throw new  ClienteInvalidoException();
		}
	
		
	}
	
	public void inserirContaBonificada(Cliente titular,double valor) throws ClienteInvalidoException, ValorInvalidoException {
		if(!repCliente.existeCliente(titular.getCpf())){
			if(valor>=5.0){
				contaBonificada = new ContaBonificada(titular,valor);
				repConta.inserirConta(contaBonificada);	
				
				//formatando o valor para duas casas decimais
				String saldo = String.format("%.2f", repConta.consultaSaldo(contaBonificada.getNumConta()));
				JOptionPane.showMessageDialog(null,"Conta Criada com sucesso Sr(sra): "+contaBonificada.getTitular().getNome()+"\nsaldo: "+saldo+"\nConta Bonificada Numero: "+contaBonificada.getNumConta());

			}else{
				throw new ValorInvalidoException();
			}
			
		}else{
			throw new  ClienteInvalidoException();
		}
	
	
	}
	
	public void consultaSaldoConta(int numConta) throws ContaInvalidaException{
		if(repConta.existir(numConta)){
			String saldo = String.format("%.2f", repConta.consultaSaldo(numConta));
			JOptionPane.showMessageDialog(null,"Contata Numero: "+numConta+"\nSaldo: "+saldo);
		}else{
			throw new  ContaInvalidaException();
		}
	}
	
	public void realizarSaque(int numConta,double valor)throws ContaInvalidaException, SaldoInsuficenteException, ValorInvalidoException{
		if(repConta.existir(numConta)){
			if(valor>0){
				if(valor<repConta.consultaSaldo(numConta)){
					conta =repConta.consultaConta(numConta);
					conta.setSaldo(conta.getSaldo()-valor);
					
					if(conta.equals(contaBonificada)){
						conta.setSaldo(conta.getSaldo()+((valor*0.02)/100));
						
					}
					
					JOptionPane.showMessageDialog(null,"Saque Realizado com Sucesso!!");
				}else{
					throw new SaldoInsuficenteException();
				}
			}else{
				throw new ValorInvalidoException();

			}
		}else{
			throw new  ContaInvalidaException();
		}
	}
	public void realizarDeposito(int numConta,double valor) throws ContaInvalidaException, ValorInvalidoException{
		if(repConta.existir(numConta)){
			if(valor>0){
				
				conta = repConta.consultaConta(numConta);
				conta.setSaldo(conta.getSaldo()+valor);
				
				if(conta.equals(contaPoupanca)){
					conta.setSaldo(conta.getSaldo()+((valor*0.5)/100));
					
				}
	
				JOptionPane.showMessageDialog(null,"Deposito Realizado Com Sucesso!!");
			}else{
				throw new ValorInvalidoException();
			}
			
		}else{
			throw new  ContaInvalidaException();
		}
	}
	
	public void realizarTransferencia(int numConta,int numConta2,double valor)throws ContaInvalidaException,SaldoInsuficenteException,ValorInvalidoException {
		if(repConta.existir(numConta) && repConta.existir(numConta2)){
			conta = repConta.consultaConta(numConta);
			conta2 = repConta.consultaConta(numConta2);
			if(valor>0){
				if(valor<conta.getSaldo()){
					conta.setSaldo(conta.getSaldo()-valor);
					conta2.setSaldo(conta2.getSaldo()+valor);
					
					if(conta2.equals(contaBonificada)){
						conta.setSaldo(conta.getSaldo()+((valor*0.02)/100));
						
					}
	
					JOptionPane.showMessageDialog(null,"Transferencia Realizada Com Sucesso!!");
				}else{
					throw new SaldoInsuficenteException ();
				}
			}else{
				throw new ValorInvalidoException();
			}
		}else{
			throw new  ContaInvalidaException();
		}
	}
	
	public void removerConta(int numConta)throws ContaInvalidaException {
		if(repConta.existir(numConta)){
			repConta.remover(numConta);
			JOptionPane.showMessageDialog(null,"Conta Removida Com Sucesso!!");
			
		}else{
			throw new  ContaInvalidaException();
		}
	}
	
	
	
	

}
