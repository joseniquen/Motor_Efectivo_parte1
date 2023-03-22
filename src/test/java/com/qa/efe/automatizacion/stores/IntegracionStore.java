package com.qa.efe.automatizacion.stores;

public class IntegracionStore implements Store {
	public String cuenta;
	public String tipo_documento;
	public int iframe;
	public int registro_operaciones;
	public int carga_archivos;
	public int captura_incremental_cotifed;
	public int captura_incremental_cretifed;
	public String dni;
	@Override
	public void reset() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
		carga_archivos=0;
		captura_incremental_cotifed=1;
		captura_incremental_cretifed=1;
		dni="";
	}
	public IntegracionStore() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
		carga_archivos=0;
		dni="";
		captura_incremental_cotifed=1;
		captura_incremental_cretifed=1;
	}
	
	
}
