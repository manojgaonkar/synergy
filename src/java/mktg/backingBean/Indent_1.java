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
public class Indent_1 {

    /** Creates a new instance of Indent_1 */
    private HashMap<Integer, Double> quantity = new HashMap<Integer, Double>();
    private HashMap<Integer, Integer> hmprodid = new HashMap<Integer, Integer>();
    private HashMap<Integer, String> hmProduct = new HashMap<Integer, String>();
    private HashMap<Integer, String> hmProductShortName = new HashMap<Integer, String>();
    private HashMap<Integer, Integer> hmprodtype = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> hmx = new HashMap<Integer, Integer>();
    private HashMap<Integer, Double> hmRate = new HashMap<Integer, Double>();
    private HashMap<Integer, Double> hmComm = new HashMap<Integer, Double>();
    private HashMap<Integer, Double> hmTax = new HashMap<Integer, Double>();
    private HashMap<Integer, Double> hmCst = new HashMap<Integer, Double>();
    private HashMap<Integer, Double> hmCess = new HashMap<Integer, Double>();
    private HashMap<Integer, Double> hmTcd = new HashMap<Integer, Double>();
    private HashMap<Integer, Double> hmsplrate = new HashMap<Integer, Double>();
    private String row;
    private int rowno;
    private int index;
    private int size;
    private int routeid;
    private int custid;
    private int talid;
    private long billno;
    private int custtype;
    private int mdt;
    private double subsidy;
    private String idate;
    private String firstname;
    private String mobileNo;
    private String cacr;
    private String rtname;
    private String moreve;
    private String rectimestamp;
    private String user;
    private boolean blnValue;
    private boolean reclock;
    private boolean blnSave;
    private boolean blnCstIndt;
    private Utility utl = new Utility();

    public Indent_1() {
//        System.out.println("Inintalising Bean");
        hmx.clear();

        quantity.clear();
        hmprodid.clear();

        hmProduct.clear();
        hmProductShortName.clear();
        hmprodtype.clear();

        hmRate.clear();
        hmComm.clear();
        hmTax.clear();
        hmCst.clear();
        hmCess.clear();
        hmTcd.clear();
        hmsplrate.clear();

        firstname = "";
        mobileNo = "";
        cacr = "";

        routeid = 0;
        custid = 0;
        talid = 0;
        index = 0;
        size = 0;
        billno = 0;

        blnValue = true;

        blnSave = false;
    }

    public HashMap getqunatity() {
        return this.quantity;
    }

    public HashMap gethmprodid() {
        return this.hmprodid;
    }

    public void setprodid(int prodid) {
        this.hmprodid.put(getindex(), prodid);        
    }

    public int getprodid() {
        if (hmprodid.containsKey(getindex())) {
            return this.hmprodid.get(getindex());
        } else {
            return 0;
        }
    }

    public void setx() {
        if (this.quantity.get(getindex()) > 0) {
            this.hmx.put(this.hmprodid.get(getindex()), getindex());
//            System.out.println("Index : " + getindex() + " prodId : " + this.hmprodid.get(getindex()));
        }
    }

    public HashMap gethmx() {
        return this.hmx;
    }

    public void setprodtype(int prodtype) {
        this.hmprodtype.put(getindex(), prodtype);
    }

    public int getprodtype() {
        if (hmprodtype.containsKey(getindex())) {
            return this.hmprodtype.get(getindex());
        } else {
            return 0;
        }
    }

    public HashMap gethmProdType() {
        return this.hmprodtype;
    }

    public void setproduct(String product) {
        hmProduct.put(getindex(), product);
    }

    public String getproduct() {
        if (hmProduct.containsKey(getindex())) {
            return this.hmProduct.get(getindex());
        } else {
            return "";
        }
    }

    public HashMap gethmProduct() {
        return this.hmProduct;
    }

        public void setproductShortName(String productShortName) {
        hmProduct.put(getindex(), productShortName);
    }

    public String getproductShortName() {
        if (hmProductShortName.containsKey(getindex())) {
            return this.hmProductShortName.get(getindex());
        } else {
            return "";
        }
    }

    public HashMap gethmProductShortName() {
        return this.hmProductShortName;
    }


    public double getqty() {
        if (quantity.containsKey(getindex())) {
            return this.quantity.get(getindex());
        } else {
            return 0.00;
        }
    }

    public void setqty(double qty) {
        this.quantity.put(getindex(), qty);
        setx();
    }

    public boolean getblnSave() {
        return this.blnSave;
    }

    public void setblnSave(boolean blnSave) {
//        System.out.println(blnSave);
        this.blnSave = blnSave;
    }

    public void setindex(int index) {
        this.index = index;
    }

    public int getindex() {
        return this.index;
    }

    public void setsize(int size) {
        this.size = size;
    }

    public int getQtysize() {
        return quantity.size();
    }

