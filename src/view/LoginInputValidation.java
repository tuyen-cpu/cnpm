package view;

public class LoginInputValidation {
	
	static String regularExp = "^[a-z0-9._-]{3,15}$";
	
	public static boolean isUnameValid(String text) {
		if (text.matches(regularExp)) {
			return true;
		}
		return false;
	}
	
	public static boolean isPassValid(char [] pass) {
		if (pass.length != 0) {
			if (pass[0] != ' ') return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = new String("admin");
		System.out.println(isUnameValid(s));
		char [] arr = {'1', '2', '3'};
		System.out.println(isPassValid(arr));
	}
}
