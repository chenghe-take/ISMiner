import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class MainISMiner {

	public static void main(String [] arg) throws IOException, ClassNotFoundException{

		// The input directory containing a dynamic attributed graph
//		String inputDirectory = fileToPath("DB_TSEQMINER") + File.separator;
//		String inputDirectory = "/Users/me/Documents/DYNAMIC_GRAPH_DATASETS_REDUCED/TSEQMINER_datasets/GrayValue4000/Graph03/Interval120/";
		String inputDirectory = "Data/USFlight/";


		// The output file path
		String outputPath = "output.txt";
		
		//PARAMETER 1: discretization threshold (float)
		// If the value is 2, it means when (next_value - cur_value) >= 2,
		// the trend is '+' and when (next_value - cur_value) <= -2, the trend is '-'. Otherwise the trend is '0'.
        float discretizationThreshold = 0.1f;
        
        // PARAMETER 2: A frequent sequence should satisfy that the frequency 
        // of the first item in sequence >= minInitSup.
        float minInitSup = 0.005f; //0.005f
        
        // PARAMETER 3: A frequent sequence should satisfy that the number of 
        // tail point of the sequence >= minTailSup.
        float minHeadSup = 0.01f;  //0.001f
        
        // PARAMETER 4: A significant sequence should satisfy that the significance
        // between any two items in sequence is >= minSig.
        float minAll = 0.04f;  // 0.05f
        
        // PARAMETER 5: the number of considered attributes  (int)
        int attributeCount = 8; //43 for DBLP or 8 for USFlight

		// PARAMETER 6: output supporting points for sequences
		boolean exhibit_supporting_points = true;

		// Note that there are more parameters that can be used in the source code,
        // in the class ParametersSetting.java. 
        // They can be used for very specific cases.
		
		// Apply the algorithm 
		AlgoISMiner algo = new AlgoISMiner();
		algo.runAlgorithm(inputDirectory, outputPath, discretizationThreshold,
				minInitSup, minHeadSup, minAll, attributeCount, exhibit_supporting_points);
		
		// Print statistics about the algorithm execution
		algo.printStats();

	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainISMiner.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
