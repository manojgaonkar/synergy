/*
 * productDBAO.java
 *
 * Created on January 30, 2009, 6:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mktg.persistDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author MD
 */
public class productDBAO {

    /** Creates a new instance of productDBAO */
    private product product;
    private product p;
    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;
    private ArrayList<SelectItem> alProduct;
//    private ArrayList<Object> alState;
    private SelectItem ProductItem;
    private ArrayList<SelectItem> alProductState;
    private SelectItem ProductItemState;
    private boolean blnUpdateBtn = false;
    private boolean blnOk = true;
    private int StateId;
    private int Limit_row;
    private int Size;
    private HashMap<Integer, Integer> hmLayoutNo = new HashMap<Integer, Integer>();

//    private boolean NEXT;   
//    private Password pwd = new Password();
    public productDBAO() {
        blnUpdateBtn = false;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String createSetup() {
        this.product = new product();
//        System.out.println("product_create");
        return "product_create";
    }

    public String createUpdateSetup() {
//        System.out.println("Update Create setup");
        this.product = new product();
//        return "product_Update";
//        if(pwd.chkPasswd())
//            return "success";
//        else
//            return "failure";
        return "password";
    }

    public List getProductList() {
        EntityManager em = getEntityManager();
        alProduct = new ArrayList<SelectItem>();
        List l = em.createQuery("SELECT t FROM product as t ").getResultList();
        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            product prod = (product) itr.next();
            ProductItem = new SelectItem(new Long(prod.getId()), prod.getproduct());
            alProduct.add(ProductItem);
        }
        return alProduct;
    }

    public void setproduct(product product) {
        this.product = product;
    }

    public product getproduct() {
        return this.product;
    }

    public String create() {
        layoutNo();
        EntityManager em = null;
        if (product.getproduct().length() > 0) {
            try {
                for (int i = 0; i < State().size(); i++) {
                    em = getEntityManager();
                    utx.begin();
                    em.joinTransaction();
                    entystate o = (entystate) State().get(i);
                    product.setstateid(o.getId());
                    product.setstatus(true);
                    product.setlayoutno(hmLayoutNo.get(new Integer(o.getId())));
                    em.persist(product);
                    utx.commit();
                }
                clearCompts();
                addSuccessMessage("product was successfully created.");
            } catch (Exception ex) {
                try {
                    addErrorMessage(ex.getLocalizedMessage());
                    utx.rollback();
                } catch (Exception e) {
                    addErrorMessage(e.getLocalizedMessage());
                }
            } finally {
                em.close();
            }
        }
        return "product_add";
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("successInfo", facesMsg);
    }

    private void clearCompts() {
        product.setproduct("");
        product.setrate(0.00);
    }

    private void clearUpdateCompts() {
        product.setrate(0.00);
        product.setcst(0.00);
        product.settax(0.00);
        product.setcess(0.00);
        product.setcommission(0.00);
        product.settcd(0.00);
        product.setsplrate(0.00);
        product.setproduct("");
        product.setutprate(0.00);
        product.setsubsidy(0.00);
    }

    public List getProductItems() {
        EntityManager em = getEntityManager();
        List l = em.createQuery("SELECT object(o)FROM product o " +
                "WHERE o.stateid = :StateId " +
                "ORDER BY o.product").setParameter(new String("StateId"), new Integer(StateId)).setFirstResult(Limit_row).setMaxResults(10).getResultList();
        Size = l.size();
        return l;
    }

    public void init(ActionEvent e) {
        Limit_row = 0;
    }

    public void processNextPageActionEvent(ActionEvent e) {
        Limit_row = Limit_row + 10;
//        System.out.println(" NEXT " + Limit_row );
    }

    public void processPrevPageActionEvent(ActionEvent e) {
        if (Limit_row <= 10) {
            Limit_row = 0;
        } else {
            Limit_row = Limit_row - 10;
//         System.out.println(" PREVIOUS " + Limit_row );
        }
    }

    public void processFirstPageActionEvent(ActionEvent e) {
        Limit_row = 0;
    }

    public void processLastPageActionEvent(ActionEvent e) {
        Limit_row = Limit_row + 10;
    }

    public boolean getNext() {
        if (Size < 10) {
            return false;
        } else {
            return true;
        }
    }

