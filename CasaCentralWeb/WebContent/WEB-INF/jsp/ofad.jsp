<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="uade.server.beans.dto.ArticuloDTO"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Zara</title>
<LINK REL=StyleSheet HREF="styles/style.css" TYPE="text/css"
	MEDIA=screen />
<LINK REL=StyleSheet HREF="css/base/ui.css" TYPE="text/css" />
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
<div class="header center"><img alt="zara logo" src="img/logo.png">
<div class="header-menu center">
<ul id="menu">
	<li><a href="ofad" title="OFAD">Preparar Oferta</a></li>
	<li><a href="pedido" title="PALC">Ingresar Pedido</a></li>
	<li><a href="solicitud" title="SOLDIST">Solicitud de
	Distribuci&oacute;n</a></li>
	<li><a href="articulos" title="NUEVOART">Administrar Articulos</a></li>
</ul>
</div>
</div>
<div class="content center"><!-- Content goes here -->
<h2>OFAD Para Tienda: Uruguay</h2>
<h3>Oferta de Articulos recomendada</h3>

<table id="listado-artículos" class="admin-table center">
	<tr>
		<th>Articulo</th>
		<th>Tipo</th>
		<th>Cantidad</th>
		<th>Eliminar</th>
	</tr>
	<tr>
		<td>1234567891234</td>
		<td>Ropa</td>
		<td>2</td>
		<td><img src="img/del.png" /></td>
	</tr>

	<tr>
		<td>1234567891235</td>
		<td>Hogar</td>
		<td>4</td>
		<td><img src="img/del.png" /></td>
	</tr>
	<tr>
		<td colspan="100" class="center"><input type="button"
			value="Generar!" /></td>
	</tr>
</table>
<br />
<div>
<table class="center">
	<thead>
		<tr>
			<th>Agregar Articulo</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Articulo</td>
			<td>
			<select name="art-id" id="art-id">
				<%
					List<ArticuloDTO> articulos = (List<ArticuloDTO>) request.getAttribute("articulos");
					if(articulos!=null){
						for(ArticuloDTO a : articulos){
							%>
								<option value="<%=a.getReferencia() %>"><%=a.getDescripcion() %></option>							
							<%
						}
					}
				%>
			</select>
			</td>
		</tr>
		<tr>
			<td>Cantidad</td>
			<td><input type="text" value="" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Agregar!" /></td>
		</tr>
	</tbody>
</table>
</div>
</div>
</div>
</body>
</html>