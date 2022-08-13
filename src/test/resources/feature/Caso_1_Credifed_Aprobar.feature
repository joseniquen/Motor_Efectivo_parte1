#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Caso 1

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
  
    Given Abrir login cretifed
    Then Validacion de conexion segura 
    Then Ingreso usuario bpm 'ext_fsosa'
		And Ingreso contraseña bpm 'Efectiva.2022'
		When doy click en el boton continuar
		
		#dashboard
		When dar click en procesos
		Then cambio de iframe a "Search Results"
		When ingresar instancia de proceso "10851647"
		And dar click en pulsar para ver instancia
		When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		When validar datos de la solicitud de credito
		|agencia 		|doc_titular|linea_producto|nro_solicitud|
		|CHICLAYO   |04645301   |EFECTIVO      |10851647     |
		Then doy click en analizar solicitud de credito
		When doy click en reclamar tarea
		When esperar 10 segundos

		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  Then cambio de iframe a "07 Datos del Titular"
	  When esperar 15 segundos
	  When verifica si existe error en consentimiento digital
	  When me dirijo a la pestaña de "Validar Requisitos"

	  When esperar 7 segundos
	  Then cambio de inframe a default
		Then cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  Then cambio de iframe a "20 Validación Requisitos"
	  When esperar 10 segundos
	  When check list de documentos
	  Then doy click en continuar
	  
	  When esperar 7 segundos
	  Then cambio de inframe a default
		Then cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  Then cambio de iframe a "21 Observaciones"
	  When esperar 10 segundos
	  Then doy click en continuar
	  
	  When esperar 7 segundos
	  Then cambio de inframe a default
		Then cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  Then cambio de iframe a "23 Datos de Referidos"
	  When esperar 10 segundos
	  Then doy click en continuar

	  When esperar 7 segundos
	  Then cambio de inframe a default
		Then cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
	  Then cambio de iframe a "22 Oferta Comercial"
	  When esperar 10 segundos
	  When doy click en simular
	  When esperar 10 segundos
	  Then doy click en aprobar
	  
	  When esperar 7 segundos
 		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Aprobar Solicitud de Crédito"
		Then cambio de iframe a "Resumen Solicitud"
	  Then verificar que estemos en la pantalla resumen del credito
	  Then doy click en aceptar solicitud de credito
	  
	  When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		Then verificar que la solicitud de credito haya sido aprobada correctamente
	  