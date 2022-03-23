import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mechanics {


    public static String[] createArray(String file_name){


        String[] array = new String[371000]; //Define variable 

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file_name));
            String line = reader.readLine();
            int counter = 0;

            while(line != null){ //Add the current line into list until there is no new line
                array[counter] = line;
                line = reader.readLine();
                counter++;
            }
            reader.close();
        }
        catch(IOException e){ //Exception handling
        }

        int line_count = 0; //Determine the size of new array
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                break;
            }
            line_count++;
        }

        String[] cleaned_array = new String[line_count]; 

        for (int i = 0; i < cleaned_array.length; i++) { //Transfer the array values
            cleaned_array[i] = array[i];
        }
        return cleaned_array;
    }

    public static char[][] createMap(String[] raw_array){ //Create 2d map array from a 1d array

        char[][] map = new char[raw_array.length][raw_array[0].length()];

        for (int i = 0; i < raw_array.length; i++) {
            for (int j = 0; j < raw_array[i].length(); j++) {
                char[] line = raw_array[i].toCharArray();
                if(line[j] == '#'){
                    map[i][j] = '#';
                }
                else{
                    map[i][j] = ' ';
                }
            }
        }

        return map;
    }
}
