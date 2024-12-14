package lector;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {

		IconoMensajes Ico = new IconoMensajes();
		Ico.generarIcono();

		LocalDate fechahoy = LocalDate.now();
		LocalDate fechaCad = LocalDate.of(2021, Month.DECEMBER, 11);

		if (fechahoy.equals(fechaCad)) {
			System.out.println("fechas iguales");
			JOptionPane.showMessageDialog(null, "Error");
			System.exit(0);
		} else {
			Lector fileChangeWatcher = new Lector();
			try {
				fileChangeWatcher.doWath("C:\\QCX");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
