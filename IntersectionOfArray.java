class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        int l1= nums1.length;
        int l2= nums2.length;

        for (int i=0; i<l1; i++){
            for(int j=0; j<l2; j++){

                if(nums1[i] == nums2[j] && ! result.contains(nums1[i])){
                    result.add(nums1[i]);
                }

            }
        }
        
        int[] intersectionarr = new int[result.size()];
        for( int i=0; i<result.size(); i++){
            intersectionarr[i]= result.get(i);
        }
        return intersectionarr;
    }
}
