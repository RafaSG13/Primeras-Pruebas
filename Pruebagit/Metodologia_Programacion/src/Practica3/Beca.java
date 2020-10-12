package Practica3;

public class Beca {
	private int id;
	private int mes_inicio;
	private int mes_fin;
	private int dinero;
	
	
	public Beca(int id,int i,int f,int d) {
		this.id=id;
		mes_inicio=i;
		mes_fin=f;
		dinero=d;
	}
	public int get_id() {
		return id;
	}
	public int get_mes_inicio() {
		return mes_inicio;
	}
	public int get_mes_fin() {
		return mes_fin;
	}
	public int get_dinero() {
		return dinero;
	}
	public String toString() {
		return id+"		"+mes_inicio+"		"+mes_fin+"		"+dinero;
	}
	
}
