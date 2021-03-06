package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class PrintDisplay extends OutputFileName{
	
	private Scanner console = new Scanner(System.in);

	//Running time: Linear O(N);
	public void print(boolean option) {
		String fileName = "", line = null;
		int userSelection;
		
		//get the instance of the file name access the name that was chosen
		OutputFileName file = OutputFileName.getFileInstance();
		
		do
		{
        	System.out.println("\nWould you like to print the text to screen?");
            System.out.println(" (1) Yes\n (2) No");
            userSelection = console.nextInt();
            
            if (userSelection > 2 || userSelection <= 0) {
            	System.out.println("Invalid selction, please try again");
            }
		}while (!(userSelection == 1)&&!(userSelection == 2));//checks for correct input
		
		//print the encrypted/decrypted text to the screen.
		if (userSelection == 1) {
			//if false then it's for encryption, so set the file name to what was entered.
			if (option == false) {
				fileName = file.getEncryptFileName() + ".txt";
			}
			else {
				fileName = file.getDecryptFileName() + ".txt";
			}
			
			try {
				//print the passed stringbuilder to a file
				BufferedReader br = new BufferedReader(new FileReader("./" + fileName));
				
				while((line = br.readLine())!= null)
				{
					System.out.println(line);
				}
				//close the file
				br.close();
			}
			 catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Unable print to console");
			}
		} //if
	}
}
