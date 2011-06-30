<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="uade.server.beans.dto.ArticuloDTO"%>
<%@page import="uade.server.beans.dto.xml.Ofad"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="uade.server.beans.dto.ArticuloHogarOfadDTO"%>
<%@page import="uade.server.beans.dto.ArticuloRopaOfadDTO"%>
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
		
		$(".delete-ofad").click(function(){
			var ref = $(this).attr("item-id");
			$("#art-id").val(ref);
			$("#deleteForm").submit();
		});
	});
	</script>
</head>
<body>
<form id="deleteForm" action="ofad" method="POST">
	<input type="hidden" name="action" value="<%=uade.web.servlets.Ofad.ACTION_DEL %>"/>
	<input type="hidden" id="art-id" name="art-id" value=""/>
</form>
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

	<%
		if(request.getSession().getAttribute("ofertas")!=null){
%>
<table id="listado-artículos" class="admin-table center">
<%			
			
			Ofad ofad = (Ofad) request.getSession().getAttribute("ofertas");
			if(ofad.getAccesoriosHogar()!=null && !ofad.getAccesoriosHogar().isEmpty()){
				%>
				<tr>
					<th colspan="100" style="text-align: center;">Articulos de Hogar</th>
				</tr>
				<tr>
					<th> Referencia </th>
					<th> Descripcion </th>
					<th> Linea </th>
					<th> Seccion </th>
					<th> Color </th>
					<th> Nombe </th>
					<th> Composicion </th>
					<th> Medidas </th>
					<th> Categoria </th>
					<th> Precio </th>
					<th> </th>
				</tr>
				<%
				for(ArticuloHogarOfadDTO r : ofad.getAccesoriosHogar()){
					%>
						<tr>
							<td><%=r.getReferencia() %></td>
							<td><%=r.getDescripcion() %></td>
							<td><%=r.getLinea() %></td>
							<td><%=r.getSeccion() %></td>
							<td><%=r.getColor() %></td>
							<td><%=r.getNombre() %></td>
							<td><%=r.getComposicion() %></td>
							<td><%=r.getMedidas() %></td>
							<td><%=r.getCategoria() %></td>
							<td>$ <%=r.getPrecio() %></td>
							<td><img class="clickable delete-ofad" src="img/del.png" item-id="<%=r.getReferencia() %>"></td>
						</tr>
					<%
				}
%>
</table>
<%
			}
			if(ofad.getRopa()!=null && !ofad.getRopa().isEmpty()){
%>
			<table id="listado-artículos2" class="admin-table center">
				<tr>
					<th colspan="100" style="text-align: center;">Articulos de Indumentaria</th>
				</tr>
				<tr>
					<th> Referencia </th>
					<th> Descripcion </th>
					<th> Linea </th>
					<th> Seccion </th>
					<th> Color </th>
					<th> Talle </th>
					<th> Origen </th>
					<th> Precio </th>
					<th> </th>
				</tr>
				<%
				for(ArticuloRopaOfadDTO r : ofad.getRopa()){
					%>
						<tr>
							<td><%=r.getReferencia() %></td>
							<td><%=r.getDescripcion() %></td>
							<td><%=r.getLinea() %></td>
							<td><%=r.getSeccion() %></td>
							<td><%=r.getColor() %></td>
							<td><%=r.getTalle() %></td>
							<td><%=r.getOrigen() %></td>
							<td>$ <%=r.getPrecio() %></td>
							<td><img class="clickable delete-ofad" src="img/del.png" item-id="<%=r.getReferencia() %>"></td>
						</tr>
					<%
				}
			}
			%>
			</table>
			<%
		}
	%>
	
<br />
<div>
<form action="ofad" method="POST">
<input type="hidden" name="action" value="<%=uade.web.servlets.Ofad.ACTION_ADD %>">
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
					List<ArticuloDTO> articulos = (List<ArticuloDTO>) request.getSession().getAttribute("articulos");
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
			<td colspan="2"><input type="submit" value="Agregar Articulo!" /></td>
		</tr>
	</tbody>
</table>
</form>
</div>
<br/>
<div class="center" style="width: 70%;border: 1px solid #efefef">
<form id="generateForm" action="ofad" method="POST">
	<input type="hidden" name="action" value="<%=uade.web.servlets.Ofad.ACTION_GENERATE %>"/>
	<input type="submit" value="Obtener XML!" />
</form>
<form id="discardForm" action="ofad" method="POST">
	<input type="hidden" name="action" value="<%=uade.web.servlets.Ofad.ACTION_DISCARD %>"/>
	<input type="submit" value="Descartar OFAD" />
</form>
</div>

<br/>
<br/>
</div>

</div>
</body>
</html>