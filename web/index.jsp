<%@page import="Modelo.Tienda"%>
<%@page import="ModeloDAO.TiendaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuestra tienda virtual</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/card.css">
        
        <%
        if(request.getParameter("mensaje")==null){}else
        if(request.getParameter("mensaje").equalsIgnoreCase("registro")){
        %>
 
        <script>
        alert("Tienda registrada con Exito");  
        </script>
        
            <%
            
        }
        
        %>
</head>
<body>

<!-- Team -->
<section id="team" class="pb-5">
    <div class="container">
        <h5 class="section-title h1">SERVICIOS</h5>
        <div class="row  justify-content-center pb-5">
  
            <div class="col-xs-12 col-sm-6 col-md-3">
            	<a href="vistas/login.jsp" class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light" type="submit">Login</a>
            </div>

            <div class="col-xs-12 col-sm-6 col-md-3 align-self-center">
            	<a href="vistas/registro.jsp" class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light" type="submit">Registrate</a>
            </div>
        </div>
<
        <div class="row">
            
            
             <%
                    
                        TiendaDAO dao=new TiendaDAO();
                        List<Tienda> list=dao.listar();
                        Iterator<Tienda>iter=list.iterator();
                        Tienda t=null;
                      
                        
                        while(iter.hasNext()){
                            t=iter.next();
                            
                        
                    %>
            <!-- Team member -->
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="image-flip" >
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                    <p><img class=" img-fluid" src="https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_02.png" alt="card image"></p>
                                    <h4 class="card-title"><%=t.getNombre()%></h4>
                                    <p class="card-text"><%=t.getLema()%></p>
                                    <a href="<%=t.getImagen()%>" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title"><%=t.getPropietario()%></h4>
                                    <p class="card-text"><%=t.getDescripcion()%></p>
                                    <ul class="list-inline">
                                        <li class="list-inline-item">
                                            <a class="social-icon text-xs-center" target="_blank" href="<%=t.getFacebook()%>">
                                                <i class="fa fa-facebook"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="social-icon text-xs-center" target="_blank" href="<%=t.getWeb()%>">
                                                <i class="fa fa-share"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="social-icon text-xs-center" target="_blank" href="#">
                                                <i class="fa fa-info-circle"></i>
                                            </a>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <%}
%>
            <!-- ./Team member -->
            
    </div>
</section>
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>