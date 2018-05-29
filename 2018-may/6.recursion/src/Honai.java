
public class Honai {

	public static void honai1(int n, char src, char aux, char target) {
		if(n == 1) {
			System.out.println(src + "->" + target);
			return;
		}
		honai1(n-1, src, target, aux);
		System.out.println(src + "->" + target);
		honai1(n-1, aux, src, target);		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		honai1(n, 'A', 'B', 'C');
	}

}
