package Ejercicios_Bactracking;

import java.lang.reflect.Array;

public class ConvOrdinaria2017_Voraz {
	static int [] pesos= {1,2,4,5,6,8};
	static int k;
	
	
	
	public static void solucion(int []solucion,int c) {
		
		int cajas[]=new int [pesos.length];
		
		for(int o=pesos.length-1;o>-1;o--) {
			int i=0;
			while(cajas[i]+pesos[o]>c) {
				i++;
			}
			cajas[i]+=pesos[o];
			solucion[o]=i;
		}
		mostrarSolucion(solucion);
	}
	public static void mostrarSolucion(int []solucion) {
		for(int i=0;i<solucion.length;i++) {
			System.out.println("El objeto "+i+" esta en la caja "+solucion[i]);
		}
	}
	public static void main(String[]args) {
		System.out.println("Bienvenido");
		int solucion[]=new int[pesos.length];
		solucion(solucion,10);
	}
}
