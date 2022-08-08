#Author: ychiroque - jniquen
Feature: Caso plantilla

  @web
  Scenario: Caso de primera plantilla 
    Given Abrir login cotifed
    Then Ingreso el usuario 'ext_fsosa'
		And Ingreso la contraseña 'Efectiva.2022'
		When doy click en el boton ingresar
				
		#seccion de filtro
		When esperar 15 segundos
		Then Selecciono tienda "CHICLAYO" 
		And Selecciono Tipo de documento "D.N.I."
		And Ingreso numero de documento "09030382"
		And Ingreso correo "correo_prueba@gmail.com"
		And Ingreso numero celular "924695269"
		When Doy click en filtrar
		
	 #seccion de linea de producto
	 And Confirmacion de alerta
	 And selecciono linea de producto "EFECTIVO"
	 Then dar click en Continuar
   
   #seccion de oferta comercial
   When esperar 7 segundos
   When Validar que se recupero ingreso vigente
 	 And esperar 15 segundos
 	 #Seguros
 	 #Seguro de Salud 12 Meses
	 #Seguro de Salud 24 Meses
	 #Seguro de Salud 36 Meses
	 #Seguro de Salud 48 Meses
	 #Seguro de Salud 60 Meses
	 #Multirriesgo Electro
	 #Contigo Familia plan Básico
	 #Contigo Familia plan Plus
	 #Accidentes Personales
	 #Seguro Oncológico 
 	 And Validar seguros marcados
 	 #And Selecciono seguros
	 #|seguros|
	 #|Seguro de Salud 48 Meses|
	 #|Accidentes Personales|
	 #|Seguro Oncológico|
	 And Titular selecciono estado civil "SOLTERO(A)"
	 And Confirmacion de alerta
	 And Titular selecciono pais "PERU"
	 And Titular selecciono tipo de vivienda "PROPIA"
	 And Titular ingreso Ant Dom Años "45"
	 And Titular ingreso Ant Dom Meses "11"
	 And Titular ingreso declarado "20000"
	 When esperar 7 segundos
	 And Titular doy check a Usar Ingreso Declarado
	 When esperar 7 segundos
	 And Titular ingreso Ant Lab Años "50"
	 And Titular ingreso Ant Lab Meses "4"
	 #And Titular ingreso inicial "0"
	 And Titular ingreso cantidad a solicitar "2000"
	 And Titular fecha de pago "7 de cada mes"
	 And Doy click en el boton simular
	 When esperar 10 segundos
	 When Elijo campaña "EFE_PROD_EFECTIVO_3" con plazo "12 meses"
	 And Doy click en el boton continuar
	 
	 #seccion confirmacion de solicitud
	 And Selecciono requisito y cargo archivo

	 And Ingreso referencias telefonicas
	     | parentesco| nombres | apellidos | prefijo    | telefono_fijo | celular  |
		   | AMIGO     | Juan    | Perez     |  01-LIMA   | 454545        | 924695269|
		   | HERMANO   | Carlos  | Peralta   |  01-LIMA   | 464646        | 984695268|

	 And Doy click en el boton solicitar
	 And Obtener numero de solicitud
	 When Terminar solicitud