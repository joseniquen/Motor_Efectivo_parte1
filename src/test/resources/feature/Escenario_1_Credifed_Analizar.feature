#Author: ychiroque - jniquen
Feature: Escenario 1 - Como usuario quiero analizar una solicitud de crédito en BPM

				 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
         #El número de solicitud lo puede visualizar en el archivo que está en la carpeta target
		     #Agencia
		     #Documento del titular
		     #Numero de solicitud
      
  @web
  Scenario: CP001: Generar solicitud en Motor para Línea de producto  Efectivo 
				  				- Con llenado de datos adicionales 
				  				- Con seguros optativos 
				  				- Desembolso efectivo en tienda vendedor 
				  				- Plan A Desgravamen SDev 
				  				- Sin periodo de gracia y Desembolsar en BT

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'ychiroque'
		And Ingreso mi contraseña bpm 'Buenasvibras.2023'
		And Doy click en boton continuar de bpm
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20565753"
		And Doy click en pulsar para ver instancia
		When Espero 10 segundos
		When Valido datos de la solicitud de credito
		|agencia 		|doc_titular|linea_producto|nro_solicitud|
		|CHICLAYO   |00231112   |EFECTIVO      |20565753     |
		When Doy click en analizar solicitud de credito
		When Doy click en reclamar tarea
		
		#PROCESO: ANALIZAR SOLICITUD
		#SECCION: DATOS DEL TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
		When Validar que el menu de analizar sea el inicial
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "07 Datos del Titular"
	  #Temporal
		When Verifico si existe error en filtro evaluar personas
		#Temporal
	  When Verifico si existe error en consentimiento digital
		When Doy click en boton editar
		When Selecciono tipo de venta "RECEPTIVA"
		And Selecciono condicion especial "SIN TESTIGO A RUEGO"
		And Selecciono estado civil "SOLTERO(A)"
		And Selecciono pais de nacimiento "PERU"
		And Selecciono pais de residencia "PERU"
		And Ingreso celular principal "580458721"
		And Ingreso celular secundario "423114987"
		And Elijo e ingreso telefono fijo "LIMA" "1894651"
		And Ingreso correo electronico "example_1@gmail.com"
		And Doy click en guardar datos
		And Acepto para sobreescribir datos originales
		And Verifico si existe error en consentimiento digital
		And Doy click en boton continuar

		#SECCION: INFORMACION DOMICILIARIA TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "08 Información Domiciliaria Titular"
	  #Temporal
	  When Verifico si existe error en filtro evaluar domicilio
	  #Temporal
	  When Doy click en boton editar
	  #Informacion domiciliaria de titular
	 	When Selecciono departamento "LIMA"
	 	And Selecciono provincia "LIMA"
	 	And Selecciono distrito "SANTIAGO DE SURCO"
	 	And selecciono via "AVENIDA"
	 	And Ingreso direccion domiciliaria "AV CAMINOS DEL INCA"
	 	And Ingreso numero de direccion domiciliaria "2412"	 	
	 	And Ingreso agrupacion "Sin agrupacion"
	 	And Ingreso division "Sin division"
	 	And Ingreso sub division "Sin sub division"
	 	And Ingreso interior "Sin interior"
	 	
	 	#And Doy click en ubicar mapa
	 	#Temporal
	 	#When Verifico si existe error en ejecución de servicio
	 	#Temporal
	 	#When Doy click en aceptar la ubicacion correcta en el mapa
	  #And Cambio de iframe a default
	 	#And Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  #And Cambio de iframe a "08 Información Domiciliaria Titular"
	 	And Selecciono tipo de referencia "FRENTE A"
	 	And Ingreso la referencia "PARQUE DE LA AMISTAD"
	 	And Doy click en guardar datos
		And Acepto para sobreescribir datos originales
		And Verifico si existe error en consentimiento digital
		And Doy click en boton continuar
		
		#SECCION: INFORMACION FINANCIERA TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "09 Información Financiera Titular"
	  When Doy click en boton editar
	  #Informacion financiera de titular
		When Selecciono perfil de ingreso principal "FORMAL"
		And Selecciono situacion laboral "DEPENDIENTE"
	  And Selecciono ocupacion "ABOGADO"
		And Ingreso declarado "90000"
		And Registro antiguedad laboral "30" años y "7" meses
		And Espero 1 segundos
		And Reviso el detalle de deudas subir sustento
		#Temporal
	 	When Verifico si existe error en filtro evaluacion financiera
	 	#Temporal
		When Doy click en guardar datos
		And Acepto para sobreescribir datos originales
		And Verifico si existe error en consentimiento digital
		And Doy click en boton continuar
		
		#SECCION: INFORMACION LABORAL TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "10 Información Laboral Titular"
	  When Doy click en boton editar
	  #Informacion laboral de titular
	  When Ingreso centro de trabajo "IDE SOLUTION"
	  When Ingreso ruc de centro de trabajo "12345689745"
	  And Elijo e ingreso telefono fijo informacion laboral "LIMA" "7894652"
	  And Ingreso celular "987654321"
	  And Selecciono departamento laboral "LIMA"
	 	And Selecciono provincia laboral "LIMA"
	 	And Selecciono distrito laboral "SANTIAGO DE SURCO"
	 	And selecciono via laboral "AVENIDA"
	 	And Ingreso direccion domiciliaria laboral "AV CAMINOS DEL INCA"
	 	And Ingreso numero de direccion domiciliaria laboral "2412"	 	
	 	And Ingreso agrupacion laboral "Sin agrupacion"
	 	And Ingreso division laboral "Sin division"
	 	And Ingreso sub division laboral "Sin sub division"
	 	And Ingreso interior laboral "Sin interior"
	 	#And Doy click en ubicar mapa laboral
	 	#Temporal
	 	#When Verifico si existe error en normalizar direccion
	 	#Temporal
	 	#Then Doy click en aceptar la ubicacion correcta en el mapa laboral
	 	
	 	#SECCION: INFORMACION LABORAL TITULAR
	 	#When Cambio de iframe a default
		#When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  #When Cambio de iframe a "10 Información Laboral Titular"
	 	And Selecciono tipo de referencia laboral "FRENTE A"
	 	And Ingreso la referencia laboral "PARQUE DE LA AMISTAD"
	 	And Doy click en guardar datos
		And Acepto para sobreescribir datos originales
		And Verifico si existe error en consentimiento digital
		And Doy click en boton continuar
		
		#SECCION: REFERENCIAS TELEFONICAS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "19 Referencias Telefónicas"
	  #Informacion referencias telefonicas
	  And Verifico si existe error en referencias telefonicas
	  And Doy click en agregar nueva referencia
	  And Creo referencia telefonica
		|parentesco	|lugar_telf|telefono |celular  |nombres |apellidos|
		|AMIGO      |LIMA      |1236547  |654987312|Juan    |Perez|
		Then Doy click en boton continuar
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  Then Continuo a aprobacion de la solicitud