# POO

# 🎥 Sistema Integral de Gestión de Cinépolis

Cinépolis, una de las principales cadenas de cine a nivel global, busca modernizar su sistema de gestión de cines para mejorar la experiencia del usuario en la compra de boletos, la reserva de asientos y la administración de sus operaciones internas. Este sistema debe ser robusto, escalable y capaz de manejar tanto operaciones en complejos físicos como la venta en línea, asegurando eficiencia, precisión y control en tiempo real sobre las actividades diarias.

## ✅ Objetivo General

Desarrollar un **Sistema Integral de Gestión para Cinépolis** que permita la **automatización de la compra y reserva de boletos**, la **gestión avanzada de salas y asientos**, y la **administración eficiente del catálogo de películas** y sus horarios, garantizando una experiencia de usuario excepcional y fluida tanto para los clientes como para los empleados de Cinépolis.

## 📖 Objetivos Específicos

1. **Facilitar la venta y reserva de boletos** a través de un sistema centralizado que permita tanto la compra en taquilla como en línea.
2. **Automatizar la asignación de asientos** y su estado (disponibles o vendidos) en tiempo real.
3. **Integrar promociones y descuentos**, asegurando que los clientes puedan acceder a beneficios como en el mes de su cumpleaños.

## 📗 Requerimientos Funcionales

### 🙋🏽‍♂️ Clientes

El sistema debe permitir almacenar la siguiente información de los clientes:

| id             | fecha de nacimiento |
|----------------|---------------------|
| nombre         | CURP                |
| apellidos      | dirección           |

### 🎬 Gestión de Películas

El sistema debe permitir agregar, modificar y asignar películas a salas y horarios. Se deben gestionar los siguientes datos:

| id       | género         |
|----------|----------------|
| título   | clasificación   |
| duración | sinopsis        |

### 🎞️ Gestión de Salas

Cada sala debe tener un número único, capacidad de asientos y un tipo de asiento (VIP, Premium). Se deben manejar los siguientes datos:

| id                | horarios de la sala                 |
|-------------------|-------------------------------------|
| capacidad         | cantidad de asientos VIP            |
| distribución      | cantidad de asientos Premium        |
| tipo de asiento   | películas proyectadas               |

### 💵 Proceso de Compra de Boletos

El sistema debe gestionar el proceso de compra de boletos validando la disponibilidad de los asientos en tiempo real, aplicando descuentos cuando corresponda. La información mínima necesaria para los boletos es la siguiente:

| id        | película        |
|-----------|-----------------|
| sala      | precio          |
| asiento   | tipo de asiento |
| cliente   | tiene descuento (boolean) |

### 🎦 Proceso de Compra y Reservación Compleja

El sistema debe validar la disponibilidad de asientos en tiempo real y permitir la compra de productos adicionales. La información mínima necesaria para una compra o reservación es:

| id         | precio total    |
|------------|-----------------|
| fecha de compra | tipo de pago    |
| boletos[]  |                     |

## 💻 Clases Principales

1. **Cine**: Representa un cine que contiene una lista de salas.
2. **Sala**: Cada sala tiene un número único, capacidad de asientos y las películas proyectadas.
3. **Película**: Almacena la información de cada película, incluyendo título, duración, género, clasificación y sinopsis.
4. **Cliente**: Representa a los clientes, almacenando su información personal y su historial de compras.
5. **Boleto**: Almacena información sobre los boletos comprados, incluyendo el asiento, la película, y el cliente.
6. **Reservación**: Gestiona el proceso de reserva de asientos, verificando su disponibilidad.
7. **Asiento**: Representa cada asiento dentro de una sala, marcando su disponibilidad (disponible, reservado, vendido).
8. **Pago**: Gestiona y procesa los pagos, permitiendo múltiples métodos de pago.

## 🚀 Instalación

1. Clona este repositorio:
    ```bash
    git clone https://github.com/tu-usuario/cinepolis.git
    cd proyecto/unidad2
    ```

2. Compila y ejecuta el proyecto:
    ```bash
    javac -d bin src/Main.java
    java -cp bin main.Main
    ```

**Contribuciones**: 

Isauro Bucio Hurtado
Angel Raul De labastida
Ernesto Yael Arteaga Zalapa
