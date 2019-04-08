
import java.util.ArrayList;
import java.util.Scanner;
public class listToArr{
     public static void main(String args[]){
         
         ArrayList<String> names = new ArrayList<String>();
         names = reArr();
         
         System.out.println(names);
         
         String[] forArr = names.toArray(new String[0]);
         for(String name:forArr){
             System.out.println(name);
         }
     }
     
     private static ArrayList<String> reArr(){
         Scanner reader = new Scanner(System.in);
         ArrayList<String> returnArray = new ArrayList<String>();
         while(true){
             System.out.println("Enter a name (for quit, enter 'quit')");
             String ans = reader.nextLine();
             if(ans.equals("quit")){
                 break;
             }else{
                 returnArray.add(ans);
             }
         }
         return returnArray;
         
     }
   
 }
