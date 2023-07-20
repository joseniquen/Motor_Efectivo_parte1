#Author: ychiroque - jniquen
Feature: Escenario 4 - Como usuario quiero analizar una solicitud de crédito en BPM

				 #Modificar obligatoriamente los siguientes inputs:
		     #Usuario credifed
		     #Contraseña credifed
		     #instancia de proceso = Numero de solicitud
         #El número de solicitud lo puede visualizar en el archivo que está en la carpeta target
		     #Agencia
		     #Documento del titular
		     #Numero de solicitud
		     
		     #ORDEN DE EJECUCION DE LOS FEATURE PARA LOS CASOS CON EXCEPCIÓN:
		     #Escenario_4_Credifed_Analizar.feature
		     #Escenario_4_Credifed_Analizar_Aval.feature
		     #Escenario_4_Credifed_Aprobar_obs.feature
		     #Aprobar_Observaciones.feature
		     #Escenario_4_Credifed_Aprobar.feature
      
  @web
  Scenario: CP004: Generar solicitud en Motor para Línea de producto  Efectivo
                   - Sin llenado de datos adicionales 
                   - Sin seguros > a 78 años 
                   - Abono en cuentas de ahorro titular 
                   - Sin periodo de gracia y Desembolsar en BT

    #SECCION: LOGIN		
    Given Ingreso a la pagina de credifed
    When Doy click en conexion segura 
    And Ingreso mi usuario bpm 'ychiroque'
		And Ingreso mi contraseña bpm 'Sisepuede.2023'
		And Doy click en boton continuar de bpm 1
		
		#SECCION: DASHBOARD
		When Doy click en procesos
		When Ingreso instancia de proceso "20572806"
		And Doy click en pulsar para ver instancia 1
		When Valido datos de la solicitud de credito 1
		|agencia 		|doc_titular|linea_producto|nro_solicitud|
		|CHICLAYO   |12541944   |EFECTIVO      |20572806     |
		When Doy click en analizar solicitud de credito 1
		When Doy click en reclamar tarea 1
		
		#PROCESO: ANALIZAR SOLICITUD
		#SECCION: DATOS DEL TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
		When Verifico si existe error en consentimiento digital 1
		When Validar que el menu de analizar sea el inicial 1
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "07 Datos del Titular"
	  #Temporal
		When Verifico si existe error en filtro evaluar personas 1
		#Temporal
		And Espero 5 segundos
	  When Verifico si existe error en consentimiento digital 1
		When Doy click en boton editar 1
		When Selecciono tipo de venta "RECEPTIVA"
		And Selecciono condicion especial "SIN TESTIGO A RUEGO"
		And Selecciono estado civil "SOLTERO(A)"
		And Selecciono pais de nacimiento "PERU"
		And Selecciono pais de residencia 1 "PERU"
		And Ingreso celular principal "580458721"
		And Ingreso celular secundario "423114987"
		And Elijo e ingreso telefono fijo "LIMA" "1894651"
		And Ingreso correo electronico 1 "example_1@gmail.com"
		And Doy click en guardar datos 1
		And Acepto para sobreescribir datos originales 1
		And Verifico si existe error en consentimiento digital 1
		And Doy click en boton continuar 1

		#SECCION: INFORMACION DOMICILIARIA TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "08 Información Domiciliaria Titular"
	  #Temporal
	  When Verifico si existe error en filtro evaluar domicilio 1
	  #Temporal
	  When Doy click en boton editar 1
	  #Informacion domiciliaria de titular
	 	When Selecciono departamento "LIMA"
	 	And Selecciono provincia "LIMA"
	 	And Selecciono distrito 1 "SANTIAGO DE SURCO"
	 	And selecciono via "AVENIDA"
	 	And Ingreso direccion domiciliaria "AV CAMINOS DEL INCA"
	 	And Ingreso numero de direccion domiciliaria "2412"	 	
	 	And Ingreso agrupacion "Sin agrupacion"
	 	And Ingreso division "Sin division"
	 	And Ingreso sub division "Sin sub division"
	 	And Ingreso interior 1 "Sin interior"
	 	#And Doy click en ubicar mapa
	 	#Temporal
	 	#When Verifico si existe error en ejecución de servicio
	 	#Temporal
	 	#When Doy click en aceptar la ubicacion correcta en el mapa
	  #And Cambio de iframe a default
	 	#And Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  #And Cambio de iframe a "08 Información Domiciliaria Titular"
	  #Temporal
	 	#When Verifico si existe error en ejecución de servicio
	 	#Temporal
	 	And Selecciono tipo de referencia "FRENTE A"
	 	And Ingreso la referencia 1 "PARQUE DE LA AMISTAD"
	 	And Doy click en guardar datos 1
		And Acepto para sobreescribir datos originales 1
		And Verifico si existe error en consentimiento digital 1
		And Doy click en boton continuar 1
		
		#SECCION: INFORMACION FINANCIERA TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "09 Información Financiera Titular"
	  When Doy click en boton editar 1
	  #Informacion financiera de titular
		When Selecciono perfil de ingreso principal 1 "FORMAL"
		And Selecciono situacion laboral "DEPENDIENTE"
	  And Selecciono ocupacion "ABOGADO"
		And Ingreso declarado "90000"
		And Registro antiguedad laboral "30" años y "7" meses 1
		And Espero 1 segundos
		And Reviso el detalle de deudas subir sustento 1
		#Temporal
	 	When Verifico si existe error en filtro evaluacion financiera
	 	#Temporal
		When Doy click en guardar datos 1
		And Acepto para sobreescribir datos originales 1
		And Verifico si existe error en consentimiento digital 1
		And Doy click en boton continuar 1
		
		#SECCION: INFORMACION LABORAL TITULAR
		When Cambio de iframe a default
		When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  When Cambio de iframe a "10 Información Laboral Titular"
	  When Doy click en boton editar 1
	  #Informacion laboral de titular
	  When Ingreso centro de trabajo "IDE SOLUTION"
	  When Ingreso ruc de centro de trabajo "12345689745"
	  And Elijo e ingreso telefono fijo informacion laboral "LIMA" "7894652"
	  And Ingreso celular 1 "987654321"
	  And Selecciono departamento laboral "LIMA"
	 	And Selecciono provincia laboral "LIMA"
	 	And Selecciono distrito laboral "SANTIAGO DE SURCO"
	 	And selecciono via laboral 1 "AVENIDA"
	 	And Ingreso direccion domiciliaria laboral "AV CAMINOS DEL INCA"
	 	And Ingreso numero de direccion domiciliaria laboral 1 "2412"	 	
	 	And Ingreso agrupacion laboral "Sin agrupacion"
	 	And Ingreso division laboral "Sin division"
	 	And Ingreso sub division laboral "Sin sub division"
	 	And Ingreso interior laboral 1 "Sin interior"
	 	#And Doy click en ubicar mapa laboral
	 	#Temporal
	 	#When Verifico si existe error en normalizar direccion
	 	#Temporal
	 	#Then Doy click en aceptar la ubicacion correcta en el mapa laboral
	 	
	 	#SECCION: INFORMACION LABORAL TITULAR
	 	#When Cambio de iframe a default
		#When Cambio de iframe a "Paso: Analizar Solicitud de Crédito"
	  #When Cambio de iframe a "10 Información Laboral Titular"
	 	And Selecciono tipo de referencia laboral "FRENTE A"
	 	And Ingreso la referencia laboral 1 "PARQUE DE LA AMISTAD"
	 	And Doy click en guardar datos 1
		And Acepto para sobreescribir datos originales 1
		And Verifico si existe error en consentimiento digital 1
		And Doy click en boton continuar 1
	  