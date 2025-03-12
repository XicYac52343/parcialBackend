<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logicaJava.claseReservasJava"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
    </head>
    <body>
        <h1>Todas las reservas: </h1>
        
        <%-- Con este bucle traemos los datos a nuestro front end y los imprimimos uno a uno, llamando los métodos necesarios --%>
        <%
            List<claseReservasJava> reservas = (List) request.getSession().getAttribute("listaReservas");
            int cont = 1;

            for (claseReservasJava reserva : reservas) {

        %>

        <div class="listaReservas">
            <%-- Al dar clic en el botón de este formulario, llamamos el método Post de nuestro servlet EliminarReserva... para que sea eliminada la reserva a la cual le dimos clic --%>
            <form action="EliminarReservaServletJava" method="POST">
                <p><b>Reserva N° <%=cont%></b></p>
                <p<label>Id: <%=reserva.getId()%></label><input type="hidden" name="id_Eliminar" value="<%=reserva.getId()%>"></p>
                <p>Nombre:  <%=reserva.getNombre()%></p>
                <p>Fecha:  <%=reserva.getFecha()%></p>
                <p>Espacio:  <%=reserva.getEspacio()%></p>
                <p>Horas:  <%=reserva.getHoras()%></p>
                <button type="submit">Eliminar Reserva</button>
            </form>
        </div>

        <%
                cont++;
            }
        %>
        <br>
    </body>
</html>
