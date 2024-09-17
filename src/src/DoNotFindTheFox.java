import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DoNotFindTheFox {
    ArrayList<Character> tiles = new ArrayList<>();
    char[][] board = new char[4][4];
    int col = 0;
    int row = 0;
    public DoNotFindTheFox(){
        System.out.println("Do not find the fox. Good luck");
        for (int i = 0; i < 5; i++) {
            tiles.add('F');
            tiles.add('X');
            tiles.add('O');
        }
        tiles.add('O');
        Collections.shuffle(tiles);
        System.out.println(tiles);
    }
    public void play(){
        while(!gameEnd()){
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Pick a number %d to %d: ", 1, tiles.size());
            int num = scanner.nextInt();
            char current = tiles.remove(num - 1);
            board[col][row] = current;
            row++;
            if(row == 4){
                row = 0;
                col++;
            }
            Collections.shuffle(tiles);
            System.out.println(currentBoard());
        }
    }
    public String currentBoard(){
        StringBuilder current = new StringBuilder("Current Board");
        current.append(System.lineSeparator());
        current.append("|");
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                current.append(chars[j]);
                current.append("|");
            }
            current.append(System.lineSeparator());
            current.append("|");
        }
        current.deleteCharAt(current.length() - 1);
        return current.toString();
    }
    public Boolean gameEnd(){
        return false;
    }
    public static void main(String[] args) {
        DoNotFindTheFox fox = new DoNotFindTheFox();
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Ready to play? ");
        String ready = scanner.nextLine();
        System.out.println(ready);
        */
        fox.play();
    }
}