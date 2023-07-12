#Author: ychiroque - jniquen
Feature: Escenario 1 - Como usuario quiero ingresar un DNI de un cliente y generar una solicitud de crédito para BPM

    		 #Modificar obligatoriamente los siguientes inputs:
	       #Usuario cotifed
	       #Contraseña cotifed
	       #Documento del cliente
	       #Seguros del cliente
	       #Importe a solicitar
	       #Dia de pago
	       #Campaña y plazo de cliente

  @web
  Scenario: CP001: Generar solicitud en Motor para Línea de producto  Efectivo 
				  				- Con llenado de datos adicionales 
				  				- Con seguros optativos 
				  				- Desembolso efectivo en tienda vendedor 
				  				- Plan A Desgravamen SDev 
				  				- Sin periodo de gracia y Desembolsar en BT
  	
  	#SECCIÓN: LOGIN			
    Given Ingreso a la pagina de cotifed
    When Ingreso mi usuario 'ychiroque'
		And Ingreso mi contraseña 'Sisepuede.2023'
		And Doy click en el boton ingresar
		And Valido que no haya sesiones abiertas
		
		#SECCIÓN: FILTRO
		When Selecciono tienda "CHICLAYO" 
		And Selecciono Tipo de documento "D.N.I."
		And Ingreso numero de documento "69205200"
		And Ingreso correo "correo_prueba@gmail.com"
		And Ingreso numero celular "924695269"
		When Doy click en filtrar
	 	And Confirmo alerta
	 
			 	#SECCIÓN: NBK-NO-RENIEC
				When Ingreso datos personales
				 | primer_nombre  |   segundo_nombre   |   apellido_paterno  |  apellido_materno |  sexo      |  estado_civil  |  fecha_nac   |
				 | Pedro          |   Carlos           |   Gonzales          |  Ramirez          |  MASCULINO |  SOLTERO(A)    |  12/12/1942  |
				When Ingreso informacion de vivienda
			   | departamento |  provincia  |  distrito  |  tipo_vivienda  |
			   | LAMBAYEQUE   |  CHICLAYO   |  CHICLAYO  |  FAMILIAR       |   
			  When Ingreso informacion laboral
			   | situacion            | ocupacion |  ingreso  |  ant_laboral_anios | ant_laboral_meses |
			   | FORMAL - DEPENDIENTE | ABOGADO   |  20000     |  20                | 11                |
	      #SECCIÓN: NBK-RENIEC
			   When Ingreso informacion de vivienda nbk
			   	|  departamento  |  provincia  |  distrito  |  tipo_de_vivienda |
			   	|  LIMA          |  LIMA       |  BARRANCO  |  PROPIA           |
			   	
			   When Ingreso informacion laboral nbk
			   	|       perfil            |  ocupacion  | ingreso | anti_anios | anti_mese |
			   	| FORMAL - INDEPENDIENTE  | FUNCIONARIO | 20000    |     10     |    11     |
	 #SECCIÓN: LINEA DE PRODUCTO
	 When Selecciono linea de producto "EFECTIVO"
	 And Confirmo alerta
	 When Doy click en continuar
	 
   #SECCIÓN: OFERTA COMERCIAL
   When Valido que se recupero ingreso vigente
 	 And Valido seguros marcados
 	 And Selecciono seguros
	 |seguros|
	 #|Seguro de Salud 12 Meses|
	 #|Seguro de Salud 24 Meses|
	 #|Seguro de Salud 36 Meses|
	 #|Seguro de Salud 48 Meses|
	 #|Seguro de Salud 60 Meses|
	 #|Contigo Familia plan Básico|
	 |Contigo Familia plan Plus|
	 #|Accidentes Personales|
	 #|Seguro Oncológico|
	 And Titular selecciono estado civil "SOLTERO(A)"
	 And Confirmo alerta
	 And Titular selecciono pais "PERU"
	 And Titular selecciono tipo de vivienda "PROPIA"
	 And Titular ingreso antiguedad domicialiaria en años "45"
	 And Titular ingreso antiguedad domicialiaria en meses "11"
	 And Titular ingreso declarado "8000"
	 And Titular doy check a usar ingreso declarado
	 And Confirmo alerta
   And Titular ingreso situacion "FORMAL - DEPENDIENTE"
   And Titular ingreso ocupacion "ABOGADO"
	 And Titular ingreso antiguedad laboral en años "50"
	 And Titular ingreso antiguedad laboral en meses "4"
	 And Titular ingreso cantidad a solicitar "2500"
	 And Titular selecciono fecha de pago "3 de cada mes"
	 And Doy click en el boton simular
	 When Elijo campaña "EFE_PROD_EFECTIVO_3" con plazo "12 meses"
	 And Doy click en el boton continuar

	 #SECCIÓN: CONFIRMACIÓN DE SOLICITUD
	 And Elijo tipo de desembolso "Desembolso de efectivo en tienda vendedor"
	 And Selecciono requisito y cargo archivo
	 And Ingreso referencias telefonicas
	     | parentesco| nombres | apellidos | prefijo    | telefono_fijo | celular  |
		   | AMIGO     | Pedro   | LLanos    |  01-LIMA   | 454545        | 924695268|
		
	 #SECCION: DATOS ADICIONALES   
   And Doy click en el boton continuar datos adicionales
   And Ingreso correo de datos principales "correo_prueba@gmail.com"
   And Ingreso numero de celular de datos principales "924695269"
   And Selecciono prefijo de datos principales "01-LIMA"
   And Ingreso numero de telefono fijo de datos principales "454787"
   #Domicilio
   And Selecciono departamento de informacion domiciliaria "LIMA"
   And Selecciono provincia de informacion domiciliaria "LIMA"
   And Selecciono distrito de informacion domiciliaria "SANTIAGO DE SURCO"
   And Ingreso avenida de informacion domiciliaria "Av. Caminos del inca 2461"
   #And Doy click en confirmar geopoint de informacion domiciliaria
   And Selecciono referencia de informacion domiciliaria "PASANDO DEL"
   And Ingreso descripcion de informacion domiciliaria "Parque de la amistad"
   #Laboral
   And Ingreso nombre centro de informacion laboral "FINANCIERA EFECTIVA S.A."
   And Selecciono prefijo de informacion laboral "01-LIMA"
   And Ingreso numero de telefono fijo de informacion laboral "754787"
   And Ingreso celular de informacion laboral "974695869"
   And Ingreso ruc de centro de informacion laboral "20605554114"
   And Selecciono departamento de informacion laboral "LIMA"
   And Selecciono provincia de informacion laboral "LIMA"
   And Selecciono distrito de informacion laboral "SANTIAGO DE SURCO"
   And Ingreso avenida de informacion laboral "Av. Caminos del inca 2461"
   #And Doy click en confirmar geopoint de informacion laboral
   And Selecciono referencia de informacion laboral "PASANDO DEL"
   And Ingreso descripcion de informacion laboral "Parque de la amistad"
	 
	 #SECCION: OBTENER NUMERO DE SOLICITUD
	 And Obtengo el numero de solicitud 
	 And Doy click en el boton solicitar
	 Then Termino la solicitud