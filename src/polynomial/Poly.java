package polynomial;

public class Poly{
	private final int[] variables;
	private final int length;

	Poly(int[] variables){
		this.variables = variables;
		length = this.variables.length;
	}
	
	private void zeroException(int[] objVariables, int objLength){
		if (objLength == 0 || (objLength == 1 && objVariables[0] == 0)
									  || length == 0 || (length == 1 && variables[0] == 0)){
			throw new  ArithmeticException("");
		} 
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
		int[] newVariables = new int[larger];
		for(int i = 0; i < smaller; i++){
			newVariables[i] = variables[i] - objVariables[i];
		}
		
		if (larger != smaller){
			for(int i = smaller; i < larger;i++){
				newVariables[i] = -largerVariables[i]; 
			}
	   	}
		return new Poly(newVariables);
	}

	private Poly div(Poly obj, boolean which){
		int [] objVariables = obj.getVariables();
		int objLength = obj.getLength();
		zeroException(objVariables, objLength);
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

	public Poly remainderOfDiv(Poly obj){
		return div(obj, false);
	}

	public int[] getVariables(){
		return variables;
	}

	public int getLength(){
		return length;
	}
	
}
