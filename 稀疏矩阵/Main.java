package 稀疏矩阵;

public class Main {
	// 三元组类，包含每个节点的行列标记以及记录，这样就可以定位到某一值了
	public class Triple {
		public int row;
		public int col;
		public int data;

		public Triple(int row, int col, int data) {
			this.row = row;
			this.col = col;
			this.data = data;
		}
	}

	// 经典方式
	// 三元组表用于存储三元组类的矩阵，还包含当前稀疏矩阵的行和列，以及当前非0元素个数，
	// 记录这些是因为不同的稀疏矩阵可能具有相同的三元组表
	public class Matrix {
		public Triple[] data;
		public int rowNumber;
		public int colNumber;
		public int length;// 非0元素个数

		public Matrix(Triple[] data, int rowNumber, int colNumber, int length) {
			this.data = data;
			this.rowNumber = rowNumber;
			this.colNumber = colNumber;
			this.length = length;
		}
	}

	// 三元组表的矩阵转至表示 , 行列进行转至,a为原三元组表，b为转至之后的三元组表
	// 时间复杂度为 O(rowNumber * length) 行*元素个数
	public Matrix transMatrix(Matrix a, Matrix b) {
		// 健壮性判断
		if (a == null || b == null) {
			return null;
		}
		if (a.data != null) {
			// 1:先对三元组表中的行列值进行转换非0元素个数不变
			b.colNumber = a.rowNumber;
			b.rowNumber = a.colNumber;
			b.length = a.length;
			b.data = new Triple[a.data.length];// 初始化里里面的三元组数组
			// 因为里面是引用类型所以要进行进一步初始化，要不初始值为null
			// 进一步初始化为行列值均为0的节点
			for (int i = 0; i < b.data.length; i++) {
				b.data[i] = new Triple(0, 0, 0);
			}
			// 用于为B数组赋值的索引初始值为0
			int index = 0;
			// 对数组data进行进一步赋值，进行转至赋值,对行进行扫描，找到当前行不为0的元素赋值进来
			for (int i = 0; i < b.rowNumber; i++) {
				for (int j = 0; j < a.data.length; j++) {
					// 找到当前行不为0的元素赋予B
					if (a.data[j].col == i) {
						// 行列赋值相反，元素值相同
						b.data[index].row = a.data[j].col;
						b.data[index].col = a.data[j].row;
						b.data[index].data = a.data[j].data;
						index++;
					}
				}
			}
		}
		return b;
	}
	// 快速转至方式 轮询一遍三元组表即可完成转至，用两个额外数组number 和position来辅助
	// number来统计当前列有多少个元素，position来统计当前列第一个元素所在的位置
	//时间复杂度为O(colNumber + length) 当前列+元素个数
	public Matrix fastTransMatrix(Matrix a,Matrix b){
		//健壮性判断
		if(a == null || b == null){
			return null;
		}
		if(a.data != null){
			b.rowNumber = a.colNumber;
			b.colNumber = a.rowNumber;
			b.length = a.length;
			b.data = new Triple[a.data.length];// 初始化里里面的三元组数组
			// 因为里面是引用类型所以要进行进一步初始化，要不初始值为null
			// 进一步初始化为行列值均为0的节点
			for (int i = 0; i < b.data.length; i++) {
				b.data[i] = new Triple(0, 0, 0);
			} 
			int[] number = new int[a.colNumber];//创建长度为三元组表列长度的数组来记录每一列中非0元素个数
			//为其赋值每一列中非0元素个数
			for(int i=0;i<number.length;i++){
				number[a.data[i].col]++; 
			}
			int[] position =new int[a.colNumber];//创建位置数组来记录每一列中第一个元素所在B中的位置
			//初始化
			//第一列的第一个元素会变成第一行所以不用对其进行赋值，直接初始值0即可
			for(int i=1;i<position.length;i++){
				//当前第一列第一个元素所在位置，为上一列第一元素所在位置+上一列元素个数
				position[i] = position[i-1]+number[i-1];
			}
			//进行逆置操作了为data真正赋值
			for(int i=0;i<a.data.length;i++){
				//找到当前元素的列位置，在number和position数组里确认其位置
				int col = a.data[i].col;
				int pos = position[col];//找到当前位置
				//为其进行逆置赋值
				b.data[pos].row = a.data[i].col;
				b.data[pos].col = a.data[i].row;
				b.data[pos].data = a.data[i].data;
				//++目的在于position之前只记录的是第一个元素所出现的位置，
				//当前列如果含有多个元素的话，指针进行移动方便下一元素的到来
				position[col]++;
			}
		}
		return b;
	}
}
