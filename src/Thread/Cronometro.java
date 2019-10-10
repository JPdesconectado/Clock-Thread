package Thread;

import Thread.Singleton;

public class Cronometro implements Runnable {
	
	public void run() {
		
		while(Principal.flag == 0) {
			
		if (Singleton.crSec < 60) {
			Singleton.crSec++;
    	}else {
    		Singleton.crSec = 0;
    		if (Singleton.crMin < 60) {
    			Singleton.crMin++;
    		}else {
    			Singleton.crMin = 0;
    			if (Singleton.crHour < 24) {
    				Singleton.crHour++;
    			}else {
    				Singleton.crHour = 0;
    			}
    			
    		}
    	}
    	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		}
	}
	
	

}
