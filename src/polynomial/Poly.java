package src.polynomial;

public class Poly{
	private final int[] variables;
	private final int length;

   
	Poly(int[] variables){
		this.variables = variables;
		length = this.variables.length;
	}
	
	private boolean isZero(int[] objVariables, int objLength){
		if (objLength == 0 || (objLength == 1 && objVariables[0] == 0)
									  || length == 0 || (length == 1 && variables[0] == 0)){
			return true;
		}
		return false;
	}
	
	//@Override
	public boolean equals(Poly obj){
		int[] objVariables = obj.getVariables();
		if (length == obj.getLength()){
			for (int i = 0; i<length; i++){
				if (variables[i] != objVariables[i]){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	
	public long value(int x){
		int power = 0;
		long polyValue = 0;
		for (int element:variables){
			polyValue += Math.pow(x, power) * element;
			power++;
		}
		return polyValue;
	}
	
	public Poly sum(Poly obj){
		int objLength = obj.getLength();
		int [] objVariables = obj.getVariables();
		int larger;
		int smaller;
		int[] largerVariables;
		if (length > objLength){
			largerVariables = variables;
			larger = length;
			smaller = objLength;
		} else{
			largerVariables = objVariables;
			larger = objLength;
			smaller = length;
		}
		int[] newVariables = new int[larger];
		for(int i = 0; i<smaller; i++){
			newVariables[i] = variables[i] + objVariables[i];
		}
		
		if (larger != smaller){
			for(int i = smaller; i < larger;i++){
				newVariables[i] = largerVariables[i]; 
			}
	   	}
		return new Poly(newVariables);
	}

	public Poly subtraction(Poly obj){
		int objLength = obj.getLength();
		int [] objVariables = obj.getVariables();
		int larger;
		int smaller;
		int[] largerVariables;
		if (length > objLength){
			largerVariables = variables;
			larger = length;
			smaller = objLength;
		} else{
			largerVariables = objVariables;
			larger = objLength;
			smaller = length;
		}
		int[] resultVariables = new int[larger];
		for(int i = 0; i < smaller; i++){
			resultVariables[i] = variables[i] - objVariables[i];
		}
		
		if (larger != smaller){
			for(int i = smaller; i < larger;i++){
				resultVariables[i] = -largerVariables[i]; 
			}
	   	}
		return new Poly(resultVariables);
	}

	private Poly div(Poly obj, boolean which){
		int [] objVariables = obj.getVariables();
		int objLength = obj.getLength();
		if(isZero(objVariables, objLength)){
			throw new IllegalArgumentException("");
		}
		int[] divider;
		int[] divisor;
		if (length > objLength){
		    divider = variables;
			divisor = objVariables;
		} else{
			divider = objVariables;
		    divisor = variables;
		}
		int[] remainder = divider;
		int[] quotient = new int[divider.length - divisor.length + 1];
		for (int i = 0; i < quotient.length;i++){
			int coefficient = remainder[remainder.length - i - 1] / divisor[0];
			quotient[quotient.length - i - 1] = coefficient;
			for (int j = 0; j < divisor.length; j++){
				remainder[remainder.length - i - j - 1] -= coefficient * divisor[divisor.length - j - 1];
			}
		}
		if (which){
			return new Poly(quotient);
		}
		else{
			return new Poly(remainder);
		}
	}
	
	public Poly division(Poly obj){
		return div(obj, true);
   	}

	public Poly remainder(Poly obj){
		int[] remainder = div(obj, false).getVariables();
		for (int i = remainder.length - 1; i >= 0; i--){
			if (remainder[i] != 0){
				int[] result = new int[i+1];
				for (int j=0;j<=i;j++){
					result[j] = remainder[j];
				}
				return new Poly(result);
			}
		}
		return new Poly(remainder);
	}

	public Poly multiplication(Poly obj){
		int objLength = obj.getLength();
		int [] objVariables = obj.getVariables();
		if (isZero(objVariables, objLength)){
			int[] emptyArray = {0};
			return new Poly(emptyArray);
		}
		int[] resultVariables = new int[length + objLength - 1];
		for(int x : resultVariables){
			x = 0;
		}
		int larger;
		int smaller;
		int[] largerVariables;
		int[] smallerVariables;
		if (length > objLength){
			largerVariables = variables;
			smallerVariables = objVariables;
			larger = length;
			smaller = objLength;
		} else{
			largerVariables = objVariables;
			smallerVariables = variables;
			larger = objLength;
			smaller = length;
		}
		for(int i = 1; i < larger + 1; i++){
			for(int j = 1; j < smaller + 1; j++){
				resultVariables[i + j - 2] += largerVariables[i - 1] * smallerVariables[j - 1];
			}
		}
		return new Poly(resultVariables);
	}

	public int[] getVariables(){
		return variables;
	}

	public int getLength(){
		return length;
	}
	
	public static void printVariables(Poly obj){
		for (int element : obj.getVariables()){
			System.out.print(element + " ");
		}
	}
}
