package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Colaborador;

public interface IColaboradorService {
	public void insert(Colaborador colaborador);

	public List<Colaborador> list();
	
	public List<Colaborador> findByNameColaborador(Colaborador c);
}
