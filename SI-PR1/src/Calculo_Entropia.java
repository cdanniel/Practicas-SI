
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;



public class Calculo_Entropia {
	

	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Character> cadena = new ArrayList<Character>();
		File archivo = null;
		FileReader fr = null;
	    BufferedReader br = null;
	    int numSaltos = 0;

	    archivo = new File ("C:\\Users\\cdani\\Downloads\\datos_1.txt"); //Torre
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
		System.out.println(numSaltos);

		Collections.sort(cadena);
		System.out.println(cadena.toString());
		ArrayList<Integer> conteo = contarCaracteres(cadena);
		System.out.println(conteo);
	    fr.close();
	}

	public static ArrayList<Integer> contarCaracteres(ArrayList<Character> cadena){

		ArrayList<Integer> conteo =  new ArrayList<Integer>();
		for (int i = 0; i < 100; i++){
			conteo.add(0);
		}
		char caracterActual = 'a';
		int pos = 0;
		for (int i = 0; i < cadena.size(); i++){
			caracterActual = cadena.get(i);
			if(i+1 < cadena.size() && caracterActual == cadena.get(i+1)){
				int valor = conteo.get(0).intValue();
				valor++;
				Integer nuevoValor = new Integer(valor);
				conteo.set(pos, nuevoValor);
			} else if(i+1 < cadena.size() && caracterActual != cadena.get(i+1)){
				pos++;
			}
		}
		return conteo;

	}

}
