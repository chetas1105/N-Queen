package Backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class nQueen {
    public static boolean isSafe(int row,int col,char[][] board ){
        //horizontal check
        for(int i=0;i<board.length;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        //vertical check
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        //upper left
        int r = row;
        for(int c = col; c >= 0 && r >=0;r--,c--){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        //upper right
        r = row;
        for(int c = col; c < board.length && r >=0;r--,c++){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        //lower left
        r = row;
        for(int c = col; c >= 0 && r < board.length;r++,c--){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        //lower right
        r = row;
        for(int c = col; c < board.length && r < board.length;r++,c++){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void saveBoard(List<List<String>> allBoard ,char[][] board ){
        StringBuilder row;
        List<String> newBoard = new ArrayList<>();
        for (char[] chars : board) {
            row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == 'Q') {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }
            newBoard.add(row.toString());
        }
        allBoard.add(newBoard);
    }
    public static void helper(List<List<String>> allBoard ,char[][] board ,int col){
        if(col == board.length){
            saveBoard(allBoard,board);
            return;
        }
        for(int row =0;row< board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                helper(allBoard,board,col+1);
                board[row][col] ='.';
            }
        }
    }
    public static void printBoard(List<List<String>> allBoard){
        for (List<String> strings : allBoard) {
            System.out.println(strings);
        }

    }
    public static void solveNQueens(int n){
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(allBoard,board,0);
        printBoard(allBoard);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solveNQueens(n);
    }
}
