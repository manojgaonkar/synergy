/*
 * Indent_1.java
 *
 * Created on February 7, 2009, 3:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

import java.util.HashMap;
import mktg.utility.Utility;

/**
 *jghjgh
 * @author MD
 */
public class CrDr {        
    
    /** Creates a new instance of Indent_1 */       
    private HashMap<Integer,Double> quantity = new HashMap<Integer,Double>();    
    private HashMap<Integer,Integer> hmprodid = new HashMap<Integer,Integer>();    
    private HashMap<Integer,Double> leakage = new HashMap<Integer,Double>();           
    private HashMap<Integer,Double> retn = new HashMap<Integer,Double>();    
    private HashMap<Integer,Integer> hmtrID = new HashMap<Integer,Integer>();    
    
    private HashMap<Integer,Double> hmRate = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmComm = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmTax = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmCst = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmCess = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmTcd = new HashMap<Integer,Double>();
     
    
    private int index;    
    private int size;    
    private int routeid;
    private int custid;
    private int talid;
    private int custtype;
    private int crateout;
    private int cratein;
    
    private String firstname;
    private String product;    
    private String cacr;
    private String idate;
    private String rtname;
    private String rectimestamp;
    private String user;
    
    private boolean blnCustList;
    private boolean blnValue;
       
    private double lessamt;
    private double exceamt;
    private double paidatbank;
    
    Utility utl = new Utility(); 
    
    public CrDr() {    
        quantity.clear();
        hmprodid.clear();
        
        leakage.clear();
        retn.clear();
        hmRate.clear();
        hmComm.clear();
        hmTax.clear();
        hmCst.clear();
        hmCess.clear();
        hmTcd.clear();
        hmtrID.clear();
        
        firstname = "";        
        product = "";  
        cacr="";
        
        routeid = 0;
        custid = 0;
        talid = 0;                
        index = 0;    
        size = 0;
        
        blnValue = true;
        blnCustList = true;
    }
       
    public HashMap getqunatity(){
        return this.quantity;
    }
    
    public HashMap gethmprodid(){
        return this.hmprodid;
    }
               
    public void setprodid(int prodid){
        this.hmprodid.put(getindex(),prodid);
    }
    
    public int getprodid(){
        if(hmprodid.containsKey(getindex()))
            return this.hmprodid.get(getindex());
        else
            return 0;
    }
    
    public void setproduct(String product){
        this.product = product;
    }
    
    public String getproduct(){
        return this.product;
    }
    
    public double getqty(){
        if(quantity.containsKey(getindex()))
                return this.quantity.get(getindex());
        else
            return 0.00;
    }
    
    public void setqty(double qty){
        this.quantity.put(getindex(),qty);               
    }    
    
    public void setindex(int index){
//        System.out.println(" INDEX NO : " + index);
        this.index = index;
    }
    
    public int getindex(){
        return this.index;
    }
    
    public void setsize(int size){
        this.size = size;
    }
    
    public int getQtysize(){
        return quantity.size();
    }
    
    public int getProdIDsize(){
        return this.hmprodid.size();
    }
    
    public void setfirstname(String firstname){
        this.firstname = firstname;
    }
        
    public String getfirstname(){
        return this.firstname;
    }
    
    public void setblnCustList(boolean blnCustList){
        this.blnCustList = blnCustList;
    }
    
    public boolean getblnCustList(){
        return this.blnCustList;
    }
    
    public void setblnValue(boolean blnValue){
        this.blnValue = blnValue;
    }
    
    public boolean getblnValue(){
        return this.blnValue;
    }
    
    public void setcacr(String cacr){
        this.cacr = cacr;
    }
    
    public String getcacr(){
        return this.cacr;
    }    
    
    public void setrouteid(int routeid){
        this.routeid = routeid;
    }
    
    public int getrouteid(){
        return this.routeid;
    }
    
    public void setcustid(int custid){
        this.custid = custid;
    }
    
    public int getcustid(){
        return this.custid;
    }
    public void settalid(int talid){
        this.talid = talid;
    }
    
    public int gettalid(){
        return this.talid;
    }
    
    public void setrate(double Rate){
        hmRate.put(getindex(),Rate);
    }
    
