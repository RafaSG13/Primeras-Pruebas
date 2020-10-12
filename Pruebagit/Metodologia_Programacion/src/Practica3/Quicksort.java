package Practica3;

public class Quicksort{
	public static void intercambia(Beca[] b, int pos1, int pos2){
		Beca aux=b[pos1];
		b[pos1]=b[pos2];
		b[pos2]=aux;
	}
	public static void quicksort(Beca[] b, int li, int ls){
		if (li<ls){
			int pos=divide(b,li,ls);
			quicksort(b, li, pos-1);
			quicksort(b, pos+1, ls);
		}
	}
	public static int divide(Beca[] b, int li, int ls){
		int pivote=b[li].get_dinero();
		int izq=li+1; int der=ls;
		while(izq<der && b[izq].get_dinero()<=pivote ) izq++;
		while (b[der].get_dinero()>pivote) der--;
		while (izq<der){
			intercambia(b,izq,der);
			do{izq++;}while(b[izq].get_dinero()<=pivote);
			do{der--;}while(b[der].get_dinero()>pivote);
		}
		intercambia(b,li,der);
		return der;
	}
}