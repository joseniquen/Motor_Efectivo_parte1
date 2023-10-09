#Author: ychiroque - jniquen
Feature: Escenario 7 - Como usuario quiero aprobar una solicitud de crédito en BPM

    		 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
		     #El número de solicitud lo puede visualizar en el archivo que está en la carpeta target
      
  @web
  Scenario: CP007: Generar solicitud en Motor para Línea de producto Efectivo
  		             - Con llenado de datos adicionales  
  		             - Sin seguros optativos > 65 años 
  		             - Desembolso efectivo en tienda vendedor 
  		             - RETANQUEO 
  		             - Plan A Desgravamen SDev 
  		             - Con periodo de gracia y Desembolsar en BT

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'ychiroque'
		And Ingreso mi contraseña bpm 'XXXXXX'
		And Doy click en boton continuar de bpm 5
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20555351"
		And Doy click en pulsar para ver instancia 5
	  #PROCESO: APROBAR SOLICITUD
	  When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea 5
		
		#SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Validar que el menu de aprobar sea el inicial 5
		#When Cambio de iframe a default
		#When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  #When Cambio de iframe a "07 Datos del Titular"
	  When Verifico alerta de servicio 5
	  #When Me dirijo a la pestaña de "Validar Requisitos"

	 	When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  When Espero 5 segundos
	  When Doy check a la lista de documentos
	  When Doy click en boton continuar 5
	  
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
	  When Espero 5 segundos
	  When Doy click en boton continuar 5
	  
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "23 Datos de Referidos"
	  When Espero 5 segundos
	  When Doy click en boton continuar 5

 		When Espero 10 segundos
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "22 Oferta Comercial"
	  When Espero 10 segundos
	  When Doy click en seguro desgravamen sin devolucion
	  
	  When Doy click en simular 5
	  When Visualizo el resumen de la solicitud 5
	  When Espero 5 segundos
	  When Doy click en el boton aprobar 5
	  
 		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Cambio de iframe a "Resumen Solicitud"
	  When Verifico que estemos en la pantalla resumen del credito 5
	  When Verifico alerta de servicio 5 
	  When Doy click en aceptar solicitud de credito 5
	  
		When Cambio de iframe a default
		When Cambio de iframe a "View Instance Details"
		Then Verifico que la solicitud de credito haya sido aprobada correctamente 5