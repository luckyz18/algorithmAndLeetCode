package java_jichu.testdemo;

import java.time.*;
import java.util.Calendar;

public class Time {
    public static void getTomorrowTime(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,1);
        System.out.println(instance.getTime());
    }

    public static void getTomorrowTime2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime tomorrow = localDateTime.plusDays(1);
        System.out.println(tomorrow);
    }
    public static void time() {
        //Date date = new Date();
        //System.out.println(date);
        //
        //Calendar calendar = Calendar.getInstance();
        //Date calendarTime = calendar.getTime();
        //System.out.println(calendarTime+"---");
        //
        ////
        //long t1 = new Date().getTime();
        //long t2 = Calendar.getInstance().getTimeInMillis();
        //long t3 = System.currentTimeMillis();
        //
        //System.out.println(t1);
        //System.out.println(t2);
        //System.out.println(t3);

        //
        //String e = new SimpleDateFormat("E").format(new Date());
        //System.out.println(e);

       /* SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Stringg 转 date
        String s = "2019-10-10 10:10:10";
        Date parse = null;
        try {
            parse = sf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);

        String s2 = "1556788591462";
        Timestamp timestamp = new Timestamp(Long.parseLong(s2));
        Date date2 = new Date(Long.parseLong(s2));
        String format = sf.format(timestamp);
        String f2 = sf.format(date2);
        System.out.println(format);
        System.out.println(f2);*/

     /*  //获取日期
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //获取时间戳
        long hm = Instant.now().toEpochMilli();
        long s = Instant.now().getEpochSecond();
        System.out.println(hm);
        System.out.println(s);

        //时间格式化
        DateTimeFormatter dateTimeFormatterPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatterPattern.format(localDateTime);
        System.out.println(format);

        String format1 = LocalDateTime.now().format(dateTimeFormatterPattern);
        System.out.println(format1);

        //时间转换
        String timeStr = "2019-10-10 06:06:06";
        LocalDateTime dateTime =
                LocalDateTime.parse(timeStr,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);
        */
        //昨天此刻的时间
       /* LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.plusDays(-1);
        String format = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(yesterday);
        System.out.println(format);*/

       /* int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        int dayOfYear = LocalDateTime.now().getDayOfYear();
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(dayOfYear);

        // //本月最后一天
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTime());*/

       //计算相隔时间
       /* LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = t1.plusHours(1);
        Duration duration = Duration.between(t1, t2);
        System.out.println(duration.getSeconds());*/

        //想个日
        LocalDate localDate =LocalDate.now();
        LocalDate localDate1 = localDate.plusDays(1);
        Period between = Period.between(localDate, localDate1);
        System.out.println(between.getDays());
        //比较两个时间的大小
        int i = localDate.compareTo(localDate1);
        boolean isleap = localDate.isLeapYear();
        System.out.println(i);
        System.out.println(isleap);
    }

    public static void main(String[] args) {
        time();
    }
}
