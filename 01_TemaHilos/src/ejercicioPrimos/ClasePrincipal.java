package ejercicioPrimos;

import java.util.Scanner;

public class ClasePrincipal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer numero");
		int num1 = sc.nextInt();
		System.out.println("Segundo numero");
		int num2 = sc.nextInt();
		System.out.println("Tercer numero");
		int num3 = sc.nextInt();
		
		Hilo hilo1 = new Hilo(num1);
		Thread t1 = new Thread(hilo1,"Hilo 1");
		
		Hilo hilo2 = new Hilo(num2);
		Thread t2 = new Thread(hilo2,"Hilo 2");
		
		Hilo hilo3 = new Hilo(num3);
		Thread t3 = new Thread(hilo3,"Hilo 3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
