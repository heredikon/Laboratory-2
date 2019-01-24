package edu.eci;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Reader {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);  // Reading from System.in
        System.out.println("write the new url");
        String in = input.next(); // Scans the next token of the input as an int.
        input.close();

        URL url = new URL("http://www." + in );
        //System.out.println(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = null;
        String website ="";
        while ((inputLine = reader.readLine()) != null) {
            website+=inputLine;
        }
        writer(website);
    }

    public static void writer(String line) {
        try {
            String ruta = "/home/laboratorio/Downloads/url.html";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

