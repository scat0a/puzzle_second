import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("재미있는 15 퍼즐");
        List<String> puzzles = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            puzzles.add(String.valueOf(i));
        }
        int turn = 1;
        puzzles.add(" ");
        List<String> answers = new ArrayList<>(puzzles);
        Collections.shuffle(puzzles);


        while (true){
            System.out.println("Turn " + turn);
            printPuzzle(puzzles);
            System.out.print("숫자 입력>" );
            String input = sc.nextLine();

            for (int i = 0; i < puzzles.size(); i++) {
                if (puzzles.get(i).equals(" ")) {
                    for (int j = 0; j < puzzles.size(); j++) {
                        if (puzzles.get(j).equals(input)) {
                            String temp = puzzles.get(i);
                            puzzles.set(i, puzzles.get(j));
                            puzzles.set(j, temp);
                            break;
                        }
                    }
                    break;
                }
            }
            turn++;

            if(puzzles.equals(answers)){
                System.out.println(turn+"턴만에 퍼즐을 완성했습니다!");
                break;
            }

        }


//        List<String> answers = new ArrayList<>(puzzles);
//
//        for (int i = 0; i < answers.size() - 1; i++) {
//            for (int j = i + 1; j < answers.size(); j++) {
//                if (answers.get(i).trim().isEmpty()) {
//                    String temp = answers.get(i);
//                    answers.set(i, answers.get(j));
//                    answers.set(j, temp);
//                    continue;
//                }
//
//                if (answers.get(j).trim().isEmpty()) {
//                    continue;
//                }
//
//                int num = Integer.parseInt(answers.get(i).trim());
//                int num2 = Integer.parseInt(answers.get(j).trim());
//
//                if (num > num2) {
//                    String temp = answers.get(i);
//                    answers.set(i, answers.get(j));
//                    answers.set(j, temp);
//                }
//
//            }
//        }




    }

    private static void printPuzzle(List<String> puzzles) {
        String[][] puzzleBoard = new String[4][4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                puzzleBoard[i][j] = puzzles.get(index++);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("[%2s]", puzzleBoard[i][j]);
            }
            System.out.println();
        }
    }
}
