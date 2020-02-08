/*
 * Utility.java
 *
 * Created on March 7, 2007, 10:33 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.utility;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author Vijay
 */


public class Utility {
    
    Date m_date;
    SimpleDateFormat sdf;

    private final String[] a = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"}; 
    private final String[] b = {"ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
    private final String[] c = {"TEN","TWENTY","THIRTY","FORTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY"};
    
    private final String HUNDRED = " HUNDRED "; 
    private final String THOUSAND = " THOUSAND "; 
    private final String LAKH = " LAKH ";
    private final String CRORER = " CRORE ";
    
    private String finalstr = "";
    
    private final static String ZERO = "ZERO";
    
    private String FIRSTDIGIT = "ZERO";
    private String SECONDDIGIT = "ZERO";
    private String THIRDDIGIT = "ZERO";
    private String FOURTHDIGIT = "ZERO";
    private String FIFTHDIGIT = "ZERO";
    private String SIXTHDIGIT = "ZERO";
    private String SEVENTHDIGIT = "ZERO";
    private String EIGHTDIGIT = "ZERO";    
    private String NINETHDIGIT = "ZERO";
   
    private int FIRSTNO = 0;    
    private int Digit = 0 ;
    private int cnt = 0 ;
    private int INDEX = 0;    
   
    /** Creates a new instance of Utility */
    public Utility() {
    }
      
   public synchronized GregorianCalendar XToDate(String strDate){
        String StrDate = null;
        
//        Calendar calendar = Calendar.getInstance(); // .getInstance(TimeZone.getDefault(),Locale.getDefault());        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setLenient(false);
        StrDate = ChangeFormat(strDate);
        try{
            calendar.set(Calendar.YEAR,Integer.parseInt(StrDate.substring(0,4)));
            calendar.set(Calendar.MONTH,Integer.parseInt(StrDate.substring(5,7)) - 1);
//            calendar.set(Calendar.MONTH,0);
            calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(StrDate.substring(8,10)));
           
            
//            if(calendar.get(calendar.DAY_OF_MONTH) >= 1 && 
//                    calendar.get(calendar.DAY_OF_MONTH) <= 32){
//                if(calendar.get(calendar.MONTH) >=1 && calendar.get(calendar.MONTH) <=12){
//                    
//                }else{
//                    return null;
//                }                
//            }else{
//                return null;
//            }
        }catch(NumberFormatException nfe){
            nfe.printStackTrace();
            return null;
        }
        return calendar;
        
//        calendar.set(Calendar.YEAR,2007);
//        calendar.set(Calendar.MONTH,10);
//        calendar.set(Calendar.DAY_OF_MONTH,14);
        
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                      
   }
   
   public synchronized String ToDate(Date d){
       if(d != null){
//           String Year = m_date.substring(0,4);
//           String Month = m_date.substring(5,7);
//           String Day = m_date.substring(8,10);

            DateFormat DF = DateFormat.getDateInstance();
//            SimpleDateFormat sdf = new SimpleDateFormat();
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy",Locale.US);      
           DF.setLenient(false);
//            try {
//                System.out.println("To Pattern " + sdf.toPattern());
//                ParsePosition pos = new ParsePosition(0);
                //                  MM/dd/yyyy  According To Regional Settings   
//                Date d = sdf.parse(Month+"/"+Day+"/"+Year+" 3:2 PM",pos);
                 //Date d = sdf.parse(m_date,pos);
    //            Date d = DF.parse("15/11/2007 4:5 PM, PDT",pos);
    //            System.out.println("Date in String "+sdf1.format(d)+" POS"+pos);
//                System.out.println("Date " + sdf1.format(d));
            return sdf1.format(d);
//       }else
           
//        } catch (ParseException ex) {
//            ex.printStackTrace();
        }
       return "";
   }
   
    public synchronized String ChangeFormat(Date m_Date){
    
        DateFormat DF = DateFormat.getDateInstance();
       
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd",Locale.US);  
        DF.setLenient(false);
        
        ParsePosition pos = new ParsePosition(0);
                        // mm/dd/yyyy   According to Regional Settings     
//        System.out.println("Formatted Date : " + sdf1.format(m_Date));
       return sdf1.format(m_Date);
   }   
   


  
   public synchronized String ChangeFormat(String m_Date){
       
//       System.out.println("DATE       " + m_Date);
       
       if(m_Date != null){
        String Day = m_Date.substring(0,2);
        String Mon = m_Date.substring(3,5);
        String Yea = m_Date.substring(6,10);
        
        DateFormat DF = DateFormat.getDateInstance();
       
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd",Locale.US);  
        DF.setLenient(false);
        
        ParsePosition pos = new ParsePosition(0);
                        // mm/dd/yyyy   According to Regional Settings     
          Date d = sdf.parse(Mon+"/"+Day+"/"+Yea+" 3:2 PM",pos);
       
        return sdf1.format(d);
       }else{
           return "";
       }
   }

