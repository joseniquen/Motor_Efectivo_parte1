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
		And Doy click en boton continuar de bpm 5
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20572753"
		And Doy click en pulsar para ver instancia 5
		When Espero 10 segundos
		#PROCESO: APROBAR SOLICITUD
		When Doy click en aprobar solicitud de credito
		When Doy click en reclamar tarea 5
		
	  #SECCION: VALIDACION REQUISITOS
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Validar que el menu de aprobar obs sea el inicial 5
	  
	  #SECCION: OBSERVACIONES
	  When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  When Cambio de iframe a "21 Observaciones"
	  When Doy click en boton actualizar
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
	  When Doy click en seguro desgravamen sin devolucion
	  #When Acepto seguro desgravamen sin devolucion
	  When Doy click en simular 5
	  When Doy click en el boton aprobar 5
	  
 		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		When Cambio de iframe a "Resumen Solicitud"
	  When Verifico que estemos en la pantalla resumen del credito 5
	  When Verifico si existe error en consentimiento digital 5
	  When Doy click en aceptar solicitud de credito 5
	  
		When Cambio de iframe a default
		When Cambio de iframe a "View Instance Details"
		Then Verifico que la solicitud de credito haya sido aprobada correctamente 5