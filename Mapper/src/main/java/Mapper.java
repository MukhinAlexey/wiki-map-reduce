import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mapper {

    private static String languageCode = "en";

    private static String[] topicFilter = {
            "Media:",
            "Special:",
            "Talk:",
            "User:",
            "User_talk:",
            "Project:",
            "Project_talk:",
            "File:",
            "File_talk:",
            "MediaWiki:",
            "MediaWiki_talk:",
            "Template:",
            "Template_talk:",
            "Help:",
            "Help_talk:",
            "Category:",
            "Category_talk:",
            "Portal:",
            "Wikipedia:",
            "Wikipedia_talk:"
    };

    private static String[] extensionFilter = {
            ".jpg",
            ".gif",
            ".png",
            ".JPG",
            ".GIF",
            ".PNG",
            ".txt",
            ".ico"
    };

    private static String[] uselessTopics = {
            "404_error/",
            "Main_Page",
            "Hypertext_Transfer_Protocol",
            "Search"
    };

    private static boolean isTopicNameOk(String inputStr) {
        if (!filterUpperCase(inputStr)) {
            return false;
        } else if (Arrays.stream(topicFilter).parallel().anyMatch(inputStr::startsWith)) {
            return false;
        } else if (Arrays.stream(extensionFilter).parallel().anyMatch(inputStr::endsWith)) {
            return false;
        } else if (Arrays.stream(uselessTopics).parallel().anyMatch(inputStr::matches)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean filterUpperCase(String inputStr) {
        return Character.isUpperCase(inputStr.charAt(0));
    }

    public static void main(String args[]) {

        try {

            BufferedReader inputDataStream = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            StringTokenizer stringTokenizer;

            while ((inputLine = inputDataStream.readLine()) != null) {

                String outputLine = "";

                stringTokenizer = new StringTokenizer(inputLine);

                if (stringTokenizer.hasMoreTokens()) {

                    String language = stringTokenizer.nextToken();

                    if (language.equals(languageCode)) {

                        if (stringTokenizer.hasMoreTokens()) {

                            String topic = stringTokenizer.nextToken();

                            if (isTopicNameOk(topic)) {

                                outputLine += topic;

                                if (stringTokenizer.hasMoreTokens()) {

                                    outputLine = outputLine + "\t" + stringTokenizer.nextToken();
                                    System.out.println(outputLine);
                                }
                            }
                        }
                    }

                }
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
