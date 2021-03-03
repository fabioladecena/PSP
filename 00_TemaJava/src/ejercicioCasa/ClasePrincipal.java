package ejercicioCasa;

import java.util.ArrayList;

public class ClasePrincipal {
	public static void main(String[] args) {

		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		ArrayList<Persona> inquilinos = new ArrayList<Persona>();

		Direccion d1p = new Direccion("Calle", "La Peseta", "27568");
//		Direccion d2p = new Direccion("Avd.", "El Euro", "21534");
		Direccion d1c = new Direccion("Calle", "La Tonteria", "23741");
//		Direccion d2c = new Direccion("Calle","El Espacio","22967");

		Persona pd1 = new Persona("Alfredo", 47, "654879521", d1p, "56876541S");
//		Persona pd2 = new Persona("Ramon",54,"654123521",d2p,"54231541J");
//		Persona pi1 = new Persona("Estaquio",66,"631429521",d1p,"36576541A");
		Persona pi2 = new Persona("Isabel", 34, "696578521", d1c, "98746541D");
		Persona pi3 = new Persona("Roberto", 37, "651234521", d1c, "46126541L");

		Habitacion h1 = new Habitacion(65.10, "salon", 1);
		Habitacion h2 = new Habitacion(25.15, "cocina", 1);
		Habitacion h3 = new Habitacion(35.10, "dormitorio", 3);
		Habitacion h4 = new Habitacion(15, "baño", 2);

		habitaciones.add(h1);
		habitaciones.add(h2);
		habitaciones.add(h3);
		habitaciones.add(h4);

		inquilinos.add(pi2);
		inquilinos.add(pi3);

		Casa c1 = new Casa(140.35, habitaciones, pd1, d1c, inquilinos, 980.55);

		System.out.println(c1);
	}
}
