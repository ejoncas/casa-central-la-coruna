package uade.server.modules;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.SolDist;

@Stateless
public class SolDistAdministratorBean implements SolDistAdministrator {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<CentroDistribucion> obtenerCentrosDeDistribucion() {
		Query query = em.createQuery("SELECT a FROM CentroDistribucion a");
		return (List<CentroDistribucion>) query.getResultList();
	}

	public void nuevoCentroDeDistribucion(CentroDistribucion cd) {
		em.persist(cd);
	}

	@SuppressWarnings("unchecked")
	public List<SolDist> generarSolicitudDistribucion() {
		List<SolDist> solicitudes = new ArrayList<SolDist>();
		List<CentroDistribucion> centros = obtenerCentrosDeDistribucion();
		for (CentroDistribucion cd : centros) {
			SolDist sd = new SolDist();
			final String query = "SELECT p FROM Pedido p WHERE p.centroDeDistribucion.id=? AND p.procesado=?";
			Query q = em.createQuery(query)
					.setParameter(1, cd.getId())
					.setParameter(2, Boolean.FALSE);
			sd.setCentroDistribucion(cd);
			sd.setPedidosAEntregar(q.getResultList());
			if (sd.getPedidosAEntregar().size() > 0) {// Si tiene articulos por entregar
				solicitudes.add(sd);
				em.persist(sd);
			}
			em.createQuery(
							"UPDATE Pedido p set p.procesado=? WHERE p.centroDeDistribucion.id=?")
					.setParameter(1, Boolean.TRUE).setParameter(2, cd.getId())
					.executeUpdate();
		}
		return solicitudes;
	}

	public SolDist obtenerSolicitudDistribucion(Long idSoldist) {
		return em.find(SolDist.class, idSoldist);
	}

}
