/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci;

import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        int funtion = 2;//cos
        double answer = 0.0;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:" + inputLine);
            if (inputLine.equals("fun:sin")) {
                funtion = 1;//sin
            } else if (inputLine.equals("fun:cos")) {
                funtion = 2;//cos
            } else if (inputLine.equals("fun:tan")) {
                funtion = 3;//tan
            } else {
                System.out.println(funtion);
                switch (funtion) {
                    case 1:
                        System.out.println("case sin");
                        answer = Math.sin(Double.parseDouble(inputLine));
                        break;
                    case 2:
                        System.out.println("case cos");
                        answer = Math.cos(Double.parseDouble(inputLine));
                        break;
                    case 3:
                        System.out.println("case tan");
                        answer = Math.tan(Double.parseDouble(inputLine));
                        break;
                }
            }
            outputLine = "Respuesta " + answer;

            out.println(outputLine);
            if (outputLine.equals("Respuesta Bye")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
