package apresentacao;



import javax.swing.JOptionPane;

import cliente.Cliente;
import execoes.ClienteInvalidoException;
import execoes.ClienteJaCadastradoException;
import execoes.ContaInvalidaException;
import execoes.ContaJaCadastradaException;
import execoes.SaldoInsuficenteException;
import execoes.ValorInvalidoException;


public class Banco {
	
	public static void main(String[] args){
		// MVC PRADÃo 
		FachadadoBanco fachada = new FachadadoBanco();
		
		int opcao = 0;
		
		while(opcao != 14){
			try{
				
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1 -Cadastar Cliente.\n"
						+ "2 -Lista Cliente.\n"
						+ "3 - Atualizar Dados de Cliente.\n"
						+ "4 - Abrir Conta Corrente.\n"
						+ "5 - Abrir Conta Poupança.\n"
						+ "6 - Abrir Conta Bonificada. \n"
						+ "7 - Consultar Saldo.\n"
						+ "8 - Realizar Saque.\n"
						+ "9 - Realizar Deposito.\n"
						+ "10 - Realizar Transferencia.\n"
						+ "11 - Render Juros. \n"
						+ "12 - Render Bônus. \n"
						+ "13 - Encerrar Conta. \n"
						+ "14 - Finalizar Sistema. "));
				
				switch(opcao){
				
				case 1:
					JOptionPane.showConfirmDialog(null,"Para Cadastrar um clinte informe:\n"
							+ " CPF , NOME e DATA DE NASCIMENTO");
					String cpf = JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					String nome = JOptionPane.showInputDialog("Digite o Nome do Cliente.");
					String dataNasc = JOptionPane.showInputDialog("Digite a data de nascimento do Cliente");
					
					try {
						fachada.cadastrarCliente(cpf, nome, dataNasc);
						JOptionPane.showMessageDialog(null, "Cliente Cadastrado. ");
						
					}catch(ClienteJaCadastradoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
					
					break;
					
				case 2:
					
					fachada.listarCliente();
					
					break;
				case 3:
				
					JOptionPane.showMessageDialog(null, "Para alterar o cliente informe o cpf , novo nome e nova data nascimento.");
					String cpf3 = JOptionPane.showInputDialog("Digite o cpf do Cliente Que deseja Alterar.");
					String nome3 = JOptionPane.showInputDialog("Digite o novo nome.");
					String dataNasc3 = JOptionPane.showInputDialog("Digite a nova data de nascimento do cliente ");
						
					try {
						fachada.alterarCliente(cpf3, nome3, dataNasc3);
						JOptionPane.showConfirmDialog(null, "Cliente Alterado com Sucesso!!. ");
						
					}catch(ClienteInvalidoException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					
					break;
				case 4:
					
					JOptionPane.showMessageDialog(null, "Para Abri uma Conta Corrente Digite CPF do cliente e o valor de abertura da conta");
					String cpf4= JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					double valor =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor."));
					
					try {
						Cliente titular6  = fachada.consultaCliente(cpf4);
						
						fachada.inserirConta(titular6, valor);
					}catch(ClienteInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}catch(ValorInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "Para Abri uma Conta Poupança Digite CPF do cliente e o valor de abertura da conta");
					String cpf5= JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					double valor5 =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de abertura da conta."));
					
					try {
						Cliente titular6  = fachada.consultaCliente(cpf5);
						
						fachada.inserirContaPoupanca(titular6, valor5);
						
					}catch(ClienteInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}catch(ValorInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "Para Abri uma Conta Bonificada Digite CPF do cliente e o valor de abertura da conta");
					String cpf6= JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					double valor6 =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de abertura da conta."));
					
					
					try {
						Cliente titular6  = fachada.consultaCliente(cpf6);
						
						fachada.inserirContaBonificada(titular6, valor6);
					}catch(ClienteInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}catch(ValorInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				
				case 7:
					int numConta7 =Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta que deseja consulta o saldo."));
					
					try {
						fachada.consultaSaldoConta(numConta7);		
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					
					break;
				case 8:
					
					int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta ."));
					double valor8  =Double.parseDouble(JOptionPane.showInputDialog("Digite valor ."));
					
					try {
						fachada.realizarSaque(numConta,valor8);
						
					}catch(ContaInvalidaException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}catch(SaldoInsuficenteException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}catch(ValorInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 9:
					int numConta9 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta que deseja realizar o depositvo ."));
					double valor9  =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de deposito ."));
					
					try {
						fachada.realizarDeposito(numConta9,valor9);
						
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}catch(ValorInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 10:
					JOptionPane.showMessageDialog(null, "Para Realizar A transferencia Informe os numeros das contas de saque e deposito");
					int numConta10 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta de saque."));
					int numConta20 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta de deposito."));
					double valor10  =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da transferencia ."));
					try {
						fachada.realizarTransferencia(numConta10,numConta20,valor10);
						
					}catch(ContaInvalidaException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}catch(SaldoInsuficenteException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}catch(ValorInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 13:
					
					int numConta13 =Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta que deseja encerrar."));
					
					try {
						fachada.removerConta(numConta13);		
					}catch(ContaInvalidaException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					break;
					
				default:
					break;
				
				}
				
				
			} catch (Exception e){
			
				e.printStackTrace();
			}
		}
		
	}

}
