package Ejercicios_Bactracking;

public class Disco {
	static int [] duracion= {1,4,3,3,2};
	static int solucion[]=new int[duracion.length];
	static int mejor[]=new int [duracion.length];
	
	public static void backtracking(int []estado, int etapa,int suma, int T,int []mejor) {
		if(etapa==estado.length ||suma==T) {
			if(esMejor(estado,mejor,etapa)) {
				for(int i=0;i<estado.length;i++) 
					mejor[i]=estado[i];
			}
		}
		else {
				for(int i =0;i<duracion.length &&suma<T;i++) {
					if(esValido(estado,etapa,suma+duracion[i],T,duracion[i])) {
					estado[etapa]=duracion[i];
					backtracking(estado,etapa+1,suma,T,mejor);
				}
			}
		}
	}

	private static boolean esValido(int[] estado, int etapa,int suma, int tiempo,int posibilidad) {
		boolean valido=true;
		if(tiempo<suma)
			valido=false;
		else {
			if(posibilidad!=0)
				for(int i=0;i<estado.length;i++)if(posibilidad==estado[i]) valido=false;
		}
		return valido;
	}

	private static boolean esMejor(int[] estado, int[] mejor, int etapa) {
		return numeroCanciones(estado)>numeroCanciones(mejor);
	}
	private static int numeroCanciones(int []estado) {
		int contador=0;
		for(int i=0;i<estado.length;i++)
			if(estado[i]!=0)
				contador++;
		return contador;
	}
	
	
	public static void main(String[]args) {
		for(int i=0;i<mejor.length;i++)
			mejor[i]=0;
		backtracking(solucion,0,0,10,mejor);
		mostrar(mejor);
		
	}
	public static void mostrar(int []solucion) {
		System.out.println("SOlUCION");
		for(int i=0;i<solucion.length;i++)
			System.out.print(solucion[i]+" ");
	}
}
