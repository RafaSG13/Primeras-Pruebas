package Ejercicios_Bactracking;

public class Libros {
	int [][] ganancias;
	
	public int[][] generarGanancias(){
		int [][] g=new int [3][3];
		for(int i=0;i<g.length;i++)
			for(int j=0;j<g[0].length;j++)
				g[i][j]= (i*j)+5;
		return g;
	}
	
	public void Solucion(int []estado, int etapa,int []mejor) {
		if(etapa==estado.length) {
			if(esMejor(estado,mejor))
				for(int i=0;i<estado.length;i++)
					mejor[i]=estado[i];
		}
		else {
			for(int posibilidad=0;posibilidad<ganancias.length;posibilidad++) {
				if(esValido(estado,etapa,posibilidad)) {
					estado[etapa]=posibilidad;
					Solucion(estado,etapa,mejor);
				}
			}
		}

	}

	private boolean esValido(int[] estado, int etapa, int posibilidad) {
		boolean posible=true;
		for(int i=0;i<etapa;i++)
			if(estado[etapa]==posibilidad)
				posible =false;
		return posible;
	}

	private boolean esMejor(int[] estado, int[] mejor) {
		int suma=0;
		int mejorSuma=0;
		for(int i=0;i<estado.length;i++) {
			suma=suma + ganancias[i][estado[i]];
			mejorSuma+=ganancias[i][mejor[i]];
		}
		return (suma>mejorSuma);
	}

}
