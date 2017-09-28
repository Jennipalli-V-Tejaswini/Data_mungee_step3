package com.stackroute.datamunger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.reader.CsvQueryProcessor;

public class DataMunger {

	public static void main(String[] args)   {
		
		// read the file name from the user
		
		System.out.println("Enter file Name");
        Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		
			/*
			 * create object of CsvQueryProcessor. We are trying to read from a file inside
			 * the constructor of this class. Hence, we will have to handle exceptions.
			 */
			try {
			CsvQueryProcessor csvQueryProcessor = new CsvQueryProcessor(str);
			
			/*
			 * call getHeader() method of CsvQueryProcessor class to retrieve the array of
			 * headers
			 */
			Header header = new Header();
			try {
			header = csvQueryProcessor.getHeader();
			
			System.out.println(header.harr[17]);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			/*
			 * 
			 * call getColumnType() method of CsvQueryProcessor class to retrieve the array
			 * of column data types which is actually the object of DataTypeDefinitions
			 * class
			 */
			DataTypeDefinitions datatypedefinitions = new DataTypeDefinitions();
			try {
			datatypedefinitions = csvQueryProcessor.getColumnType();
			System.out.println(datatypedefinitions.htype[17]);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			
			/*
			 * display the columnName from the header object along with its data type from
			 * DataTypeDefinitions object
			 */
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

        
       
		

		

	}

}