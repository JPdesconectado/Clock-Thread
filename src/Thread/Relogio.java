package Thread;

import Thread.Singleton;

public class Relogio implements Runnable {

	public void run() {

        while(true){
        	
        	if (Singleton.segundo < 60) {
        		Singleton.segundo++;
        	}else {
        		Singleton.segundo = 0;
        		if (Singleton.minuto < 60) {
        			Singleton.minuto++;
        		}else {
        			Singleton.minuto = 0;
        			if (Singleton.hora < 24) {
        				Singleton.hora++;
        			}else {
        				Singleton.hora = 0;
        			}
        			
        		}
        	}

        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
 	
			Alarme.verifica();
        }
        
    }
}
