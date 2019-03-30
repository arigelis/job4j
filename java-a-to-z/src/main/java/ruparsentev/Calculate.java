package ruparsentev;

public class Calculate{
	public String echo(String txt){
		return(String.format("%S %S %S",txt,txt,txt));
	}
	
	public static void main(String[] args) {
		Calculate calc = new Calculate();
		System.out.println(calc.echo("go! "));
	}
}