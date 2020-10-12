package Ejercicios_Bactracking;

public class Ficha {
	private int N1;
	private int N2;
	public int getN1() {
		return N1;
	}
	public int getN2() {
		return N2;
	}
	public void setN2(int n2) {
		N2=n2;
	}
	public void setN1(int n1) {
		N1=n1;
	}
	public Ficha(int n1, int n2) {
		N1=n1;
		N2=n2;
	}
	public String toString() {
		return "|"+N1+"|"+N2+"|";
	}
}
