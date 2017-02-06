package 二叉树的顺序存储;

public class Main {
	private  int[] array = new int[100]; // 当前二叉树的顺序存储的空间当为-1的时候说明没有元素

	public Main() {
		// 把当前数组初始化为-1表示当前位置没有元素
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
	}

	public  void add(int number) {
		// 如果当前树为空树直接让这个number等于当前的根节点
		if (array[0] == -1) {
			array[0] = number;
		} else {
			int temp = array[0];
			int index = 0;
			while (temp != -1) {
				if (temp > number) {
					//如果小于的话让当前temp为左孩子索引位置元素并hold住左孩子索引
					temp = array[index * 2 + 1];
					index = index * 2 + 1;
				} else if (temp < number) {
					//如果大于的话让当前temp为右孩子索引位置元素并hold住右孩子索引
					temp = array[index * 2 + 2];
					index = index * 2 + 2;
				} else {
					// 相等的话直接return不插入
					return;
				}
			}
			if(index < 100){
				array[index] = number;
			}else{
				System.out.println("当前内存不足");
				return ;
			}
		}

	}
	public  void print(){
		if(array[0] != -1){
			System.out.println(array[0]);
			int index = 0;
			for(int i=1;i<array.length;i++){
				if(array[i] != -1){
					index ++;
					System.out.print(array[i]+" ");
					if(index % 2 == 0 ){
						System.out.println();
					}
				}
			}
		}else{
			System.out.println("空树");
			return ;
		}
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.add(10);
		m.add(7);
		m.add(13);
		m.add(3);
		m.add(8);
		m.add(11);
		m.add(16);
		m.add(1);
		m.add(9);
		m.print();
	}
}
