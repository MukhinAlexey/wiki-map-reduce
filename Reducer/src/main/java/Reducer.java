import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reducer {

    private static boolean filterUpperCase(String inputStr) {
        return Character.isUpperCase(inputStr.charAt(0));
    }

    public static void main(String args[]) {

        try {

            BufferedReader inputDataStream = new BufferedReader(new InputStreamReader(System.in));

            String currentTitle = null;
            int currentTitleCount = 0;

            String inputLine;
            String title;
            while ((inputLine = inputDataStream.readLine()) != null) {
                String[] lineParts = inputLine.split("\t");
                title = lineParts[0];
                int titleCount = Integer.parseInt(lineParts[1]);

                if (currentTitle == null) {
                    currentTitle = title;
                    currentTitleCount = titleCount;
                } else if (currentTitle.equals(title)) {
                    currentTitleCount += titleCount;
                } else {
                    System.out.println(currentTitle + "\t" + currentTitleCount);
                    currentTitle = title;
                    currentTitleCount = titleCount;
                }

            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
