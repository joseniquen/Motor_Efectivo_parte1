package com.qa.efe.automatizacion.stores;

public class IntegracionStore implements Store {
	public String cuenta;
	public String tipo_documento;
	public int iframe;
	public int registro_operaciones;
	public int carga_archivos;
	public String dni;
	@Override
	public void reset() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
		carga_archivos=0;
		dni="";
	}
	public IntegracionStore() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
		carga_archivos=0;
		dni="";

	}
	
	
}
