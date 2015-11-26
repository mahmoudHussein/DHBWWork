import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;

import javax.swing.JFileChooser;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
public class FileCreatorV2 {

public static void FileAppending(File[] excels) throws IOException{
	for(int i = 0; i <excels.length; i++){
		String csvFilename = ""+excels[i];    //convert the file name into a string to be read by the filereader
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row = null;
		String [] headings = csvReader.readNext();
		while((row = csvReader.readNext()) != null) { //reading the line ... this while loop is where eveything will be modified
			String[] WritingRow = new String[8]; 
			String lastName = row[0];
			WritingRow[0] = lastName;
			String firstName = row[1];
			WritingRow[1] = firstName;
			if(!row[2].equals("")){
			String Birthdate = dateChanger(row[2]);    // birthday here eg.20/07/1993 we need to change that to the sql date format which is 1993 - 07 - 20
			System.out.println(Birthdate);
			WritingRow[2] = Birthdate;
			}else{
				WritingRow[2] = "0000-00-00";
			}
			if(!row[3].equals("")){
			String ContractStarted = dateChanger(row[3]);
			System.out.println(ContractStarted);
			WritingRow[3] = ContractStarted;
			}else{
				WritingRow[3] = "0000-00-00";
			}
			if(!row[4].equals("")){
			String ContractEnded = dateChanger(row[4]);
			System.out.println(ContractEnded);
			WritingRow[4] = ContractEnded;
			}else{
				WritingRow[4] = "0000-00-00";
			}
			String LivingAddress = row[5];
			WritingRow[5] = LivingAddress;
			String AddressZipCode = row[6];
			WritingRow[6] = AddressZipCode;
			String City = row[7];
			WritingRow[7] = City;
			
			AddLineToDB(WritingRow);
		}	
		csvReader.close();
	}
	System.out.println("done");
}

public static void AddLineToDB(String[] WritingRow){
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "dhbw_personal" ;
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root"; 
	String password = "mahmoud";
try{
	Class.forName(driver).newInstance();
	Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	//System.out.println("connected");
	Statement st = conn.createStatement();
	int val = st.executeUpdate("INSERT into employees VALUES(\""+ WritingRow[0] +"\",\""+ WritingRow[1] +"\",'"+WritingRow[2]+"','"+WritingRow[3]+"','"+ WritingRow[4]+"',\""+ WritingRow[5]+"\",\""+WritingRow[6]+"\",\""+ WritingRow[7]+"\")");
	if (val ==1){
		System.out.println("successfully inserted value");
	}
	conn.close();
} catch(Exception e){
	e.printStackTrace();
}
}

public static String dateChanger(String date){
	String[] newDate = date.split("/");
	String NewDate = newDate[2]+"-"+ newDate[0]+"-"+ newDate[1];
//	System.out.println(NewDate);
	return NewDate;
	
	
}

public static void ChoosingRecords() throws IOException{
	final JFileChooser chooser = new JFileChooser();
	chooser.setMultiSelectionEnabled(true);
	chooser.showOpenDialog(null);
	File[] excels = chooser.getSelectedFiles();
    FileAppending(excels);
    
}
public static void main(String[]args) throws IOException{
	
	ChoosingRecords();
    
}
/*	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "Test" ;
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root"; 
	String password = "mahmoud";
try{
	Class.forName(driver).newInstance();
	Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	System.out.println("connected");
	Statement st = conn.createStatement();
	int val = st.executeUpdate("INSERT into employees VALUES(1,\"Abdoulaye Ibouraima\",\" Kadri\",'1970-01-10',2008,\" Heinrich-Lanz-Str. 43\",\"Mannheim\")");
	if (val ==1){
		System.out.println("successfully inserted value");
	}
	conn.close();
} catch(Exception e){
	e.printStackTrace();
}*/
}
	

