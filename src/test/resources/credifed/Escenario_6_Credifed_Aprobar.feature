#Author: ychiroque - jniquen
Feature: Escenario 6 - Como usuario quiero aprobar una solicitud de crédito en BPM

    		 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
		     #El número de solicitud lo puede visualizar en el archivo que está en la carpeta target
		     
		     #ORDEN DE EJECUCION DE LOS FEATURE PARA LOS CASOS CON EXCEPCIÓN:
		     #Escenario_6_Credifed_Analizar.feature
		     #Escenario_6_Credifed_Aprobar_obs.feature
		     #Aprobar_Observaciones.feature
		     #Escenario_6_Credifed_Aprobar.feature
      
  @web
  Scenario: CP006: Generar solicitud en Motor para Línea de producto Efectivo 
                   - Con llenado de datos adicionales 
                   - CONVENIO 
                   - Desembolso efectivo en tienda vendedor 
                   - Plan B Desgravamen CDev 
                   - Con periodo de gracia y Desembolsar en BT

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'ychiroque'
		And Ingreso mi contraseña bpm 'Lologramos.2023'
		And Doy click en boton continuar de bpm 5
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20578306"
		And Doy click en pulsar para ver instancia 5
		When Espero 10 segundos
		#PROCESO: APROBAR SOLICITUD
		When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea 5
		
	  #SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Validar que el menu de aprobar sea el inicial 5

	 	When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  When Espero 5 segundos
	  When Doy check a la lista de documentos
	  When Doy click en boton continuar 5
	  
	  #SECCION: OBSERVACIONES
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
	  #When Doy click en boton actualizar
	  When Doy click en boton continuar 5
	  
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "23 Datos de Referidos"
	  When Doy click en boton continuar 5

	  When Espero 10 segundos
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "22 Oferta Comercial"
	  When Espero 10 segundos
	  When Verifico CME del cliente 5
	  When Doy click en seguro desgravamen con devolucion 5
	  When Acepto seguro desgravamen con devolucion 5
	  When Doy click en simular 5
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