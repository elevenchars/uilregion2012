import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Rasterizer {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("example/rasterizer.dat"));
        int images = Integer.parseInt(sc.nextLine());
        while(images-- > 0){
            String[] dims = sc.nextLine().split(" ");
            String[][] grid = new String[Integer.parseInt(dims[1])][Integer.parseInt(dims[0])];
            String s = sc.nextLine();
            while(!s.equals("END")){
                String[] stuff = s.split(" ");
                if(stuff[0].equals("BOX")){
                    addBox(grid,stuff[1],Integer.parseInt(stuff[2]),Integer.parseInt(stuff[3]),Integer.parseInt(stuff[4]),Integer.parseInt(stuff[5]),stuff[6]);
                }
                else if(stuff[0].equals("LINE")){
                    addLine(grid,stuff[1],Integer.parseInt(stuff[2]),Integer.parseInt(stuff[3]),Integer.parseInt(stuff[4]),Integer.parseInt(stuff[5]));
                }
                else{//cross
                    addCross(grid,stuff[1],Integer.parseInt(stuff[2]),Integer.parseInt(stuff[3]),Integer.parseInt(stuff[4]),Integer.parseInt(stuff[5]));
                }
                /////////////////////////////////////
                s = sc.nextLine();
            }
            for(String[] arr : grid){
                for(String str : arr){
                    System.out.print(str+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void addLine(String[][] grid, String color, int x1, int y1, int x2, int y2){
        if(x1==x2){
            if(y1 > y2){
                for(int i=y1;i>=y2;i--){
                    grid[i][x1] = color;
                }
            }
            else{
                for(int i=y2;i>=y1;i--){
                    grid[i][x1] = color;
                }
            }
        }
        else{
            if(x1 > x2){
                for(int i=x1;i>=x2;i--){
                    grid[y1][i] = color;
                }
            }
            else{
                for(int i=x2;i>=x1;i--){
                    grid[y1][i] = color;
                }
            }
        }
    }
    public static void addBox(String[][] grid, String color, int x1, int y1, int x2, int y2, String fill){
        if(fill.equals("Y")){
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    grid[j][i] = color;
                }
            }
        }
        else{
            addLine(grid,color,x1,y1,x2,y1);
            addLine(grid,color,x1,y1,x1,y2);
            addLine(grid,color,x1,y2,x2,y2);
            addLine(grid,color,x2,y1,x2,y2);
        }
    }
    public static void addCross(String[][] grid, String color, int x1, int y1, int w, int h){
        if(w%2==0){
            addLine(grid,color,x1-w/2+1,y1,x1+w/2,y1);
        }
        else{
            addLine(grid,color,x1-w/2,y1,x1+w/2,y1);
        }
        if(h%2==0){
            addLine(grid,color,x1,y1-h/2+1,x1,y1+h/2);
        }
        else{
            addLine(grid,color,x1,y1-h/2,x1,y1+h/2);
        }
    }
}
