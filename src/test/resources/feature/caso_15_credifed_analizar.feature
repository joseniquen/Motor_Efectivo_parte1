#Author: jniquen
Feature: Caso 14

  @web
  Scenario: Línea de producto  Efectivo - con llenado de datos adicionales de un cliente bancarizado - 
  Con seguros - Desembolso efectivo en tienda vendedor
    Given Abrir login cretifed
    Then Validacion de conexion segura 
    Then Ingreso usuario bpm 'ext_fsosa'
		And Ingreso contraseña bpm 'Efectiva.2022'
		When doy click en el boton continuar
		
		#dashboard
		When dar click en procesos
		Then cambio de iframe a "Search Results"
		When ingresar instancia de proceso "10851042"
		And dar click en pulsar para ver instancia
		When esperar 7 segundos
		Then cambio de inframe a default
		Then cambio de iframe a "View Instance Details"
		When validar datos de la solicitud de credito
		|agencia 		|doc_titular|linea_producto|nro_solicitud|
		|CHICLAYO   |05364817   |EFECTIVO      |10851042     |
		Then doy click en analizar solicitud de credito
		When doy click en reclamar tarea
		When esperar 10 segundos
		
		#datos de titular
		Then cambio de inframe a default
		Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "07 Datos del Titular"
	  When esperar 10 segundos
	  When verifica si existe error en consentimiento digital
		When doy click en boton editar
		When selecciono tipo de venta "RECEPTIVA"
		Then selecciono condicion especial "SIN TESTIGO A RUEGO"
		Then selecciono estado civil "SOLTERO(A)"
		And selecciono pais de nacimiento "PERU"
		And selecciono pais de nacimiento "PERU"
		And ingreso celular principal "580458721"
		And ingreso celular secundario "423114987"
		And elijo e ingreso telefono fijo "LIMA" "1894651"
		And ingreso correo electronico "example_1@gmail.com"
		Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When esperar 10 segundos
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
	 	And ingreso direccion domiciliaria "AV CAMINOS DEL INCA 2412"
	 	Then click en ubicar mapa
	 	When esperar 15 segundos
	 	Then doy click en aceptar la ubicacion correcta en el mapa
	 	When esperar 10 segundos
	  Then cambio de inframe a default
	 	Then cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  Then cambio de iframe a "08 Información Domiciliaria Titular"
	 	And selecciono tipo de referencia "FRENTE A"
	 	And ingreso la referencia "PARQUE DE LA AMISTAD"
	 	Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When esperar 10 segundos
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
		And registro antiguedad laboral "30" años y "7" meses
		When esperar 10 segundos
		When revisar el detalle de deudas subir sustento
		Then doy click en guardar datos
		Then acepto para sobreescribir datos originales
		When esperar 10 segundos
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
		When esperar 10 segundos
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