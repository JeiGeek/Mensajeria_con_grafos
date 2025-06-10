# 📦 Sistema de Gestión de Envíos CargaVeloz

![Second Shop Logo/Banner Placeholder](https://github.com/JeiGeek/Mensajeria_con_grafos/Mensajeria/src/Imagenes/icono.png)

Este repositorio contiene el proyecto final desarrollado para la empresa CargaVeloz, un sistema diseñado para optimizar la gestión y entrega de paquetería, calculando rutas eficientes y considerando factores como el tráfico en las vías.

---

## 👥 Autores

*   Steven Arbey Rey Maldonado
*   Sara Sofia Patiño Gordillo
*   Jeison Fernando Guarguati Anaya

---

## 📝 Planteamiento del Problema

La empresa **CargaVeloz**, con su central de envíos en **Bucaramanga**, necesitaba un sistema eficiente para **calcular la ruta óptima entre ciudades destinatarias** y así agilizar la entrega de paquetería solicitada por sus clientes. El objetivo era **optimizar el tiempo de entrega**, simulando trayectos para estimar la duración del viaje en fechas, tomando en cuenta las posibles **condiciones de tráfico** que pudieran impactar el recorrido. Adicionalmente, se buscaba una **interfaz intuitiva y amigable** para facilitar la interacción del usuario.

CargaVeloz es una compañía relativamente nueva con una flota inicial de 15 vehículos. Cada vehículo tiene una capacidad máxima de 8500 kg y 25000 m³. La tarifa estándar de envío es de 15000 pesos para la mayoría de las ciudades, aunque puede variar. Por cada kilogramo adicional que supere el peso inicial, se incrementan 3000 pesos al precio. Los costos asociados al servicio representan el 40% de las ganancias totales.

---

## 💡 Estrategia de Solución

La finalidad del programa es que cada camión, con una carga específica, pueda visitar las ciudades designadas para la entrega. La estrategia implementada se basa en encontrar la **ruta más corta entre las ciudades**.

Para ello, se ha adoptado la lógica de identificar pares de nodos utilizando el **algoritmo de Floyd-Warshall**. Este enfoque permite determinar de manera eficiente las **distancias más cortas entre todas las ciudades** y, por ende, optimizar el recorrido de cada camión para agilizar las entregas.

El algoritmo de Floyd-Warshall funciona creando y actualizando matrices de pesos y de relación de recorridos, comparando la suma de "pivotes" con los valores existentes para encontrar rutas más cortas.

---

## 🏙️ Datos Utilizados

Para construir el grafo, se tomaron en cuenta **51 sitios representativos de Colombia** y **69 conexiones** entre ellas. Las ciudades corresponden a los nodos y las carreteras a las aristas.

Las ciudades consideradas incluyen: BUCARAMANGA, SABANA DE TORRES, PUERTO WILCHES, BARRANCABERMEJA, ZAPATOCA, PAMPLONA, MALAGA, AGUACHICA, OCAÑA, CUCUTA, PUERTO BERRIO, ARAUCA, VALLEDUPAR, MAICAO, RIOHACHA, SANTA MARTA, BARRANQUILLA, SOLEDAD, CARTAGENA, COVEÑAS, SINCELEJO, MONTERIA, MEDELLIN, RIONEGRO, QUIBDO, CHIQUINQUIRA, TUNJA, PAIPA, DUITAMA, SOGAMOSO, YOPAL, MANIZALES, PEREIRA, ARMENIA, IBAGUE, GIRARDOT, MELGAR, SOACHA, BOGOTA, VILLAVICENCIO, TULUA, BUENAVENTURA, PALMIRA, CALI, NEIVA, POPAYAN, SAN VICENTE DEL CAGUAN, MOCOA, PASTO, TUMACO, SAN VICENTE DE CHUCURI.

Se utilizó **Google Maps** como herramienta para obtener estimaciones precisas del tiempo de viaje y la distancia en kilómetros entre cada una de las ciudades.

Las tarifas se inspiraron en empresas como Servientrega o Inter rapidisimo, con una tarifa estándar y variación por peso.

---

## 🚚 Funcionamiento de Recorridos

El sistema calcula la ruta para cada camión partiendo de la ciudad de origen (Bucaramanga). Se determinan las **rutas mínimas entre todos los pares de nodos** que se deben visitar. El vehículo viaja hacia la ciudad con el menor "peso" (tiempo/distancia). Una vez allí, se entregan los pedidos, se marca la ciudad como visitada, y el proceso se repite desde la nueva ciudad de origen hasta completar todas las entregas.

---

## 🚦 Simulación y Actualización de Pesos (Tráfico)

Como requisito de la empresa, se considera la posibilidad de **tráfico en las vías**. Se han implementado simulaciones que toman en cuenta la variabilidad del tráfico.

El simulador opera generando un número aleatorio (1-100) para cada conexión (arista). Si el número es menor o igual a 3 (una **posibilidad del 3%**), se simula una condición de tráfico en esa arista. Aleatoriamente, se determinan las **horas adicionales** debido al tráfico, que pueden ser entre 1 y 5 horas para ese 3% de posibilidad. Estas horas adicionales se suman al peso (tiempo) de la ruta.

---

## 🖥️ Solución Generada (Programa)

La solución es un programa con una **interfaz gráfica** que permite la interacción del usuario.

Las opciones de la interfaz incluyen:
*   **Agregar un paquete**: Registrar información de nuevos envíos.
*   **Visualizar el listado completo de paquetes**: Ver todos los paquetes agregados.
*   **Simular el proceso de envío**: Ejecutar la simulación de tráfico y calcular las rutas óptimas para la entrega de paquetes.
*   **Obtener información sobre las utilidades totales**: Calcular las ganancias generadas tras la simulación de envíos.

---

## 🚀 ¡Explora el Código!

Este repositorio contiene la implementación de esta estrategia utilizando estructuras de datos y el algoritmo de Floyd-Warshall para resolver un problema real de logística.

---