     public synchronized Date ChangeToDate(String m_Date){
             
        String Day = m_Date.substring(0,2);
        String Mon = m_Date.substring(3,5);
        String Yea = m_Date.substring(6,10);
        
        DateFormat DF = DateFormat.getDateInstance();
       
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd",Locale.US);  
        DF.setLenient(false);
        
        ParsePosition pos = new ParsePosition(0);
                        // mm/dd/yyyy   According to Regional Settings     
        Date d = sdf.parse(Mon+"/"+Day+"/"+Yea+" 3:2 PM",pos);
       
        return d;
       
   }   
   

    public synchronized Date NextDayDate(String m_Date){
             
        String Day = m_Date.substring(0,2);
        String Mon = m_Date.substring(3,5);
        String Yea = m_Date.substring(6,10);
        
        Yea = m_Date.substring(0,4);        
        Mon = m_Date.substring(5,7);
        Day = m_Date.substring(8,10);
        
        int mDay = Integer.parseInt(Day) + 1;
        
        Day = ""+mDay;     
        
        DateFormat DF = DateFormat.getDateInstance();
       
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy",Locale.US);  
        DF.setLenient(false);
        
        ParsePosition pos = new ParsePosition(0);
                        // mm/dd/yyyy   According to Regional Settings     
        Date d = sdf.parse(Mon+"/"+Day+"/"+Yea+" 3:2 PM",pos);
        
//        System.out.println(d);
        
        return d;
       
   }        
     
     
    public synchronized String amountToString(String paramAmount){        
        
        String s = "";
        s = paramAmount;
        
        StringTokenizer sToken = new StringTokenizer(s,".");
        
        String amount = sToken.nextToken();
        String paise = sToken.nextToken();
        
        char irt[] = amount.toCharArray();
        INDEX = irt.length - 1;
        amount = NumToChar(irt);
        char irt1[] = paise.toCharArray();
        INDEX = irt1.length - 1;
        paise = NumToChar(irt1) ;        
        if(paise.length() == 0){                        
            finalstr = "RUPEES "+ amount + " ONLY.";
        }else{
            if(amount.length() == 0){
                finalstr = "PAISE "+ paise + " ONLY.";
            }else{
                finalstr = "RUPEES "+amount + " AND PAISE "+ paise + " ONLY.";
            }    
        }        
        return finalstr;
    }
    
   private String NumToChar(char paramirt[]){ 
       FIRSTDIGIT = "ZERO";
       SECONDDIGIT = "ZERO";
       THIRDDIGIT = "ZERO";
       FOURTHDIGIT = "ZERO";
       FIFTHDIGIT = "ZERO";
       SIXTHDIGIT = "ZERO";
       SEVENTHDIGIT = "ZERO";
       EIGHTDIGIT = "ZERO";    
       NINETHDIGIT = "ZERO";
       FIRSTNO = 0;        
       cnt = 0;     
       
        while(INDEX >=0){ 
            Digit = Integer.parseInt(""+paramirt[INDEX]);
            cnt ++;   
            switch (cnt){
                case 1:
                    FIRSTDIGIT = a[Digit];
                    FIRSTNO = Digit;
                    break;
                case 2:    
                    if((FIRSTDIGIT.compareTo(ZERO) == 0 )){
                        if(Digit > 0){
                            SECONDDIGIT = Number(0) ;
                            break;                            
                        }
                    }
                    if(Digit == 1){
                        SECONDDIGIT = Number(Digit); 
                        FIRSTDIGIT = "";
                        break;
                    }
                    if(Digit > 0){
                        SECONDDIGIT = c[Digit - 1];
                        break;                        
                    }
                case 3:           
                    if(Digit > 0){
                        THIRDDIGIT = a[Digit];
                    }                    
                    break;
                case 4:
                    if(Digit > 0){
                        FOURTHDIGIT = a[Digit];
                        FIRSTNO = Digit;
                    }
                    break;
                case 5:     
                    if((FOURTHDIGIT.compareTo(ZERO) == 0 )){
                        if(Digit > 0){
                            FIFTHDIGIT = Number(0) ;
                            FOURTHDIGIT = "";
                            break;                            
                        }
                    }                    
                    if(Digit == 1 ){ 
                        FIFTHDIGIT = Number(Digit) ; 
                        FOURTHDIGIT = "";
                        FIRSTNO = Digit;
                        break;
                    }  
                    if(Digit > 0){
                        FIFTHDIGIT = c[Digit - 1];
                        FIRSTNO = Digit;
                    }    
                    break;
                case 6:
                    if(Digit == 1 ) { 
                        SIXTHDIGIT = a[Digit];  
                        FIRSTNO = Digit;
                        break;
                    }                                        
                    SIXTHDIGIT = a[Digit];
                    FIRSTNO = Digit;
                    break;
                case 7:
                    if(SIXTHDIGIT.compareTo(ZERO) == 0){
                        if(Digit > 0){
                            SEVENTHDIGIT = Number(0);
                            SIXTHDIGIT = "";
                            break;                            
                        }
                    }
                    if(Digit == 1 ) {
                        SEVENTHDIGIT = Number(Digit);
                        SIXTHDIGIT = "";
                        break;
                    }  
                    if(Digit > 0){
                        SEVENTHDIGIT = c[Digit -1];    
                        FIRSTNO = Digit;
                        break;                        
                    }
                case 8:
                    if(Digit > 0){
                        EIGHTDIGIT = a[Digit];
                        FIRSTNO = Digit;
                        break;                                            
                    }
                case 9:
                    if(EIGHTDIGIT.compareTo(ZERO) == 0){
                        if(Digit > 0){
                            EIGHTDIGIT = Number(0);  
                            break;
                        }                        
                    }
                    if(Digit == 1){
                        EIGHTDIGIT = Number(Digit);                        
                        break;
                    }
                    if(Digit > 0){
                        NINETHDIGIT = c[Digit -1];
                        break;
                    }
                default:    
            }             
            INDEX--;
        }           
        return formatString();    
   }

    
    
