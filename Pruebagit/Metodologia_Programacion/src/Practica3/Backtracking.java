package Practica3;

public class Backtracking {

	public static Beca[] solucion(int[] solucion,Beca[] b) {
		int contador=0;
		System.out.println("SOLUCION\n");
		for(int i=0;i<solucion.length;i++) {
			if(solucion[i]==1)
				contador++;
		}

		Beca []becas=new Beca[contador];
		int i=0;
		for(int j=0;j<b.length;j++) {
			if(solucion[j]==1) {
				becas[i]=b[j];
				++i;
			}
		}
		return becas;
	}
	public static int[] becaRec(int solucion[],int etapa, Beca becas[],int solucion_final[]) {
		int i=0;
		if(etapa<=becas.length-1) {
			do {
				solucion[etapa]=i;
				if(valido(solucion,etapa,becas)) {
					if(etapa==becas.length-1)
						actualizarSolucion(solucion,becas,solucion_final);
					else
						solucion_final=becaRec(solucion,etapa+1,becas,solucion_final);
				}
				i++;
			}while(solucion[etapa]!=1);
			solucion[etapa]=-1;
		}return solucion_final;
	}
	public static void actualizarSolucion(int solucion[],Beca becas[],int solucion_final[]) {
		int valor_total=0;
		int valor_final=ObtenerValor(solucion_final,becas);

		for(int i=0;i<becas.length;i++) {
			if(solucion[i]==1)
				valor_total += becas[i].get_dinero()*NumeroMeses(becas[i].get_mes_inicio(),becas[i].get_mes_fin());
		}
		if(valor_total>valor_final) {
			for(int i=0;i<becas.length;i++)
				solucion_final[i]= solucion[i];
			valor_final=valor_total;
		}
	}
	public static int NumeroMeses(int inicio, int fin) {
		int numero=1;
		for(int i=inicio;i<fin;i++) {
			++numero;
		}
		return numero;
	}
	public static int ObtenerValor(int solucion[],Beca becas[]) {
		int valor = 0;
		for(int i=0;i<becas.length;i++) {
			if(solucion[i]==1) 
				valor+=becas[i].get_dinero()*NumeroMeses(becas[i].get_mes_inicio(),becas[i].get_mes_fin());
		}
		return valor;

	}

	public static boolean[] modificarMeses(boolean[] M, Beca beca) {
		int i = beca.get_mes_inicio();
		int f = beca.get_mes_fin();

		for(int j=i-1;j<f;j++) {
			M[j]=false;
		}
		return M;
	}

	public static boolean valido(int solucion[],int etapa,Beca becas[]) {
		boolean valido = true;
		if(solucion[etapa]==1) {
			Beca b=becas[etapa];
			int mes_inicial=b.get_mes_inicio();
			int mes_final=b.get_mes_fin();
			boolean[]meses=new boolean[12];

			for(int i=0;i<meses.length;i++) {
				meses[i]=true;
			}
			for(int i=0;i<etapa;i++) {
				if (solucion[i]==1)
					meses=modificarMeses(meses,becas[i]);
			}
			for(int j=mes_inicial-1;j<mes_final;j++) {
				if(meses[j]==false)
					valido=false;
			}


		}
		return valido;
	}
}
