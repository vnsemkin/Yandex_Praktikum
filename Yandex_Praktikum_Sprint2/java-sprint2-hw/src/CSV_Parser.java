
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSV_Parser {
    private final String[] month = new String[]{"01", "02", "03"};
    private static HashMap<Integer, ArrayList<MonthlyReport>> map = new HashMap();
    private static List<YearlyReport> list = new ArrayList();

    public CSV_Parser() {
    }

    public static List<YearlyReport> getList() {
        return list;
    }

    public void readFileYear() {
        String url = "./resources/y.2021.csv";
        File file = new File(url);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = br.readLine();
            while((s = br.readLine()) != null) {
                String[] array = s.split(",");
                list.add(new YearlyReport(Integer.parseInt(array[0]), Boolean.parseBoolean(array[2]), Integer.parseInt(array[1])));
            }

            br.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void readMonthFile() {
        for(int i = 0; i < month.length; ++i) {
            String actualMonth = month[i];
            String url = "./resources/m.2021" + actualMonth + ".csv";
            File file = new File(url);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String s = br.readLine();
                ArrayList monthList = new ArrayList();

                while((s = br.readLine()) != null) {
                    String[] array = s.split(",");
                    monthList.add(new MonthlyReport(array[0], Boolean.parseBoolean(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3])));
                    map.put(Integer.parseInt(month[i]), monthList);
                }

                br.close();
            } catch (IOException var8) {
                var8.printStackTrace();
            }
        }

    }

    public static HashMap<Integer, ArrayList<MonthlyReport>> getMap() {
        return map;
    }
}
