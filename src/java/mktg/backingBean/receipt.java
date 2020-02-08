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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mktg.utility.Utility;

/**
 *jghjgh
 * @author MD
 */
public class receipt {        
    
    /** Creates a new instance of Indent_1 */       
    private HashMap<Integer,Double> quantity = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmamt = new HashMap<Integer,Double>();
    private HashMap<Integer,Integer> hmID = new HashMap<Integer,Integer>();
    private HashMap<Integer,Long> hmBillno = new HashMap<Integer,Long>();
    private HashMap<Integer,String> hmgrno = new HashMap<Integer,String>();
    private HashMap<Integer,String> hmgpno = new HashMap<Integer,String>();
    private HashMap<Integer,String> hmgrdate = new HashMap<Integer,String>(); 
    private HashMap<Integer,String> hmchequeno = new HashMap<Integer,String>();
    private HashMap<Integer,Integer> hmrouteid = new HashMap<Integer,Integer>();
    private HashMap<Integer,Integer> hmprodid = new HashMap<Integer,Integer>();  
    private HashMap<Integer,String> hmProduct = new HashMap<Integer,String>();
    private HashMap<Integer,Integer> hmprodtype = new HashMap<Integer,Integer>();  
        
    private HashMap<Integer,Double> hmRate = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmComm = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmTax = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmCst = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmCess = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmTcd = new HashMap<Integer,Double>();

    private HashMap<Integer,Double> hmlessamt = new HashMap<Integer,Double>();
    private HashMap<Integer,Double> hmexceamt = new HashMap<Integer,Double>();
    
    private String row;
    private int rowno;
    private int index;    
    private int size;    
//    private int routeid;
    private int custid;
    private int talid;
//    private int billno;
    private int custtype;
    private int mdt;
    
    private double subsidy;
    private double Amt;
    
    private String idate;
    private String firstname;

    private String cacr;
    private String rtname;
    private String moreve;
    

