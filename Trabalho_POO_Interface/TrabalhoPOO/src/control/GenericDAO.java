package control;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<Entidade> {
	
	public void adicionar(Entidade e);
	public void deletar(Entidade e);
	public void atualizar(Entidade e);
	public Entidade consultar(long mat);
	public List<Entidade> listar();

}
