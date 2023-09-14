import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'stockSpike' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int stockSpike(List<Integer> prices, int k) {
        // Write your code here
    
        //size of the array 
        int size = prices.size();
        //variable to zero 
        int count = 0; 
        //int element = 0;
        
        //for loop to iterate between the right and the left and then two more for loops required 
        for ( int i = 0; i < size; i ++) {
            
            int left = 0;
            int right = 0;
            
            //count the elements of the left side < than the prices
            for( k = i - 1; k >= 0; k-- ) {
                
                if ( prices.get(k) < prices.get(i)) {
                    
                    left ++;//increment 
                    
                    if ( left >= k || left > k ) {
                        
                        break;//stop the loop
                    
                    }
                }
                
                //for looop to count on the right side 
                for ( k = i + 1; k < size; k++) {
                    
                    if ( prices.get(k) < prices.get(i)) {
                        
                        right ++;//increment 
                        
                        if (right >= k || right > k ) {
                            
                            break;//stop the lloopp here 
                        
                        }
                    }
                    
                    //if statement to both right and left 
                    if ( right >= k && left >= k ) {
                        
                        count ++;
                        
                    }
                }
                
                
            }
            
        }
        return count;//returning the variable 
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int pricesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> prices = IntStream.range(0, pricesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.stockSpike(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
