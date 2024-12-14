package lector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class modificador {

	public void ModificarArchivo(String texto, String Archivo) {

		String fecha = "", hora = "", Molino = "", ID = "", Silo = "", Muestra = "", ArchivoFinal = "";

		String[] arregloString = texto.split("\n");
		// variable para verificar si es crudo
		Muestra = arregloString[1].substring(2, 14);
		// System.out.println(Muestra);

		if (Muestra.equals("HARINA CRUDA")) {

			fecha = arregloString[1].substring(34, 42);
			hora = arregloString[1].substring(42, 47);
			Molino = "M2";
			ID = arregloString[1].substring(63, 73);
			Silo = "1.00";

			arregloString[1] = "S CRUT    " + fecha + hora + Molino + "    852                               " + ID
					+ "       ";
			arregloString[2] = "A CRUDOprensaNVA                                                                ";
			arregloString[3] = "D 10 CRUDOpren C000                 " + Silo + "   " + Silo
					+ "                                 ";
			arregloString[12] = "C Cl    0.00000 %    Cl           0.6589 120.0 0.8626 0.0000 8000               ";
			arregloString[13] = "C F     0.00000 %    F            0.1789 120.0 0.9518 0.0000 C000               ";
			arregloString[14] = "";
			arregloString[15] = "";
			arregloString[16] = "";
			arregloString[17] = "";
			arregloString[18] = "";
			arregloString[19] = "";
			arregloString[20] = "";
			// Recorrer array
			for (int x = 1; x < 14; x++) {
				System.out.println(arregloString[x]);
				ArchivoFinal = ArchivoFinal + arregloString[x] + "\r\n";
			}

			
			String fechita = fecha.replace(".", "_");
			String horita = hora.replace(":", "_");
			try {
				//String ruta = "C:\\QCX2\\CRUT" + fechita + "-" + horita + ".QAN";
			
				String ruta = "\\\\QCX1883SVR01\\FLSA_SuperQXRF\\CRUT"+ fechita + "-" + horita + ".QAN";
				File file = new File(ruta);
				// Si el archivo no existe es creado
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(ArchivoFinal);
				System.out.println(ArchivoFinal);
				bw.close();

				File fichero = new File(Archivo);

				if (fichero.delete())
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				else
					System.out.println("El fichero no puede ser borrado");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			File fichero = new File(Archivo);

			if (fichero.delete())
				System.out.println("El fichero ha sido borrado satisfactoriamente");
			else
				System.out.println("El fichero no puede ser borrado");
		}

	}

}
