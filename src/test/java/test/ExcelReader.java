package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import utility.Exelsheet;

public class ExcelReader {


    public static String reader1User() throws EncryptedDocumentException, IOException
    {
        String user = Exelsheet.read( "Credentials",0,0);
        return user;
    }
    public static String reader1Pass() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",0,1);
    }
    public static String read2User() throws EncryptedDocumentException, IOException {

        return Exelsheet.read( "Credentials",1,0);
    }
    public static String read2Pass() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",1,1);
    }
    public static String read3User() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",2,0);
    }
    public static String read3Pass() throws EncryptedDocumentException, IOException {
        return Exelsheet.read( "Credentials",2,1);
    }
    public static String read4User() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",3,0);
    }
    public static String read4Pass() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",3,1);

    }
    public static String readFirstName() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",6,0);

    }
    public static String readLastName() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",6,1);

    }
    public static String readPincode() throws EncryptedDocumentException, IOException
    {
        return Exelsheet.read( "Credentials",6,2);

    }



}
