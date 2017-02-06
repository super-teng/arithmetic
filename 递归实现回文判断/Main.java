package 递归实现回文判断;

public class Main {

	public boolean judje(String number) {
		if (number.length() <= 1) {
			return true;
		} else {
			if (number.charAt(0) == number.charAt(number.length() - 1)) {
				number = number.substring(1, number.length() - 1);
				return judje(number);
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		String number = "1233223321";
		System.out.println(m.judje(number));
		String s = "123";
		s = s.substring(1, 1);
		System.out.println(s.length() + "---");
	}

}
