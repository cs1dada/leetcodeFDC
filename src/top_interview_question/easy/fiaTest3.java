package top_interview_question.easy;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private void checkCollectMk( BigDecimal TMP_AMT1) {

        TMP_AMT1 = TMP_AMT1.add(new BigDecimal(1));
        System.out.println("checkCollectMk===" + TMP_AMT1);

    }    
    private void checkCollectMk2( Map<String, Object> dateMap) {
        dateMap.put("key", 123);
        System.out.println("checkCollectMk===" + dateMap.get("key"));

    }    
    private void checkCollectMk3( BAM134XVO vo) {
        String ban = vo.getBamt051Ban();
        ban = "11111111111111";
        System.out.println("checkCollectM3k===" +ban);
        // vo.setBamt051Ban("11111111111111");
        // System.out.println("checkCollectM3k===" + vo.getBamt051Ban());

    }    
    public static void main(String[] args) throws UnsupportedEncodingException {
        fiaTest3 aa = new fiaTest3();

        BAM134XVO vo = new BAM134XVO();
        System.out.println("before===" + vo.getBamt051Ban());
        aa.checkCollectMk3(vo);
        System.out.println("after ===" + vo.getBamt051Ban());

        
        // Map<String, Object> dateMap = new HashMap<String, Object>();
        // dateMap.put("key", 1);

        // System.out.println("before===" + dateMap.get("key"));
        // aa.checkCollectMk2(dateMap);
        // System.out.println("after===" + dateMap.get("key"));


        // BigDecimal TMP_AMT1 = new BigDecimal(1); 
        // System.out.println("before===" + TMP_AMT1);
        // aa.checkCollectMk(TMP_AMT1);
        // System.out.println("after===" +TMP_AMT1);


        // Long datetime = System.currentTimeMillis();
        // Timestamp timestamp = new Timestamp(datetime);

        
        // Date afterAmountDay = aa.getCalDate(timestamp,3);

        // System.out.println("Current Time Stamp: "+timestamp);
        // System.out.println("3dayLaterTimeStamp: "+afterAmountDay);

        // DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        // try {
        //     Date date = dateFormat.parse("22/09/2021");
        //     System.out.println("date: "+date);

        //     System.out.println("date after 3dayLaterTimeStamp: "+date.after(afterAmountDay));
        // } catch (ParseException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }        
        


        // List <Integer> resultList = new ArrayList<>();
        // resultList.add(null);
        // System.out.println(resultList.isEmpty());
        // Integer aabb = 60;
        // System.out.println("round test " + Math.round(2* aabb/200));
        // System.out.println("round test " + Math.round(2* (float)aabb/200));

        // String s1 = "中文";
        // String s2 = URLEncoder.encode(s1,"UTF-8");
        // String s3 = URLDecoder.decode(s2, "UTF-8");
        // System.out.println(s1);
        // System.out.println(s2);
        // System.out.println(s3);
        
        
        
        // Integer month = 7;
        // List <Integer> validMonth = Arrays.asList(3,6,9,12);

        // // if (!validMonth.contains(month)){
        // //     System.out.println("輸入月份錯誤");
        // // }

        // if (month == 3 || month == 6|| month == 9) {
    
        //     System.out.println("ok");
        // } else {
        //     System.out.println("fail");
        // }
        
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "甲甲甲";
        final byte[] textByte = text.getBytes("UTF-8");
        //編碼
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        //解碼
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
String encodeStr = "5LiA5LqM5LiJ5Zub5LqU5YWt5LiD5YWr5Lmd5Y2B5aO56LKz5Y+D6IKG5LyN6Zm45p+S5o2M546W"+
"5ou+5LiA5LqM5LiJ5Zub5LqU5YWt5LiD5YWr5Lmd5Y2B5aO56LKz5Y+D6IKG5LyN6Zm45p+S5o2M"+
"546W5ou+5LiA5LqM5LiJ5Zub5LqU5YWt5LiD5YWr5Lmd5Y2B5aO56LKz5Y+D6IKG5LyN6Zm45p+S"+
"5o2M546W5ou+fOS4gOS6jOS4ieWbm+S6lOWFreS4g+WFq+S5neWNgeWjueiys+WPg+iChuS8jemZ"+
"uOafkuaNjOeOluaLvuS4gOS6jOS4ieWbm+S6lOWFreS4g+WFq+S5neWNgeWjueiys+WPg+iChuS8"+
"jemZuOafkuaNjOeOluaLvuS4gOS6jOS4ieWbm+S6lOWFreS4g+WFq+S5neWNgeWjueiys+WPg+iC"+
"huS8jemZuOafkuaNjOeOluaLvnwxfDAxMDAwMTAwMDA1MjQ4fDAxMDE0NjEyMzQwMDAwfDB8QTEy"+
"MzQ1Njc4OXznlLLnlLLnlLLkuIDkuozkuInlm5vkupTlha3kuIPlhavkuZ3ljYHlo7nosrPlj4Po"+
"gobkvI3pmbjmn5LmjYznjpbmi77kuIDkuozkuInlm5vkupTlha3kuIPlhavkuZ3ljYHlo7nosrPl"+
"j4PogobkvI3pmbjmn5LmjYznjpbmi77kuIDkuozkuInlm5vkupTlha3kuIPlhavkuZ3ljYHlo7no"+
"srPlj4PogobkvI3pmbjmn5LmjYznjpbmi7585Zyw5Z2A5ris6Kmm5LiA5LqM5LiJ5Zub5LqU5YWt"+
"5LiD5YWr5Lmd5Y2B5aO56LKz5Y+D6IKG5LyN6Zm45p+S5o2M546W5ou+5LiA5LqM5LiJ5Zub5LqU"+
"5YWt5LiD5YWr5Lmd5Y2B5aO56LKz5Y+D6IKG5LyN6Zm45p+S5o2M546W5ou+5LiA5LqM5LiJ5Zub"+
"5LqU5YWt5LiD5YWr5Lmd5Y2B5aO56LKz5Y+D6IKG5LyN6Zm45p+S5o2M546W5ou+fDEyfDM0fDU0"+
"MzJ8MTExMDIwOHwxMjM0NXxIfDYwNTM2MjA3MnxBfDExMTAyMTV8MTIzNDU2Nzg5MTIzNDU2fDF8"+
"6Y2+5a6c54eVfOahg+WckuW4gi3nuL3lsYA=";
System.out.println(new String(decoder.decode(encodeStr), "UTF-8"));
        // BigDecimal WK_AMT, WK_AMT1, WK_AMT2, WK_AMT3, WK_AMT4;
        // WK_AMT1 = WK_AMT2 = WK_AMT3 = WK_AMT4 = BigDecimal.ZERO;
        // System.out.println(WK_AMT1.toString());
        // System.out.println(WK_AMT2.toBigInteger());

        // Integer inin1 = new Integer(1); 
        // Integer inin2 = new Integer(1);
        // Integer inin3 = inin1;
        
        // System.out.println(inin1 == inin2);
        // System.out.println(inin1 == inin3);
        // inin3 = 2;
        // System.out.println(inin3);
        // System.out.println(inin1);



    }


}


