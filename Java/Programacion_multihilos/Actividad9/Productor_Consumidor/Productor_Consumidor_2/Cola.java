package Productor_Consumidor_2;
public class Cola {
    private String cadena;
    private boolean disponible = false;//inicialmente cola vacia

    public synchronized String get() {
    	  while (!disponible) {
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  //visualize valor
    	  disponible = false;
    	  notify();
    	  return cadena;
    	}


    public synchronized void put(String valor) {
    	  while (disponible){
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  cadena = valor;
    	  disponible = true;
    	  //visualiza valor
    	  notify();
    	}

     
     
}
