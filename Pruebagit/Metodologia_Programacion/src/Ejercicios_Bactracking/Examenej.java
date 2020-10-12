package Ejercicios_Bactracking;

public class Examenej {
	public static int misterio (int v[], int x, int li, int ls) {
	       int res = -1;
	       if (li <= ls) {
	            int mitad = (li+ls) / 2;
	                   if (x == v[mitad]) {
	                        res = mitad;
	                   }
	                        else
	                        	if (x < v[mitad]) {
	                                 res = misterio (v, x, li, mitad-1);
	                        	}
	                                 else {
	                                	 res = misterio (v, x, mitad+1, ls);
	                                 }
	                       }
	           
	       
	       return res;
	}
	public static void main(String[]args) {
		int [] v={2,3,5,9};
		System.out.println(misterio(v,4,0,3));
	}
}
