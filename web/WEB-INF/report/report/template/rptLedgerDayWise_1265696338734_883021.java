/*
 * Generated by JasperReports - 2/9/10 11:48 AM
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import net.sf.jasperreports.engine.*;
import java.util.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class rptLedgerDayWise_1265696338734_883021 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_TDT = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_CUSTID = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_FDT = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_SUBREPORT_DIR = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_TODT = null;
    private JRFillParameter parameter_FROMDT = null;
    private JRFillParameter parameter_REPORT_DATE_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_leakage = null;
    private JRFillField field_reclock = null;
    private JRFillField field_rtname = null;
    private JRFillField field_customer = null;
    private JRFillField field_amount = null;
    private JRFillField field_gpno = null;
    private JRFillField field_tcdamt = null;
    private JRFillField field_quantity = null;
    private JRFillField field_paidatbank = null;
    private JRFillField field_cessamt = null;
    private JRFillField field_commi = null;
    private JRFillField field_sf = null;
    private JRFillField field_ratetype = null;
    private JRFillField field_cstamt = null;
    private JRFillField field_subsidy = null;
    private JRFillField field_cess = null;
    private JRFillField field_tax = null;
    private JRFillField field_prodtype = null;
    private JRFillField field_exceamt = null;
    private JRFillField field_cst = null;
    private JRFillField field_entrytype = null;
    private JRFillField field_grdate = null;
    private JRFillField field_moreve = null;
    private JRFillField field_netamount = null;
    private JRFillField field_prodname = null;
    private JRFillField field_returnmilk = null;
    private JRFillField field_cratein = null;
    private JRFillField field_tcd = null;
    private JRFillField field_hl = null;
    private JRFillField field_rectimestamp = null;
    private JRFillField field_id = null;
    private JRFillField field_lessamt = null;
    private JRFillField field_taluka = null;
    private JRFillField field_rate = null;
    private JRFillField field_crateout = null;
    private JRFillField field_custname = null;
    private JRFillField field_custtype = null;
    private JRFillField field_cacr = null;
    private JRFillField field_netqty = null;
    private JRFillField field_commiamt = null;
    private JRFillField field_print = null;
    private JRFillField field_product = null;
    private JRFillField field_idate = null;
    private JRFillField field_saletype = null;
    private JRFillField field_route = null;
    private JRFillField field_taxamt = null;
    private JRFillField field_grno = null;
    private JRFillField field_billno = null;
    private JRFillField field_user = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_date_COUNT = null;
    private JRFillVariable variable_NetAmt = null;
    private JRFillVariable variable_GRTOTAL = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_TDT = (JRFillParameter)pm.get("TDT");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_CUSTID = (JRFillParameter)pm.get("CUSTID");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_FDT = (JRFillParameter)pm.get("FDT");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_SUBREPORT_DIR = (JRFillParameter)pm.get("SUBREPORT_DIR");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_TODT = (JRFillParameter)pm.get("TODT");
        parameter_FROMDT = (JRFillParameter)pm.get("FROMDT");
        parameter_REPORT_DATE_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_DATE_FORMAT_FACTORY");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_leakage = (JRFillField)fm.get("leakage");
        field_reclock = (JRFillField)fm.get("reclock");
        field_rtname = (JRFillField)fm.get("rtname");
        field_customer = (JRFillField)fm.get("customer");
        field_amount = (JRFillField)fm.get("amount");
        field_gpno = (JRFillField)fm.get("gpno");
        field_tcdamt = (JRFillField)fm.get("tcdamt");
        field_quantity = (JRFillField)fm.get("quantity");
        field_paidatbank = (JRFillField)fm.get("paidatbank");
        field_cessamt = (JRFillField)fm.get("cessamt");
        field_commi = (JRFillField)fm.get("commi");
        field_sf = (JRFillField)fm.get("sf");
        field_ratetype = (JRFillField)fm.get("ratetype");
        field_cstamt = (JRFillField)fm.get("cstamt");
        field_subsidy = (JRFillField)fm.get("subsidy");
        field_cess = (JRFillField)fm.get("cess");
        field_tax = (JRFillField)fm.get("tax");
        field_prodtype = (JRFillField)fm.get("prodtype");
        field_exceamt = (JRFillField)fm.get("exceamt");
        field_cst = (JRFillField)fm.get("cst");
        field_entrytype = (JRFillField)fm.get("entrytype");
        field_grdate = (JRFillField)fm.get("grdate");
        field_moreve = (JRFillField)fm.get("moreve");
        field_netamount = (JRFillField)fm.get("netamount");
        field_prodname = (JRFillField)fm.get("prodname");
        field_returnmilk = (JRFillField)fm.get("returnmilk");
        field_cratein = (JRFillField)fm.get("cratein");
        field_tcd = (JRFillField)fm.get("tcd");
        field_hl = (JRFillField)fm.get("hl");
        field_rectimestamp = (JRFillField)fm.get("rectimestamp");
        field_id = (JRFillField)fm.get("id");
        field_lessamt = (JRFillField)fm.get("lessamt");
        field_taluka = (JRFillField)fm.get("taluka");
        field_rate = (JRFillField)fm.get("rate");
        field_crateout = (JRFillField)fm.get("crateout");
        field_custname = (JRFillField)fm.get("custname");
        field_custtype = (JRFillField)fm.get("custtype");
        field_cacr = (JRFillField)fm.get("cacr");
        field_netqty = (JRFillField)fm.get("netqty");
        field_commiamt = (JRFillField)fm.get("commiamt");
        field_print = (JRFillField)fm.get("print");
        field_product = (JRFillField)fm.get("product");
        field_idate = (JRFillField)fm.get("idate");
        field_saletype = (JRFillField)fm.get("saletype");
        field_route = (JRFillField)fm.get("route");
        field_taxamt = (JRFillField)fm.get("taxamt");
        field_grno = (JRFillField)fm.get("grno");
        field_billno = (JRFillField)fm.get("billno");
        field_user = (JRFillField)fm.get("user");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_date_COUNT = (JRFillVariable)vm.get("date_COUNT");
        variable_NetAmt = (JRFillVariable)vm.get("NetAmt");
        variable_GRTOTAL = (JRFillVariable)vm.get("GRTOTAL");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.String)("C:\\Program Files\\mktgReport\\report\\template\\");
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 11 : 
            {
                value = (java.lang.Double)(new Double((((java.math.BigDecimal)field_netamount.getValue()).doubleValue() + ((java.math.BigDecimal)field_taxamt.getValue()).doubleValue()) - 
((java.math.BigDecimal)field_subsidy.getValue()).doubleValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Double)(new Double(((java.math.BigDecimal)field_netamount.getValue()).doubleValue() - ((java.math.BigDecimal)field_taxamt.getValue()).doubleValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.sql.Date)field_idate.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)field_customer.getValue()).longValue()));
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(new String(((java.sql.Date)field_idate.getValue()).toString()));
                break;
            }
            case 16 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_MIlk.jasper");
                break;
            }
            case 18 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)field_customer.getValue()).longValue()));
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(new String(((java.sql.Date)field_idate.getValue()).toString()));
                break;
            }
            case 20 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_Product.jasper");
                break;
            }
            case 22 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_idate.getValue()));
                break;
            }
            case 23 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_NetAmt.getValue()));
                break;
            }
            case 24 : 
            {
                value = (java.lang.String)(((java.lang.String)field_custname.getValue()));
                break;
            }
            case 25 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
                break;
            }
            case 26 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_GRTOTAL.getValue()));
                break;
            }
            case 27 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)parameter_CUSTID.getValue()).longValue()));
                break;
            }
            case 28 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_TDT.getValue()).toString()));
                break;
            }
            case 29 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_TODT.getValue())));
                break;
            }
            case 30 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_FDT.getValue()).toString()));
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_FROMDT.getValue())));
                break;
            }
            case 32 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 33 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_LedAbstract.jasper");
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.String)("C:\\Program Files\\mktgReport\\report\\template\\");
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 11 : 
            {
                value = (java.lang.Double)(new Double((((java.math.BigDecimal)field_netamount.getOldValue()).doubleValue() + ((java.math.BigDecimal)field_taxamt.getOldValue()).doubleValue()) - 
((java.math.BigDecimal)field_subsidy.getOldValue()).doubleValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Double)(new Double(((java.math.BigDecimal)field_netamount.getOldValue()).doubleValue() - ((java.math.BigDecimal)field_taxamt.getOldValue()).doubleValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.sql.Date)field_idate.getOldValue()));
                break;
            }
            case 14 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)field_customer.getOldValue()).longValue()));
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(new String(((java.sql.Date)field_idate.getOldValue()).toString()));
                break;
            }
            case 16 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_MIlk.jasper");
                break;
            }
            case 18 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)field_customer.getOldValue()).longValue()));
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(new String(((java.sql.Date)field_idate.getOldValue()).toString()));
                break;
            }
            case 20 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_Product.jasper");
                break;
            }
            case 22 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_idate.getOldValue()));
                break;
            }
            case 23 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_NetAmt.getOldValue()));
                break;
            }
            case 24 : 
            {
                value = (java.lang.String)(((java.lang.String)field_custname.getOldValue()));
                break;
            }
            case 25 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
                break;
            }
            case 26 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_GRTOTAL.getOldValue()));
                break;
            }
            case 27 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)parameter_CUSTID.getValue()).longValue()));
                break;
            }
            case 28 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_TDT.getValue()).toString()));
                break;
            }
            case 29 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_TODT.getValue())));
                break;
            }
            case 30 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_FDT.getValue()).toString()));
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_FROMDT.getValue())));
                break;
            }
            case 32 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 33 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_LedAbstract.jasper");
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.String)("C:\\Program Files\\mktgReport\\report\\template\\");
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 11 : 
            {
                value = (java.lang.Double)(new Double((((java.math.BigDecimal)field_netamount.getValue()).doubleValue() + ((java.math.BigDecimal)field_taxamt.getValue()).doubleValue()) - 
((java.math.BigDecimal)field_subsidy.getValue()).doubleValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Double)(new Double(((java.math.BigDecimal)field_netamount.getValue()).doubleValue() - ((java.math.BigDecimal)field_taxamt.getValue()).doubleValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.sql.Date)field_idate.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)field_customer.getValue()).longValue()));
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(new String(((java.sql.Date)field_idate.getValue()).toString()));
                break;
            }
            case 16 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_MIlk.jasper");
                break;
            }
            case 18 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)field_customer.getValue()).longValue()));
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(new String(((java.sql.Date)field_idate.getValue()).toString()));
                break;
            }
            case 20 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_Product.jasper");
                break;
            }
            case 22 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_idate.getValue()));
                break;
            }
            case 23 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_NetAmt.getEstimatedValue()));
                break;
            }
            case 24 : 
            {
                value = (java.lang.String)(((java.lang.String)field_custname.getValue()));
                break;
            }
            case 25 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
                break;
            }
            case 26 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_GRTOTAL.getEstimatedValue()));
                break;
            }
            case 27 : 
            {
                value = (java.lang.Object)(new Long(((java.lang.Long)parameter_CUSTID.getValue()).longValue()));
                break;
            }
            case 28 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_TDT.getValue()).toString()));
                break;
            }
            case 29 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_TODT.getValue())));
                break;
            }
            case 30 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_FDT.getValue()).toString()));
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)(new String(((java.lang.String)parameter_FROMDT.getValue())));
                break;
            }
            case 32 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 33 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "rptLedgerDayWise_LedAbstract.jasper");
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
