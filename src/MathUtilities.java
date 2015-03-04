import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * 
 * @author swethaprasad
 * Mathematical calculations
 */
public class MathUtilities {

	/**
	 * Calculating sigmoid output = 1/(1+e^-x)
	 * @param in
	 * @param weights
	 * @return
	 */
	public static double getSigmoid(InputModel in, double[] weights) {
		int dotProduct=0;
		for(int i=0;i<(in.getAttr().length)-1;i++){
			dotProduct+=(in.getAttr()[i]*weights[i]);
		}
		dotProduct=dotProduct*(-1);

		return roundToThreeDecimal((double) 1.0/(1.0+(Math.exp((double)dotProduct))));



	}
	/**
	 * rounding input values to 3 decimal places
	 * @param d
	 * @return
	 */

	public static double roundToThreeDecimal(double d){

		/*BigDecimal bd = new BigDecimal(d);
		bd = bd.round(new MathContext(4));
		return (bd.doubleValue());*/
		
		return d;
		
		


	}
	
	/**
	 * rounding input accuracy values to 3 decimal places
	 * @param d
	 * @return
	 */

	public static double roundToThreeDecimalAccuracy(double d){

		BigDecimal bd = new BigDecimal(d);
		bd = bd.round(new MathContext(4));
		return (bd.doubleValue());
		

		
		


	}

	/**
	 *  calculating delta weights as trainingRate* sigmoid*(1-sigmoid)*attribute value
	 * @param error
	 * @param sigmoid
	 * @param attr
	 * @param trainingRate
	 * @return
	 */
	public static double getDeltaWeight(double error, double sigmoid,int attr, double trainingRate) {

		double deltaWeight=trainingRate*error*sigmoid*(1-sigmoid)*attr;
		return roundToThreeDecimal(deltaWeight);
	}

	/**
	 * Calculating accuracy on test and train data.
	 * @param inputSet
	 * @param weights
	 * @return
	 */
	public static double calculateAccuracy(List<InputModel> inputSet,double[] weights) {
		double rightPrediction=0,wrongPrediction=0;
		for(InputModel in : inputSet){
			double prediction = getSigmoid(in,weights)	;
			int predictionInt=prediction>=0.5?1:0;
			if(predictionInt == in.getClassLabel()){
				rightPrediction++;
			}else{
				wrongPrediction++;
			}
		}
		return ((double)((double)rightPrediction/(double)(rightPrediction+wrongPrediction)));

	}

}
