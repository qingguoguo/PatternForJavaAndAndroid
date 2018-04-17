import java.util.*;

public class TestDemo {

    static ArrayList<String> firstList = new ArrayList<String>();
    static ArrayList<ArrayList<String>> secondList = new ArrayList<ArrayList<String>>();
    static HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

    public static void main(String args[]) {

        ArrayList<ReportYearAndNum> objects = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            objects.add(new ReportYearAndNum("2017", "****" + i));
        }

        for (int i = 0; i < 2; i++) {
            objects.add(new ReportYearAndNum("2019", "&&&&" + i));
        }

        for (int i = 0; i < 2; i++) {
            objects.add(new ReportYearAndNum("2018", "%%%%" + i));
        }

        initData(objects);
        System.out.println(hashMap);
        System.out.println(firstList);
        System.out.println(secondList);
    }

    private static void initData(ArrayList<ReportYearAndNum> data) {
        if (data != null) {
            for (ReportYearAndNum yearAndNum : data) {
                if (hashMap.containsKey(yearAndNum.getYear())) {
                    ArrayList<String> listNum = hashMap.get(yearAndNum.getYear());
                    listNum.add(yearAndNum.getNum());
                }else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(yearAndNum.getNum());
                    hashMap.put(yearAndNum.getYear(),list);
                }
            }

            Set<Map.Entry<String, ArrayList<String>>> entries = hashMap.entrySet();
            for (Map.Entry<String, ArrayList<String>> entry : entries) {
                firstList.add(entry.getKey());
                secondList.add(entry.getValue());
            }
        }
    }

    public static class ReportYearAndNum {
        String year;
        String num;

        @Override
        public String toString() {
            return "ReportYearAndNum{" +
                    "year='" + year + '\'' +
                    ", num='" + num + '\'' +
                    '}';
        }

        public ReportYearAndNum(String year, String num) {
            this.year = year;
            this.num = num;
        }

        public String getYear() {
            return year;
        }

        public String getNum() {
            return num;
        }
    }
}
