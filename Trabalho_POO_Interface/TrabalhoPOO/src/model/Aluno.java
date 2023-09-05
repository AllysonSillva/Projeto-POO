package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery (name="alunos.consultar", query="select a from Aluno a where matricula=:matricula"),
	@NamedQuery (name="alunos.listar", query="select nome from Aluno")
})
public class Aluno {
	
	@Id
	@GeneratedValue
	@Column (name="matricula")
	private long matricula;
	@Column (name="nome")
	private String nome;
	@Column (name="idade")
	private int idade;
	@Column (name="curso")
	private String curso;
	@Column (name="cidade")
	private String cidade;
	@Column (name="endereco")
	private String endereco;
	@Column (name="telefone")
	private String telefone;
	
	public Aluno() {
		super();
	}

	public Aluno(long matricula, String nome, int idade, String curso,
			String cidade, String endereco, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.idade = idade;
		this.curso = curso;
		this.cidade = cidade;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Aluno(String nome, int idade, String curso,
			String cidade, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.curso = curso;
		this.cidade = cidade;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString() {
		return " " + nome + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (matricula ^ (matricula >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	

}
