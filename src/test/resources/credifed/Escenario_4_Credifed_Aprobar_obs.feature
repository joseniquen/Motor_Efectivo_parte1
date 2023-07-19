#Author: ychiroque - jniquen
Feature: Escenario 4 - Como usuario quiero aprobar una solicitud de crédito en BPM

    		 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
		     #El número de solicitud lo puede visualizar en el archivo que está en la carpeta target
      
  @web
  Scenario: CP004: Generar solicitud en Motor para Línea de producto  Efectivo
                   - Sin llenado de datos adicionales 
                   - Sin seguros > a 78 años 
                   - Abono en cuentas de ahorro titular 
                   - Sin periodo de gracia y Desembolsar en BT

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'EXT_JNIQUEN'
		And Ingreso mi contraseña bpm 'Julio.2023'
		And Doy click en boton continuar de bpm 2
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20572753"
		And Doy click en pulsar para ver instancia 2
		When Espero 10 segundos
		#PROCESO: APROBAR SOLICITUD
		When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea 2
		
	  #SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Verifico si existe error en consentimiento digital 2
		When Validar que el menu de aprobar sea el inicial 2
		#When Cambio de iframe a default
		#When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  #When Cambio de iframe a "07 Datos del Titular"
	  When Verifico si existe error en consentimiento digital 2
	  #When Me dirijo a la pestaña de "Validar Requisitos"

	 	When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "20 Validación Requisitos"
	  When Espero 5 segundos
	  When Doy check a la lista de documentos
	  When Doy click en boton continuar 2
	  
	  #SECCION: OBSERVACIONES
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
		When Doy click en el boton habilitar aprobacion por excepcion
		When Selecciono estado "RESUELTA" e ingreso comentario "TODO OK"		
	  When Doy click en el boton enviar aprobacion por excepcion
	  When Doy click en aceptar aprobacion por excepcion
	  When Tomo captura de la pagina de Obs 2 "6"