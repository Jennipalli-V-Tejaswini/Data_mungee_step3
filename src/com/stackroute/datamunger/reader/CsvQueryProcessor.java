package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
   private String file = new String();
   private BufferedReader crunchifyBuffer = null;
   public String[] frow;
   public String[] srow;
   
   
    // parameterized constructor to initialize filename
    public CsvQueryProcessor(String fileName) throws FileNotFoundException {
            this.file=fileName;
            crunchifyBuffer = new BufferedReader(new FileReader(file.trim()));
            try {
                this.frow =crunchifyBuffer.readLine().split(",");
            
                this.srow =crunchifyBuffer.readLine().split(",",-1);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
    }

    /*
     * implementation of getHeader() method. We will have to extract the headers
     * from the first line of the file.
     * Note: Return type of the method will be Header
     */
    @Override
    public Header getHeader() throws IOException {
     Header header = new Header();
        // read the first line
        header.harr=frow;
        // populate the header object with the String array containing the header names
        return header;
    }

    /**
     * getDataRow() method will be used in the upcoming assignments
     */
    @Override
    public void getDataRow() {

    }

    /*
     * implementation of getColumnType() method. To find out the data types, we will
     * read the first line from the file and extract the field values from it. If a
     * specific field value can be converted to Integer, the data type of that field
     * will contain "java.lang.Integer", otherwise if it can be converted to Double,
     * then the data type of that field will contain "java.lang.Double", otherwise,
     * the field is to be treated as String.
     * Note: Return Type of the method will be DataTypeDefinitions
     */
    @Override
    public DataTypeDefinitions getColumnType() throws IOException {
       
        int size = srow.length;
        DataTypeDefinitions datatypedefinitions = new DataTypeDefinitions();
        datatypedefinitions.htype=srow;
        for(int i=0;i< size;i++) {
           
            if (srow[i].matches("^-?\\d+$"))
                datatypedefinitions.htype[i]= "java.lang.Integer";
            else
                datatypedefinitions.htype[i]= "java.lang.String";
        }
       
       
       
        return datatypedefinitions;
    }
}