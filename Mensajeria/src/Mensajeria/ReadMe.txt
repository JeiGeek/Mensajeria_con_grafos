Manual de uso del código del programa

El programa cuenta con 7 clases:
- Grafo (No hay necesidad de modificarla).
- Envio (Se usa para hacer algunos cambios).
- Paquete (No hay necesidad de modificarla).
- Vehiculo (No hay necesidad de modificarla).
- Arista (No hay necesidad de modificarla).
- Screen (No hay necesidad de modificarla).
- main (Se ejecuta el programa)

-------------------------------------------------------------------------------------
- Agregar una arista nueva al grafo:
-------------------------------------------------------------------------------------
Para agregar una arista en el programa siga los siguientes pasos:

  1- Vaya a la clase Envio.
  2- Dirigase al metodo public void crearMapa().
  3- Para crear la arista llame al objeto g con su metodo agregarArista
	g.agregarArista();

  4- Los parametros que se le deben pasar son lo siguientes:
	- Origen -> Coloque la ciudad de origen (En preferencia en mayuscula).
	- Destino -> Coloque la ciudad de festino (En preferencia en mayuscula).
	NOTA: Como son cadena de caracteres se deben colocar las comillas dobles " ".

	- Kilometros -> Coloque el numero de kilometros que hay entre las dos ciudades.
	- Peso -> Coloque el numero de horas que hay entre las dos ciudades.
	NOTA: Si se va agregar un numero decimal se debe colocar al final del mismo una f ej: 12.3f	

     Un ejemplo de como debe quedar el metodo agregado en el metodo es:
	g.agregarArista("SABANA DE TORRES", "AGUACHICA", 282, 1.88f);
  5- Cambien el numero de nodos si va agregar una nueva ciudad (Recuerde toda ciudad está en mayuscula)
	-Para cambiar el numero de nodos vaya al constructor Envio() y busque (g = new Grafo(51);)
	donde encuentra el numero cambie el valor.
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
- Agregar un nuevo paquete al grafo por defecto:
-------------------------------------------------------------------------------------
   1. En el apartado del Proyecto busque el paquete llamado Txt y entre al archivo txt.txt
   2. Para agregar un nuevo paquete debe agregar lo siguiente
	- Descripcion del producto -> sin necesidad de comilla describa el producto.
	- Ciuidad de destino -> Escriba la ciudad de destino EN MAYUSCULA (Si se van a usar las que hay)
	para evitar excepciones.
	- Volumen -> Agregue el volumen del paquete.
	- Peso -> Aregue el peso del paquete.
	NOTA: Si se va agregar un numero decimal se debe colocar al final del mismo una f ej: 12.3f
	- Nombre del destinatario -> Menciones para quien es el paquete.
   NOTA: una vez se coloca cada dato en el orden dado se pone una coma y se deja una espacio, ejemplo:
	Cama, BOGOTA, 25, 0.2f, Pedro Hernandez
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
- Inicializar el programa:
-------------------------------------------------------------------------------------
Ejecute el programa desde el main.

-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
- Cambiar una tarifa:
-------------------------------------------------------------------------------------
   1- Vaya a la clase Envio.
   2- Dirigase al metodo public void crearMapa().
   3- Para cambiar una tarifa dentro del metodo coloque el siguiente metodo: g.agregarTarifa();
	De parametro se pasa con comillas dobles y en mayuscula (si se usan las ciudades por defecto)
	se coloca la ciudad y luego el valor de la tarifa ej:
	g.agregarTarifa("RIOHACHA", 25000);
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------