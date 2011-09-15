package uade.server.modules;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uade.server.beans.Articulo;
import uade.server.beans.ItemPedido;
import uade.server.beans.Oferta;
import uade.server.beans.Pedido;
import uade.server.beans.Tienda;

@Stateless
public class OfadAdministratorBean implements OfadAdministrator{
	
	@PersistenceContext 
    private EntityManager em;
	
	
	private static float DESC_1_PEDIDO = .1f;
	private static float DESC_2_PEDIDO = .1f;
	private static float NO_DISCOUNT = 0.0f;
	
	public OfadAdministratorBean(){
	}

	/**
	 * Descripci�n: consiste en la generaci�n del listado de art�culos que pueden ser 
	 * solicitados por las tiendas. Ese listado se genera con una frecuencia semanal.
	 *  
	 * Entrada: este servicio es activado y cargado directamente por el operador 
	 * (a trav�s de la interfaz gr�fica).
	 * 
	 * L�gica/Restricciones: 
	 * El sistema debe proponer un listado tentativo de los art�culos a incluir en la OfAD, 
	 * a trav�s de mostrarlos en la pantalla al operador y permitir que �ste seleccione cuales 
	 * son los art�culos que desea incluir en la OfAD. Este listado tentativo deber�a incluir:
	 * -Los art�culos que fueron solicitados por al menos 2 tiendas en las �ltimas 2 semanas
	 * -Los art�culos nuevos, que no fueron incluidos en alguna OfAD previa
	 * -A partir de este listado tentativo, el operador deber�a seleccionar cuales art�culos son los que desea incluir en la OfAD.-El operador tambi�n podr� incluir en la OfAD otros art�culos, que no est�n incluidos en el listado tentativo (con s�lo ingresar su id).
	 * -Se debe mantener el registro de la OfAD, y todos los art�culos incluidos en ella (y los precios de oferta en los casos que corresponda)
	 * 
	 * Salida: el sistema debe generar:
	 * -un listado por pantalla de todos los art�culos que componen la OfAD
	 * -un archivo de texto (con formato XML) con la informaci�n contenida en la OfAD.
	 */
	public Oferta obtenerOfad() {
		Oferta o = new Oferta();
		{
			o.setArticulos(obtenerArticulosOfad());
			o.setFechaOferta(new Date());			
		}
		em.persist(o);//sets the ID's
		return o;
	}

	/**
	 * TODO - Falta agregar los productos que estan en su mes de descuento y mostrar el
	 * % de descuento por pantalla
	 * @return
	 */
	private Set<Articulo> obtenerArticulosOfad() {
		Set<Articulo> articulos = new HashSet<Articulo>();
		//-Los art�culos que fueron solicitados por al menos 2 tiendas en las �ltimas 2 semanas
		articulos.addAll(obtenerArticulosPedidosPor2TiendasUltimas2Semanas());
		//Los art�culos nuevos, que no fueron incluidos en alguna OfAD previa
		articulos.addAll(obtenerArticulosNoIncluidosEnOfadsPrevias());
		
		//Aplicar descuentos
		for(Articulo a : articulos){
			a.setDescuento(getDescuentoParaArticulo(a));
		}
		
		return articulos;
	}

	@SuppressWarnings("unchecked")
	private List<Articulo> obtenerArticulosNoIncluidosEnOfadsPrevias() {
		List<Articulo> articulosEnOfad = em.createQuery("SELECT art FROM Articulo art WHERE art.referencia NOT IN (" +
				" SELECT a.referencia FROM Oferta o INNER JOIN o.articulos as a ) ").getResultList();
		return articulosEnOfad;
	}

	@SuppressWarnings("unchecked")
	private Float getDescuentoParaArticulo(Articulo a) {
		if (isEnMesDeRebaja(a)) {// si esta en mes de rebaja

			Calendar calendar = GregorianCalendar.getInstance();
			calendar.add(Calendar.DATE, -15);
			//-Los art�culos que fueron solicitados por al menos 2 tiendas en las �ltimas 2 semanas
			List<Articulo> articulos = em.createQuery(
					"SELECT ip.articulo FROM Pedido p "
							+ "INNER JOIN p.items as ip "
							+ "WHERE p.fechaPedido > :hace2Semanas " +
									"GROUP BY p.tienda " +
									"HAVING COUNT(p.tienda) > 2")
					.setParameter("hace2Semanas", calendar.getTime())
					.getResultList();
			if (articulos != null) {
				Integer cantidadDePedidos = articulos.size();
				if (cantidadDePedidos == 0)
					return DESC_2_PEDIDO;
				else if (cantidadDePedidos >= 1)
					return DESC_1_PEDIDO;
			}
		}
		return NO_DISCOUNT;

	}

	private boolean isEnMesDeRebaja(Articulo art) {
		if (art != null && art.getMesRebaja() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM");
			Integer mesRebaja = Integer
					.parseInt(sdf.format(art.getMesRebaja()));
			Integer mesActual = Integer.parseInt(sdf.format(new Date()));
			return mesActual == mesRebaja;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private List<Articulo> obtenerArticulosPedidosPor2TiendasUltimas2Semanas() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.add(Calendar.DATE, -15);
		List<Pedido> pedidos = em.createQuery("SELECT p FROM Pedido p " +
				"WHERE p.fechaPedido > :hace2Semanas "+
				"GROUP BY p.tienda " +
				"HAVING COUNT(p.tienda) > 2")
								.setParameter("hace2Semanas", calendar.getTime()).getResultList();
		List<Articulo> articulos = new ArrayList<Articulo>();
		for(Pedido p: pedidos){
			for(ItemPedido ip : p.getItems()){
				articulos.add(ip.getArticulo());
			}
		}
		return articulos;
	}

	public Articulo obtenerArticulo(Long ref) {
		return em.find(Articulo.class, ref);
	}

	public void actualizarOferta(Oferta oferta) {
		Oferta persistedEntity = em.find(Oferta.class, oferta.getId());
		persistedEntity.setArticulos(oferta.getArticulos());
		em.persist(persistedEntity);
	}

	public Articulo agregarOfad(Oferta ofer, Articulo art) {
		Oferta persistedOffer = em.find(Oferta.class, ofer.getId());
		Articulo persistedArt = em.find(Articulo.class, art.getReferencia());
		persistedOffer.addArticulo(persistedArt);
		em.persist(persistedOffer);
		return persistedArt;
	}

	public Articulo eliminarArtOfad(Oferta ofer, Articulo art) {
		Oferta persistedOffer = em.find(Oferta.class, ofer.getId());
		Articulo artToRemove = em.find(Articulo.class, art.getReferencia());
		persistedOffer.addArticulo(artToRemove);
		if(persistedOffer.getArticulos()!=null){
			persistedOffer.getArticulos().remove(artToRemove);
		}
		em.persist(persistedOffer);
		return artToRemove;
	}

	public void eliminarOfad(Oferta o) {
		Oferta oferta = em.find(Oferta.class, o.getId());
		em.remove(oferta);
	}

	@SuppressWarnings("unchecked")
	public List<Tienda> obtenerTiendas() {
		List<Tienda> tiendas = em.createQuery("SELECT t FROM Tienda t").getResultList();
		return tiendas;
	}
	
}
