package ¹þÏ£·¨;

public class Test {
	public enum Color{
		RED("ºìÉ«",1);
		private String name;
        private int index;
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        public String toString() {
            return this.index + "_" + this.name;
        }
	}
	public static void main(String[] args){
		Test t = new Test();
		Color color = Color.RED;
		System.out.println(color);
	}
}
