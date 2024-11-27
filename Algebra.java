// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int a , int b) {
		for (int i=0; i<b; i++){
			a++;
		}
		return a;
	}

	// Returns x1 - x2
	public static int minus(int a , int b) {
		if (b<0){
			return plus (a,-b);
		}
		for (int i=0; i<b; i++){
			a--;
		}
		return a ;
	}

	// Returns x1 * x2
	public static int times(int a , int b) {
		boolean negative =false;
		if (b<0){
			b= minus(0,b);
			negative = !negative;
		}
		if (a<0){
			a= minus(0,a);
			negative = !negative;
		}
		int result=0;
		for (int i=0; i<b; i++){
			result+=a;  
		}
		return result ;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int a, int b) {
		if (b==0) return 1;
		int result= 1;  
		for (int i=0; i<b; i++){
			result *= a;
		}
		
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int a , int b) {
		boolean negative= false;
		if (a<0) {
			a=times(a,-1);
			negative= !negative;
		}
		if (b<0){
			b=times(b,-1);
			negative= !negative;
		}
		int count=0;
		while (a>=b) {
			a-=b;
			count++;
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int a , int b) {
		int result=a;
		while (result>=b) {
			result-=b;
		}
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int a) {
		int result=1;
		while (times(result,result)<=a) {
			result++;
		}
		return (result-1);
	}
}	
 	  