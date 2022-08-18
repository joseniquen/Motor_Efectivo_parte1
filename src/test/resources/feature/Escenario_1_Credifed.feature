#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Escenario 1 - Como usuario quiero analizar y aprobar una solicitud de crédito

	#Modificar obligatoriamente los siguientes inputs:
      #Usuario credifed
      #Contraseña credifed
      #Numero de cotizacion
      #Agencia
      #Documento del cliente
      #Linea de producto
      #Numero de solicitud
      
  @web
  Scenario: Línea de producto  Efectivo
  				- Con llenado de datos adicionales 
  				- Con seguros optativos 
  				- Desembolso efectivo en tienda vendedor 
  				- Plan A Desgravamen SDev 
  				- Sin periodo de gracia

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'EXT_JNIQUEN'
		And Ingreso mi contraseña bpm 'Efectiva.2022'
		And Doy click en boton continuar de bpm
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "10852810"
		And Doy click en pulsar para ver instancia
		When Espero 10 segundos
		When Valido datos de la solicitud de credito
		|agencia 		|doc_titular|linea_producto|nro_solicitud|
		|CHICLAYO   |04055004   |EFECTIVO      |10852810     |
		When Doy click en analizar solicitud de credito
		When Doy click en reclamar tarea
		When Espero 10 segundos
		
		#PROCESO: ANALIZAR SOLICITUD
		#SECCION: DATOS DEL TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "07 Datos del Titular"
	  When Espero 15 segundos
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
		And Espero 10 segundos
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
	 	And Ingreso direccion domiciliaria "AV CAMINOS DEL INCA 2412"
	 	And Doy click en ubicar mapa
	 	And Espero 15 segundos
	 	#Temporal
	 	When Verifico si existe error en ejecución de servicio
	 	#Temporal
	 	When Doy click en aceptar la ubicacion correcta en el mapa
	 	When Espero 10 segundos
	  And Cambio de iframe a default
	 	And Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  And Cambio de iframe a "08 Información Domiciliaria Titular"
	 	And Selecciono tipo de referencia "FRENTE A"
	 	And Ingreso la referencia "PARQUE DE LA AMISTAD"
	 	And Doy click en guardar datos
		And Acepto para sobreescribir datos originales
		And Espero 10 segundos
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
		And Espero 10 segundos
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
	 	And Ingreso direccion domiciliaria laboral "AV CAMINOS DEL INCA 2461"
	 	And Doy click en ubicar mapa laboral
	 	And Espero 15 segundos
	 	#Temporal
	 	When Verifico si existe error en normalizar direccion
	 	#Temporal
	 	Then Doy click en aceptar la ubicacion correcta en el mapa laboral
	 	When Espero 10 segundos
	 	
	 	#SECCION: INFORMACION LABORAL TITULAR
	 	When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "10 Información Laboral Titular"
	 	And Selecciono tipo de referencia laboral "FRENTE A"
	 	And Ingreso la referencia laboral "PARQUE DE LA AMISTAD"
	 	And Doy click en guardar datos
		And Acepto para sobreescribir datos originales
		And Espero 10 segundos
		And Verifico si existe error en consentimiento digital
		And Doy click en boton continuar
		
		#SECCION: REFERENCIAS TELEFONICAS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "19 Referencias Telefónicas"
	  #Informacion referencias telefonicas
	  And Espero 10 segundos
	  And Verifico si existe error en referencias telefonicas
	  And Doy click en agregar nueva referencia
	  And Creo referencia telefonica
		|parentesco	|lugar_telf|telefono |celular  |nombres |apellidos|
		|AMIGO      |LIMA      |1236547  |654987312|aaaa aaa|bbbb bbbb|
		And Espero 5 segundos
		Then Doy click en boton continuar
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  Then Continuo a aprobacion de la solicitud
	  
	  #PROCESO: APROBAR SOLICITUD
	  When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea
		When Espero 10 segundos
		
		#SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "07 Datos del Titular"
	  When Espero 15 segundos
	  When Verifico si existe error en consentimiento digital
	  When Me dirijo a la pestaña de "Validar Requisitos"

	  When Espero 7 segundos
	 	When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  When Espero 10 segundos
	  When Doy check a la lista de documentos
	  When Doy click en boton continuar
	  
	  When Espero 7 segundos
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
	  When Espero 10 segundos
	  When Doy click en boton continuar
	  
	  When Espero 7 segundos
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "23 Datos de Referidos"
	  When Espero 10 segundos
	  When Doy click en boton continuar

	  When Espero 7 segundos
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "22 Oferta Comercial"
	  When Espero 10 segundos
	  When Doy click en simular
	  When Espero 10 segundos
	  When Doy click en el boton aprobar
	  
	  When Espero 7 segundos
 		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Cambio de iframe a "Resumen Solicitud"
	  When Verifico que estemos en la pantalla resumen del credito
	  When Doy click en aceptar solicitud de credito
	  
	  When Espero 7 segundos
		When Cambio de iframe a default
		When Cambio de iframe a "View Instance Details"
		Then Verifico que la solicitud de credito haya sido aprobada correctamente
	  
	  
	  