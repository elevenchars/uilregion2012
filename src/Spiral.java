import java.util.*;
import java.io.*;
public class Spiral {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("judges/spiral.dat"));
        String[] line = sc.nextLine().split(" ");
        for(String s : line){
            int num = Integer.parseInt(s);
            int dim = 1;
            while(dim*dim < num){
                dim += 2;
            }
            int start = dim/2+1;
            int x,y;
            x=y=start;
            int current = 1;
            int move = 1;
            boolean done = current == dim;
            while(!done){
                for(int i=0;i<move;i++){
                    y--;
                    current++;
                    if(current==num){
                        done = true;
                        break;
                    }
                }
                if(!done){
                    for(int i=0;i<move;i++){
                        x--;
                        current++;
                        if(current==num){
                            done = true;
                            break;
                        }
                    }
                }
                move++;
                if(!done){
                    for(int i=0;i<move;i++){
                        y++;
                        current++;
                        if(current==num){
                            done = true;
                            break;
                        }
                    }
                }
                if(!done){
                    for(int i=0;i<move;i++){
                        x++;
                        current++;
                        if(current==num){
                            done = true;
                            break;
                        }
                    }
                }
                move++;
            }
            System.out.println(y+" "+x);
        }
    }
}
