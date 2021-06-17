package loginView;

public class LoginInputValidation {
	
	static String regularExp = "^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
	static String regularExp2 = " &=_'-+,<>.";
	static String regularExp3 = "^(?=.*[A-Za-z])(?=.*)[A-Za-z]{8,}$";
	
	public static boolean isUnameValid(String text) {
		if ((text.matches(regularExp))&&(!(text.matches(regularExp2)))) {
			return true;
		}
		return false;
	}
	
	public static boolean isPassValid(char [] pass) {
		String s = String.valueOf(pass);
		if (s.matches(regularExp3)) return true;
		return false;
	}
}
