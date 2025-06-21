package Strings;

public class removeOutermostParanthesis {

    static String res(String s){
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(count>0){
                    sb.append("(");
                }
                count++;
            }
            else if(s.charAt(i) == ')'){
                if(count>1){
                    sb.append(")");
                }
                count--;
            }
        }

        return new String(sb.toString());
    }
    public static void main(String[] args) {
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        System.out.println(res(s1));
        System.out.println(res(s2));
        
    }
}
