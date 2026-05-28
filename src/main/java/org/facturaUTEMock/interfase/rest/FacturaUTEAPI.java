package org.facturaUTEMock.interfase.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@ApplicationScoped
@Path("/factura-ute")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaUTEAPI {

    // curl -X POST http://localhost:8080/FacturaUTEMock/api/factura-ute/notificar-pago -H "Content-Type: application/json" -d "{\"clienteId\":1,\"cargaId\":10,\"numeroCuenta\":\"UTE-12345\",\"importe\":150.0}"
    @POST
    @Path("/notificar-pago")
    public Response notificarPago(NotificacionPagoDTO notificacion) {
        RespuestaPagoDTO respuesta = new RespuestaPagoDTO();
        respuesta.estado = "CONFIRMADO";
        respuesta.codigoUTE = UUID.randomUUID().toString();
        respuesta.mensaje = "Pago registrado en factura UTE cuenta: " + notificacion.numeroCuenta;

        return Response.ok(respuesta).build();
    }
}