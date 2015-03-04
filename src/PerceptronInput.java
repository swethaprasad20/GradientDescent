
import java.util.List;

/**
 * saves training / test examples and weights
 * @author swethaprasad
 *
 */
public class PerceptronInput {
	
	double weights[];
	
	List<InputModel> inputModelList;

	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}

	public List<InputModel> getInputModelList() {
		return inputModelList;
	}

	public void setInputModelList(List<InputModel> inputModelList) {
		this.inputModelList = inputModelList;
	}
	

	public void adjustWeight(int k, double delta) {
		this.weights[k]=MathUtilities.roundToThreeDecimal(this.weights[k]+delta);
		
	}

	public void initializeWeights(InputModel inputModel) {
		this.weights= new double[inputModel.getAttr().length];
		
	}
	

}

