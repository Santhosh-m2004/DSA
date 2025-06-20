package java1;

public class selection_sort {
    public static void main(String[] args) {
        int[] arr={2,1,3,1,4,5,7,6};
        for(int i=0;i<arr.length;i++){
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[smallest]){
                    smallest=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
