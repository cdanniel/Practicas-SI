
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class Calculo_Entropia {
	
	
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Character> cadena = new ArrayList<Character>();
		ArrayList<Character> cadenaSinRepetidos = new ArrayList<Character>();
		File archivo = null;
		FileReader fr = null;
	    BufferedReader br = null;
	    int numSaltos = 0;

	    archivo = new File ("C:\\Users\\PC\\Downloads\\datos_1.txt"); //Torre
	    fr = new FileReader (archivo);
	    br = new BufferedReader(fr);

	    // Lectura del fichero
	    String linea;
	    while((linea=br.readLine()	)!=null) {
	    	System.out.println(linea);
	    	for(int i = 0; i < linea.length(); i++) {
	    		cadena.add(linea.charAt(i));
	    		if(cadenaSinRepetidos.contains(linea.charAt(i)) == false) {
	    			cadenaSinRepetidos.add(linea.charAt(i));
	    		}
	    		
	    	}
	    	numSaltos++;
	    }
	    numSaltos = (numSaltos-1) * 2;
	    System.out.println(cadena.toString());
	    System.out.println(cadenaSinRepetidos.toString());
		System.out.println(numSaltos);

		ArrayList<Integer> conteo = contarCaracteres(cadena, cadenaSinRepetidos, numSaltos);
		System.out.println(conteo);
	    fr.close();
	}

	public static ArrayList<Integer> contarCaracteres(ArrayList<Character> cadena, ArrayList<Character> cadenaSinRepetidos, int numSaltos){
		boolean c = true;
		ArrayList<Integer> conteo =  new ArrayList<Integer>();
		for(int i = 0; i < cadenaSinRepetidos.size(); i++) {
			int cont = 0;
			Character caracterActual = cadenaSinRepetidos.get(i);
			for(int j = 0; j < cadena.size(); j++) {
				if(caracterActual == cadena.get(j)) {
					if(c == true && caracterActual == ' ') {
						cont += numSaltos;
						c = false;
					}
					cont++;
				}
			}
			conteo.add(cont);
		}
		
//		for(int i = 0; i < cadenaSinRepetidos.size(); i++) {
//		if(cadenaSinRepetidos.get(i) == ' ') {
//			conteo.get(i) = conteo.get(i) + numSaltos;
//		}
//	}
		return conteo;

	}

}
