package top.fedoseev.adm01;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        generateTraffic();
    }

    public static void generateTraffic() {
        String sql = "INSERT INTO `traffic` (`id`,`date`,`subscriber_id`,`uplink`,`downlink`) VALUES ";
        String pattern = "(%d,\"%s\",%d,%d,%d)";
        Random random = new Random(20);

        long offset = Timestamp.valueOf("2016-09-08 00:00:00").getTime();
        long end = Timestamp.valueOf("2016-09-10 00:00:00").getTime();
        long diff = end - offset + 1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.print(sql);

        for (int i = 1; i < 5000; i++) {
            int subscriber = 1 + random.nextInt(20);
            int uplink = 1 + random.nextInt(100000);
            int downlink = 1 + random.nextInt(100000);
            Timestamp randDate = new Timestamp(offset + (long) (Math.random() * diff));

            System.out.print(String.format(pattern, i, sdf.format(randDate), subscriber, uplink, downlink));

            if (i%10 != 0) {
                System.out.print(", ");
            } else {
                System.out.println(";");
                System.out.print(sql);
            }
        }
    }

    public static void generateSubscribers() {
        String sql = "INSERT INTO `subscriber` (`id`, `account_number`) VALUES ";
        String pattern = "(%d,%d)";

        System.out.print(sql);

        for (int i = 1; i < 100; i++) {
            int account_number = 1090000 + i;

            System.out.print(String.format(pattern, i, account_number));

            if (i%10 != 0) {
                System.out.print(", ");
            } else {
                System.out.println(";");
                System.out.print(sql);
            }
        }

    }
}
