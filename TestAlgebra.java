private static int testPow() {
        System.out.println("\nTesting power operations:");
        totalTests += 6;
        
        boolean test1 = Algebra.pow(5, 3) == 125;
        System.out.println("Test 1 (basic power): " + (test1 ? "PASS" : "FAIL"));
        
        boolean test2 = Algebra.pow(2, 0) == 1;
        System.out.println("Test 2 (zero exponent): " + (test2 ? "PASS" : "FAIL"));
        
        boolean test3 = Algebra.pow(0, 5) == 0;
        System.out.println("Test 3 (zero base): " + (test3 ? "PASS" : "FAIL"));
        
        boolean test4 = Algebra.pow(1, 10) == 1;
        System.out.println("Test 4 (identity): " + (test4 ? "PASS" : "FAIL"));
        
        boolean test5 = Algebra.pow(2, 4) == 16;
        System.out.println("Test 5 (power of 2): " + (test5 ? "PASS" : "FAIL"));
        
        boolean test6 = Algebra.pow(-2, 3) == -8;
        System.out.println("Test 6 (negative base): " + (test6 ? "PASS" : "FAIL"));

        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (test3 ? 1 : 0) + 
                    (test4 ? 1 : 0) + (test5 ? 1 : 0) + (test6 ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    private static int testDiv() {
        System.out.println("\nTesting division operations:");
        totalTests += 6;
        
        boolean test1 = Algebra.div(12, 3) == 4;
        System.out.println("Test 1 (basic division): " + (test1 ? "PASS" : "FAIL"));
        
        boolean test2 = Algebra.div(25, 7) == 3;
        System.out.println("Test 2 (integer division): " + (test2 ? "PASS" : "FAIL"));
        
        boolean test3 = Algebra.div(0, 5) == 0;
        System.out.println("Test 3 (zero dividend): " + (test3 ? "PASS" : "FAIL"));
        
        boolean test4 = Algebra.div(100, 10) == 10;
        System.out.println("Test 4 (large numbers): " + (test4 ? "PASS" : "FAIL"));
        
        boolean test5 = Algebra.div(-15, 3) == -5;
        System.out.println("Test 5 (negative dividend): " + (test5 ? "PASS" : "FAIL"));
        
        boolean test6 = Algebra.div(-15, -3) == 5;
        System.out.println("Test 6 (negative numbers): " + (test6 ? "PASS" : "FAIL"));

        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (test3 ? 1 : 0) + 
                    (test4 ? 1 : 0) + (test5 ? 1 : 0) + (test6 ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    private static int testMod() {
        System.out.println("\nTesting modulo operations:");
        totalTests += 6;
        
        boolean test1 = Algebra.mod(25, 7) == 4;
        System.out.println("Test 1 (basic modulo): " + (test1 ? "PASS" : "FAIL"));
        
        boolean test2 = Algebra.mod(120, 6) == 0;
        System.out.println("Test 2 (no remainder): " + (test2 ? "PASS" : "FAIL"));
        
        boolean test3 = Algebra.mod(0, 5) == 0;
        System.out.println("Test 3 (zero dividend): " + (test3 ? "PASS" : "FAIL"));
        
        boolean test4 = Algebra.mod(7, 3) == 1;
        System.out.println("Test 4 (small numbers): " + (test4 ? "PASS" : "FAIL"));
        
        boolean test5 = Algebra.mod(17, 5) == 2;
        System.out.println("Test 5 (larger numbers): " + (test5 ? "PASS" : "FAIL"));
        
        boolean test6 = Algebra.mod(100, 10) == 0;
        System.out.println("Test 6 (divisible): " + (test6 ? "PASS" : "FAIL"));

        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (test3 ? 1 : 0) + 
                    (test4 ? 1 : 0) + (test5 ? 1 : 0) + (test6 ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    private static int testSqrt() {
        System.out.println("\nTesting square root operations:");
        totalTests += 6;
        
        boolean test1 = Algebra.sqrt(36) == 6;
        System.out.println("Test 1 (perfect square): " + (test1 ? "PASS" : "FAIL"));
        
        boolean test2 = Algebra.sqrt(0) == 0;
        System.out.println("Test 2 (zero): " + (test2 ? "PASS" : "FAIL"));
        
        boolean test3 = Algebra.sqrt(1) == 1;
        System.out.println("Test 3 (one): " + (test3 ? "PASS" : "FAIL"));
        
        boolean test4 = Algebra.sqrt(263169) == 513;
        System.out.println("Test 4 (large perfect square): " + (test4 ? "PASS" : "FAIL"));
        
        boolean test5 = Algebra.sqrt(76123) == 275;
        System.out.println("Test 5 (floor value): " + (test5 ? "PASS" : "FAIL"));
        
        boolean test6 = Algebra.sqrt(10000) == 100;
        System.out.println("Test 6 (power of 10): " + (test6 ? "PASS" : "FAIL"));

        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (test3 ? 1 : 0) + 
                    (test4 ? 1 : 0) + (test5 ? 1 : 0) + (test6 ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    private static int testForbiddenOperators() {
        System.out.println("\nTesting forbidden operators:");
        totalTests += 1;
        
        try {
            String algebraCode = new String(Files.readAllBytes(Paths.get("Algebra.java")));
            algebraCode = algebraCode.replaceAll("\".*\"", "")
                                   .replaceAll("/\\*.*?\\*/", "")
                                   .replaceAll("//.*", "");
            
            String[] forbidden = {
                "\\+[^+]", "-[^-]", "\\*", "/", "%", "Math\\.pow", "Math\\.sqrt"
            };

            for (String operator : forbidden) {
                if (algebraCode.matches(".*" + operator + ".*")) {
                    System.out.println("Test 1 (no forbidden operators): FAIL");
                    System.out.println("Found forbidden operator matching: " + operator);
                    return 0;
                }
            }
            System.out.println("Test 1 (no forbidden operators): PASS");
            passedTests += 1;
            return 1;
        } catch (IOException e) {
            System.out.println("Test 1 (no forbidden operators): FAIL");
            System.out.println("Could not read Algebra.java");
            return 0;
        }
    }

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
    if (b==0) return a;
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