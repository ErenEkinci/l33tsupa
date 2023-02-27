package l33t.supa.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
//        System.out.println(generate(5));
//        System.out.println(getRow(30));
        System.out.println(combination(30,14));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>(List.of(1));
        triangle.add(firstRow);
        if(numRows == 1) return triangle;

        List<Integer> secondRow = new ArrayList<>(List.of(1,1));
        triangle.add(secondRow);
        if(numRows == 2) return triangle;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i-1; j++) {
                row.add(triangle.get(i-2).get(j-1) + triangle.get(i-2).get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex+1);
        for (int i = 0; i <= rowIndex; i++) {
            row.add(combination(rowIndex, i));
        }
        return row;
    }

    private static int combination(int t, int b){
        long result = 1;
        if(b > t/2){
            b = t-b;
        }
        if(b != t){
            for (int i = 1; i <= b; i++) {
                result *= (t-b+i);
                result /= i;
            }
        }
        return (int) result;
    }
}
