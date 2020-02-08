/*
 * indent.java
 *
 * Created on February 4, 2009, 11:04 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class indent
 * 
 * @author MD
 */
@Entity
public class indent implements Serializable {

    
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private long billno;
    private int customer;
    private int product;            
    private int route;
    private int taluka;
    private int saletype;
    private int prodtype;
    private int custtype;
    private int entrytype;    
    private int crateout;
    private int cratein;
    private int ratetype;
    
    private String cacr;
    private String prodname;
    private String custname;    
    private String rtname;
    private String moreve;
    private String grno;
    private String chequeno;
    private Date grdate;
    private String gpno;
    private String rectimestamp;
    private String user;
    private Date Idate;
    
//    private Date Grdate;
    
            
    private double quantity;
    private double amount;
    private double rate; 
    private double commi;
    private double commiamt;    
    private double tax;
    private double taxamt;
    private double cst;
    private double cstamt;
    private double cess;
    private double cessamt;
    private double tcd;
    private double tcdamt;
//    private double splrate;
//    private double splrateamt;
    
    private double netamount;
    private double leakage;
    private double returnmilk;
    private double netqty;
    private double subsidy;
    private double lessamt;
    private double exceamt;
    private double paidatbank;    
    private double sf;
    private double hl;    
    private double demand;
    
    private boolean reclock;
    
    /** Creates a new instance of indent */
    public indent() {
    }

    /**
     * Gets the id of this indent.
     * @return the id
     */
    @Id
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this indent to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setcustomer(int customer){
        this.customer = customer;
    }

    public int getcustomer(){
        return this.customer;
    }    
    
    public void setquantity(double quantity){
        this.quantity = quantity;
    }
    
    public double getquantity(){
        return this.quantity;
    }
    
    public void setproduct(int product){
        this.product = product;
    }
    
    public int getproduct(){
        return this.product;
    }
    
    public void setprodname(String prodname){
        this.prodname = prodname;
    }
    
    public String getprodname(){
        return this.prodname;
    }
    
  
    public void setroute(int route){
        this.route = route;
    }
    
    public int getroute(){
        return this.route;
    }
    
    public void settaluka(int taluka){
        this.taluka = taluka;
    }
    
    public int gettaluka(){
        return this.taluka;
    }
    
    public void setcacr(String cacr){
        this.cacr = cacr;
    }
    
    public String getcacr(){
        return this.cacr;
    }    
    
    public void setamount(double amount){
        this.amount = amount;
    }
    
    public double getamount(){
        return this.amount;
    }
    
    public void setrate(double rate){
        this.rate = rate;
    }
            
    public double getrate(){
        return this.rate;
    }
    
    public void setIdate(Date Idate){
        this.Idate = Idate;
    }
    
//    public void setGrdate(Date Grdate){
//        this.Grdate = Grdate;
//    }
    
   
    
    public void setcustname(String custname){
        this.custname = custname;
    }
    
    public String getcustname(){
        return this.custname;
    }
    
    @Temporal(value = TemporalType.DATE)
    public Date getIdate(){
        return this.Idate;
    }
            
//    @Temporal(value = TemporalType.DATE)
//    public Date getGrdate(){
//        return this.Grdate;
//    }
    
    public void settax(double tax){
        this.tax = tax;
    }
    public double gettax(){
        return this.tax;
    }
    
    public void settaxamt(double taxamt){
        this.taxamt = taxamt;
    }    
    public double gettaxamt(){
        return this.taxamt;
    }
    
    public void setcst(double cst){
        this.cst = cst;
    }
    public double getcst(){
        return this.cst;
    }
    
    public void setcstamt(double cstamt){
        this.cstamt = cstamt;
    }
    public double getcstamt(){
        return this.cstamt;
    }
            
    public void setcess(double cess){
        this.cess = cess;
    }
    public double getcess(){
        return this.cess;
    }
    
    public void setcessamt(double cessamt){
        this.cessamt = cessamt;
    }
    public double getcessamt(){
        return this.cessamt;
    }
        
    public void setnetamount(double netamount){
        this.netamount = netamount;
    }    
    public double getnetamount(){
        return this.netamount;
    }
    
    public void settcd(double tcd){
        this.tcd = tcd;
    }
    public double gettcd(){
        return this.tcd;
    }
    
