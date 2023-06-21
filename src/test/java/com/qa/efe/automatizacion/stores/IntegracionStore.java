package com.qa.efe.automatizacion.stores;

public class IntegracionStore implements Store {
	public int captura_incremental_cotifed;
	public int captura_incremental_cretifed;
	public String cuenta;
	public String tipo_documento;
	public int iframe;
	public int registro_operaciones;
	public int carga_archivos;
	public String dni;
	//domiciliaria titular
	public String departamentoDomTitular;
	public String provinciaDomTitular;
	public String distritoDomTitular;
	//info laboral titular
	public String centroTrabajolaboral;
	public String rucCentroTrabajolaboral;
	public String DeptotelFijoLaboral;
	public String telFijoLaboral;
	public String celLaboral;
	public String departamentoLaboralTitular;
	public String provinciaDomLaboralTitular;
	public String distritoDomLaboralTitular;
	//domiciliaria titular aval
	public String tipoPropiedadDomTitularAval;
	public String antiguedadAnioDomTitularAval;
	public String antiguedadMesDomTitularAval;
	public String departamentoDomTitularAval;
	public String provinciaDomTitularAval;
	public String distritoDomTitularAval;
	//info laboral titular aval
	public String centroTrabajolaboralAval;
	public String rucCentroTrabajolaboralAval;
	public String DeptotelFijoLaboralAval;
	public String telFijoLaboralAval;
	public String celLaboralAval;
	public String departamentoLaboralTitularAval;
	public String provinciaDomLaboralTitularAval;
	public String distritoDomLaboralTitularAval;
	@Override
	public void reset() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
		carga_archivos=0;
		dni="";
		departamentoDomTitular="";
		provinciaDomTitular="";
		distritoDomTitular="";
		centroTrabajolaboral="";
		rucCentroTrabajolaboral="";
		DeptotelFijoLaboral="";
		telFijoLaboral="";
		celLaboral="";
		departamentoLaboralTitular="";
		provinciaDomLaboralTitular="";
		distritoDomLaboralTitular="";
		departamentoDomTitularAval="";
		provinciaDomTitularAval="";
		distritoDomTitularAval="";
		centroTrabajolaboralAval="";
		rucCentroTrabajolaboralAval="";
		DeptotelFijoLaboralAval="";
		telFijoLaboralAval="";
		celLaboralAval="";
		departamentoLaboralTitularAval="";
		provinciaDomLaboralTitularAval="";
		distritoDomLaboralTitularAval="";
		captura_incremental_cotifed=1;
		captura_incremental_cretifed=1;
	}
	public IntegracionStore() {
		tipo_documento="";
		cuenta = "";
		iframe= 1;
		registro_operaciones= 0;
		carga_archivos=0;
		dni="";
		departamentoDomTitular="";
		provinciaDomTitular="";
		distritoDomTitular="";
		centroTrabajolaboral="";
		rucCentroTrabajolaboral="";
		DeptotelFijoLaboral="";
		telFijoLaboral="";
		celLaboral="";
		departamentoLaboralTitular="";
		provinciaDomLaboralTitular="";
		distritoDomLaboralTitular="";
		departamentoDomTitularAval="";
		provinciaDomTitularAval="";
		distritoDomTitularAval="";
		centroTrabajolaboralAval="";
		rucCentroTrabajolaboralAval="";
		DeptotelFijoLaboralAval="";
		telFijoLaboralAval="";
		celLaboralAval="";
		departamentoLaboralTitularAval="";
		provinciaDomLaboralTitularAval="";
		distritoDomLaboralTitularAval="";
		captura_incremental_cotifed=1;
		captura_incremental_cretifed=1;
	}
	
	
}
