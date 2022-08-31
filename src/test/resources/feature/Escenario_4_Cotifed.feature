#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Escenario 4 - Como usuario quiero ingresar un DNI de un cliente y generar una solicitud de crédito para BPM

    		 #Modificar obligatoriamente los siguientes inputs:
	       #Usuario cotifed
	       #Contraseña cotifed
	       #Documento del cliente
	       #Seguros del cliente
	       #Importe a solicitar
	       #Dia de pago
	       #Campaña y plazo de cliente

  @web
  Scenario: EP004: Línea de producto  Efectivo 
  								 - Sin llenado de datos adicionales 
  								 -  Sin seguros > a 78 años 
  								 - Abono en cuentas de ahorro titular 
  								 - Sin periodo de gracia
  	
  	#SECCIÓN: LOGIN			
    Given Ingreso a la pagina de cotifed
    When Ingreso mi usuario 'ext_fsosa'
		And Ingreso mi contraseña 'Efectiva.2022'
		And Doy click en el boton ingresar
		And Valido que no haya sesiones abiertas
		
		#SECCIÓN: FILTRO
		When Selecciono tienda "CHICLAYO" 
		And Selecciono Tipo de documento "D.N.I."
		And Ingreso numero de documento "92635372"
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
			   | FORMAL - DEPENDIENTE | ABOGADO   |  3000     |  20                | 11                |
	   	  #SECCIÓN: NBK-RENIEC
			   When Ingreso informacion de vivienda nbk
			   	|  departamento  |  provincia  |  distrito  |  tipo_de_vivienda |
			   	|  LIMA          |  LIMA       |  BARRANCO  |  PROPIA           |
			   	
			   When Ingreso informacion laboral nbk
			   	|       perfil            |  ocupacion  | ingreso | anti_anios | anti_mese |
			   	| FORMAL - INDEPENDIENTE  | FUNCIONARIO | 3000    |     10     |    11     |
	 #SECCIÓN: LINEA DE PRODUCTO
	 When Selecciono linea de producto "EFECTIVO"
	 And Confirmo alerta
	 When Doy click en continuar
	 
   #SECCIÓN: OFERTA COMERCIAL
   When Valido que se recupero ingreso vigente
	 And Titular selecciono estado civil "SOLTERO(A)"
	 And Confirmo alerta
	 And Titular selecciono pais "PERU"
	 And Titular selecciono tipo de vivienda "PROPIA"
	 And Titular ingreso antiguedad domicialiaria en años "45"
	 And Titular ingreso antiguedad domicialiaria en meses "11"
	 And Titular ingreso declarado "8000"
	 And Titular doy check a usar ingreso declarado
   And Titular ingreso situacion "FORMAL - DEPENDIENTE"
   And Titular ingreso ocupacion "ABOGADO"
	 And Titular ingreso antiguedad laboral en años "50"
	 And Titular ingreso antiguedad laboral en meses "4"
	 And Titular ingreso cantidad a solicitar "2000"
	 And Titular selecciono fecha de pago "15 de cada mes"
	 And Doy click en el boton simular
	 When Elijo campaña "EFE_PROD_EFECTIVO_3" con plazo "6 meses"
	 And Titular selecciono requisito "AVAL"
	 And Doy click en el boton continuar

	 #SECCIÓN: CONFIRMACIÓN DE SOLICITUD
	 And Elijo tipo de desembolso "Abono en Cuenta de Ahorros titular"
	 And Selecciono la entidad tipo "EFECTIVA"
	 And Ingreso numero titular
	 And Ingreso numero de cuenta "19496386122018" y CCI "00219419638612201795"
	 And Valido la observación de la edad del titular
	 And Selecciono requisito y cargo archivo
	 And Ingreso referencias telefonicas
	     | parentesco| nombres | apellidos | prefijo    | telefono_fijo | celular  |
		   | AMIGO     | Pedro   | LLanos    |  01-LIMA   | 454545        | 924695268|
	 
	 #SECCION: OBTENER NUMERO DE SOLICITUD
	 And Obtengo el numero de solicitud 
	 And Doy click en el boton solicitar
	 Then Termino la solicitud