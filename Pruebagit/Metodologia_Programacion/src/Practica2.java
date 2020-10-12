import java.util.function.Function;
public class Practica2 {

	public static void main(String args[]) {
		double pi=Math.PI;
			Function<Double,Double> funcion1 = x -> (x*x)-2*x-3;
			Function<Double,Double> funcion2 = x -> (Math.pow(2,x))-(x*x)-10;
			Function<Double,Double> funcion3 = x -> Math.sin(x)-1/x;
			biseccion(funcion1,0,4,0);
			biseccion(funcion1,2,2.5,0);
			biseccion(funcion2,0,6,0.05);
			biseccion(funcion3,2*pi,(5*pi)/2,0.1);
		
	}


	public static void biseccion(Function<Double,Double> f,double a,double b,double e) {
		boolean encontrado = false;
		double  c;
		if(f.apply(a)*f.apply(b)>0) { 
			System.out.println("No hay punto c tal que f(c)=0");
		}else {
		do {
			c=(a+b)/2;
			if(f.apply(c)<=e && f.apply(c)>=(-e)) {
				encontrado=true;
			}else {
				if(f.apply(c)>0)
					b=c;
				if(f.apply(c)<0)
					a=c;
			}

		}while(!encontrado);
		System.out.println(c);
		}
	}
	

}