import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Matrix {
    public static void main(String[] args) {
        try{
            File file = new File("matrix");
            if (file.exists()){
                FileReader reader = new FileReader(file);
                BufferedReader buffer  = new BufferedReader(reader);

                int rows = Integer.parseInt(buffer.readLine()); //the documents first line has been read there completely
                int column = Integer.parseInt(buffer.readLine());

                int[][] matrix = new int[rows][column];

                //reading the all the rows
                for (int i = 0; i < rows; i++) {
                    //converting the matrix line elements into a string array
                    String[] line = buffer.readLine().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        //storing the matrix elements in the matrix
                        matrix[i][j] = Integer.parseInt(line[j]);
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }else{
                file.createNewFile();
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
