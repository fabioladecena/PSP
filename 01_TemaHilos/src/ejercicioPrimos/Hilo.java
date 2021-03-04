package ejercicioPrimos;

import java.util.Date;

public class Hilo implements Runnable {
	private int numero;

	public Hilo(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {

		Date date = new Date();
		double tInicial = date.getTime();

		int count = 0;

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				count++;
			}
		}

		if (count == 2) {
			System.out.println("El numero " + numero + " es Primo");
		} else {
			System.out.println("El numero " + numero + " no es Primo");
		}
		
		Date date2 = new Date();
		double tFinal = date2.getTime();
		
		System.out.println("El hilo tardó "+ Thread.currentThread().getName() + (tFinal-tInicial) + " milisegundos");
	}
}
