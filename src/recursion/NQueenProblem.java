package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblem {

  /**
   * given a nxn chess board place n queens in the chess board such that one queen doesn't attack antoher
   * the idea is to start by placing queens in the first column
   *  and keep checking for each column's row if it's safe to place the queen or not
   *
   */

  public static boolean isSafe( int row,int col, char[][] board){

    /**
     * we only need to check the top left, bottom left diagonals and the left side of the row
     *  to see if a queen can be placed in a certain position or not
     *
     *  becasue we're moving from left to right while placing the queens so the right columns, rows and diagonals are ideally empty
     */

    // to check in the same row ==> onlmy left values
    if(col > 0){
      int prevCol = col-1;
      while(prevCol>=0){
        if(board[row][prevCol] == 'Q') return false;
        prevCol--;
      }
    }

    // check upper diagonal
    if(row>0 && col>0){
      int prevRow = row-1;
      int prevCol = col-1;
      while(prevRow>=0 && prevCol>=0){
        if(board[prevRow][prevCol]=='Q') return false;
        prevCol--;
        prevRow--;
      }
    }

    //check lower diagonal
    if(row<board.length-1 && col > 0){
      int nextRow = row+1;
      int prevCol = col-1;
      while(nextRow<board.length && prevCol>=0){
        if(board[nextRow][prevCol]=='Q') return false;
        prevCol--;
        nextRow++;
      }
    }
    return true;
  }


  public static List<String> returnResultArray(char[][] board){
    List<String> curResult = new ArrayList<>();
    for(int i=0;i<board.length;i++){
      StringBuilder builder = new StringBuilder();
      for(int j=0;j<board.length;j++){
        builder.append(String.valueOf(board[i][j]));
      }
      curResult.add(builder.toString());
    }
    return curResult;
  }


  /**
   * the IsSafe? function can be further optimised by hashing
   *
   * 1. For row - we don't need to parse through the whole row, once an element is inserted, we know that the row isn't avaialble.
   *      we can use an arrary of length N that stores the filled row values.
   *
   * 2. For lower diagonal, there's a formula. the [row + column] value gives the value of diagonal positions
   *    - so whenever a queen is placed in a diagonal path,
   *      - we'll fill the lower diagonal hash and check if its safe to place another queen in it's path or not.
   *
   * 3. For upper diagonal, we have a similar approach. [(n-1) + (col - row)] value gives the value of diagonal positions
   *    *    - so whenever a queen is placed in a diagonal path,
   *    *      - we'll fill the upper diagonal hash and check if its safe to place another queen in it's path or not.
   *
   *
   */

  public static void placesQueensWithOptimisedIsSafeCheck(int col, char[][] board,List<List<String>> result,
      int[] leftRow,int[] lowerDiagonal,int[] upperDiagonal){

    if(col==board.length) {
      List<String> curResult = returnResultArray(board);
      result.add(new ArrayList<>(curResult));
      return;
    }

    int len = board.length;
    for(int row=0;row<board.length;row++){
      if(leftRow[row] ==1 || lowerDiagonal[row+col] ==1 || upperDiagonal[(len-1) + (col-row)]==1){
        continue;
      }
        board[row][col] = 'Q';
        leftRow[row] = 1;
        lowerDiagonal[row+col] = 1;
        upperDiagonal[(len-1) + (col-row)] = 1;
        placesQueensWithOptimisedIsSafeCheck(col+1,board,result,leftRow,lowerDiagonal,upperDiagonal);
        board[row][col] = '.';
        leftRow[row] = 0;
        lowerDiagonal[row+col] = 0;
        upperDiagonal[(len-1) + (col-row)] = 0;
    }
  }

  public static void placesQueens(int col, char[][] board,List<List<String>> result){

    if(col==board.length) {
      List<String> curResult = returnResultArray(board);
      result.add(new ArrayList<>(curResult));
      return;
    }

    for(int row=0;row<board.length;row++){
      if(isSafe(row,col,board)){
        board[row][col] = 'Q';
        placesQueens(col+1,board,result);
        board[row][col] = '.';
      }
    }
  }

  public static void main(String args[]){
    int n=4;
    char[][] board = new char[n][n];
    for(int i=0;i<board.length;i++){
      System.out.println();
      for(int j=0;j<board.length;j++){
        board[i][j] = '.';
      }
    }

    List<List<String>> result = new ArrayList<>();
    placesQueens(0,board,result);


    for(List<String> val:result){
      System.out.println();
        for(String res:val){
          System.out.println(res);
        }
    }

    int[] leftRowValues = new int[n];// if there's a value in a given row, this will tell us
    int[] lowerDiagonal = new int[((2*n)-1)]; // if there's a value in the diagonal position, this will tell us
    int[] upperDiagonal = new int[((2*n)-1)]; // if there's a value in the diagonal position, this will tell us

    placesQueensWithOptimisedIsSafeCheck(0,board,result,leftRowValues,lowerDiagonal,upperDiagonal);


  }
}
