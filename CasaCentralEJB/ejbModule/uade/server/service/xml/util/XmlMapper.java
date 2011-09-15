package uade.server.service.xml.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uade.server.beans.Articulo;
import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;
import uade.server.beans.ItemPedido;
import uade.server.beans.Oferta;
import uade.server.beans.Pedido;
import uade.server.beans.SolDist;
import uade.server.beans.dto.ArticuloHogarOfadDTO;
import uade.server.beans.dto.ArticuloRopaOfadDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.EnvioDTO;
import uade.server.beans.dto.ItemPedidoDTO;
import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.SolDistDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.mapper.DTOMapper;
import uade.server.beans.dto.xml.ItemPedidoXml2DTO;
import uade.server.beans.dto.xml.Ofad;
import uade.server.beans.dto.xml.Soldist;

public class XmlMapper {

	private XmlMapper() { }
	
	public static Soldist mapSolDistXml(SolDistDTO sd) {
		Soldist xml = new Soldist();
		xml.setNumSolDist(sd.getId());
		List<EnvioDTO> envios = new ArrayList<EnvioDTO>();
		for(PedidoDTO p : sd.getPedidosAEntregar()){
			EnvioDTO e = new EnvioDTO();
			e.setIdTienda(p.getTienda().getId());
			List<ItemPedidoXml2DTO> items = new ArrayList<ItemPedidoXml2DTO>();
			for(ItemPedidoDTO ipDto : p.getItems()){
				ItemPedidoXml2DTO itemDto = new ItemPedidoXml2DTO();
				itemDto.setRef(ipDto.getArticulo().getReferencia().toString());
				itemDto.setCant(ipDto.getCantidad());
				items.add(itemDto);
			}
			e.setPedidos(items);
			envios.add(e);
		}
		xml.setEnvios(envios);
		return xml;
	}
	
	public static SolDistDTO mapearDto(SolDist sd) {
		SolDistDTO dto = new SolDistDTO();
		
		dto.setCentroDistribucion(
				(CentroDistribucionDTO) DTOMapper.map(sd.getCentroDistribucion(), 
						CentroDistribucionDTO.class));
		
		dto.setId(sd.getId());
		List<PedidoDTO> pedidosDto = new ArrayList<PedidoDTO>();
		for(Pedido pa : sd.getPedidosAEntregar()){
			PedidoDTO pdto = new PedidoDTO();
			pdto.setCentroDeDistribucion((CentroDistribucionDTO) DTOMapper.map(pa.getCentroDeDistribucion(), 
					CentroDistribucionDTO.class));
			pdto.setFechaPedido(pa.getFechaPedido());
			pdto.setProcesado(pa.getProcesado());
			pdto.setTienda((TiendaDTO) DTOMapper.map(pa.getTienda(), TiendaDTO.class));
			List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
			for(ItemPedido ip: pa.getItems()){
				items.add(ip.getDTO());
			}
			pdto.setItems(items);
			pedidosDto.add(pdto);
		}
		dto.setPedidosAEntregar(pedidosDto);
		return dto;
	}
	
	public static Ofad mapearOfertasToDto(Oferta ofertas) {
		Ofad ofad =  new Ofad();
		
		Set<ArticuloRopaOfadDTO> ropa = new HashSet<ArticuloRopaOfadDTO>();
		Set<ArticuloHogarOfadDTO> hogar = new HashSet<ArticuloHogarOfadDTO>();
		for(Articulo a : ofertas.getArticulos()){
			if(a instanceof ArticuloHogar)
				hogar.add((ArticuloHogarOfadDTO) a.getOfadDTO());
			else if (a instanceof ArticuloRopa)
				ropa.add((ArticuloRopaOfadDTO) a.getOfadDTO());
		}
		
		ofad.setAccesoriosHogar(hogar);
		ofad.setRopa(ropa);
		ofad.setId(ofertas.getId());
		return ofad;
	}

	public static List<SolDistDTO> mapearDto(List<SolDist> solicitudes) {
		List<SolDistDTO> r = new ArrayList<SolDistDTO>();
		for(SolDist sd : solicitudes){
			SolDistDTO dto = XmlMapper.mapearDto(sd);
			r.add(dto);
		}
		return r;
	}
	
}
