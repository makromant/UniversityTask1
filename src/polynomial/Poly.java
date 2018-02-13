package polynomial;

public class Poly{
	private final int[] variables;
	private final int length;

	Poly(int[] variables){
		this.variables = variables;
		length = this.variables.length;
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
			polyValue += Math.pow(x, power)*element;
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
			for(int i = smaller; i<larger;i++){
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
		for(int i = 0; i<smaller; i++){
			newVariables[i] = variables[i] - objVariables[i];
		}
		
		if (larger != smaller){
			for(int i = smaller; i<larger;i++){
				newVariables[i] = -largerVariables[i]; 
			}
	   	}
		return new Poly(newVariables);
	}
	
	public int[] getVariables(){
		return variables;
	}

	public int getLength(){
		return length;
	}
}
