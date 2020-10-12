package Ejercicios_Bactracking;

public class Domino {
	public static Ficha[] fichas= {new Ficha(1,1),new Ficha(1,2),new Ficha(1,3),new Ficha(1,4),new Ficha(1,5),new Ficha(1,6),new Ficha(2,1),
			new Ficha(2,2),new Ficha(2,3),new Ficha(2,4),new Ficha(2,5),new Ficha(2,6),new Ficha(3,1),new Ficha(3,2),new Ficha(3,3),new Ficha(3,4)};
	
	public static void main(String []args) {
		int []estado_main=new int [fichas.length];
		int []mejor=new int [fichas.length];
		for(int i=0;i<estado_main.length;i++) {
			estado_main[i]=-1;
			mejor[i]=-1;
		}
		System.out.println();
		domino(estado_main,0,mejor);
		System.out.println("SOLUCION\n-------------------------------------------------------------------------------");
		mostrarSolucion(mejor);
	}

	static void domino(int estado[],int etapa,int []mejor) {
		if(Es_Solucion(estado,etapa)) {
			if(esMejor(estado,etapa,mejor)) {
				for(int j=0;j<fichas.length;j++) {
					mejor[j]=estado[j];
				}
			}
		}
		else {
			for(int i=0;i<fichas.length;i++) { 
				if(esPosible(estado,etapa,i)) {
					estado=Actualizar_estado(estado,etapa,i);	
					domino(estado,etapa+1,mejor);

				}
			}
		}
	}

	private static void mostrarSolucion(int[] mejor) {
		for(int j=0;j<mejor.length;j++) {
			if(mejor[j]!=-1)
				System.out.print(fichas[mejor[j]].toString()+" - ");
		}
		System.out.println("");

	}
	private static boolean esPosible(int[] estado, int etapa,int n_ficha) {
		boolean posible=false;
		if(etapa==0) 
			posible=true;
		else {
			if(!Ficha_Repetida(n_ficha,estado)) {
				if(fichas[estado[etapa-1]].getN2()== fichas[n_ficha].getN1())
					posible=true;
			}
		}

		return posible;

	}
	private static boolean esMejor(int[] estado, int etapa, int[] mejor) {
		int fichas_estado=0;
		int fichas_mejor=0;
		for(int i=0;i<fichas.length;i++) {
			if(estado[i]!=-1)
				fichas_estado++;
			if(mejor[i]!=-1)
				fichas_mejor++;
		}
		return fichas_estado>fichas_mejor;
	}
	private static boolean Ficha_Repetida(int ficha, int estado[]) {
		boolean repetida = false;
		for(int i=0;i<estado.length;i++)
			if(ficha==estado[i])
				repetida= true;
		return repetida;
	}
	private static boolean Es_Solucion(int estado[], int etapa) {
		boolean solucion=true;
		for(int i=0;i<fichas.length;i++) { 
			if(esPosible(estado,etapa,i)) 
				solucion = false;
		}
		return solucion;
	}
	private static int[] Actualizar_estado(int estado[], int etapa, int ficha) {
		estado[etapa]=ficha;
		etapa++;
		for(int i=etapa;i<estado.length;i++)
			estado[i]=-1;
		return estado;

	}
}