class minChairs {
    public int minimumChairs(String s) {
        int left=0;
        int required=0;
        char[] ch=s.toCharArray();
        int res=0;

        for(char c:ch){
            if(c=='E'){
                required++;
            }
            else if(c=='L'){
                left++;
            }
            res=Math.max(res,required-left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s="EELEE";
        minChairs obj=new minChairs();
        System.out.println(obj.minimumChairs(s));
    }
}