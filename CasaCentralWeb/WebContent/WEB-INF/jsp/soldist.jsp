<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="uade.server.beans.dto.xml.Palc"%>
<%@page import="uade.server.beans.dto.ItemPedidoDTO"%>
<%@page import="java.util.List"%>
<%@page import="uade.server.beans.dto.SolDistDTO"%>
<%@page import="uade.server.beans.dto.PedidoDTO"%>
<html>
<head>
<title>Zara</title>
<LINK REL=StyleSheet HREF="styles/style.css" TYPE="text/css" MEDIA=screen/>
<LINK REL=StyleSheet HREF="css/base/ui.css" TYPE="text/css"/>
<script language="javascript" src="js/jq.js"></script>
<script language="javascript" src="js/ui.js"></script>
<script language="javascript" src="js/util.js"></script>
<!-- JS INITIALIZATION CODE -->
<script language="javascript">

	$(document).ready(function (){
		$("input:button").button();
		$("input:submit").button();
	});
</script>
</head>
<body>
<!-- DIV MAIN CONTENT -->
<div class="main">
	<div class="header center">
		<img alt="zara logo" src="img/logo.png">
		<div class="header-menu center">
							<ul id="menu"> 
				<li><a href="ofad" title="OFAD">Preparar Oferta</a></li> 
				<li><a href="pedido" title="PALC">Ingresar Pedido</a></li> 
				<li><a href="solicitud" title="SOLDIST">Solicitud de Distribuci&oacute;n</a></li> 
				<li><a href="articulos" title="NUEVOART">Administrar Articulos</a></li> 
			</ul>  
		</div>
	</div>
	<div class="content center">
	
		<!-- Content goes here -->
		<h2>Generar Solicitud de Distribucion</h2>
		<form action="solicitud" method="post">	
			<input type="submit" value="Generar Solicitudes para Todos los CDs"/>
		</form>
		
		<%
			if(request.getAttribute("solicitudes")!=null){
				%>
				<br/>
				<br/>
				<h3>Solicitud de Distribucion Generada</h3>
				<%
				List<SolDistDTO> solicitudes =  (List<SolDistDTO>)request.getAttribute("solicitudes");
				for(SolDistDTO sd : solicitudes){
		%>
				<br/>
				<table class="center" style="width: 80%;">
					<thead>
						<tr>
							<th colspan="100">Centro de Distribucion: <%=sd.getCentroDistribucion().getNombre() %></th>
						</tr>
					</thead>
					<tbody>
						<%
							for(PedidoDTO p : sd.getPedidosAEntregar()){
						%>
						<tr>
							<td>Tienda: <%=p.getTienda().getNombre() %></td>
							<td>
							<table class="detalle-pedido">
								<%
									for(ItemPedidoDTO ip : p.getItems()){
								%>							
									<tr>
										<td><%=ip.getArticulo().getReferencia()+" - "+ip.getArticulo().getDescripcion() %></td>
										<td><%=ip.getCantidad()%></td>
									</tr>
								<%
									}
								%>	
							</table>
							</td>
						</tr>
						<%
							} 
						%>
					</tbody>
				</table>			
		
		<%
			%>
				<a href="download-xml?id=<%=sd.getId()%>" class="center">Bajar XML</a>	
				<br/>			
			<%
				}
			}
		%>
		
		<br/>
		<br/>
		<br/>
	</div>
</div>
</body>
</html>