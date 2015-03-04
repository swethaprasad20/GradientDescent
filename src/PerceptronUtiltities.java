import java.util.Arrays;




public class PerceptronUtiltities {
	
	/**
	 * trains the weights using gradient descent
	 * 
	 * each input is read and delta weights are calculated.
	 * weights are updated.
	 * 
	 * @param perceptronInput
	 * @param trainingRate
	 * @param numberOfIterations
	 */

	public void trainWeights(PerceptronInput perceptronInput, double trainingRate, int numberOfIterations ){
		int trainingIteration=numberOfIterations;

		while(trainingIteration>0){

			for(InputModel in: perceptronInput.getInputModelList()){
				if(trainingIteration==0){
					return;
				}
				double sigmoid=MathUtilities.getSigmoid(in,perceptronInput.getWeights());
				
				double error=in.getClassLabel()-sigmoid;
				for(int k=0;k< in.getAttr().length;k++){

					double deltaWeight=MathUtilities.getDeltaWeight(error,sigmoid,in.getAttr()[k],trainingRate);
					perceptronInput.adjustWeight(k, deltaWeight);

					
				}
				//System.out.println("At iteration "+(numberOfIterations-trainingIteration+1)+" weights ==>"+Arrays.toString(perceptronInput.getWeights()));
				trainingIteration--;
			}
		}
	}
}

