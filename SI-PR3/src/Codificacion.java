import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.math3.fraction.*;

public class Codificacion {
	
	public static void main(String[] args) throws IOException {
		
		ejercicio1();
	}
	
	
	public static ArrayList<String> ejercicio1() {
		
		char[] alf = { 'A', 'B', 'C', 'D' , 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '.'};
        double num = 0.1613657607216723798346110583;
        int longitud = 19;
        int frecuencia = 29;
		
		ArrayList<String> mensaje = new ArrayList<String>();
		
		ArrayList<Fraction> intervalos = new ArrayList<Fraction>();
		
		intervalos = intervalos(frecuencia);
		int pos = posicionDecodificada(intervalos, num);
		mensaje.add(String.valueOf(alf[pos-1]));
		
		for(int i = 0; i < longitud; i++) {
			
			num = calcularSiguiente(num, intervalos.get(pos-1).doubleValue(), intervalos.get(pos).doubleValue());
			pos = posicionDecodificada(intervalos, num);
			mensaje.add(String.valueOf(alf[pos-1]));
		}

		
		System.out.println(pos);
		System.out.println(intervalos);
		System.out.println(mensaje.toString());
		
		
		return mensaje;
	}
	
	
	public static ArrayList<Fraction> intervalos(int frecuencia){
		
		ArrayList<Fraction> intervalos = new ArrayList<Fraction>();
		Fraction fraccion = new Fraction(0, 1);
		intervalos.add(fraccion);
		
		for(int i = 1; i < frecuencia+1; i++) {
			fraccion = new Fraction(i, frecuencia);
			intervalos.add(fraccion);
		}
		
		return intervalos;
	}
	
	
	public static int posicionDecodificada(ArrayList<Fraction> intervalos, double num) {
		int pos = 0;
		
		for(int i = 0; i < intervalos.size(); i++) {
			
			if(i == 29) {
				pos = i;
				break;
			}
			
			if(intervalos.get(i).doubleValue() <= num && intervalos.get(i+1).doubleValue() > num) {
				pos = i+1;
				break;
			}
		}
		
		return pos;
	}
	
	public static double calcularSiguiente(double num, double pre, double pos) {
		double siguiente = 0;
		siguiente = (num - pre) / (pos - pre);
		return siguiente;
	}
	
//	public static double calcularSiguiente(Fraction num, Fraction pre, Fraction pos) {
//		Fraction siguiente = new Fraction(0);
//		Fraction resta = new Fraction(0);
//		resta = pos.subtract(pre);
//		siguiente = num.subtract(pre);
//		siguiente = siguiente.divide(resta);
//		return siguiente.doubleValue();
//	}

}