    private boolean blnValue;
    private boolean reclock;
    private int id;
    
    
    private Utility utl = new Utility();
    public receipt() {   
        
        hmlessamt.clear();
        hmexceamt.clear();
        hmamt.clear();
        hmgrno.clear();
        hmgpno.clear();
        hmgrdate.clear();
        hmchequeno.clear();
        hmrouteid.clear();
        hmProduct.clear();
        hmprodtype.clear();
        
        hmBillno.clear();
        quantity.clear();
        hmprodid.clear();
        
        hmRate.clear();
        hmComm.clear();
        hmTax.clear();
        hmCst.clear();
        hmCess.clear();
        hmTcd.clear();
            
        firstname = "";        
        cacr="";
        
//        routeid = 0;
        custid = 0;
        talid = 0;                
        index = 0;    
        size = 0;
//        billno =0;
        
        blnValue = true;
      
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
    
    public void setprodtype(int prodtype){
        this.hmprodtype.put(getindex(),prodtype);
    }
    
    public int getprodtype(){
        if(hmprodtype.containsKey(getindex()))
            return this.hmprodtype.get(getindex());
        else
            return 0;        
    }
    
    public HashMap gethmProdType(){
        return this.hmprodtype;
    }
    
    public void setproduct(String product){        
        hmProduct.put(getindex(),product);        
    }
    
    public String getproduct(){
        if(hmProduct.containsKey(getindex()))
            return this.hmProduct.get(getindex());
        else
            return "";
    }
    
    public HashMap gethmProduct(){
        return this.hmProduct;
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
    
    
    public double getamt(){
        if(hmamt.containsKey(getindex()))
                return this.hmamt.get(getindex());
        else
            return 0.00;
    }
    
    public void setamt(double amt){
        this.hmamt.put(getindex(),amt);               
    }      
    
    public HashMap gethmamt(){
        return this.hmamt;
    }
  
    public String getgrno(){
        if(hmgrno.containsKey(getindex()))
            return this.hmgrno.get(getindex());
        else
            return "";
    }   
    
    public void setgrno(String grno){
        this.hmgrno.put(getindex(),grno);             
    }          
    
    
    public HashMap gethmgrno(){
        return this.hmgrno;
    }
  
     public String getchequeno(){
        if(hmchequeno.containsKey(getindex()))
            return this.hmchequeno.get(getindex());
        else
            return "";
    } 
     
    public void setchequeno(String chequeno){
        this.hmchequeno.put(getindex(),chequeno);
    }
    
    public HashMap gethmchequeno(){
        return this.hmchequeno;
    }
    
    public String getgpno(){
        if(hmgpno.containsKey(getindex()))
            return this.hmgpno.get(getindex());
        else
            return "";        
    }
    
    public void setgpno(String gpno){
        this.hmgpno.put(getindex(),gpno);
    }
    
    public HashMap gethmgpno(){
        return this.hmgpno;
    }
        
   public String getgrdate(){
        if(hmgrdate.containsKey(getindex()))
                return this.hmgrdate.get(getindex());
        else
            return "";
    }    
   
    public void setgrdate(String grdate){
        this.hmgrdate.put(getindex(),grdate);               
    }          
    
    public HashMap gethmgrdate(){
        return this.hmgrdate;
    }    
        
    public void setindex(int index){
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
        this.hmrouteid.put(getindex(),routeid);
    }
    
    public int getrouteid(){
        if(hmrouteid.containsKey(getindex()))
            return this.hmrouteid.get(getindex());
        else
            return 0;
    }
    
    public HashMap gethmrouteid(){
        return this.hmrouteid;
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
    
    public void setcomm(double Comm){        
        hmComm.put(getindex(),Comm);
    }
    
    public double getcomm(){
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
        
    public void setrow(String row){
        this.row = row;
        if(hmProduct.containsValue(this.row)){
            Set s = hmProduct.entrySet();                    
            Iterator itr = s.iterator();
            while(itr.hasNext()){
                Map.Entry me = (Map.Entry) itr.next();
                if(this.row.equals(me.getValue())){                                            
                    rowno = Integer.parseInt(me.getKey().toString());
                    break;
                }
            }         
        }                    
    }
    
    public int getrowno(){   
        return this.rowno;
    }
    
    public void setidate(String idate){
        this.idate = idate;        
    }
    
    public String getidate(){
        return utl.ChangeFormat(this.idate);
    }
        
    public void setbillno(long billno){
        this.hmBillno.put(getindex(),billno);
    }
    
    public long getbillno(){
     if(hmBillno.containsKey(getindex()))
            return this.hmBillno.get(getindex());
        else
            return 0;
    }
    
    public HashMap gethmBillno(){
        return this.hmBillno;
    }
            
    public void setrtname(String rtname){
        this.rtname = rtname;
    }
    
    public String getrtname(){
        return this.rtname;
    }
    
    public void setcusttype(int custtype){
        this.custtype = custtype;
    }
    
    public int getcusttype(){
        return this.custtype;
    }
    
    public void setsubsidy(double subsidy){
        this.subsidy = subsidy;
    }
    
    public double getsubsidy(){
        return this.subsidy;
    }
    
    public void setmoreve(String moreve){
        this.moreve = moreve;
    }
                        
    public String getmoreve(){
        return this.moreve;
    }
    
    public void setmdt(int mdt){
        this.mdt = mdt;
    }
    
    public int getmdt(){
        return this.mdt;
    }
    
    public void setreclock(boolean reclock){
        this.reclock = reclock;
    }
    
    public boolean getreclock(){
        return this.reclock;
    }
        
    public double getexceamt(){
        if(this.hmexceamt.containsKey(getindex()))
            return this.hmexceamt.get(getindex());
        else
            return 0.00;
    }   
    
    public void setexceamt(double exceamt){
        this.hmexceamt.put(getindex(),exceamt);             
    }              
            
    public HashMap gethmexceamt(){
        return this.hmexceamt;
    }
        
    public double getlessamt(){
        if(this.hmlessamt.containsKey(getindex()))
            return this.hmlessamt.get(getindex());
        else
            return 0.00;
    }   
    
    public void setlessamt(double lessamt){
        this.hmlessamt.put(getindex(),lessamt);             
    }                  
            
    public HashMap gethmlessamt(){
        return this.hmlessamt;
    }
               
    public void setid(int id){
        this.hmID.put(getindex(), id);
    }
    
    public int getid(){
        if(this.hmID.containsKey(getindex()))
            return this.hmID.get(getindex());
        else
            return 0;        
    }
    
    public HashMap gethmid(){
        return this.hmID;
    }
    
}
