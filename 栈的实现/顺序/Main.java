package 栈的实现.顺序;

import java.util.Stack;

public class Main {
	public static final int MAXSIZE = 100;

	public SeqStack s;// 全局变量当前操作的栈

	// 当前栈类，里面包含当前栈的存储数组，以及当前栈的指针一直指向当前最后一个元素
	public class SeqStack {
		// 指针
		public int[] data = new int[MAXSIZE];
		public int top;
	}

	// 栈的初始化
	public SeqStack seqStackinit() {
		// 初始化一个空栈
		s = new SeqStack();
		s.top = -1;// 初始情况下栈的指针指向-1表示当前里面没有任何元素
		return s;
	}

	// 判断栈空
	public boolean SeqStackEmpty() {
		if (s == null || s.top == -1) {
			return true;
		} else {
			return false;
		}
	}

	// 入栈
	public void SeqStackPush(int number) {
		if (s == null) {
			System.out.println("栈未初始化!");
		} else {
			if (s.top == MAXSIZE - 1) {
				System.out.println("栈满");
				return;
			} else {
				// 入栈
				s.top++;
				s.data[s.top] = number;
			}
		}
	}

	// 出栈
	public int SeqStackPop() {
		if (s == null) {
			System.out.println("栈未初始化!");
			return -1; // 当前栈未初始化的错误标志
		} else {
			if (s.top == -1) {
				System.out.println("栈空");
				return -2; // 当前栈空的错误标志
			} else {
				int index = s.top;
				s.top--;
				return s.data[index];
			}
		}
	}

	// 取栈顶元素
	public int SeqStackGetTop() {
		if (s == null) {
			System.out.println("栈未初始化!");
			return -1;// 当前栈未初始化的错误标志
		} else {
			if (s.top != -1) {
				return s.data[s.top];
			} else {
				return -2;// 当前栈空的错误标志
			}
		}
	}

	// 清空栈操作
	public void SeqStackClean() {
		if (s == null) {
			return;
		} else {
			s.top = -1;// 让当前指针指向-1位置
		}
	}

	// 求当前栈长度
	public int SeqStackSize() {
		if (s == null) {
			System.out.println("栈未初始化!");
			return -1;
		} else {
			return s.top + 1;
		}
	}

	// 数制转换 此处为十进制转换为8进制，其他进制转化思路相同
	public void convert(int number) {
		seqStackinit();// 初始化一个栈
		// 不断进行转换之后压栈
		while (number != 0) {
			SeqStackPush(number % 8);
			number /= 8;
		}
		// 栈不为空时则弹栈
		while (!SeqStackEmpty()) {
			System.out.print(SeqStackPop() + " ");
		}
	}

	// 判断算数表达式括号是否匹配
	public void Match(String ex) {
		if (ex == null || ex.length() == 0) {
			return;
		} else {
			seqStackinit();// 初始化一个栈
			for (int i = 0; i < ex.length(); i++) {
				char temp = ex.charAt(i);
				switch (temp) {
				case '{':
					SeqStackPush(temp);
					break;
				case '}':
					if (SeqStackGetTop() != '{') {
						System.out.println("表达式不匹配");
						return;
					} else {
						SeqStackPop();
						break;
					}
				case '[':
					SeqStackPush(temp);
					break;
				case ']':
					if (SeqStackGetTop() != '[') {
						System.out.println("表达式不匹配");
						return;
					} else {
						SeqStackPop();
						break;
					}
				case '(':
					SeqStackPush(temp);
					break;
				case ')':
					if (SeqStackGetTop() != '(') {
						System.out.println("表达式不匹配");
						return;
					} else {
						SeqStackPop();
						break;
					}
				}
			}
			System.out.println("当前表达式正确");
		}
	}

	// 表达式求值
	public int CalculExp(String ex) {
		if (ex == null || ex.length() == 0) {
			return -10000000;// 当前运算错误的标志
		} else {
			Stack<Integer> number = new Stack<Integer>();
			Stack<Character> operator = new Stack<Character>();
			for (int i = 0; i < ex.length(); i++) {
				if (ex.charAt(i) >= '0' && ex.charAt(i) <= '9') {
					number.push(Integer.parseInt(String.valueOf(ex.charAt(i))));
				} else if (ex.charAt(i) == '(') {
					operator.push(ex.charAt(i));
				} else if (ex.charAt(i) == ')') {
					while (operator.peek() != '(') {
						char temp = operator.pop();
						int number1 = number.pop();
						int number2 = number.pop();
						if (temp == '+') {
							number.push(number1 + number2);
						} else if (temp == '-') {
							number.push(number1 - number2);
						} else if (temp == '*') {
							number.push(number1 * number2);
						} else {
							number.push(number1 / number2);
						}
					}
					operator.pop();// 把最后一个括号出栈
				} else if (ex.charAt(i) == '+' || ex.charAt(i) == '-') {
					if (operator.size() == 0) {
						operator.push(ex.charAt(i));
					} else {
						if (operator.peek() == '*' || operator.peek() == '/') {
							int number1 = number.pop();
							int number2 = number.pop();
							if (operator.peek() == '*') {
								number.push(number1 * number2);
							} else {
								number.push(number1 / number2);
							}
							operator.pop();
						}
						operator.push(ex.charAt(i));
					}
				} else {
					operator.push(ex.charAt(i));
				}
			}
			while (operator.size() != 0) {
				int number1 = number.pop();
				int number2 = number.pop();
				if (operator.peek() == '+') {
					number.push(number1 + number2);
					operator.pop();
				} else if (operator.peek() == '-') {
					number.push(number2 - number1);
					operator.pop();
				} else if (operator.peek() == '*') {
					number.push(number1 * number2);
					operator.pop();
				} else {
					number.push(number2 / number1);
					operator.pop();
				}
			}
			return number.pop();
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.seqStackinit();// 初始化
		System.out.println(m.SeqStackEmpty());// 判断栈是否为空
		m.SeqStackPush(10);// 入栈
		m.SeqStackPush(20);
		System.out.println(m.SeqStackPop());// 出栈
		System.out.println(m.SeqStackSize());// 求当前栈长度
		System.out.println(m.SeqStackGetTop());// 取栈顶元素
		m.SeqStackClean();// 清空当前栈
		System.out.println(m.SeqStackSize());
		m.convert(1600);
		m.Match("((a+b+[[c+d]]))");
		System.out.println(m.CalculExp("1+(3+5*8)-8*2"));
	}
}
