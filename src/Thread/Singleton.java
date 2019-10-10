package Thread;

public class Singleton {

	 private static Singleton uniqueInstance = new Singleton();

	 public static int hora;
	 public static int minuto;
	 public static int segundo;
	 public static int crHour;
	 public static int crMin;
	 public static int crSec;
	 private Singleton() {
			hora = 0;
			minuto = 0;
			segundo = 0;
			crHour = 0;
			crMin = 0;
			crSec = 0;
	    }
	 
	    public static Singleton getInstance() {
	        return uniqueInstance;
	    }
	    
	}