<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Reservas</title>
    </head>
    <body>
        <h1>
            Gestión de Reservas
        </h1>
        <%-- En este index manejamos el envio de reservas, y un botón que nos redirecciona a la lista  --%>
        <div class="barra">
            <p>En este espacio podrás agendar y adminisitrar las reservas</p>
        </div>

        <div class="datosClientes">
            <div class="cajaDatosCliente">
                <h2>
                    Ingresa los siguientes datos
                </h2>
                <form action="ReservaServlet1" method="POST">
                    <%-- En este formulario ingresamos todos los inputs con cada tipo requerido --%>
                    <%-- Enviamos todos los datos con un button submit a nuestro servlet llamado ReservasServlet a el metodo de POST --%>
                    <p><label>Nombre: </label><input type="text" name="nombre" required></p>
                    <p><label>Fecha: </label><input type="date" name="fecha" required></p>
                    <p><label>Espacio: </label>
                    <p><label></label><input type="radio" name="espacio" value="Escritorio" required>Escritorio</p>
                    <p><label></label><input type="radio" name="espacio" value="Sala de Reuniones" required>Sala de Reuniones</p>
                    <p><label></label><input type="radio" name="espacio" value="Oficina Privada" required>Oficina Privada</p>
                    <p><label>Duración en horas: </label><input type="number" name="horas" required></p>
                    <p><button type="submit">Enviar</button></p>
                </form>

            </div>
        </div>
        <div class="botonRedireccion">
            <h2>Ver lista de Reservas</h2>
            <p>Para visualizar la lista de Reservas, da clic en el siguiente botón: </p>
            <%-- En este form, al dar clic en el botón, llamamos el método get del servlet ListaReservasServletJava--%>
            <form action="ListaReservasServletJava" method="GET">
                <button type="submit">Ver reservas</button>
            </form>
        </div>
    </body>
</html>
