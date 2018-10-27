package settimana4.esercizio3;

import java.util.Scanner;

public class Password {

	private static boolean check(String pwd) {
		if (pwd.length() < 8) {
			return false;
		}
		boolean number = false;
		boolean uc = false;
		boolean lc = false;
		for (char a : pwd.toCharArray()) {
			if (!number && '0' <= a && a <= '9') {
				number = true;
			}
			if (!uc && 'A' <= a && a <= 'Z') {
				uc = true;
			}
			if (!lc && 'a' <= a && a <= 'z') {
				lc = true;
			}
			if (number && uc && lc) {
				break;
			}
		}
		return number && uc && lc;
	}

	public static void checkTest() {
		String pwd, cpwd = "";
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Fornisci password: ");
			pwd = in.next();
			if (!Password.check(pwd)) {
				System.out.println("Fornisci minimo 8 caratteri tra cui 1 maiuscolo 1 minuscolo 1 numero.\n");
				continue;
			}
			System.out.println("Ripeti password: ");
			cpwd = in.next();
			if (!pwd.equals(cpwd)) {
				System.out.println("Riprova!\n");
			}
		} while (!pwd.equals(cpwd));
		System.out.println("Password scelta: " + pwd);
	}

}
