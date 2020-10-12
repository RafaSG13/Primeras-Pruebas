package Practica3;

import java.io.*; 
import java.util.*;

/**
 * @author Rafael Serrano Gamara y Alejandro Nieto Molina.
 *
 */
public class File_Manager {
	public static ArrayList<Beca> leerBecas(String cadena ) throws FileNotFoundException{
		File becas=new File(cadena);
		Scanner scan=new Scanner(becas);
		ArrayList<Beca> B=new ArrayList<Beca>();
		while(scan.hasNext()) {
			
			int id=scan.nextInt();
			int imes=scan.nextInt();
			int fmes=scan.nextInt();
			int dinero=scan.nextInt();
			Beca b=new Beca(id,imes,fmes,dinero);
			B.add(b);
		}
		return B;
	}
}