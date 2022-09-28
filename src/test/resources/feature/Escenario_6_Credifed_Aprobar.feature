#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Escenario 6 - Como usuario quiero analizar y aprobar una solicitud de crédito

				 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
		     #Agencia
		     #Documento del titular
		     #Numero de solicitud
      
  @web
  Scenario: EP006: Línea de producto  Efectivo 
								  - Con llenado de datos adicionales  
								  - CONVENIO 
								  - Desembolso efectivo en tienda vendedor 
								  - Plan B Desgravamen CDev 
								  - Con periodo de gracia

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'ext_fsosa'
		And Ingreso mi contraseña bpm 'Efectiva.2022'
		And Doy click en boton continuar de bpm
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "10859285"
		And Doy click en pulsar para ver instancia
		When Espero 10 segundos
		#PROCESO: APROBAR SOLICITUD
		When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea
		
	  #SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Validar que el menu de aprobar sea el inicial
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "07 Datos del Titular"
	  When Verifico si existe error en consentimiento digital
	  When Me dirijo a la pestaña de "Validar Requisitos"

	 	When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  When Espero 5 segundos
	  When Doy check a la lista de documentos
	  When Doy click en boton continuar
	  
	  #SECCION: OBSERVACIONES
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
	  When Verifico que haya observaciones por edad del cliente
	  When Doy click en el boton habilitar aprobacion por excepcion
	  When Selecciono estado "RESUELTA" e ingreso comentario "TODO OK"
	  When Doy click en el boton enviar aprobacion por excepcion
	  When Doy click en aceptar aprobacion por excepcion
	  
	  #SECCION: APROBACION POR EXCEPCION
	  When Cambio de iframe a default
	  When Cierro sesion de credifed
	  When Espero 10 segundos
	  And Ingreso mi usuario bpm 'useradmision'
		And Ingreso mi contraseña bpm 'Efectiva2021'
	  And Doy click en boton continuar de bpm
	  When Doy click en procesos
		When Ingreso instancia de proceso anterior
		And Doy click en aprobar observaciones
		When Doy click en aprobacion por excepcion
		
		#SECCION: APROBACION POR EXCEPCION
	  When Cambio de iframe a default
		When Cambio de iframe a "Aprobación por Excepción"
	  When Cambio de iframe a "22 Oferta Comercial"
	  When Me dirijo a la pestaña de "Observaciones"
	  
	  #SECCION: APROBAR OBSERVACIONES
	  When Cambio de iframe a default
		When Cambio de iframe a "Aprobación por Excepción"
	  When Cambio de iframe a "21 Observaciones"
	  When Verifico que haya observaciones por edad del cliente
	  When Selecciono estado "CONFORME" e ingreso comentario aprobador "TODO OK"
	  When Doy click en el boton responder aprobacion por excepcion
	  When Espero 10 segundos
	  When Cambio de iframe a default
	  When Cierro sesion de credifed
	  When Espero 5 segundos
	  
    And Ingreso mi usuario bpm 'ext_fsosa'
		And Ingreso mi contraseña bpm 'Efectiva.2022'
		And Doy click en boton continuar de bpm
	  When Doy click en procesos
	  When Ingreso instancia de proceso anterior sin observaciones
		And Doy click en pulsar para ver instancia
		When Doy click en aprobar solicitud de credito

		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
	  When Doy click en boton actualizar
	  When Doy click en boton continuar
	  
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "23 Datos de Referidos"
	  When Doy click en boton continuar

	  When Espero 10 segundos
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "22 Oferta Comercial"
	  When Espero 10 segundos
	  When Verifico CME del cliente
	  When Doy click en seguro desgravamen con devolucion
	  When Acepto seguro desgravamen con devolucion
	  When Doy click en simular
	  When Doy click en el boton aprobar
	  
 		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Cambio de iframe a "Resumen Solicitud"
	  When Verifico que estemos en la pantalla resumen del credito
	  When Doy click en aceptar solicitud de credito
	  
		When Cambio de iframe a default
		When Cambio de iframe a "View Instance Details"
		Then Verifico que la solicitud de credito haya sido aprobada correctamente