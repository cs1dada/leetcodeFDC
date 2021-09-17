package top_interview_question.easy;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class fiaTest3 {

    public boolean isPalindrome(String s) {

        char [] charArray = s.toCharArray();
        int head = 0;
        int tail = charArray.length - 1;
        
        while (head<=tail) {
            if(!Character.isLetterOrDigit(charArray[head])){
                head++;
            } else if(!Character.isLetterOrDigit(charArray[tail])) {
                tail--;
            } else {
                if(Character.toLowerCase(charArray[head]) != Character.toLowerCase(charArray[tail])) {
                    return false;
                } else {
                    head++;
                    tail--;
                }
            }            
        }

        return true;
    }

//民國年轉西元
//     本(110)年提供的資料格式為：
// 序號(7位)+身分證號(10位)+出生日期(8位：7位民國年月日及1位民國年示意符號+)+出境日期(7位民國年月日)+入境日期(7位民國年月日)+姓名（以上每欄位之間含有一個空格）。
// 範例如下：
// 0000008 B123456789 0410506+ 1080601 1090121 楊測試
// 0000056 K123456789 0481206+ 1080601 1090308 王測試

    String toADYear(String year){
        String out = "";
        if(year.length() == 7){
            out = String.valueOf(Integer.parseInt(year)+1911*10000);

        } else if(year.length() == 8) {  
            String mark = ("+".equals(year.substring(7, 8)) ? "+" : "-" );
            if (mark == "+") {
                //0481206+ => 19591206                
                out = String.valueOf(Integer.parseInt(year.substring(0, 7))+1911*10000);
            } else if (mark == "-"){
                //0481206- => 18631206
                out = String.valueOf((1911-Integer.parseInt(year.substring(0, 3)))*10000 +
                                      Integer.parseInt(year.substring(3, 7)));
            }            
            
        }

        return out;

    }

        /**
     * 取得幾天前後的日期
     * @param date date
     * @param amount amount
     * @return Date
     */
    public Date getCalDate(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        c.set(year, month, day);
        c.add(Calendar.DATE, amount);
        return c.getTime();
    }

    public static void main(String[] args) {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);

        fiaTest3 aa = new fiaTest3();
        Date afterAmountDay = aa.getCalDate(timestamp,3);

        System.out.println("Current Time Stamp: "+timestamp);
        System.out.println("3dayLaterTimeStamp: "+afterAmountDay);

    }
}