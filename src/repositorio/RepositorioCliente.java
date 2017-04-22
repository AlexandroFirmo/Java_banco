package repositorio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import cliente.Cliente;

public class RepositorioCliente {
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void cadastrarClinte(Cliente cliente){
		clientes.add(cliente);
	}
	
	public boolean existeCliente(String cpf){
		boolean f = true;
		
		for (Cliente c: clientes){
			if(cpf.equals(c.getCpf())){
				f = false;
				return f;
			}
		}
		return f;
	}
	
	public String imprimir(){
		String listaCliente = "Clientes\n----------------\n";
		for(Cliente c:clientes){
			listaCliente+="nome: "+c.getNome()+"\nCPF: "+c.getCpf()
			+"\nData Nascimento: "+c.getDataNasc()+"\n--------------------\n";
	
		}
		return listaCliente;
	}
	
	public void alterarClinete(String cpf,String nome, String dataNasc){
		for(Cliente c:clientes){
			if(cpf.equals(c.getCpf())){
				c.setNome(nome);
				c.setDataNasc(dataNasc);
			}
		}
		
	}
	public Cliente retornaCliente(String cpf){
		
		for (Cliente c: clientes){
			if(cpf.equals(c.getCpf())){
				return c;
			}
		}
		return null;
	}
	
	public Cliente consultaCliente(String cpf){
		
		for(Cliente c : clientes){
			if(cpf.equals(c.getCpf())){
				return c;
			}
		}
		
		return null;
	}
	
	
}
