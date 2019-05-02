# procesarFacturacion

Realizar:

a. Recibir una colección de pedidos, realizar facturación
b. Recibir una lista de facturas a anular y Realizar la cancelación de pedidos
c. Proveer un método que Genere un informe de la operatoria del día con el
siguiente formato:
   Cliente-Tipo de Documento-Letra-Nro-Fecha de emisión-Monto
d. Listar los patrones utilizados y la justificación de uso    

## NOTAS:
A y B estan recibiendo de la misma fuente informacion
No me quedo claro que tiene que hacer B por eso hice un proceso parecido al A. O sea,
que se imprima en el punto C.


## Se utilizo los siguientes patrones de diseño: 

Data Acces Object: para obtener al informacion a procesar.
Clases: FacturacionDAO, PedidoDAO.    

Business Object: para procesar la información. Y manejar la logica del negocio del sistema.
Clases: FacturaBO, PedidoBO.

Data Transfer Object: para manejar la informacion a mostrar. 
Clases: FacturacionDTO.



## Dos maneras de probar:

1 - Ejecutar el test unitario ubicado en:
     test.MainTest
     
2 - Ejecutar con linea de comando:

    2.1- Posicionarse en la carpeta que se encuentra el .jar
    
    2.2- Tiene que existir en esa carpeta el archivo informeDiarioFacturacion.txt
    
    2.3- Ejecutar la siguiente linea de comando: java -jar   procesar.facturar.pedidos-1.0.0.jar

    
