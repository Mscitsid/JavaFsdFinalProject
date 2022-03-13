package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe
{
	static final String projectFilesPath="C:\\Users\\Mhatre\\Documents\\Simplilearn\\Full Stack Java Developer\\Day 9 Projects\\Files Project 9";
		
	/**
	 * This method will display the menu for end users
	 * 
	 */
		public static void displayMenu()
	{
			System.out.println("********************************************************");
			System.out.println("\tWelcome to LockedMe.com secure App");
			System.out.println("\tDeveloped by : Siddhant H Mhatre");
			System.out.println("********************************************************");		
			System.out.println("\t1. Display all files");
			System.out.println("\t2. Add a new file");
			System.out.println("\t3. Delete a file");
			System.out.println("\t4. Search file");
			System.out.println("\t5. Exit");
			System.out.println("********************************************************");
	  }
		/**
		 * This method will retrieve all files
		 * 
		 */
	
		public static void getAllFiles()
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
	
		if(listOfFiles.length> 0)
		{
			System.out.println("FILES LIST IS BELOW:\n");
			for(var l:listOfFiles)
			{
				System.out.println(l.getName());
			}
		}
		else
		{
			System.out.println("The Folder Is Empty");
		}
	}
		/**
		 * This method will read file detail rom user and create files
		 */
	
		public static void createFiles()
		{
			try
			{	//Variable declaration
				Scanner obj = new Scanner(System.in);
				String fileName;
				
				//Read file name from user
				System.out.println("Enter file name:");
				fileName=obj.nextLine();
				
				int linesCount;
				System.out.println("Enter how many lines in the file ");
				linesCount=Integer.parseInt(obj.nextLine());
				

				FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
				
				//Read line by line from user
				for(int i=1;i<=linesCount;i++)
				{
					System.out.println("Enter file Line");
					fw.write(obj.nextLine()+"\n");
				}
				
				System.out.println("File Created Successfully");
				fw.close();
			
			}
			catch(Exception Ex)
			{
				
			}
		}
		/**
		 * This method will take file as parameters and checks if
		 *  it is present in the project folder or not
		 * @param fileName String
		 * @return boolean
		 */
		public static boolean checkFileExists(String fileName)
	{
		// Get all files into a list
			ArrayList<String> allFilesNames = new ArrayList<String>();
			
			File folder = new File(projectFilesPath);
			
			File[] listOfFiles = folder.listFiles();
				
				if(listOfFiles.length>0)
				{
						for(var l :listOfFiles)
						{
							allFilesNames.add(l.getName());
						}
					}
				return allFilesNames.contains(fileName);
					
	}
	
		public static void deleteFiles()
		{
			try 
			{
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter file name to be deleted:");
			fileName=obj.nextLine();
			File f = new File(projectFilesPath+"\\"+fileName);
		
				if(checkFileExists(fileName))
			{
				f.delete();
				System.out.println("File deleted Successully");
			}
			else
			{
				System.out.println("File does not exist");
			}
		}
			catch(Exception Ex)
			{
				System.out.println("Unable to delete file. \n\t\t Please Contact : admin@test.com");
			}
}		
			
		public static void searchFiles()
		{
			try
			{
				Scanner obj= new Scanner(System.in);
				String fileName;
				System.out.println("Enter the file name to searched");
				fileName = obj.nextLine();
							
			if(checkFileExists(fileName))
			{
				System.out.println("File is available");
			}
			else
			{
				System.out.println("File is not available");
			}
		}
			
		catch(Exception Ex)
			{
				
			}
		}	
		
}

