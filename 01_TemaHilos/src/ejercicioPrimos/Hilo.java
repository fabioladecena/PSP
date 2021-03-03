package ejercicioPrimos;

import java.util.Date;

public class Hilo implements Runnable{
	private int numero;

	public Hilo(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void run() {
		Date date = new Date();
		double tiempoInicial = date.getTime();
		System.out.println("Soy el hilo: " + Thread.currentThread().getName() + " llevo el numero: " + numero);
		boolean prime = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				prime = false;
				break;
			}
		}
		
		Date date2 = new Date();
		double tiempoFinal = date2.getTime();
		double tiempoTotal = tiempoFinal - tiempoInicial;

		if (prime) {
			System.out.println("Soy el hilo: " + Thread.currentThread().getName() + " y mi numero: " + numero
					+ " es Primooooooo" + " y mi tiempo es: " + tiempoTotal + " milisegundos");
		} else {
			System.out.println("Soy el hilo: " + Thread.currentThread().getName() + " y mi numero: " + numero
					+ " NO es Primoooooo" + " y mi tiempo es: " + tiempoTotal + " milisegundos");
		}
	}
}
