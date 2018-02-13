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
	
	public int[] getVariables(){
		return variables;
	}

	public int getLength(){
		return length;
	}
}
