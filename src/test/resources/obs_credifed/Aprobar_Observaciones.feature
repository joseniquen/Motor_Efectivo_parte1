#Author: ychiroque - jniquen
Feature: Aprobar Observaciones

 #-USUARIOS PARA APROBAR OBSERVACIONES (EXEPCIONES Y AUTONOMIA INICIAL) 
 #userzonal 		Efectiva2021 
 #useradmision		Efectiva2021 
 #JefeEfectinegocios	Efectiva2021 
 #gerentedyv		Efectiva2021 
 #GerenteRiesgos		Efectiva2021 
 #GerenteProducto		Efectiva2021 
 #JefeProducto		Efectiva2021 
 #OficialCredito 	        Efectiva2021 
 #EjecutivoConvenio     Efectiva.2022 
 #GerenteHyC     Efectiva.2022

  @web
  Scenario: Aprobar Observaciones
  	
   #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'useradmision'
		And Ingreso mi contraseña bpm 'Efectiva2021'
		And Doy click en boton continuar de bpm 4
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20572753"
		And Doy click en pulsar para ver obs
		When Espero 10 segundos
		#PROCESO: APROBAR SOLICITUD
		When Doy click en aprobar excepcion de credito
		When Doy click en reclamar tarea 4
		
		When Cambio de iframe a default
		When Cambio de iframe a "Aprobación por Excepción"
		When Validar que el menu de exepciones sea el inicial
		
	  When Selecciono estado "CONFORME" e ingreso comentario aprobador "TODO OK"
	  When Doy click en el boton responder aprobacion por excepcion 4
	  When Cambio de iframe a default
	  When Espero 10 segundos
	  When Cierro sesion de credifed