    public int getProdIDsize() {
        return this.hmprodid.size();
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getfirstname() {
        return this.firstname;
    }
    public void setmobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getmobileNo() {
        return this.mobileNo;
    }
    
    public void setblnValue(boolean blnValue) {
        this.blnValue = blnValue;
    }

    public boolean getblnValue() {
        return this.blnValue;
    }

    public void setcacr(String cacr) {
        this.cacr = cacr;
    }

    public String getcacr() {
        return this.cacr;
    }

    public void setrouteid(int routeid) {
        this.routeid = routeid;
    }

    public int getrouteid() {
        return this.routeid;
    }

    public void setcustid(int custid) {
        this.custid = custid;
    }

    public int getcustid() {
        return this.custid;
    }

    public void settalid(int talid) {
        this.talid = talid;
    }

    public int gettalid() {
        return this.talid;
    }

    public void setrate(double Rate) {
        hmRate.put(getindex(), Rate);
    }

    public double getrate() {
        if (hmRate.containsKey(getindex())) {
            return this.hmRate.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmRate() {
        return this.hmRate;
    }

    public void setcomm(double Comm) {
        hmComm.put(getindex(), Comm);
    }

    public double getcomm() {
        if (hmComm.containsKey(getindex())) {
            return this.hmComm.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmComm() {
        return this.hmComm;
    }

    public void settax(double Tax) {
        hmTax.put(getindex(), Tax);
    }

    public double gettax() {
        if (hmTax.containsKey(getindex())) {
            return this.hmTax.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmTax() {
        return this.hmTax;
    }

    public void setcst(double cst) {
        hmCst.put(getindex(), cst);
    }

    public double getcst() {
        if (hmCst.containsKey(getindex())) {
            return this.hmCst.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmCst() {
        return this.hmCst;
    }

    public void setcess(double cess) {
        hmCess.put(getindex(), cess);
    }

    public double getcess() {
        if (hmCess.containsKey(getindex())) {
            return this.hmCess.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmCess() {
        return this.hmCess;
    }

    public void settcd(double Tcd) {
        hmTcd.put(getindex(), Tcd);
    }

    public double gettcd() {
        if (hmTcd.containsKey(getindex())) {
            return this.hmTcd.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmTcd() {
        return this.hmTcd;
    }

    
    public void setsplrate(double splrate) {
        hmsplrate.put(getindex(), splrate);
    }

    public double getsplrate() {
        if (hmsplrate.containsKey(getindex())) {
            return this.hmsplrate.get(getindex());
        } else {
            return 0.00;
        }
    }

    public HashMap gethmsplrate() {
        return this.hmsplrate;
    }
    
    
    public void setrow(String row) {
        this.row = row;
        if (hmProduct.containsValue(this.row)) {
            Set s = hmProduct.entrySet();
            Iterator itr = s.iterator();
            while (itr.hasNext()) {
                Map.Entry me = (Map.Entry) itr.next();
                if (this.row.equals(me.getValue())) {
                    rowno = Integer.parseInt(me.getKey().toString());
                    break;
                }
            }
        }
    }

    public int getrowno() {
        return this.rowno;
    }

    public void setidate(String idate) {
        this.idate = idate;
    }

    public String getidate() {
        return utl.ChangeFormat(this.idate);
    }

    public void setbillno(long billno) {
        this.billno = billno;
    }

    public long getbillno() {
        return this.billno;
    }

    public void setrtname(String rtname) {
        this.rtname = rtname;
    }

    public String getrtname() {
        return this.rtname;
    }

    public void setcusttype(int custtype) {
        this.custtype = custtype;
    }

    public int getcusttype() {
        return this.custtype;
    }

    public void setsubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public double getsubsidy() {
        return this.subsidy;
    }

    public void setmoreve(String moreve) {
        this.moreve = moreve;
    }

    public String getmoreve() {
        return this.moreve;
    }

    public void setmdt(int mdt) {
        this.mdt = mdt;
    }

    public int getmdt() {
        return this.mdt;
    }

    public void setreclock(boolean reclock) {
        this.reclock = reclock;
    }

    public boolean getreclock() {
        return this.reclock;
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

    public void setblnCstIndt(boolean blnCstIndt) {
        this.blnCstIndt = blnCstIndt;
    }

    public boolean getblnCstIndt() {
        return this.blnCstIndt;
    }

    public void reInit() {
//        System.out.println("Re-Initialising Bean");
        hmx.clear();

        quantity.clear();
        hmprodid.clear();

        hmProduct.clear();
        hmProductShortName.clear();
        hmprodtype.clear();

        hmRate.clear();
        hmComm.clear();
        hmTax.clear();
        hmCst.clear();
        hmCess.clear();
        hmTcd.clear();
        hmsplrate.clear();

        firstname = "";
        cacr = "";

        routeid = 0;
        custid = 0;
        talid = 0;
        index = 0;
        size = 0;
        billno = 0;

        blnValue = true;

        blnSave = false;        
        
    }
}
