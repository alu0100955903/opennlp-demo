
package org.fogbeam.example.opennlp;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class TokenizerMain
{
	public static void main( String[] args ) throws Exception
	{
		/**
		 * Este es el modulo que viene provisto
		 */
		// the provided model
		//InputStream modelIn = new FileInputStream( "models/en-token.bin" );

		/**
		 * Este es el modulo que viene entrenado
		 */
		// the model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		
		/**
		 * Declaramos un puntero a fichero para escribir
		 */
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try
		{
			
			TokenizerModel model = new TokenizerModel( modelIn );
			Tokenizer tokenizer = new TokenizerME(model);

			/**
			 * Indicamos el fichero de entrada de texto y lo cargamos en el buffer
			 */
			File archivoentrada = new File ("models/prueba.txt");
			FileReader entry = new FileReader (archivoentrada);
			BufferedReader buffer = new BufferedReader(entry);
			
			String linea; 
			String[] tokens=null;
			
			/**
			 * fichero = new FileWriter("path to directory")
			 * Declaramos un fichero que sera donde hagamos la salida por fichero de los tokens
			 */
			 fichero = new FileWriter("models/prueba2.txt");
		     pw = new PrintWriter(fichero);
		     
		     /**
		      * tokens=tokenizer.tokenize(linea)
		      * Bucle para introducir cada palabra como un token
		      */
			 while((linea=buffer.readLine())!=null) {
		            tokens=tokenizer.tokenize(linea);
		            
		            
			 }
			 
			 /**
			  * System.out.println para mostrar por terminal
			  * pw.println(token) para escribir en el fichero
			  */
			 for( String token : tokens )
				{
					System.out.println( token );
					pw.println(token); 			
				}
		     
			 
		}
		
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
		
	  
	    try
	    {

	    } catch (Exception e) {
	            e.printStackTrace();
	    } finally {
	       try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	    }
	    
	}
}
