<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="uade.server.beans.dto.ArticuloDTO"%>
<%@page import="uade.web.servlets.AjaxArticulo"%>
<html>
<head>
<title>Zara</title>
<LINK REL=StyleSheet HREF="styles/style.css" TYPE="text/css" MEDIA=screen/>
<LINK REL=StyleSheet HREF="css/base/ui.css" TYPE="text/css"/>
<script language="javascript" src="js/jq.js"></script>
<script language="javascript" src="js/ui.js"></script>
<script language="javascript" src="js/util.js"></script>
<script language="javascript" src="js/jstepper.js"></script>

<!-- JS INITIALIZATION CODE -->
<script language="javascript">

	$(document).ready(function (){
	
		$("input:button").button();
		$("input:submit").button();
		$(".numeric").jStepper({minValue:0, maxValue:9999999, maxDecimals: 2});
		
		$(".delete-art").click(function(){
			//TODO - eliminar articulo
			var ref = $(this).attr("art-id")
			 $.ajax({
			      url: "AjaxArticulo",
			   	  type: "POST",
			      data: {
			      	action: "<%= AjaxArticulo.ACTION_DEL%>",
			      	referencia: ref 
			      },
			      success: function(msg){
						jqAlert(msg,"Respuesta",function(){
									      		window.location.reload()
						});
				  }
			});
		});
		
		$(".edit-art").click(function(){
			//TODO -  Open popup and edit user
			alert($(this).attr("art-id"));
			alert($(this).attr("type"));
			 $.ajax({
			      url: "AjaxArticulo",
			      //UPDATE
			});
		});
		
		
		$("#button-alta").click(function(){
			$("#dialog-alta-articulo").dialog({
						modal: true,
						show: "blind",
						width: 300,
						buttons: {
							Agregar: function() {
								 $.ajax({
								      url: "AjaxArticulo",
								      type: "POST",
								      data: ({
								      		//Ropa Fields
								      		action: "<%= AjaxArticulo.ACTION_NEW%>",
								      		type: "R",
								      		linea: $("#ropa-linea").val(),
								      		desc: $("#ropa-desc").val(),
								      		talle: $("#ropa-talle").val(),
								      		color: $("#ropa-color").val(),
								      		seccion: $("#ropa-seccion").val(),
								      		precio: $("#ropa-precio").val(),
								      		origen: $("#ropa-origen").val()
								      }),
								      dataType: "html",
								      success: function(msg){
								      	jqAlert(msg,"Respuesta",function(){
									      		window.location.reload()
									    });
								      }
								   }
								);
								$( this ).dialog( "close" );
							},
							Cancelar: function() {
								$( this ).dialog( "close" );
							}
						}
			});
		});
		
		$("#button-alta-hogar").click(function(){
			$("#dialog-alta-arthogar").dialog({
							modal: true,
							show: "blind",
							width: 300,
							buttons: {
								Agregar: function() {
									$.ajax({
								      	  url: "AjaxArticulo",
									      type: "POST",
									      data: ({
									      		//Hogar Fields
									      		type: "H",
									      		nombre: $("#hog-nombre").val(),
									      		desc: $("#hog-desc").val(),
									      		linea: $("#hog-linea").val(),
									      		composicion: $("#hog-composion").val(),
									      		color: $("#hog-color").val(),
									      		medidas: $("#hog-medidas").val(),
									      		precio: $("#hog-precio").val(),
									      		seccion: $("#hog-seccion").val(),
									      		categoria: $("#hog-categoria").val()									      		
									      }),
									      dataType: "html",
									      success: function(msg){
									      	jqAlert(msg,"Respuesta", function(){
									      		window.location.reload()
									      	});
									      }
									   }
									);
									$( this ).dialog( "close" );
								},
								Cancelar: function() {
									$( this ).dialog( "close" );
								}
							}
				});
		});
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
				<li><a href="ofad.html" title="OFAD">Preparar Oferta</a></li> 
				<li><a href="palc.html" title="PALC">Ingresar Pedido</a></li> 
				<li><a href="soldist.html" title="SOLDIST">Solicitud de Distribuci&oacute;n</a></li> 
				<li><a href="articulos.html" title="NUEVOART">Administrar Articulos</a></li> 
			</ul> 
		</div>
	</div>
	<div class="content center">
		<!-- Content goes here -->
		<!-- Contenido de la página -->
	<h2>Administraci&oacute;n de Artículos</h2>
		<table id="listado-artículos" class="admin-table center" >
			<thead>
			<tr>
				<th> Referencia </th>
				<th> Descripcion </th>
				<th> Linea </th>
				<th> Seccion </th>
				<th> Color </th>
				<th> Precio </th>
				<th> Tipo </th>
				<th> Acciones </th>
			</tr>
			</thead>
			<tbody>
			<%
				List<ArticuloDTO> articulos = (List<ArticuloDTO>) request.getAttribute("articulos");
				if(articulos!=null && !articulos.isEmpty()){
					for(ArticuloDTO art : articulos){
			%>
			<tr>
				<td><%=art.getReferencia() %></td>
				<td><%=art.getDescripcion() %></td>
				<td><%=art.getLinea() %></td>
				<td><%=art.getSeccion() %></td>
				<td><%=art.getColor() %></td>
				<td><%=art.getPrecio() %></td>
				<td><%=art.getType() %></td>
				<td>
					<img class="clickable delete-art" src="img/del.png" art-id="<%=art.getReferencia() %>">
					<img class="clickable edit-art" src="img/edit.gif" art-id="<%=art.getReferencia() %>" type="<%=art.getType() %>">
				</td>
			</tr>
			<%
					}
				}else{
			%>
				<tr><td colspan="100">No hay articulos cargados</td> </tr>	
			<%} %>
			</tbody>
		</table>
		<br/>
		<div class="actions-button center">
			<input type="button" id="button-alta" value="Alta Artículo Ropa">
			<input type="button" id="button-alta-hogar" value="Alta Accesorio Hogar">
		</div>
	</div>
</div>

<div style="display:none" id="dialog-alta-articulo" title="Crear Nuevo Articulo de Ropa">
		<form>
		<fieldset>
			<!--
			<label for="referencia">Referencia</label>
			<input type="text" name="referencia" id="referencia" class="text ui-widget-content ui-corner-all" />
			-->
			<label for="linea">Linea</label>
			<input type="text" name="linea" id="ropa-linea" value="" class="text ui-widget-content ui-corner-all" />
			<label for="desc">Descripcion</label>
			<input type="text" name="desc" id="ropa-desc" value="" class="text ui-widget-content ui-corner-all" />
			<label for="talle">Talle</label>
			<input type="text" name="talle" id="ropa-talle" value="" class="text ui-widget-content ui-corner-all" />
			<label for="color">Color</label>
			<input type="text" name="color" id="ropa-color" value="" class="text ui-widget-content ui-corner-all" />
			<label for="seccion">Seccion</label>
			<input type="text" name="seccion" id="ropa-seccion" value="" class="text ui-widget-content ui-corner-all" />
			<label for="precio">Precio</label>
			<input type="text" name="precio" id="ropa-precio" value="" class="numeric text ui-widget-content ui-corner-all" />
			<label for="origen">Origen</label>
			<input type="text" name="origen" id="ropa-origen" value="" class="text ui-widget-content ui-corner-all" />
		</fieldset>
	</form>
</div>

<div style="display:none" id="dialog-alta-arthogar" title="Crear Nuevo Articulo de Hogar">
		<form>
		<fieldset>
		<!-- 
			<label for="referencia">Referencia</label>
			<input type="text" name="referencia" id="referencia" class="text ui-widget-content ui-corner-all" />
			 -->
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" id="hog-nombre" value="" class="text ui-widget-content ui-corner-all" />
			<label for="desc">Descripcion</label>
			<input type="text" name="desc" id="hog-desc" value="" class="text ui-widget-content ui-corner-all" />
			<label for="linea">Linea</label>
			<input type="text" name="linea" id="hog-linea" value="" class="text ui-widget-content ui-corner-all" />
			<label for="composicion">Composicion</label>
			<input type="text" name="composion" id="hog-composion" value="" class="text ui-widget-content ui-corner-all" />
			<label for="color">Color</label>
			<input type="text" name="color" id="hog-color" value="" class="text ui-widget-content ui-corner-all" />
			<label for="seccion">Seccion</label>
			<input type="text" name="seccion" id="hog-seccion" value="" class="text ui-widget-content ui-corner-all" />
			<label for="medidas">Medidas</label>
			<input type="text" name="medidas" id="hog-medidas" value="" class="text ui-widget-content ui-corner-all" />
			<label for="precio">Precio</label>
			<input type="text" name="precio" id="hog-precio" value="" class="numeric text ui-widget-content ui-corner-all" />
			<label for="categoria">Categoria</label>
			<input type="text" name="categoria" id="hog-categoria" value="" class="text ui-widget-content ui-corner-all" />
		</fieldset>
	</form>
		
</div>
</body>
</html>