    private String  Number(int No){
        if(No == 0){
            return c[Digit - 1];
        }
        if(No == 1){
            return b[FIRSTNO - 1];
        }
        return "";
    }
    
    private String formatString(){
        String amount = ""; 
        if(NINETHDIGIT.compareTo(ZERO) != 0){
            amount = amount + NINETHDIGIT ;
        }
        if(EIGHTDIGIT.compareTo(ZERO) != 0){
            amount = amount + EIGHTDIGIT + CRORER;
        }
        if(SEVENTHDIGIT.compareTo(ZERO) != 0){
            amount = amount + SEVENTHDIGIT ;
        }
        if(SIXTHDIGIT.compareTo(ZERO) != 0 ){
            amount = amount + SIXTHDIGIT + LAKH;
        }
        if(FIFTHDIGIT.compareTo(ZERO) != 0){
            amount = amount + FIFTHDIGIT ;
        }
        if(FOURTHDIGIT.compareTo(ZERO) != 0){
            amount = amount + FOURTHDIGIT + THOUSAND;            
        }
        if(THIRDDIGIT.compareTo(ZERO) != 0){
            amount = amount + THIRDDIGIT + HUNDRED ;
        }
        if(SECONDDIGIT.compareTo(ZERO) != 0){
            amount = amount + SECONDDIGIT;
        }
        if(FIRSTDIGIT.compareTo(ZERO) != 0){
            amount = amount + FIRSTDIGIT ;
        }
        return amount ;
    }
    
//   public static void main(String args[]){
//        Utility utl = new Utility();
////        utl.ToDate("");
//        utl.Dt();
//       
//   }
    
    
//    public void reverseDate(String date){
//        String tmp = null;
//        System.out.println(date.length());
//        for(int i = date.length() ; i >= 0 ; i--){
//            tmp = date.substring(8,1);
//            System.out.println(tmp);
//        }
//    }
    
 public synchronized Date TodaysDate(String m_Date){
             
        String Day = m_Date.substring(0,2);
        String Mon = m_Date.substring(3,5);
        String Yea = m_Date.substring(6,10);
        
        Yea = m_Date.substring(0,4);        
        Mon = m_Date.substring(5,7);
        Day = m_Date.substring(8,10);
        
        int mDay = Integer.parseInt(Day);
        
        Day = ""+mDay;     
        
        DateFormat DF = DateFormat.getDateInstance();
       
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy",Locale.US);  
        DF.setLenient(false);
        
        ParsePosition pos = new ParsePosition(0);
                        // mm/dd/yyyy   According to Regional Settings     
        Date d = sdf.parse(Mon+"/"+Day+"/"+Yea+" 3:2 PM",pos);
        
//        System.out.println(d);
        
        return d;
       
   }          
  
    public synchronized Date BackDate(String m_Date){
             
        String Day = m_Date.substring(0,2);
        String Mon = m_Date.substring(3,5);
        String Yea = m_Date.substring(6,10);
        
        Yea = m_Date.substring(0,4);        
        Mon = m_Date.substring(5,7);
        Day = m_Date.substring(8,10);
        
        int mDay = Integer.parseInt(Day) - 1;
        
        Day = ""+mDay;     
        
        DateFormat DF = DateFormat.getDateInstance();
       
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy",Locale.US);  
        DF.setLenient(false);
        
        ParsePosition pos = new ParsePosition(0);
                        // mm/dd/yyyy   According to Regional Settings     
        Date d = sdf.parse(Mon+"/"+Day+"/"+Yea+" 3:2 PM",pos);
        
//        System.out.println(d);
        
        return d;
       
   }         
 
}

