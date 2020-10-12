public class Practica1 {

	public static void main(String[] args) {
		int n=300;
		long t0,t,tf;

		t0=System.nanoTime();
		metodo1(n);
		tf=System.nanoTime();
		t=tf-t0;
		System.out.println("Resultado Formula: "+metodo1(n)+"    Tiempo: "+t+" ns");

		t0=System.nanoTime();
		metodo2(n);
		tf=System.nanoTime();
		t=tf-t0;
		System.out.println("Resultado Bucle: "+metodo2(n)+"    Tiempo: "+t+" ns");

		t0=System.nanoTime();
		metodo3(n);
		tf=System.nanoTime();
		t=tf-t0;
		System.out.println("Resultado Recursivo: "+metodo3(n)+"    Tiempo: "+t+" ns\n\n");

	}
	public static int metodo1(int n) {
		return 2*(n*n)-n;
	}
	// Complejidad 4
	public static int metodo2(int n) {
		int resultado=0;
		for(int i=0;i<n;i++) {
			resultado=resultado + 4*i+1;
		}
		return resultado;
	}
	//3+4n
	public static int metodo3(int n) {
		int resultado;
		if(n==0) {
			resultado=0;
		}else {
			resultado=(4*(n-1)+1)+metodo3(n-1);
		}
		return resultado;
	}
}
