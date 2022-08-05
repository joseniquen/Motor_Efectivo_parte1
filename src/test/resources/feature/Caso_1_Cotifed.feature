#Author: ychiroque - jniquennnn
Feature: Caso 1

  @web
  Scenario: Línea de producto Electro - Computo - con llenado de datos opcionales de un cliente bancarizado - Sin seguros
    Given Abrir login cotifed
    Then Ingreso el usuario 'ychiroque'
		And Ingreso la contraseña 'Efectiva.2023'
		When doy click en el boton ingresar
				
		#seccion de filtro
		When esperar 15 segundos
		Then Selecciono tienda "PIURA" 
		And Selecciono Tipo de documento "D.N.I."
		And Ingreso numero de documento "37902408"
		And Ingreso correo "correo_prueba@gmail.com"
		And Ingreso numero celular "924695269"
		When esperar 10 segundos
		When Doy click en filtrar
		
	 #seccion de linea de producto
	 When esperar 10 segundos
	 And Confirmacion de alerta
	 When Selecciono categoria de linea de producto "ELECTRO" "Computo" 
	 And selecciono linea de producto "ELECTRO"
	 Then dar click en Continuar
   
   #seccion de oferta comercial
   When esperar 7 segundos
 	 And Ingreso modelo de producto "G4030-44LM"
	 And seleciono coincidencia de modelo de producto
 	 And Ingreso precio de venta de producto "1399"
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
	 And Titular ingreso inicial "0"
	 And Titular ingreso cantidad a solicitar "5000"
	 And Titular fecha de pago "15 de cada mes"
	 And Doy click en el boton simular
	 When esperar 10 segundos
	 When Elijo campaña "CAMP_PREMIUM" con plazo "18 meses"
	 And Doy click en el boton continuar
	 
	 #seccion confirmacion de solicitud
	 And Selecciono requisito y cargo archivo
	     | requisitos |
		   | BOLETA     |
		   | DNI        |
		   | DNI REVERSO|
		   | ARBITRIO   | 
	 And Ingreso referencias telefonicas
	     | parentesco| nombres | apellidos | prefijo    | telefono_fijo | celular  |
		   | AMIGO     | Juan    | Perez     |  01-LIMA   | 454545        | 924695269|
		   | HERMANO   | Carlos  | Peralta   |  01-LIMA   | 464646        | 984695268|
	     #seccion datos adicionales
	     And Doy click en el boton continuar datos adicionales
	     And Ingreso correo de datos principales "correo_prueba@gmail.com"
	     And Ingreso numero de celular de datos principales "924695269"
	     And Selecciono prefijo de datos principales "01-LIMA"
	     And Ingreso numero de telefono fijo de datos principales "454787"
	     And Selecciono departamento de info domiciliaria "LIMA"
	     And Selecciono provincia de info domiciliaria "LIMA"
	     And Selecciono distrito de info domiciliaria "SANTIAGO DE SURCO"
	     And Ingreso avenida de info domiciliaria "Av. Caminos del inca 2461"
	     When esperar 10 segundos
	     And Doy click en confirmar geopoint de info domiciliaria
	     And Retornar al iframe por defecto
	     When esperar 5 segundos
	     And Selecciono referencia de info domiciliaria "PASANDO DEL"
	     And Ingreso descripcion de info domiciliaria "Parque de la amistad"
	     And Ingreso nombre centro de info laboral "FINANCIERA EFECTIVA S.A."
	     And Selecciono prefijo de info laboral "01-LIMA"
	     And Ingreso numero de telefono fijo de info laboral "754787"
	     And Ingreso celular de info laboral "974695869"
	     And Ingreso ruc de centro de info laboral "20605554114"
	     And Selecciono departamento de info laboral "LIMA"
	     And Selecciono provincia de info laboral "LIMA"
	     And Selecciono distrito de info laboral "SANTIAGO DE SURCO"
	     And Ingreso avenida de info laboral "Av. Caminos del inca 2461"
	     When esperar 10 segundos
	     And Doy click en confirmar geopoint de info laboral
	     And Retornar al iframe por defecto
	     When esperar 5 segundos
	     And Selecciono referencia de info laboral "PASANDO DEL"
	     And Ingreso descripcion de info laboral "Parque de la amistad"
	 And Doy click en el boton solicitar
	 And Obtener numero de solicitud
	 When Terminar solicitud
	 
	
	
	
	 
	 
	 
	 

	 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 