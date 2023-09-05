package view;

import model.Aluno;
import control.AlunoDAO;

public class Teste {

	public static void main(String[] args) {
		
		AlunoDAO aluno= new AlunoDAO();
		
		Aluno a;
		
		/*a = new Aluno("Allyson", 12 ,"Informatica","Parnaiba","Endereco", "Telefone");
		aluno.adicionar(a);
		
		a = new Aluno("Raul", 12 ,"Informatica","Araioses","Endereco", "Telefone");
		aluno.adicionar(a);
		
		System.out.println(aluno.consultar(1));*/
		
		System.out.println(aluno.consultar(2));
		
		System.out.println(aluno.listar());
		
		aluno.close();
		
		
	}

}
