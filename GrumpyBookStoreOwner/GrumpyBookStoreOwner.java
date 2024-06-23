
class GrumpyBookStoreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int a = 0;
        int active = 0;
        int max = 0;
        int sum;
        int sum1 = 0;
        int sum2 = 0;
        int total;
        for (int i = 0; i <= customers.length-1; i++) {

            if(minutes==customers.length){
                int n = i;
                while (a < minutes) { // looping forward in the arry

                    sum1 += customers[n];
                    n++;
                    a++;
                }
                return sum1;
            }

            if(minutes==customers.length-1 && grumpy[0]==0 && grumpy[1]==0 && grumpy[grumpy.length-1]==0 && grumpy[grumpy.length-1]==0){
                int temp=0;
                if(i==0){
                    int n = i;
                    while (a < minutes) { // looping forward in the array
                        temp += customers[n];
                        n++;
                        a++;
                    }
                    a=0;
                    sum1=temp;
                    // return sum1;
                }else{
                    int n = i;
                    while (a < minutes) { // looping forward in the array
                        temp += customers[n];
                        n++;
                        a++;
                    }
                    if(sum1<temp){
                        sum1=temp;
                    }
                    if(grumpy[0]==0){
                        sum1+=customers[0];
                    }
                    return sum1;
                }
            }


            if (i + minutes <= customers.length && grumpy[i] == 1) { // condition for window doesn't go out of index and
                // shopkeepy is tired
                int n = i;
                while (a < minutes) { // looping forward in the arry

                    if (grumpy[n] == 1) {
                        sum1 += customers[n];
                    }
                    n++;
                    a++;
                }
                a = 0;
            }

            if (i+1 - minutes >= 0 && grumpy[i] == 1) {
                int m = i;
                while (a < minutes) { // looping Backward in the array

                    if (grumpy[m] == 1) {
                        sum2 += customers[m];
                    }
                    m--; // [1,0,1,2,1,1,7,5]
                    a++; // [0,1,0,1,0,1,0,1]
                }
                a = 0;
            }

            if (sum1 < sum2) {
                sum = sum2;
            } else {
                sum = sum1;
            }
            sum1 = 0;
            sum2 = 0;

            if (max < sum) {
                max = sum;
            }
            sum = 0;

            if (grumpy[i] == 0) {
                active += customers[i];
            }
        }
        total = active + max;

        return total;
    }
    public static void main(String[] args) {
        int[] customer={4,10,10};
        int[] grumpy={1,1,0};

        System.out.println(maxSatisfied(customer,grumpy,2));
    }
}