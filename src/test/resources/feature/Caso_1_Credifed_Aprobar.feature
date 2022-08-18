#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Escenario 1 - xxxxxx

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
  
    #SECCIÓN: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'ext_fsosa'
		And Ingreso mi contraseña bpm 'Efectiva.2022'
		And Doy click en boton continuar de bpm
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "10852564"
		And Doy click en pulsar para ver instancia
		When Espero 10 segundos
		When Valido datos de la solicitud de credito
		|agencia 		|doc_titular|linea_producto|nro_solicitud|
		|CHICLAYO   |04645301   |EFECTIVO      |10852564     |
		When Doy click en analizar solicitud de credito
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
	  