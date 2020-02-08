/*
 * customer.java
 *
 * Created on January 7, 2009, 4:09 PM
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
 *
 * @author MD
 */


    @Entity
   
    
public class customer implements Serializable {
              
    /** Creates a new instance of customer */
        
        private Long id;
        int custtype;
        
        private String firstname;
//        private String midname;
//        private String lastname;
        
        private String nominee;
        
        private String add1;
        private String add2;        
        private String add3;
        private String add4;
        private String add5;        
        
        private String cacr;
        
        private String phone;
        private String mobile;
        
        private String acno;
        private String panno;        
        private String grno;
        
        private int stateid;
        private int taluka;
        private int route;
        private int bank;
        private int layoutno;
        
        private Date comdate ;
        private Date depodate;
        private Date grdate;
        
        private double deposit;
        private double subsidy;
        
        private boolean bln;
        
        private double ratetype;
        
        private String policyno;
        
        private Float openingbal;
        
        
        public customer() {
        }

    
        @Id  
        public Long getId(){
            return this.id;
        }        
        
        public void setId(Long id){
            this.id = id;
        }      
        
        
        public void setcusttype(int custtype){
            this.custtype = custtype;
        }
        public int getcusttype(){
            return this.custtype;
        }               
            
        
        public void setcacr(String cacr){
            this.cacr = cacr;
        }
        public String getcacr(){
            return this.cacr;
        }
        
        public String getfirstname(){
            return this.firstname;
        }    
        public void setfirstname(String firstname){
            this.firstname = firstname;
        }        
        
//        public String getMidName(){
//            return this.midname;
//        }    
//        public void setMidName(String midname){
//            this.midname = midname;
//        }                
//        
//        public String getLastName(){
//            return this.lastname;
//        }    
//        public void setLastName(String lastname){
//            this.lastname = lastname;
//        } 
        
        
        public void setratetype(double ratetype){
            this.ratetype = ratetype;
        }
                
        public double getratetype(){
            return this.ratetype;
        }
        
        public void setAdd1(String add1){
            this.add1 = add1;
        }
        public String getAdd1(){
            return this.add1;
        }        
                
        public void setAdd2(String add2){
            this.add2 = add2;
        }
        public String getAdd2(){
            return this.add2;
        }               
                
        public void setAdd3(String add3){
            this.add3 = add3;
        }
        public String getAdd3(){
            return this.add3;
        }       
        
        public void setAdd4(String add4){
           this.add4 = add4;
        }
        public String getAdd4(){
            return this.add4;
        }
        
        public void setAdd5(String add5){
           this.add5 = add5;
        }
        public String getAdd5(){
            return this.add5;
        }        
        
                
        public void setPhone(String phone){
            this.phone = phone;
        }
        public String getPhone(){
            return this.phone;
        }               
        
        public void setMobile(String mobile){
            this.mobile = mobile;
        }
        public String getMobile(){
            return this.mobile;
        }                       
                
        public void setPanNo(String panno){
            this.panno = panno;
        }
        public String getPanNo(){
            return this.panno;
        }       
            
        public void setstateid(int stateid){
            this.stateid = stateid;
        }
        public int getstateid(){
            return this.stateid;
        }
        
        public void setTaluka(int taluka){
            this.taluka = taluka;
        }             
        public int getTaluka(){
            return this.taluka;
        }        
                
        public void setRoute(int route){
            this.route = route;
        }             
        public int getRoute(){
            return this.route;
        }               
//        public boolean getStatus(){
//            return this.status;
//        }   
//        public void setStatus(boolean status){
//            this.status = status;
//        }        
    
        public void setAcNo(String acno){
            this.acno = acno;
        }
        
        public String getAcNo(){
            return this.acno;
        }
        
        public void setDeposit(double deposit){
            this.deposit = deposit;
        }
        
        public double getDeposit(){
            return this.deposit;
        }
        
        public void setsubsidy(double subsidy){
            this.subsidy = subsidy;
        }
        
        public double getsubsidy(){
            return this.subsidy;
        }
        
    @Temporal(value = TemporalType.DATE)
        public Date getComdate(){
            return this.comdate;
        }        

        public void setComdate(Date comdate){
            this.comdate = comdate;
        }
                      
    @Temporal(value = TemporalType.DATE)        
        public Date getDepodate(){
            return this.depodate;
        }
    
        public void setDepodate(Date depodate){
            this.depodate = depodate;
        }    
        
        public void setNominee(String nominee){
            this.nominee = nominee;
        }
        
        public String getNominee(){
            return this.nominee;
        }
            
        public void setGrNo(String grno){
            this.grno = grno;
        }
        
        public String getGrNo(){
            return this.grno;
        }
        
        public void setGrDate(Date grdate){
            this.grdate = grdate;
        }
        
        @Temporal(value = TemporalType.DATE)
        public Date getGrDate(){
            return this.grdate;
        } 
        
        public void setBank(int bank){
            this.bank = bank;
        }
        
        public int getBank(){
            return this.bank;
        }
                
        public void setbln(boolean bln){
            this.bln = bln;
        }
        
        public boolean getbln(){
            return this.bln;
        }
        
        public void setlayoutno(int layoutno){
            this.layoutno = layoutno;
        }
        
        public int getlayoutno(){
            return this.layoutno;
        }
        
        public String getpolicyno(){
            return this.policyno;
        }
        public void setpolicyno(String policyno){
            this.policyno = policyno;
        }
        
        public Float getopeningbal(){
            return this.openingbal;
        }
        public void setopeningbal(Float openingbal){
            this.openingbal = openingbal;
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
     * Determines whether another object is equal to this customer.  The result is 
     * <code>true</code> if and only if the argument is not null and is a customer object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof customer)) {
            return false;
        }
        customer other = (customer)object;
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
        return "per.customer[id=" + id + "]";
    }        
    }