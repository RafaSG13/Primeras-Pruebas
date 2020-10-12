package Practica3;

import java.io.FileNotFoundException;
import java.util.*;

public class Principal {
	public static void main(String []args) {
		String ruta="C:/Users/Usuario/Desktop/Informatica/PROGRAMACION/DatosBecas8.txt";
		ArrayList<Beca> b = null;
		try {
			b=File_Manager.leerBecas(ruta);
			menu(ruta,b);
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

	}

	public static void mostrar(Beca[] b) {
		System.out.println("ID	Mes inicio	      Mes Fin		Dinero\n-------------------------------------------------------");
		for(int i=0;i<b.length && b[i]!= null;i++){
			System.out.println(b[i].toString());
		}
	}
	public static Beca[] crearArray(ArrayList<Beca>B) {
		Beca[]becas=new Beca[B.size()];
		for(int i=0;i<B.size();i++) {
			becas[i]=B.get(i);
		}
		return becas;
	}
	public static void menu(String ruta, ArrayList<Beca> b){
		long t,t0,tf;
		boolean fin = false;
		System.out.println("Bienvenido al programa.");
		while(!fin) {

			Scanner scan= new Scanner(System.in);
			int opcion = 0;
			System.out.println("Introduzca la opción que desea ejecutar.\n1.-Práctica 3, algoritmos voraces.\n2.-Práctica 4, backtracking.\n3.-Salir.");
			opcion=scan.nextInt();
			switch(opcion) {

			case 1:
				Beca []B=crearArray(b);
				mostrar(crearArray(Estrategia.estrategia_DineroMensual(B)));
				System.out.println("\n\n	ESTRATEGIA 2\n");
				mostrar(crearArray(Estrategia.estrategia_DineroTotal(B)));
				break;

			case 2:
				Beca []becas=crearArray(b);	
				mostrar(becas);
				System.out.println();
				int solucion[]=new int[becas.length];
				int solucion_final[]=new int[becas.length];
				for(int i=0;i<solucion.length;i++)
					solucion[i]=-1;
				for(int i=0;i<solucion_final.length;i++)
					solucion_final[i]=0;

				mostrar(Backtracking.solucion(Backtracking.becaRec(solucion,0,becas,solucion_final),becas));
				break;

			case 3:
				System.out.println("Terminando programa");
				fin=true;
				break;

			default:
				System.out.println("Error, opcion no válida");
				System.out.println("Introduzca un número entre el 1 y el 3");
			}
		}
	}
}
	