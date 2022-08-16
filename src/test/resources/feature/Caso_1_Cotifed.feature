#Author: ychiroque - jniquen - fsosa - dcruz
Feature: Caso 1

    #Modificar obligatoriamente los siguientes inputs:
        #Usuario cotifed
        #Contraseña cotifed
        #Documento del cliente
        #Seguros del cliente
        #Importe a solicitar
        #Dia de pago
        #Campaña y plazo de cliente

  @web
  Scenario: Línea de producto  Efectivo
  				- Con llenado de datos adicionales 
  				- Con seguros optativos 
  				- Desembolso efectivo en tienda vendedor 
  				- Plan A Desgravamen SDev 
  				- Sin periodo de gracia
  				
    Given Abrir login cotifed
    Then Ingreso el usuario 'ext_fsosa'
		And Ingreso la contraseña 'Efectiva.2022'
		And doy click en el boton ingresar
		When Cargando datos espere...
		And valido que no haya sesiones abiertas
		#seccion de filtro
		When Cargando datos espere...
		Then Selecciono tienda "CHICLAYO" 
		And Selecciono Tipo de documento "D.N.I."
		And Ingreso numero de documento "04645301"
		When Cargando datos espere...
		And Ingreso correo "correo_prueba@gmail.com"
		And Ingreso numero celular "924695269"
		When Doy click en filtrar
		When Cargando datos espere...
		
	 #seccion de linea de producto
	 And Confirmacion de alerta
	 
	 #seccion nbk-no-reniec
		
		Then Ingreso datos personales
		 | primer_nombre  |   segundo_nombre   |   apellido_paterno  |  apellido_materno |  sexo      |  estado_civil  |  fecha_nac   |
		 | Pedro          |   Carlos           |   Gonzales          |  Ramirez          |  MASCULINO |  SOLTERO(A)    |  12/12/1942  |
		
		Then Ingreso informacion de vivienda
	   | departamento |  provincia  |  distrito  |  tipo_vivienda  |
	   | LAMBAYEQUE   |  CHICLAYO   |  CHICLAYO  |  FAMILIAR       |
	   
	   Then Ingreso informacion laboral
	   | situacion            | ocupacion |  ingreso  |  ant_laboral_anios | ant_laboral_meses |
	   | FORMAL - DEPENDIENTE | ABOGADO   |  3000     |  20                | 11                |
	 
	 And selecciono linea de producto "EFECTIVO"
	 And Confirmacion de alerta
	 When Cargando datos espere...
	 Then dar click en Continuar
   When Cargando datos espere...
   
   #seccion de oferta comercial
   When Validar que se recupero ingreso vigente
   When Cargando datos espere...
 	 #Seguros|#Seguro de Salud 12 Meses|#Seguro de Salud 24 Meses|#Seguro de Salud 36 Meses|#Seguro de Salud 48 Meses
	 #Seguro de Salud 60 Meses|#Multirriesgo Electro|#Contigo Familia plan Básico|#Contigo Familia plan Plus
	 #Accidentes Personales|#Seguro Oncológico 
 	 And Validar seguros marcados
 	 And Selecciono seguros
	 |seguros|
	 |Seguro de Salud 12 Meses|
	 |Seguro Oncológico|
	 And Titular selecciono estado civil "SOLTERO(A)"
	 And Confirmacion de alerta
	 And Titular selecciono pais "PERU"
	 And Titular selecciono tipo de vivienda "PROPIA"
	 And Titular ingreso Ant Dom Años "45"
	 And Titular ingreso Ant Dom Meses "11"
	 And Titular ingreso declarado "8000"
   When Cargando datos espere...
	 And Titular doy check a Usar Ingreso Declarado
   When Cargando datos espere...
   And Titular ingreso situacion "FORMAL - DEPENDIENTE"
   When Cargando datos espere...
   And Titular ingreso ocupacion "ABOGADO"
   When Cargando datos espere...
	 And Titular ingreso Ant Lab Años "50"
	 And Titular ingreso Ant Lab Meses "4"
	 #And Titular ingreso inicial "0"
	 And Titular ingreso cantidad a solicitar "2000"
	 And Titular fecha de pago "3 de cada mes"
	 When Cargando datos espere...
	 And Doy click en el boton simular
   When Cargando datos espere...
	 When Elijo campaña "EFE_PROD_EFECTIVO_3" con plazo "12 meses"
	 When Cargando datos espere...
	 And Doy click en el boton continuar
	 When Cargando datos espere...
	 #seccion confirmacion de solicitud
	 #Abono en Cuenta de Ahorros titular|#Tarjeta prepagada
	 #Desembolso de efectivo en tienda vendedor|#Desembolso en otra tienda
	 And Elijo tipo de desembolso "Desembolso de efectivo en tienda vendedor"
	 And Selecciono requisito y cargo archivo
	 And Ingreso referencias telefonicas
	     | parentesco| nombres | apellidos | prefijo    | telefono_fijo | celular  |
		   | AMIGO     | Juan    | Perez     |  01-LIMA   | 454545        | 924695269|
		   | HERMANO   | Carlos  | Peralta   |  01-LIMA   | 464646        | 984695268|
	  #seccion datos adicionales
   And Doy click en el boton continuar datos adicionales
   And Ingreso correo de datos principales "correo_prueba@gmail.com"
   And Ingreso numero de celular de datos principales "924695269"
   And Selecciono prefijo de datos principales "01-LIMA"
   And Ingreso numero de telefono fijo de datos principales "454787"
   #Domicilio
   And Selecciono departamento de info domiciliaria "LIMA"
   And Selecciono provincia de info domiciliaria "LIMA"
   And Selecciono distrito de info domiciliaria "SANTIAGO DE SURCO"
   And Ingreso avenida de info domiciliaria "Av. Caminos del inca 2461"
   #When Cargando datos espere...
   When esperar 10 segundos
   And Doy click en confirmar geopoint de info domiciliaria
   And Retornar al iframe por defecto
   When esperar 2 segundos
   And Selecciono referencia de info domiciliaria "PASANDO DEL"
   And Ingreso descripcion de info domiciliaria "Parque de la amistad"
   #Laboral
   And Ingreso nombre centro de info laboral "FINANCIERA EFECTIVA S.A."
   And Selecciono prefijo de info laboral "01-LIMA"
   And Ingreso numero de telefono fijo de info laboral "754787"
   And Ingreso celular de info laboral "974695869"
   And Ingreso ruc de centro de info laboral "20605554114"
   And Selecciono departamento de info laboral "LIMA"
   And Selecciono provincia de info laboral "LIMA"
   And Selecciono distrito de info laboral "SANTIAGO DE SURCO"
   And Ingreso avenida de info laboral "Av. Caminos del inca 2461"
   #When Cargando datos espere...
   When esperar 10 segundos
   And Doy click en confirmar geopoint de info laboral
   And Retornar al iframe por defecto
   When esperar 2 segundos
   And Selecciono referencia de info laboral "PASANDO DEL"
   And Ingreso descripcion de info laboral "Parque de la amistad"
	 #When esperar 5 segundos 
	 And Obtener numero de solicitud 
	 And Doy click en el boton solicitar
	 When Terminar solicitud