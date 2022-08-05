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
		When ingresar instancia de proceso "4466505"
		And dar click en pulsar para ver instancia
		When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		When validar datos de la solicitud de credito
		|agencia					 |doc_titular|linea_producto|nro_solicitud|
		|VILLAMARIA TRIUNFO|37902408   |ELECTRO       |4466505      |
		Then doy click en analizar solicitud de credito
		#When doy click en reclamar tarea
		When esperar 15 segundos
		
		#datos de titular
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "07 Datos del Titular"
	  When esperar 15 segundos
	  When verifica si existe error en consentimiento digital
		When doy click en boton editar
		When selecciono tipo de venta "RECEPTIVA"
		Then selecciono condicion especial "SIN TESTIGO A RUEGO"
		Then selecciono estado civil "SOLTERO(A)"
		And selecciono pais de nacimiento "PERU"
		And selecciono pais de nacimiento "PERU"
		And ingreso celular principal "580458721"
		And ingreso celular secundario "423114987"
		And elijo e ingreso telefono fijo "LIMA" "1894654"
		And ingreso correo electronico "example_2@gmail.com"
		Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When verifica si existe error en consentimiento digital
		Then doy click en continuar
		#datos de titular
		
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "08 Información Domiciliaria Titular"
	  When doy click en boton editar
	  #informacion domiciliaria de titular
	 	When selecciono departamento "LIMA"
	 	When selecciono provincia "LIMA"
	 	When selecciono distrito "SANTIAGO DE SURCO"
	 	And ingreso direccion domiciliaria "AV CAMINOS DEL INCA 2419"
	 	Then click en ubicar mapa
	 	When esperar 15 segundos
	 	Then doy click en aceptar la ubicacion correcta en el mapa
	 	When esperar 10 segundos
	  Then cambio de inframe a default
	 	Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "08 Información Domiciliaria Titular"
	 	And selecciono tipo de referencia "FRENTE A"
	 	And ingreso la referencia "PARQUE DE LA AMISTADa"
	 	Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When verifica si existe error en consentimiento digital
		Then doy click en continuar
		
		
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "09 Información Financiera Titular"
	  When doy click en boton editar
	  #informacion financiera de titular
		Then perfil de ingreso principal "FORMAL"
		And selecciono situacion laboral "DEPENDIENTE"
	  Then selecciono ocupacion "ABOGADO"
		And ingreso declarado "90000"
		And registro antiguedad laboral "30" años y "5" meses
		When esperar 10 segundos
		When revisar el detalle de deudas subir sustento
		Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When verifica si existe error en consentimiento digital
		Then doy click en continuar
		
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "10 Información Laboral Titular"
	  When doy click en boton editar
	  #informacion laboral de titular
	  When ingreso centro de trabajo "IDE SOLUTION"
	  When ingreso ruc de centro de trabajo "12345689745"
	  And elijo e ingreso telefono fijo info laboral "LIMA" "7894652"
	  And ingreso celular "987654321"
	  When selecciono departamento laboral "LIMA"
	 	When selecciono provincia laboral "LIMA"
	 	When selecciono distrito laboral "SANTIAGO DE SURCO"
	 	And ingreso direccion domiciliaria laboral "AV CAMINOS DEL INCA 2461"
	 	Then click en ubicar mapa laboral
	 	When esperar 15 segundos
	 	Then doy click en aceptar la ubicacion correcta en el mapa laboral
	 	When esperar 10 segundos
	 	Then cambio de inframe a default
	 	Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "10 Información Laboral Titular"
	 	And selecciono tipo de referencia laboral "FRENTE A"
	 	And ingreso la referencia laboral "PARQUE DE LA AMISTAD"
	 	Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When verifica si existe error en consentimiento digital
		Then doy click en continuar
		
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "19 Referencias Telefónicas"
	  #When doy click en boton editar
	  #informacion referencias telefonicas
	  When esperar 10 segundos
	  Then click en agregar nueva referencia
	  When creo referencia telefonica
		|parentesco	|lugar_telf|telefono |celular  |nombres |apellidos|
		|AMIGO      |LIMA      |1236547  |654987312|aaaa aaa|bbbb bbbb|
		Then click en agregar nueva referencia
		When esperar 5 segundos
	  When creo referencia telefonica
		|parentesco	|lugar_telf|telefono |celular  |nombres |apellidos|
		|AMIGO      |LIMA      |1236547  |654987312|aaaa aaa|bbbb bbbb|
		When esperar 5 segundos
		Then doy click en continuar
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "20 Validación Requisitos"
	  Then continuo a aprobacion de la solicitud
	  When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		Then doy click en aprobar solicitud de credito
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