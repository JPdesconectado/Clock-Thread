package Thread;

public class Alarme extends Thread{
	
	public static void verifica() {
		
	if (Singleton.hora == Principal.hor && Singleton.minuto == Principal.min && Principal.flag == 1) {
		System.out.println("AAAAAAAAAAAAAAAAAAAA TA NA HORAAAAAAAAAAAAAAAAAAAAAAAAA");
		Principal.hor = 0;
		Principal.min = 0;
	}
	}
}
