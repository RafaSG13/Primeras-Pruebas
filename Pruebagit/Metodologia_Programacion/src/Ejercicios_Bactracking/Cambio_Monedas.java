package Ejercicios_Bactracking;

public class Cambio_Monedas {
	public static int[] tipos= {1,2,5,10,20,50};
	public static void main(String[]args) {
		System.out.println("Bienvenido al programa de cambio de monedas");
		int cambio=20; //4 euros
		mostrarSolucion(Solucion(cambio));
	}
	public static void Solucion(int x,int[]sol,int i, int[]aux) {
		if(i==tipos.length) {
			if(x==0)
				if(EsMejor(aux,sol))
					System.arraycopy(aux, 0, sol, 0, aux.length);
		}else {
			for(int monedas=0;x-tipos[i]*monedas>=0;monedas++) {
				aux[i]=monedas;
				Solucion(x-tipos[i]*monedas,sol,i+1,aux);
			}
			aux[i]=0;
		}
	}
	public static boolean EsMejor(int []aux,int []sol) {
		int cAUX=0;
		int cSOL=0;
		for(int x=0;x<sol.length;x++) cSOL+=sol[x];
		for(int y=0;y<sol.length;y++) cAUX+=aux[y];
		return (cAUX<cSOL||cSOL==0);
	}
	
	public static int [] Solucion(int x) {
		int sol[]=new int[tipos.length];
		Solucion(x,sol,0,new int[tipos.length]);
		return sol;
	}
	public static void mostrarSolucion(int[] solucion) {
		System.out.println("El cambio es el siguiente");
		for(int i=0;i<solucion.length;i++) {
			System.out.println("Numero: "+solucion[i]+"\tMoneda: "+tipos[i]);
		}
	}
}
