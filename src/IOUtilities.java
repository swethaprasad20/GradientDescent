import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author swethaprasad
 *
 *
 *reads training and test file and saves the data in InputModel.
 */
public class IOUtilities {

	/**
	 * reading the input file from internet.
	 * @param urlParam
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static List<InputModel> readInputFile(String urlParam) throws MalformedURLException,IOException {

		URL url;
		BufferedReader reader = null;
		List<InputModel> inputFile = new ArrayList<InputModel>();
		try {
			url = new URL(urlParam);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String line = null;
			boolean firstLine=true;
			// skipping first line as it contains attributes name.
			while ((line = reader.readLine()) != null) {
				if(line!=null && !line.equals("")){
					if(firstLine){

						firstLine=false;
					}else {

						InputModel attr= new InputModel(line);
						inputFile.add(attr);

					}
				}

			}



		} finally {

			if (reader != null){
				reader.close();
			}

		}

		return inputFile;
	}




}
