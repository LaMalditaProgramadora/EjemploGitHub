package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IColaboradorDao;
import pe.edu.upc.entity.Colaborador;

public class ColaboradorDaoImpl implements Serializable, IColaboradorDao {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	public void insert(Colaborador c) {
		try {
			em.persist(c);

		} catch (Exception e) {
			System.out.println("Error al insertar colaborador");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> list() {
		List<Colaborador> lista = new ArrayList<Colaborador>();
		try {
			Query q = em.createQuery("from Colaborador c");
			lista = (List<Colaborador>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar colaborador");
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> findByNameColaborador(Colaborador c) {
		List<Colaborador> lista = new ArrayList<Colaborador>();
		try {
			Query q = em.createQuery("from Colaborador c where c.nombreCompleto like ?1");
			q.setParameter(1, "%" + c.getNombreCompleto() + "%");
			lista = (List<Colaborador>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar colaborador");
		}
		return lista;
	}

}