    public void settcdamt(double tcdamt){
        this.tcdamt = tcdamt;
    }
    public double gettcdamt(){
        return this.tcdamt;
    }    
    
//    public void setsplrate(double splrate){
//        this.splrate = splrate;
//    }
//    public double getsplrate(){
//        return this.splrate;
//    }
//    
//    public void setsplrateamt(double splrateamt){
//        this.splrateamt = splrateamt;
//    }
//    public double getsplrateamt(){
//        return this.splrateamt;
//    }    
    
    public void setcommi(double commi){
        this.commi = commi;
    }
    
    public double getcommi(){
        return this.commi;
    }
    
    public void setcommiamt(double commiamt){
        this.commiamt = commiamt;
    }
    
    public double getcommiamt(){
        return this.commiamt;
    }
    
    public void setleakage(double leakage){
        this.leakage = leakage;
    }
    
    public double getleakage(){
        return this.leakage;
    }
    
    public void setreturnmilk(double returnmilk){
        this.returnmilk = returnmilk;
    }
    
    public double getreturnmilk(){
        return this.returnmilk;
    }
    
    public void setnetqty(double netqty){
        this.netqty = netqty;
    }
    
    public double getnetqty(){
        return this.netqty;
    }
    
    public void setbillno(long billno){
        this.billno = billno;
    }
    
    public long getbillno(){
        return this.billno;
    }
    
    public void setsaletype(int saletype){
        this.saletype = saletype;
    }
    
    public int getsaletype(){
        return this.saletype;
    }
    
    public void setprodtype(int prodtype){
        this.prodtype = prodtype;
    }
    
    public int getprodtype(){
        return this.prodtype;
    }
    
    public void setrtname(String rtname){
        this.rtname = rtname;
    }
    
    public String getrtname(){
        return this.rtname;
    }
    
    public void setsubsidy(double subsidy){
        this.subsidy = subsidy;
    }
    
    public double getsubsidy(){
        return this.subsidy;
    }    
    
    public void setcusttype(int custtype){
        this.custtype = custtype;
    }
    
    public int getcusttype(){
        return this.custtype;
    }
    
   public void setlessamt(double lessamt){
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
    
    public void setentrytype(int entrytype){
        this.entrytype = entrytype;
    }
    
    public int getentrytype(){
        return this.entrytype;
    }
    
    public void setsf(double sf){
        this.sf = sf;
    }
    
    public double getsf(){
        return this.sf;
    }
    
    public void sethl(double hl){
        this.hl = hl;
    }
    
    public double gethl(){
        return this.hl;
    }
    
    public void setmoreve(String moreve){
        this.moreve = moreve;
    }
    
    public String getmoreve(){
        return this.moreve;
    }
    
    public void setratetype(int ratetype){
        this.ratetype = ratetype;
    }
    
    public int getratetype(){
        return this.ratetype;
    }
    
    public void setgrno(String grno){
        this.grno = grno;
    }
    
    public String getgrno(){
        return this.grno;
    }
    
    public void setchequeno(String chequeno){
        this.chequeno = chequeno;
    }
    
    public String getchequeno(){
        return this.chequeno;
    }
    
    public void setgrdate(Date grdate){
        this.grdate = grdate;
    }
    
    @Temporal(value = TemporalType.DATE)    
    public Date getgrdate(){
        return this.grdate;
    }
        
    public void setreclock(boolean reclock){
        this.reclock = reclock;
    }
    
    public boolean getreclock(){
        return this.reclock;
    }
    
    public void setgpno(String gpno){
        this.gpno = gpno;
    }
    
    public String getgpno(){
        return this.gpno;
    }
    
    public void setrectimestamp(String rectimestamp){
        this.rectimestamp = rectimestamp;
    }
    
    public String getrectimestamp(){
        return this.rectimestamp;
    }
    
    public void setuser(String user){
        this.user = user;
    }
    
    public String getuser(){
        return this.user;
    }
    
    public double getdemand(){
        return this.demand;
    }
    public void setdemand(double demand){
        this.demand = demand;
    }
    
    private Float closingbal;
    
    public void setclosingbal(Float closingbal){
        this.closingbal = closingbal;
    }
    
    public Float getclosngbal(){
        return this.closingbal;
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this indent.  The result is 
     * <code>true</code> if and only if the argument is not null and is a indent object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof indent)) {
            return false;
        }
        indent other = (indent)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "mktg.persistDatabase.indent[id=" + id + "]";
    }
    
}
