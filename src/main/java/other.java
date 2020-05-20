
import java.util.Arrays;
import java.util.List;

public class other {


        public static void main( String args[] ) {
            // String to be scanned to find the pattern.
            String path = "";
            String[] pathArr = path.split("/");
            List pathList = Arrays.asList(pathArr);

            boolean isPath = (pathList.contains("sites") && ((pathList.contains("requisitions") && pathList.contains("preview")) ||pathList.contains("job")));
            System.out.println(isPath);
            test("google","googleref");
        }

        public static void test(String source, String reference){
            source = "test";

            System.out.println("source " +source);
            System.out.println("reference "+reference);

        }
}