    public boolean getPrevious() {
        if (Limit_row <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void processValueChangeEvent(ValueChangeEvent e) {
        StateId = Integer.parseInt(e.getNewValue().toString());
    }

    private List State() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT Object(o) FROM entystate o ").getResultList();
    }

    public List getProductListState() {
        EntityManager em = getEntityManager();
        alProductState = new ArrayList<SelectItem>();
        List l = em.createQuery("SELECT t FROM product as t " +
                "WHERE t.stateid = :StateId").setParameter(new String("StateId"), new Integer(StateId)).getResultList();
        Iterator itr = l.iterator();
        if (l.size() > 0) {
            blnOk = true;
        } else {
            blnOk = false;
        }
        while (itr.hasNext()) {
            product prod = (product) itr.next();
            ProductItemState = new SelectItem(new Integer(prod.getId()),
                    new String(prod.getproduct()));
            alProductState.add(ProductItemState);
        }
        return alProductState;
    }

    public void setblnOk(boolean blnOk) {
        this.blnOk = blnOk;
    }

    public boolean getblnOk() {
        return this.blnOk;
    }

    public void setblnUpdateBtn(boolean blnUpdateBtn) {
        this.blnUpdateBtn = blnUpdateBtn;
    }

    public boolean getblnUpdateBtn() {
        return this.blnUpdateBtn;
    }

    public void processValueChangeListener(ValueChangeEvent e) {
        if (e.getNewValue() != null) {
            StateId = Integer.parseInt(e.getNewValue().toString());
        }
    }

    public void getRateActionEvent() {
        this.blnUpdateBtn = true;
        p = findProd();
        product.setrate(p.getrate());
        product.settax(p.gettax());
        product.setcst(p.getcst());
        product.setcess(p.getcess());
        product.setcommission(p.getcommission());
        product.settcd(p.gettcd());
        product.setsplrate(p.getsplrate());
        product.setproduct(p.getproduct());
        product.setutprate(p.getutprate());
        product.setsubsidy(p.getsubsidy());
    }

    private product findProd() {
        EntityManager em = getEntityManager();
        try {
            p = em.find(product.class, new Integer(product.getId()));
        } catch (IllegalStateException es) {
        } catch (IllegalArgumentException ea) {
        }
        return p;
    }

    public void processUpdateRateEvent() {
        this.blnUpdateBtn = false;
        EntityManager em = getEntityManager();
        p.setrate(product.getrate());
        p.settax(product.gettax());
        p.setcst(product.getcst());
        p.setcess(product.getcess());
        p.setcommission(product.getcommission());
        p.settcd(product.gettcd());
        p.setproduct(product.getproduct());
        p.setutprate(product.getutprate());
        p.setsubsidy(product.getsubsidy());
        p.setsplrate(product.getsplrate());
        try {
            utx.begin();
            em.joinTransaction();
            em.merge(p);
            //            Query qry = em.createQuery("delete from customer as c");
            //            Query qry = em.createQuery("update customer AS c " +
            //                    "SET c.firstname = 'xxxxxxxxxxxxxxxxxx'");
            //            qry.executeUpdate();
            utx.commit();
            clearUpdateCompts();
            addSuccessMessage("product was successfully updated.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
        } finally {
            em.close();
        }
    }

    public void processInitEvent(ActionEvent ae) {
        this.setblnUpdateBtn(false);
    }

    private void layoutNo() {
        EntityManager em = getEntityManager();
        try {
            Iterator itr = State().iterator();

            while (itr.hasNext()) {
                entystate es = (entystate) itr.next();
                System.out.print(es.getId() + " " + es.getstatename());
                List l = em.createQuery("SELECT t FROM product as t " +
                        "WHERE t.stateid = :StateId " +
                        "ORDER BY t.layoutno DESC ") //.setParameter(new String("StateId"), new Integer(StateId))
                        .setParameter(new String("StateId"), new Integer(es.getId())).setMaxResults(1).getResultList();
                Iterator itr1 = l.iterator();
                product prod = (product) itr1.next();
                hmLayoutNo.put(new Integer(es.getId()), prod.getlayoutno() + 1);
            }
//            Set s = hmLayoutNo.entrySet();
//            itr = s.iterator();                    
//            while(itr.hasNext()){
//                Map.Entry me = (Map.Entry) itr.next();
//                System.out.println(me.getKey() + "  " + me.getValue());
//            }

            em.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
