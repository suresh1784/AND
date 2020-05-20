package algorithm.educative.arrays;

class leastCommonNumber{

    public static void main(String[] args){
        int[] arr1 = {6,7,10,25,30,63,64};
        int[] arr2 = {-1,4,5,6,7,8,50};
        int[] arr3 = {1,6,10,14};

        System.out.println("result "+find_least_common_number(arr1,arr2,arr3));
    }

    static int find_least_common_number(int[] a,
                                        int[] b,
                                        int[] c) {
        int min = max(a[0],b[0],c[0]);
        int i=0,j=0,k=0;

        while (i<a.length && j<b.length && k<c.length){
            if (a[i]==min && b[j]== min && c[k]==min){
                return min;
            }

            if (a[i]> min || b[j]> min ||c[k]> min){
                min = max(a[i],b[j],c[k]);
            }

            if (a[i]<min){
                i++;
            }

            if (b[j]<min){
                j++;
            }

            if (c[k]<min){
                k++;
            }




        }

        //TODO: Write - Your - Code

        return -1;
    }

    static int max(int a,int b, int c){
        return  Math.max(Math.max(a,b),c);
    }
}