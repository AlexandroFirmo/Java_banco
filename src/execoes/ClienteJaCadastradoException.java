package execoes;

public class ClienteJaCadastradoException extends Exception{
	
	public ClienteJaCadastradoException(){
		super("Cliente já Cadastrado!!");
	}
}
