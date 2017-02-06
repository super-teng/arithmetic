package 归并排序;

public class Test{
    public static void main(String[] args) {
   //需要进行排序的数组
    int[] array=new int[]{8,3,2,1,7,4,6,5};
     //输出原数组的内容
    printResult(array);
    //归并排序操作
    sort(array,0,array.length-1);
    //输出排序后的相关结果
    printResult(array);
    }
     
     
    /**
     * 归并排序
     * @param array
     */
    private static void sort(int[] array,int i,int j) {
        if(i<j)
        {
            int middle=(i+j)/2;
            //递归处理相关的合并事项
            sort(array,i,middle);
            sort(array,middle+1,j);
            merge(array,i,middle,j);           
        }
    }
 
 
    /**
     * 合并相关的数组内容
     * 同时使合并后的数组仍然有序
     * @param array
     * @param i
     * @param middle
     * @param j
     *  4 5 6     9 10 11
     *
     */
    private static void merge(int[] array, int i, int middle, int j) {
        //创建一个临时数组用来存储合并后的数据
        int[] temp=new int[array.length];
        int m=i;
        int n=middle+1;
        int k=i;
        while(m<=middle&&n<=j)
        {
            if(array[m]<array[n])
                temp[k++]=array[m++];
            else
                temp[k++]=array[n++];
        }
        //处理剩余未合并的部分
        while(m<=middle)
        {
            temp[k++]=array[m++];
        }
        while(n<=j)
        {
            temp[k++]=array[n++];
        }
        //将临时数组中的内容存储到原数组中
        while(i<=j)
        {
            array[i]=temp[i++];
        }
    }
 
 
    /**
     *                                       
     * 输出相应数组的结果
     * @param array
     */
    private static void printResult(int[] array) {
       for(int value:array)    
           System.out.print(" "+value+" ");
      System.out.println();
    }
}
