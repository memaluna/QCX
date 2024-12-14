package lector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Generador {

	public String leerArchivo(String archivo, String directorio) {
		
		String texto = "", archivo2 = "";
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			System.out.println(directorio + "\\" + archivo);
			archivo2 = directorio + "\\" + archivo;
			file = new File(directorio + "\\" + archivo);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				texto = texto + "\n" + linea;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			
		return texto;
	}
}
