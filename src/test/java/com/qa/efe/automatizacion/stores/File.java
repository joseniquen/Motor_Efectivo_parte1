package com.qa.efe.automatizacion.stores;

import java.io.IOException;
import java.io.PrintWriter;
public class File {
	public void cargarDatos(String dni, String solicitud) {
		String fileName = "target/cliente_"+dni+".txt";
	    String encoding = "UTF-8";
	    try{
	    PrintWriter writer = new PrintWriter(fileName, encoding);
	    writer.println("DNI: "+dni);
	    writer.println(solicitud);
	    writer.close();
	    }
	    catch (IOException e){
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
