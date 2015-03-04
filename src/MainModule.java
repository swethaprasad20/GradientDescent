import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * 
 * @author swethaprasad
 *
 *This program trains preceptron weights using gradient descent
 *weights are updated online
 *
 *4 arguments
 * 1 - training data file
 * 2 - test data file
 * 3 - training rate
 * 4 - iterations
 */
public class MainModule {
	public static void main(String[] args){
		if(args==null || args.length!=4){
			System.out.println("Please enter 4 arguments");
			System.exit(0);
		}

		try {
			List<InputModel> trainingSet= IOUtilities.readInputFile(args[0]);

			// initializing weights to 0
			PerceptronInput perceptronInput= new PerceptronInput();
			perceptronInput.setInputModelList(trainingSet);
			perceptronInput.initializeWeights(trainingSet.get(0));

			// training weights by reading training examples
			PerceptronUtiltities perceptronUtiltities= new PerceptronUtiltities();
			perceptronUtiltities.trainWeights(perceptronInput, Double.parseDouble(args[2]), Integer.parseInt(args[3]));

			//calculating the accuracy on the training data
			double accOnTraining= MathUtilities.calculateAccuracy(trainingSet,perceptronInput.getWeights());
			System.out.println("Accuracy on training set ( "+trainingSet.size()+" instances ) : "+MathUtilities.roundToThreeDecimalAccuracy(accOnTraining*100)+"%");

			//calculating the accuracy on the test data
			List<InputModel> testSet= IOUtilities.readInputFile(args[1]);
			double accOnTest=MathUtilities.calculateAccuracy(testSet,perceptronInput.getWeights());
			System.out.println("Accuracy on test set ( "+testSet.size()+" instances ) : "+MathUtilities.roundToThreeDecimalAccuracy(accOnTest*100)+"%");


		} catch (MalformedURLException e) {
			System.out.println("Entered URL is not in the right format. \n URL should look like http://www.hlt.utdallas.edu/~yangl/cs6375/homework/hw1/");
		} catch (IOException e) {
			System.out.println("Exception occured while reding input files. Make sure you are connected to the internet.");
		}
	}
}
