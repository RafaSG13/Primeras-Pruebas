package Ejercicios_Bactracking;
// Es un laberinto que consta de una array donde o es libre y x es prohibido el paso, en numero es el paso que estas dando, comenzamos en el 0,0
//y terminamos en el N,N
public class Laberinto {

	
	public String[][] copia(String[][] t){
		String[][] copia=new String[t.length][t[0].length];
		for(int f=0;f<t.length;f++)
		for(int c=0;c<t[0].length;c++)
		copia[f][c]=t[f][c];
		return copia;
		}
}
