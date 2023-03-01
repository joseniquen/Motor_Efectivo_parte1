#Author: ychiroque - jniquen
Feature: Escenario 6 - Como usuario quiero aprobar una solicitud de crédito en BPM

    		 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
		     #El número de solicitud lo puede visualizar en el archivo que está en la carpeta target
      
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
		And Ingreso mi contraseña bpm 'XXXXXX'
		And Doy click en boton continuar de bpm
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20554331"
		And Doy click en pulsar para ver instancia
		When Espero 10 segundos
		#PROCESO: APROBAR SOLICITUD
		When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea
		
	  #SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Validar que el menu de aprobar sea el inicial
		#When Cambio de iframe a default
		#When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  #When Cambio de iframe a "07 Datos del Titular"
	  #When Verifico si existe error en consentimiento digital
	  #When Me dirijo a la pestaña de "Validar Requisitos"

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
		When Doy click en el boton habilitar aprobacion por excepcion
		When Selecciono estado "RESUELTA" e ingreso comentario "TODO OK"		
	  When Doy click en el boton enviar aprobacion por excepcion
	  When Doy click en aceptar aprobacion por excepcion
	  When Tomo captura de la pagina de Obs "6"