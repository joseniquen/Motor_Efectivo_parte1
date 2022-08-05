#Author: jniquen
Feature: Caso 1

  @web
  Scenario: Línea de producto Electro - Computo - con llenado de datos opcionales de un cliente bancarizado - Sin seguros
    Given Abrir login cretifed
    Then Validacion de conexion segura 
    Then Ingreso usuario bpm 'EXT_JNIQUEN'
		And Ingreso contraseña bpm 'Efectiva.2023'
		When doy click en el boton continuar
		
		#dashboard
		When dar click en procesos
		Then cambio de iframe a "Search Results"
		When ingresar instancia de proceso "10836800"
		And dar click en pulsar para ver instancia
		When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		When validar datos de la solicitud de credito
		|agencia |doc_titular|linea_producto|nro_solicitud|
		|PIURA   |07521101   |EFECTIVO      |10836800     |
		Then doy click en analizar solicitud de credito
		When doy click en reclamar tarea
		When esperar 15 segundos

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
	  Then verificar que estemmos en la pantalla reusmen del credito
	  Then doy click en aceptar solicitud de credito
	  
	  When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		Then verificar que la solicitud de credito haya sido aprobada correctamente
	  