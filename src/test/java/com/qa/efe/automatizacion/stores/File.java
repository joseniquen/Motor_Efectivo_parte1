package com.qa.efe.automatizacion.stores;

import java.io.IOException;
import java.io.PrintWriter;
public class File {
	public void cargarDatos(String dni, String solicitud) {
		solicitud = solicitud.replace("N°. Cotización: ", ""); 
		String fileName = "target/cliente_"+dni+"_"+solicitud+".txt";
	    String encoding = "UTF-8";
	    try{
	    PrintWriter writer = new PrintWriter(fileName, encoding);
	    writer.println("DNI: "+dni);
	    writer.println("N°. Cotización: "+solicitud);
	    writer.close();
	    }
	    catch (IOException e){
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
