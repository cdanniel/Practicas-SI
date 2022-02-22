
import java.io.*;
import java.util.ArrayList;


public class Calculo_Entropía {
	

	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Character> cadena = new ArrayList<Character>();
		File archivo = null;
		FileReader fr = null;
	    BufferedReader br = null;
	    int numSaltos = 0;

	    archivo = new File ("C:\\Users\\PC\\Desktop\\Universidad\\3º - 2\\SI\\PR1\\datos_1.txt");
	    fr = new FileReader (archivo);
	    br = new BufferedReader(fr);

	         // Lectura del fichero
	    String linea;
	    while((linea=br.readLine()	)!=null) {
	    	System.out.println(linea);
	    	for(int i = 0; i < linea.length(); i++) {
	    		cadena.add(linea.charAt(i));
	    	}
	    	numSaltos++;
	    }
	    System.out.println(cadena.toString());
	    fr.close(); 
	}

}
