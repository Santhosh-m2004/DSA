public class containerWithMostWater {

    public static int maxArea(int[] height){
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right){
            int curArea=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,curArea);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    
}
