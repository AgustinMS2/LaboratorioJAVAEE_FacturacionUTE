# FacturaUTEMock

Mock del sistema externo de Facturación UTE, utilizado para pruebas de integración
del sistema de Gestión de Movilidad Eléctrica.

---

## Descripción

Simula el servicio de facturación de UTE. Recibe notificaciones de pago y siempre
retorna confirmación, dado que UTE no rechaza pagos por esta vía.

---

## Endpoint

| Método | URL | Descripción |
|---|---|---|
| POST | `/api/factura-ute/notificar-pago` | Recibe notificación de pago de una carga |

### Request
```json
{
  "clienteId": 1,
  "cargaId": 10,
  "numeroCuenta": "UTE-12345",
  "importe": 150.0
}
```

### Response
```json
{
  "estado": "CONFIRMADO",
  "codigoUTE": "2cc20b31-7403-45ba-9e1f-ad033ad26f62",
  "mensaje": "Pago registrado en factura UTE cuenta: UTE-12345"
}
```

---

## Cómo ejecutar

Este mock se despliega junto al core de GestorMovilidad. No requiere un servidor
propio.

1. Compilar el WAR:
```bash
mvn clean package
```

2. Copiar el WAR a la carpeta deployments del core:
```bash
# Linux
cp target/FacturaUTEMock.war <ruta-core>/target/server/standalone/deployments/

# Windows
copy target\FacturaUTEMock.war <ruta-core>\target\server\standalone\deployments\
```

3. Levantar el core normalmente con `mvn wildfly:run`.

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Jakarta EE | 10 |
| WildFly | 27.0.1 |