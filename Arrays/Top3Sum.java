class Top3Sum {

    // Problem link: https://leetcode.com/problems/maximum-product-of-three-numbers/
    public static void main(String[] args) {
        int arr[] = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        int res = maximumProduct(arr);
        System.out.println("res: "+res);

    }
    public static int maximumProduct(int[] nums) {
     int[] top3 = new int[3];
     int[] bottom3 = new int[3];
        
        for(int i = 0;i<top3.length; i++){
            top3[i] = Integer.MIN_VALUE;
            bottom3[i] = Integer.MAX_VALUE;
        }
    
        for(int i = 0; i< nums.length; i++){
            if(nums[i] >= top3[2]){
                
                int temp1 = top3[2];
                top3[2] = nums[i];
                
                int temp2 = top3[1];
                top3[1] = temp1;
                top3[0] = temp2;
            }
            else if (nums[i] >= top3[1]){
                int temp = top3[1];
                top3[1] = nums[i];
                top3[0] = temp;
            }
            else if(nums[i] >= top3[0]){
                top3[0] = nums[i];
            }


            if(nums[i] <= bottom3[2]){
                
                int temp1 = bottom3[2];
                bottom3[2] = nums[i];
                
                int temp2 = bottom3[1];
                bottom3[0] = temp2;
                bottom3[1] = temp1;
            }
            else if (nums[i] <= bottom3[1]){
                int temp = bottom3[1];
                bottom3[1] = nums[i];
                bottom3[0] = temp;
            }
            else if(nums[i] <= bottom3[0]){
                bottom3[0] = nums[i];
            }
        }
        
        int product = 1;
        int cnt = 0;
        for(int i = 0;i<top3.length; i++){
            if( top3[i] < 0){
                cnt++;
            }
        }

        if(cnt == 2){
            product = top3[2]*bottom3[2]*bottom3[1];
        }
        else{
            product = Math.max(top3[2]*top3[1]*top3[0], top3[2]*bottom3[2]*bottom3[1]);
        }
        
        return product;
    }
}