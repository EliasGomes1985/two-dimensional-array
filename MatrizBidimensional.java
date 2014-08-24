import java.util.Scanner;
import java.util.Random;

public class MatrizBidimensional {
   
	static int row;
	static int column;
	
	public static void main( String args[] ) {
	    
		Scanner input = new Scanner( System.in );
		
		Random randomNumbers = new Random();
		
		System.out.printf( "\n\tEnter the number of rows of the matrix  [ row ] -> " );
		row = input.nextInt();
		
		System.out.printf( "\n\tEnter the number of columns of the matrix [ column ] -> " );
        column = input.nextInt();	

        System.out.println();		
		
        int[][] matriz = new int[ row ][ column ];
	
	    for ( int row = 0; row < matriz.length; row++ ) {
		   
		   for ( int column = 0; column < matriz[ row ].length; column++ ) {
		   
		      int values = randomNumbers.nextInt( 99 );
			  
			  matriz[ row ][ column ] = values;
		      
			  System.out.printf( "\n\tValue in the row[ %d ] and column[ %d ] = %d ",
			         row, column, values  ); 
			}
		}     
		
		System.out.println( "\n\nValues in MatrizBidimensional are: ");
        outputMatriz( matriz );
			  
    	sumValuesMainDiagonal( matriz );
	    countEqualValuesInArray( matriz );		
        		
	}
	
	public static void outputMatriz( int[][] ArrayMatriz ) {
	
  	    for ( int row = 0; row < ArrayMatriz.length; row++ ) {
		
		   for ( int colum = 0; colum < ArrayMatriz[ row ].length; colum++ ) 
		      System.out.printf( "\t%3d  ", ArrayMatriz[ row ][ colum ] );
			  
		   System.out.println();
		}
	}
	
	public static void sumValuesMainDiagonal( int[][] arrayMatriz ) {
	
	   int sum = 0;
	   
	   for ( int row = 0; row < arrayMatriz.length; row++ ) {
	   
	      for ( int colum = 0; colum < arrayMatriz[ row ].length; colum++ ) {
		  
		     if ( row == colum ) 
               sum += arrayMatriz[ row ][ colum ]; 
			   
		    }
	    }
        
		System.out.printf( "\n\tSum of the main diagonal is: %d\n\n ", sum );		
    }
	
	public static void countEqualValuesInArray( int[][] arrayMatriz ) {
	
	    int count = 0; // counts how many times the number is repeated
		int rows = 0; // determines which line'll be the number to be compared
		int columns = 0; // determines which column'll be the number to be compared
		int numberRepeated = arrayMatriz[ rows ][ columns ]; // stores the number to be compared
		int account = 0; // determines the position in which the amount contained in count will be placed
		int position = 0; // determines the position in which the number that has been compared remained
		int lastPosition = 0; // flag for comparison until the last number
		int total = arrayMatriz.length * column;
		int[] frequency = new int[ total ]; // stores the frequency of repetition of each number in the array, uses Total specifying the size of the vector
		boolean numberCompared = false; // checks whether the number has already been compared
	    int[] numbersNowCompared = new int[ total ]; // array holding numbers already compared, Total specifies the vector size
		
		for ( int i = 0; i < arrayMatriz.length * column; i++ ) {
	      
     		for ( int row = 0; row < arrayMatriz.length; row++ ) {
		
		        for ( int column = 0; column < arrayMatriz[ row ].length; column++ ) {
		   
		            if ( arrayMatriz[ row ][ column ] == numberRepeated ) 
			            count++;
				   
			        if ( row == arrayMatriz.length - 1 && column == arrayMatriz[ row ].length - 1 ) {
			       
				        frequency [ account ] = count;
						count = 0;
						++account;
						
						numbersNowCompared [ position ] = numberRepeated;
						position++;
						
						do {
						
							lastPosition++;
							
					        if ( columns == arrayMatriz[ row ].length - 1 ) {
						        columns = 0;
								
								if ( rows == arrayMatriz.length - 1 )
								   break;
								   
							    numberRepeated = arrayMatriz[ ++rows ][ columns ];
							
						    } else 
						        numberRepeated = arrayMatriz[ rows ][ ++columns ];
						   
						    numberCompared = verifiesNumberHasBeenCompared( numberRepeated, numbersNowCompared );
						
						} while( numberCompared );
					}					
			    }   		 	
		    }
			
			if ( lastPosition == arrayMatriz.length * column  ) // checks if the last number of the matrix was compared
			   break;
	    }
		
		displayNumbersRepeatedInArray( total, frequency, numbersNowCompared );	
    }
        	
	public static void displayNumbersRepeatedInArray( int total, int[] frequencyNumbers, int[] array ) {
	
	    System.out.printf( "\tElements contained in the array are: %d\n ", total );
		
        for ( int numbers = 0; numbers < frequencyNumbers.length; numbers++ ) {
	    
		    if ( frequencyNumbers[ numbers ] != 0 ) 
			   System.out.printf( "\tbeing %d -> %d\n ", frequencyNumbers[ numbers ], 
			          array[ numbers ] );
					 
			System.out.println();   
		}	
	}
	
	public static boolean verifiesNumberHasBeenCompared( int number, int[] numbersNowCompared  ) {
	    
	    for ( int i = 0; i < numbersNowCompared.length; i++ ) {
		  
		   if ( number == numbersNowCompared[ i ] )
			 return true;	
		}
		return false;
	}
}