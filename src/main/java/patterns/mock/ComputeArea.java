package patterns.mock;

public class ComputeArea {

    public static void main(String[] args){
        System.out.println(computeArea(-2, -2 , 2, 2, 3 , 3, 4 , 4));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = area(A,B, C, D);
        int a2 = area(E,F,G,H);
        System.out.println(a1);
        System.out.println(a2);
        int a3 = 0 ;

        int X1 = Math.max(A,E);
        int Y1 = Math.max(F,B);
        int X2 = Math.min(C,G);
        int Y2 = Math.min(D,H);

        a3 = area(X1,Y1,X2,Y2);

        return a1+a2-a3;
    }

    public static int area(int x1, int y1, int x2, int y2){
        return (x2-x1)*(y2-y1);
    }
}
