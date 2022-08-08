package com.qa.efe.automatizacion.stores;

public class IntegracionStore implements Store {
	public String cuenta;
	public String tipo_documento;
	public int iframe;
	public int registro_operaciones;
	@Override
	public void reset() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
	}
	public IntegracionStore() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;

	}
	
	
}
