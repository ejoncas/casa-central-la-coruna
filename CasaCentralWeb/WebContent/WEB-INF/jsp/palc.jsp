<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<li><a href="ofad.html" title="OFAD">Preparar Oferta</a></li> 
				<li><a href="pedido" title="PALC">Ingresar Pedido</a></li> 
				<li><a href="soldist.html" title="SOLDIST">Solicitud de Distribuci&oacute;n</a></li> 
				<li><a href="articulos" title="NUEVOART">Administrar Articulos</a></li> 
			</ul>  
		</div>
	</div>
	<div class="content center">
		<!-- Content goes here -->

<h2>Importar Pedido (PALC)</h2>
<form action="pedido-upload" method="POST" enctype="multipart/form-data">
<table  class="center">
<tbody>
			 <tr>
			 		 <td><strong>Archivo XML:</strong></td>
 			 		 <td><input type="file" value="Buscar" name="pedido"/></td>
					 <td width="250px"><input type="submit" value="Ingresar Pedidos"/></td>
			 </tr>
			 
</tbody>
</table>
</form>
<br/>		
	</div>
</div>
</body>
</html>