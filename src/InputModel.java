import java.util.Arrays;

/**
 * 
 * @author swethaprasad
 *saves each example as an array of attributes and class label.
 */
public class InputModel {

	int attr[];

	int classLabel;

	

	public InputModel(String line){
		String[] splitLine= line.split("\\s+");
		attr= new int[splitLine.length];
		attr[0]=1;
		for(int i=1,k=0;i<splitLine.length;i++,k++){
			attr[i]=Integer.parseInt(splitLine[k]);
		}

		classLabel=Integer.parseInt(splitLine[splitLine.length-1]);
		

	}

	public int[] getAttr() {
		return attr;
	}

	public int getClassLabel() {
		return classLabel;
	}

	@Override
	public String toString() {
		return "InputModel [attr=" + Arrays.toString(attr) + ", classLabel="
				+ classLabel + "]";
	}








}
