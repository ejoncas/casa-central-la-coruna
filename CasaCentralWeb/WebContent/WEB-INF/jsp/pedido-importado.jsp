<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="uade.server.beans.dto.xml.Palc"%>
<%@page import="uade.server.beans.dto.xml.ItemPedidoXmlDTO"%>
<%@page import="uade.server.beans.dto.PedidoDTO"%>
<%@page import="uade.server.beans.dto.ItemPedidoDTO"%>
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
<%
	Palc palc = (Palc)request.getAttribute("pedido");
	PedidoDTO dto = (PedidoDTO) request.getAttribute("dto");
%>
<h2>Pedido Importado. Tienda: <%= dto.getTienda().getNombre()%></h2>

<h3>Centro de Distribucion Asociado: <%= dto.getCentroDeDistribucion().getNombre()%></h3>

<table  class="center">
<thead>
	<tr>
		<th>Referencia</th>
		<th>Articulo</th>
		<th>Cantida Pedida</th>
		<th>Precio Total</th>
	</tr>
</thead>
<tbody>
	<%
		for(ItemPedidoDTO p : dto.getItems()){
	%>
			 <tr>
			 	<td><%=p.getArticulo().getReferencia() %></td><td><%=p.getArticulo().getDescripcion()%></td><td><%=p.getCantidad()%></td><td><%=(p.getPrecioVenta() * p.getCantidad()) %></td>
			 </tr>
	<%
		} 
	%>
</tbody>
</table>
<br/>		
</div>
</div>
</body>
</html>