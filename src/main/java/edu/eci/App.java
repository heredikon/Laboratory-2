package edu.eci;
import java.net.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            URL escuela = new URL("http://www.escuelaing.edu.co:80/");
            System.out.println(escuela.getProtocol());
            System.out.println(escuela.getAuthority());
            System.out.println(escuela.getHost());
            System.out.println(escuela.getPort());
            System.out.println(escuela.getPath());
            System.out.println(escuela.getQuery());
            System.out.println(escuela.getFile());
            System.out.println(escuela.getRef());

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        
    }
}
