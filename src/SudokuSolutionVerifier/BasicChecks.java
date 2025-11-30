package SudokuSolutionVerifier;

public class SudokuVerifier {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SudokuVerifier <mode> <csv>");
            return;
        }

        int mode;
        try {
            mode = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Invalid mode");
            return;
        }

        String file = args[1];

        int[][] board;
        try {
            board = CSVReader.load(file);
        } catch (Exception e) {
            System.out.println("Error reading file");
            return;
        }

        SudokuMode m;
        try {
            m = ModesFactory.create(mode);
        } catch (Exception e) {
            System.out.println("Invalid mode");
            return;
        }

        ValidationResult r = m.verify(board);
        ResultPrinter.get().print(r);
    }
}
