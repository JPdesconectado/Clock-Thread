package Thread;

import java.util.Scanner;
import Thread.Singleton;

public class Principal {

	static Scanner teclado = new Scanner(System.in);
	static int op = 0;
	static int flag = 0;
	static int hor;
	static int min;
	public static void main(String[] args) throws InterruptedException{
		
		Relogio hr = new Relogio();
		Thread thr = new Thread(hr);
		thr.start();
		Cronometro cr = new Cronometro();
		Thread tcr = new Thread(cr);
		

			if (Singleton.hora == hor && Singleton.minuto == min && flag == 1) {
				System.out.println("AAAAAAAAAAAAAAAAAAAA TA NA HORAAAAAAAAAAAAAAAAAAAAAAAAA");
				hor = 0;
				min = 0;
				Thread.sleep(5000);
			}			
		while(true) {		
		System.out.println("------- Menu: -------");
		System.out.println("1 - Ajustar Horário:");
		System.out.println("2 - Visualizar Horário:");
		System.out.println("3 - Iniciar Cronômetro:");
		System.out.println("4 - Parar Cronômetro:");
		System.out.println("5 - Zerar Cronômetro:");
		System.out.println("6 - Definir Alarme:");
		op = teclado.nextInt();
		
		
		switch(op) {
		
		case 1:
			System.out.println("Digite a hora:");
			Singleton.hora = teclado.nextInt();
			System.out.println("Digite os minutos:");
			Singleton.minuto = teclado.nextInt();
			System.out.println("Digite os segundos:");
			Singleton.segundo = teclado.nextInt();
			System.out.println("Horario Atualizado!");
			break;
			
		case 2:	
			formatar();
			break;
			
		case 3:
			
			if (tcr.isAlive() && tcr.isInterrupted()) {
				System.out.println("Cronômetro rodando");
			//	Singleton.crHour = hor;
			//	Singleton.crMin = min;
			//	Singleton.crSec = seg;
				synchronized(tcr) {

					tcr.notify();
				}
				
				cronometroFormato();
			}else {
				tcr.start();
				System.out.println("Cronômetro iniciado");

			}
			
			break;
			
		case 4:
			synchronized (tcr) {
				tcr.wait();
			}
			System.out.println("Cronômetro parado");
			cronometroFormato();
			break;
			
		case 5:
			System.out.println("Cronômetro zerado");
			cronometroFormato();
			break;
			
		case 6:
			
			System.out.println("Digite a hora:");
			hor = teclado.nextInt();
			System.out.println("Digite os minutos:");
			min = teclado.nextInt();
			System.out.println("Alarme Setado!");
			flag = 1;
			break;
		}
		
		}
		
		
	}
	
	static void formatar() {
		
    	if (Singleton.hora < 10) {
    		System.out.print("0" + Singleton.hora + ":");

    	}else {
    		System.out.print(Singleton.hora + ":");

    	}
    	
    	if (Singleton.minuto < 10) {
    		System.out.print("0" + Singleton.minuto + ":");

    	}else {
    		System.out.print(Singleton.minuto + ":");

    	}
    	
    	if (Singleton.segundo < 10) {
    		System.out.print("0" + Singleton.segundo + "\n");

    	}else {
    		System.out.print(Singleton.segundo + "\n");
	
    	}
	}
	
	static void cronometroFormato() {
		if (Singleton.crHour< 10) {
    		System.out.print("0" + Singleton.crHour + ":");

    	}else {
    		System.out.print(Singleton.crHour + ":");

    	}
    	
    	if (Singleton.crMin < 10) {
    		System.out.print("0" + Singleton.crMin + ":");

    	}else {
    		System.out.print(Singleton.crMin + ":");

    	}
    	
    	if (Singleton.crSec  < 10) {
    		System.out.print("0" + Singleton.crSec + "\n");

    	}else {
    		System.out.print(Singleton.crSec  + "\n");
	
    	}
   
	}
}
