package lector;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class Main {
	
	private static final Logger Log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		
		

		IconoMensajes Ico = new IconoMensajes();
		Ico.generarIcono();
		
		Lector fileChangeWatcher = new Lector();
		try {
			fileChangeWatcher.doWath("C:\\QCX");
		} catch (IOException e) {
			Log.info(e);
			e.printStackTrace();
		}
	}

}
