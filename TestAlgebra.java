class TestAlgebra {
    public static int plus(int a , int b) {
    for (int i=0; i<b; i++){
        a++;
    }
    return a;
}

public static int minus(int a , int b) {
    for (int i=0; i<b; i++){
        a--;
    }
    return a ;
}

public static int times(int a , int b) {
    int result=0;
    for (int i=0; i<b; i++){
        result+=a;  
    }
    return result ;
}

public static int pow(int a, int b) {
    int result= 1;
    for (int i=0; i<b; i++){
        result *= a;
    }
    return result;
}

public static int div(int a , int b) {
    int count=0;
    while (a>=b) {
        a-=b;
        count++;
    }
    return count;
}

public static int mod(int a , int b) {
    int result=a;
    while (result>=b) {
        result-=b;
    }
    return result;
}

public static int sqrt(int a) {
    int result=1;
    while (times(result,result)<=a) {
        result++;
    }
    return (result-1);
}

public static void main(String[] args) {
    System.out.println("Plus: " + plus(1, 2));    // 3
    System.out.println("Minus: " + minus(4, 3));  // 1
    System.out.println("Times: " + times(3, 4));  // 12
    System.out.println("Pow: " + pow(2, 4));      // 16
    System.out.println("Div: " + div(9, 2));     // 4
    System.out.println("Mod: " + mod(10, 3));     // 1
    System.out.println("Sqrt: " + sqrt(25));      // 5
}
}