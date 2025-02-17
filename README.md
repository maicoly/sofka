# sofka
Proyecto de Gestión de Movimientos en Cuentas

Este proyecto proporciona una solución para gestionar los movimientos de cuentas bancarias, incluyendo el registro de transacciones, la verificación de saldo disponible, y el manejo de errores relacionados con operaciones de movimiento. Utiliza **Spring Boot** y **Reactive Programming** con **Mono** de **Project Reactor**.

## Características Principales

- **Registro de Movimientos**: Permite registrar movimientos (depósitos o retiros) en cuentas bancarias.
- **Verificación de Saldo**: Antes de realizar un movimiento, se verifica si el saldo disponible es suficiente. Si no es así, se genera un error personalizado.
- **Actualización de Saldo**: Al realizar un movimiento, el saldo de la cuenta se actualiza automáticamente (el saldo inicial).
- **Persistencia en Base de Datos**: Los movimientos se guardan en la base de datos, y las cuentas se actualizan con el nuevo saldo.
- **Manejo de Errores**: Se manejan los errores de forma adecuada, proporcionando mensajes claros cuando algo falla.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para la creación del servicio.
- **Spring Data JPA**: Para interactuar con la base de datos de forma sencilla.
- **Project Reactor (Mono)**: Para manejar la programación reactiva.
- **PostgreSQL**: Base de datos relacional para almacenar las cuentas y movimientos.
- **Java 21**: Versión del OPEN JDK utilizada para el desarrollo.sarrollo.

# DOCKER CONTAINER RUNNING

El repositorio puedes verlo en mi docker hub publico: https://hub.docker.com/repository/docker/mmorocho/gittemp_app-client-person/general

- **1** go to ../docker
- **2** run with: **docker-compose up** (or docker-compose up --build)