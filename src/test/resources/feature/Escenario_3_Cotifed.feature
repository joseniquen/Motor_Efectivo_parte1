#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Escenario 3 - Como usuario quiero ingresar un DNI de un cliente y generar una solicitud de crédito para BPM

    		 #Modificar obligatoriamente los siguientes inputs:
	       #Usuario cotifed
	       #Contraseña cotifed
	       #Documento del cliente
	       #Seguros del cliente
	       #Documento del cónyuge
	       #Importe a solicitar
	       #Dia de pago
	       #Campaña y plazo de cliente

  @web
  Scenario: EP003: Línea de producto  Efectivo 
  								 - Con llenado de datos adicionales 
  								 - Con seguros optativos 
  								 - Abono en cuentas de ahorro titular 
  								 - DELIVERY 
  								 - Con cónyuge 
  								 - Plan B Desgravamen CDev 
  								 - Con periodo de gracia
  	
  	#SECCIÓN: LOGIN			
    Given Ingreso a la pagina de cotifed
    When Ingreso mi usuario 'ychiroque'
		And Ingreso mi contraseña 'Setiembre.2022'
		And Doy click en el boton ingresar
		And Valido que no haya sesiones abiertas
		
		#SECCIÓN: FILTRO
		When Selecciono tienda "CACERES" 
		And Selecciono Tipo de documento "D.N.I."
		And Ingreso numero de documento "00246824"
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
	   
	 #SECCIÓN: LINEA DE PRODUCTO
	 When Selecciono linea de producto "EFECTIVO"
	 And Confirmo alerta
	 When Doy click en continuar
	 
   #SECCIÓN: OFERTA COMERCIAL
   #Titular
   When Valido que se recupero ingreso vigente
 	 And Valido seguros marcados
 	 And Selecciono seguros
	 |seguros|
	 #|Seguro de Salud 12 Meses|
	 |Seguro de Salud 24 Meses|
	 #|Seguro de Salud 36 Meses|
	 #|Seguro de Salud 48 Meses|
	 #|Seguro de Salud 60 Meses|
	 |Contigo Familia plan Básico|
	 #|Contigo Familia plan Plus|
	 #|Accidentes Personales|
	 #|Seguro Oncológico|
	 And Titular selecciono estado civil "CASADO(A)"
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
	 #Conyuge
	 And Conyuge selecciono tipo de documento "D.N.I."
	 And Conyuge ingreso numero de documento "75252602"
	 And Conyuge doy click en filtrar
	 And Conyuge selecciono estado civil "CASADO(A)"
	 And Conyuge selecciono departamento "LIMA"
	 And Conyuge selecciono provincia "LIMA"
	 And Conyuge selecciono distrito "SANTIAGO DE SURCO"
	 And Conyuge selecciono tipo de vivienda "PROPIA"
	 And Conyuge ingreso antiguedad domiciliaria en años "45"
	 And Conyuge ingreso antiguedad domiciliaria en meses "11"
	 And Conyuge selecciono perfil situacion "FORMAL - DEPENDIENTE" 
	 And Conyuge selecciono ocupacion "ABOGADO"
	 And Conyuge ingreso ingreso "8000"
	 And Conyuge ingreso antiguedad laboral en años "25"
	 And Conyuge ingreso antiguedad laboral en meses "11"
	 #Titular
	 And Titular ingreso cantidad a solicitar "5000"
	 And Titular selecciono fecha de pago "3 de cada mes"
	 