    public double getrate(){
        if(hmRate.containsKey(getindex()))
            return this.hmRate.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap gethmRate(){
        return this.hmRate;
    }
    
    public void setcommi(double Comm){        
        hmComm.put(getindex(),Comm);
    }
    
    public double getcommi(){
        if(hmComm.containsKey(getindex()))
            return this.hmComm.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap gethmComm(){
        return this.hmComm;
    }
    
    public void settax(double Tax){
        hmTax.put(getindex(),Tax);
    }
    
    public double gettax(){
        if(hmTax.containsKey(getindex()))
            return this.hmTax.get(getindex());
        else
            return 0.00;
    }

    public HashMap gethmTax(){
        return this.hmTax;
    }
    public void setcst(double cst){
        hmCst.put(getindex(),cst);
    }
    
    public double getcst(){
        if(hmCst.containsKey(getindex()))
            return this.hmCst.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap gethmCst(){
        return this.hmCst;
    }

    public void setcess(double cess){
        hmCess.put(getindex(),cess);
    }
    
    public double getcess(){
        if(hmCess.containsKey(getindex()))
            return this.hmCess.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap gethmCess(){
        return this.hmCess;
    }
    
    public void settcd(double Tcd){
        hmTcd.put(getindex(),Tcd);
    }

    public double gettcd(){
        if(hmTcd.containsKey(getindex()))
            return this.hmTcd.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap gethmTcd(){
        return this.hmTcd;
    }
    
    public void setleakage(double leakage){
        System.out.println("Leakage : " + leakage + " Index : " + getindex());        
        this.leakage.put(getindex(),leakage);               
    }
    
    public double getleakage(){
        if(leakage.containsKey(getindex()))
            return this.leakage.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap getLeak(){
        return this.leakage;
    }
    
    public void setretn(double retn){
        this.retn.put(getindex(),retn);               
    }
    
    public double getretn(){
        if(retn.containsKey(getindex()))
            return this.retn.get(getindex());
        else
            return 0.00;
    }
    
    public HashMap getRtn(){
        return this.retn;
    }    
    
    public void setidate(String idate){
        this.idate = idate;
    }
    
    public String getidate()throws NullPointerException{
//        if(this.idate.length() > 0)
            return utl.ChangeFormat(this.idate);
//        else 
//            return "";
    }
    
    public void settrID(int trID){
//        System.out.println("TRAN ID : " +trID + " INDEX " + getindex());
        this.hmtrID.put(getindex(),trID);
    }
    
    public int gettrID(){
        if(hmtrID.containsKey(getindex()))
            return this.hmtrID.get(getindex());
        else
            return 0;
    }
    public HashMap gethmtrID(){
        return this.hmtrID;
    }
    
    
    public void setcusttype(int custtype){
        this.custtype = custtype;
    }
    
    public int getcusttype(){
        return this.custtype;
    }
        
    public void setrtname(String rtname){
        this.rtname = rtname;
    }
    
    public String getrtname(){
        return this.rtname;
    }
    
    public void setlessamt(double lessamt){
        System.out.println("LessAmount "+ lessamt);
        this.lessamt = lessamt;
    }
    
    public double getlessamt(){
        return this.lessamt;
    }
    
    public void setexceamt(double exceamt){
        this.exceamt = exceamt;
    }
    
    public double getexceamt(){
        return this.exceamt;
    }
    
    public void setcrateout(int crateout){
        this.crateout = crateout;
    }
    
    public int getcrateout(){
        return this.crateout;
    }
    
    public void setcratein(int cratein){
        this.cratein = cratein;
    }
    
    public int getcratein(){
        return this.cratein;
    }
    
    public void setpaidatbank(double paidatbank){
        this.paidatbank = paidatbank;
    }
    
    public double getpaidatbank(){
        return this.paidatbank;
    }
    
    public void setrectimestamp(String rectimestamp) {
        this.rectimestamp = rectimestamp;
    }

    public String getrectimestamp() {
        return this.rectimestamp;
    }
    
    public void setuser(String user){
        this.user = user;
    }
    
    public String getuser(){
        return this.user;
    }    
    
  
}
