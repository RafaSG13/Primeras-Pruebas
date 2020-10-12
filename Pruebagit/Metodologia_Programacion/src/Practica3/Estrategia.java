package Practica3;

import java.util.ArrayList;

public class Estrategia {
	
	public static ArrayList<Beca> estrategia_DineroMensual(Beca[]B) {
		ArrayList<Beca> solucion=new ArrayList<Beca>();
		Quicksort.quicksort(B, 0, B.length-1);
		boolean[]meses=crearMeses();
		for(int i=B.length-1;i>-1;i--) {
			if(posible(meses,B[i].get_mes_inicio(),B[i].get_mes_fin())) {
				solucion.add(B[i]);
				modificarMeses(meses,B[i].get_mes_inicio(),B[i].get_mes_fin());
			}
		}
		return solucion;
	}
	public static ArrayList<Beca> estrategia_DineroTotal(Beca[]becas) {
		ArrayList<Beca> solucion=new ArrayList<Beca>();
		Beca[] B=calcular_dinero_total(becas);
		Quicksort.quicksort(B, 0, B.length-1);
		boolean[]meses=crearMeses();
		for(int i=B.length-1;i>-1;i--) {
			if(posible(meses,B[i].get_mes_inicio(),B[i].get_mes_fin())) {
				solucion.add(B[i]);
				modificarMeses(meses,B[i].get_mes_inicio(),B[i].get_mes_fin());
			}
		}
		return solucion;
	}
	public static boolean posible(boolean[] meses,int i,int f) {
		boolean posible=true;
		for(int j=i-1;j<f;j++) {
			if(meses[j]==false)
				posible=false;
		}
		return posible;
	}
	public static boolean[]crearMeses(){
		boolean[]meses=new boolean[12];
		for(int i=0;i<meses.length;i++) {
			meses[i]=true;
		}
		return meses;
	}
	public static void modificarMeses(boolean[] M,int i,int f) {
		for(int j=i-1;j<f;j++) {
			M[j]=false;
		}
	}
	public static int NumeroMeses(int inicio, int fin) {
		int numero=1;
		for(int i=inicio;i<fin;i++) {
			++numero;
		}
		return numero;
	}
	public static Beca[]calcular_dinero_total(Beca[]B){
		Beca[]dinero_total=new Beca[B.length];
		for(int i=0;i<B.length;i++) {
			dinero_total[i]=new Beca(B[i].get_id(),B[i].get_mes_inicio(),B[i].get_mes_fin(),B[i].get_dinero()*NumeroMeses(B[i].get_mes_inicio(),B[i].get_mes_fin()));
		}
		return dinero_total;
		
	}
}
