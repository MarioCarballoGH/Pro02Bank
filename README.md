# Bank Manager
Servicios web REST y SOAP para las administracion de bancos, sucursales y ordenes de pago.

## Entidades
- Banco
- Sucursal
- Order de Pago

## Servicios
- Utilizar el prefijo *http://servername:port/bankservice* seguido de los respectivos endpoints...
### REST

#### Servicios para el mantenimiento de todas las entidades

##### Banco
- /bank - Obtener todos los bancos
- /bank/{id} - Obtener un banco a partir de su id
- /bank/save - Crear un banco

##### Sucursal
- /branch - Obtener todas las sucursales
- /branch/{id} - Obtener una sucursal a partir de su id
- /branch/save/{id} - Crear una sucursal de un banco, dado el id del banco

##### Orden de pago
- /payment - Obtener todas las ordenes de pago
- /payment/{id} - Obtener una orden de pago a partir de su id
- /payment/save - Crear una orden de pago
- /associate/{orderId}/{branchId} - Asociar una orden de pago a una sucursal a partir de sus id

#### Listar las ordenes de pago de una sucursal segun el tipo de moneda
- /branch/payments/{id}

### SOAP
#### Listar las sucursales de un banco
- /sucursalesservice - Obtener todas las sucursales de un banco a partir del nombre del banco

## Ejemplos de objetos válidos para peticiones
> Banco
```json
{
    "name":"Test Bank",
    "address":"Test address",
    "registrydate":"10/10/20"
}
```
> Sucursal
```json
{
    "name":"Test Sucursal",
    "address":"Test address",
    "registrydate":"10/10/20"
}
```
> Orden de pago
```json
{
    "amount":100,
    "currency":"USD",
    "state":2,
    "paymentDate":"10/10/20"
}
"state" es un enumerado que representa el estado de la orden. 
Posibles valores:
- 1 (PAYED)
- 2 (DECLINED)
- 3 (FAILED)
- 4 (CANCELED)
```

## Ejemplos de respuestas
> Banco
```json
{
    "id": 1,
    "name": "Test Bank",
    "address": "Test address",
    "registrydate": "10/10/20"
}
```
> Sucursal
```json
{
    "id": 1,
    "name": "Test Sucursal",
    "address": "Test address",
    "registrydate": "10/10/20",
    "bank": {
        "id": 1,
        "name": "Test Bank",
        "address": "Test address",
        "registrydate": "10/10/20"
    }
}
```
> Orden de pago
```json
{
    "id": 1,
    "amount": 100.0,
    "currency": "USD",
    "state": "FAILED",
    "paymentDate": "12/12/21",
    "branchOffice": {
        "id": 1,
        "name": "Test Sucursal",
        "address": "Test address",
        "registrydate": "10/10/20",
        "bank": {
            "id": 1,
            "name": "Test Bank",
            "address": "Test address",
            "registrydate": "10/10/20"
        }
    }
}
```

## Descargar proyecto
```
$ git clone https://github.com/MarioCarballoGH/Pro02Bank.git
```

## Install
```
$ mvn clean install
```

## Iniciar
```
$ mvn spring-boot:run
```