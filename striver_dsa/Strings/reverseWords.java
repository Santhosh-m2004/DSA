package Strings;

public class reverseWords {
    // static String res(String s){
    //     String[] str=s.trim().split("\\s+");
    //     int start=0;
    //     int end=str.length-1;
    //     while(start<end){
    //         String temp=str[start];
    //         str[start]=str[end];
    //         str[end]=temp;
    //         start++;
    //         end--;
    //     }
    //     return String.join(" ",str);
    // }

    static String res(String s){
        String[] arr=s.split("\\s+");
        StringBuilder res=new StringBuilder();

        for(int i=arr.length-1;i>=0;i--){
            res.append(arr[i]);
            if(i>0){
                res.append(" ");
            }
        }

        return res.toString().trim();
    }
    public static void main(String[] args) {
        String s="the sky is blue";
        System.out.println(res(s));
    }
}
