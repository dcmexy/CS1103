import java.io.*;
import java.net.*;

/**
 * This is IO Operations task for Unit 1
 * @author Dean C.
 *
 */
public class OperationsIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input = null;
		OutputStream output = null;
		
		// Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        
        System.out.println("Please enter a valid url for the file: ");
        try {
        	URL url = new URL(reader.readLine());
        	input = url.openStream();
        	System.out.println("Please enter a valid full filepath for output: ");
        	String filename = reader.readLine();
        	System.out.println("filename is " + filename);
        	output = new FileOutputStream(filename);
        	
        	// Copy stream
        	copyStream(input, output);
        	System.out.println("Success!");
        	
        } catch(MalformedURLException mue) {
        	System.out.println("ERROR! The value you entered in not a valid URL");
        } catch(FileNotFoundException fnf) {
        	System.out.println("ERROR! The output filename does not exist or you do not have the right permissions");
        }catch(IOException ioe) {
        	System.out.println("ERROR! There was an error reading your input.");
        } catch(Exception e) {
        	System.out.println(e);
        } finally {
        	try {
	        	if(input != null) {
	        		input.close();
	        	}
	        	if(output != null) {
	        		output.close();
	        	}
        	} catch(Exception e) {
        		System.out.println("ERROR! There was a little problem finishing up");
        	}
        	
        	System.out.println("Finished!");
        }

	}
	
	/*
	 * CopyStream method adapted from Eck (2019).
	 */
	private static void copyStream(InputStream in, OutputStream out) throws IOException {
		int oneByte = in.read();
		
		while (oneByte >= 0) { // negative value indicates end-of-stream
			out.write(oneByte);
			oneByte = in.read();
		}
	}

}
