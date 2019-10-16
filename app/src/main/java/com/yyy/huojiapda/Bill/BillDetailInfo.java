package com.yyy.huojiapda.Bill;

import com.yyy.pda.util.StringUtil;

import java.util.List;

public class BillDetailInfo {

    /**
     * success : true
     * message :
     * info : {"formColumns":[{"iRowNum":1,"iColumnNum":1,"iDetail":0,"sFieldsName":"sBillNo","sFieldsDisplayName":"入库单号","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":1,"iColumnNum":2,"iDetail":0,"sFieldsName":"dDate","sFieldsDisplayName":"入库日期","sFieldsType":"date","iDigit":0,"sDefaultValue":"CurrentDate","iRequired":1,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":2,"iColumnNum":1,"iDetail":0,"sFieldsName":"iBscDataStockMRecNo","sFieldsDisplayName":"入库仓库","sFieldsType":"int","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":2,"iColumnNum":2,"iDetail":0,"sFieldsName":"iBscDataCustomerRecNo","sFieldsDisplayName":"供应商","sFieldsType":"int","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":3,"iColumnNum":1,"iDetail":0,"sFieldsName":"fPortCharges","sFieldsDisplayName":"港口费用","sFieldsType":"decimal","iDigit":2,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":3,"iColumnNum":2,"iDetail":0,"sFieldsName":"fFreightCharges","sFieldsDisplayName":"运费","sFieldsType":"decimal","iDigit":2,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":4,"iColumnNum":1,"iDetail":0,"sFieldsName":"sReMark","sFieldsDisplayName":"备注","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":0},{"iRowNum":4,"iColumnNum":2,"iDetail":0,"sFieldsName":"sUserID","sFieldsDisplayName":"","sFieldsType":"int","iDigit":0,"sDefaultValue":"UserID","iRequired":0,"iHide":1,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":0},{"iRowNum":4,"iColumnNum":3,"iDetail":0,"sFieldsName":"dInputDate","sFieldsDisplayName":"","sFieldsType":"int","iDigit":0,"sDefaultValue":"CurrentDateTime","iRequired":0,"iHide":1,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":0},{"iRowNum":5,"iColumnNum":1,"iDetail":0,"sFieldsName":"sBarCode","sFieldsDisplayName":"条码","sFieldsType":"","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":1,"iBarcodeScan":1,"sBarcodeScanSQL":"exec SpBarcodeScanMMStockIn '{sBarcCode}',{iBscDataCustomerRecNo},{iRed}","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":0},{"iRowNum":5,"iColumnNum":1,"iDetail":1,"sFieldsName":"iSerial","sFieldsDisplayName":"序号","sFieldsType":"int","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":1,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":30},{"iRowNum":5,"iColumnNum":2,"iDetail":1,"sFieldsName":"sBerChID","sFieldsDisplayName":"仓位","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":70},{"iRowNum":5,"iColumnNum":3,"iDetail":1,"sFieldsName":"iBscDataStockDRecNo","sFieldsDisplayName":"","sFieldsType":"int","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":0,"iAutoAdd":1,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":0},{"iRowNum":6,"iColumnNum":1,"iDetail":1,"sFieldsName":"sCode","sFieldsDisplayName":"物料编码","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":6,"iColumnNum":2,"iDetail":1,"sFieldsName":"sName","sFieldsDisplayName":"物料名称","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":6,"iColumnNum":3,"iDetail":1,"sFieldsName":"iBscDataMatRecNo","sFieldsDisplayName":"","sFieldsType":"","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":1,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":0},{"iRowNum":7,"iColumnNum":1,"iDetail":1,"sFieldsName":"sElements","sFieldsDisplayName":"规格","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":7,"iColumnNum":2,"iDetail":1,"sFieldsName":"sUnitName","sFieldsDisplayName":"单位","sFieldsType":"","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":8,"iColumnNum":1,"iDetail":1,"sFieldsName":"fQty","sFieldsDisplayName":"入库数量","sFieldsType":"decimal","iDigit":2,"sDefaultValue":"","iRequired":1,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":8,"iColumnNum":2,"iDetail":1,"sFieldsName":"fPrice","sFieldsDisplayName":"单价","sFieldsType":"decimal","iDigit":2,"sDefaultValue":"","iRequired":1,"iHide":0,"iReadOnly":0,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":9,"iColumnNum":1,"iDetail":1,"sFieldsName":"sPurOrderNo","sFieldsDisplayName":"采购单号","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50},{"iRowNum":9,"iColumnNum":2,"iDetail":1,"sFieldsName":"sBatchNo","sFieldsDisplayName":"钢卷号","sFieldsType":"string","iDigit":0,"sDefaultValue":"","iRequired":0,"iHide":0,"iReadOnly":1,"iAutoAdd":0,"iNoSave":0,"iBarcodeScan":0,"sBarcodeScanSQL":"","sNameFontColor":"","sNameFontSize":"","iNameFontBold":0,"sValueFontColor":"","sValueFontSize":"","iValueFontBold":0,"iProportio":50}],"mainLookup":[{"sFieldName":"iBscDataStockMRecNo","sLookUpName":"sStockSelect","sFixFilters":"sMatClass<'09'","iPageSize":20,"iMenuID":0,"iSerial":1,"sType":"lookUp","sCondition":"","sMatchFields":"iBerCh=iBerCh,iPurOrder=iPurOrder,sMatClass=sMatClass","sChangeFilters":"","sTextID":"","sValueID":"","sEditMatchFields":"#iBerCh#=#iBerCh#,#iPurOrder#=#iPurOrder#,#sMatClass#=#sMatClass#"},{"sFieldName":"iBscDataCustomerRecNo","sLookUpName":"SupplierSelect","sFixFilters":"","iPageSize":20,"iMenuID":0,"iSerial":3,"sType":"lookUp","sCondition":"","sMatchFields":"","sChangeFilters":"(sCustID like '%{this}%' or sCustShortName like '%{this}%')","sTextID":"","sValueID":"","sEditMatchFields":""},{"sFieldName":"sTypeName","sLookUpName":"bscDataListD1","sFixFilters":"sClassID='storeIntype'","iPageSize":20,"iMenuID":0,"iSerial":4,"sType":"lookUp","sCondition":"","sMatchFields":"","sChangeFilters":"","sTextID":"","sValueID":"","sEditMatchFields":null},{"sFieldName":"sBscDataPersonID","sLookUpName":"bscDataperson2","sFixFilters":"charindex('原料入库',isnull(sJobRole ,''))>=1 and iState='01'","iPageSize":20,"iMenuID":0,"iSerial":5,"sType":"lookUp","sCondition":null,"sMatchFields":"","sChangeFilters":"","sTextID":"","sValueID":"","sEditMatchFields":null},{"sFieldName":"sUserID","sLookUpName":"bscDataPerson1","sFixFilters":"","iPageSize":20,"iMenuID":0,"iSerial":7,"sType":"lookUp","sCondition":"","sMatchFields":"","sChangeFilters":"","sTextID":"","sValueID":"","sEditMatchFields":""}],"childLookup":[{"sTableName":"MMStockInD","sFieldName":"sBerChID","sLookUpName":"BscDataStockDSelect","sFixFilters":"iMainRecNo='#m.iBscDataStockMRecNo#'","iPageSize":20,"sMatchFields":"iBscDataStockDRecNo=iRecNo,sBerChID=sBerChID,iBscDataStockDRecNo=sBerChID,sBerChID=iRecNo"}]}
     * key : 262
     */

    private boolean success;
    private String message;
    private Info info;
    private int key;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static class Info {
        private List<FormColumns> formColumns;
        private List<MainLookup> mainLookup;
        private List<ChildLookup> childLookup;

        public List<FormColumns> getFormColumns() {
            return formColumns;
        }

        public void setFormColumns(List<FormColumns> formColumns) {
            this.formColumns = formColumns;
        }

        public List<MainLookup> getMainLookup() {
            return mainLookup;
        }

        public void setMainLookup(List<MainLookup> mainLookup) {
            this.mainLookup = mainLookup;
        }

        public List<ChildLookup> getChildLookup() {
            return childLookup;
        }

        public void setChildLookup(List<ChildLookup> childLookup) {
            this.childLookup = childLookup;
        }

        public static class FormColumns {
            /**
             * iRowNum : 1
             * iColumnNum : 1
             * iDetail : 0
             * sFieldsName : sBillNo
             * sFieldsDisplayName : 入库单号
             * sFieldsType : string
             * iDigit : 0
             * sDefaultValue :
             * iRequired : 0
             * iHide : 0
             * iReadOnly : 1
             * iAutoAdd : 0
             * iNoSave : 0
             * iBarcodeScan : 0
             * sBarcodeScanSQL :
             * sNameFontColor :
             * sNameFontSize :
             * iNameFontBold : 0
             * sValueFontColor :
             * sValueFontSize :
             * iValueFontBold : 0
             * iProportio : 50
             */

            private int iRowNum;
            private int iColumnNum;
            private int iDetail;
            private String sFieldsName;
            private String sFieldsDisplayName;
            private String sFieldsType;
            private int iDigit;
            private String sDefaultValue;
            private int iRequired;
            private int iHide;
            private int iReadOnly;
            private int iAutoAdd;
            private int iNoSave;
            private int iBarcodeScan;
            private String sBarcodeScanSQL;
            private String sNameFontColor;
            private String sNameFontSize;
            private int iNameFontBold;
            private String sValueFontColor;
            private String sValueFontSize;
            private int iValueFontBold;
            private int iProportio;

            public String getLookup() {
                return lookup;
            }

            public void setLookup(String lookup) {
                this.lookup = lookup;
            }

            private String lookup;

            public int getIRowNum() {
                return iRowNum;
            }

            public void setIRowNum(int iRowNum) {
                this.iRowNum = iRowNum;
            }

            public int getIColumnNum() {
                return iColumnNum;
            }

            public void setIColumnNum(int iColumnNum) {
                this.iColumnNum = iColumnNum;
            }

            public int getIDetail() {
                return iDetail;
            }

            public void setIDetail(int iDetail) {
                this.iDetail = iDetail;
            }

            public String getSFieldsName() {
                return sFieldsName;
            }

            public void setSFieldsName(String sFieldsName) {
                this.sFieldsName = sFieldsName;
            }

            public String getSFieldsDisplayName() {
                return sFieldsDisplayName;
            }

            public void setSFieldsDisplayName(String sFieldsDisplayName) {
                this.sFieldsDisplayName = sFieldsDisplayName;
            }

            public String getSFieldsType() {
                if (sFieldsType.toLowerCase().equals("decimal") && iDigit == 0) {
                    return "int";
                }
                return sFieldsType;
            }

            public void setSFieldsType(String sFieldsType) {
                this.sFieldsType = sFieldsType;
            }

            public int getIDigit() {
                return iDigit;
            }

            public void setIDigit(int iDigit) {
                this.iDigit = iDigit;
            }

            public String getSDefaultValue() {
                return sDefaultValue;
            }

            public void setSDefaultValue(String sDefaultValue) {
                this.sDefaultValue = sDefaultValue;
            }

            public int getIRequired() {
                return iRequired;
            }

            public void setIRequired(int iRequired) {
                this.iRequired = iRequired;
            }

            public int getIHide() {
                return iHide;
            }

            public void setIHide(int iHide) {
                this.iHide = iHide;
            }

            public int getIReadOnly() {
                if (StringUtil.isNotEmpty(lookup))
                    return 1;
                else
                    return iReadOnly;
            }

            public void setIReadOnly(int iReadOnly) {
                this.iReadOnly = iReadOnly;
            }

            public int getIAutoAdd() {
                return iAutoAdd;
            }

            public void setIAutoAdd(int iAutoAdd) {
                this.iAutoAdd = iAutoAdd;
            }

            public int getINoSave() {
                return iNoSave;
            }

            public void setINoSave(int iNoSave) {
                this.iNoSave = iNoSave;
            }

            public int getIBarcodeScan() {
                return iBarcodeScan;
            }

            public void setIBarcodeScan(int iBarcodeScan) {
                this.iBarcodeScan = iBarcodeScan;
            }

            public String getSBarcodeScanSQL() {
                return sBarcodeScanSQL;
            }

            public void setSBarcodeScanSQL(String sBarcodeScanSQL) {
                this.sBarcodeScanSQL = sBarcodeScanSQL;
            }

            public String getSNameFontColor() {
                return sNameFontColor;
            }

            public void setSNameFontColor(String sNameFontColor) {
                this.sNameFontColor = sNameFontColor;
            }

            public String getSNameFontSize() {
                return sNameFontSize;
            }

            public void setSNameFontSize(String sNameFontSize) {
                this.sNameFontSize = sNameFontSize;
            }

            public int getINameFontBold() {
                return iNameFontBold;
            }

            public void setINameFontBold(int iNameFontBold) {
                this.iNameFontBold = iNameFontBold;
            }

            public String getSValueFontColor() {
                return sValueFontColor;
            }

            public void setSValueFontColor(String sValueFontColor) {
                this.sValueFontColor = sValueFontColor;
            }

            public String getSValueFontSize() {
                return sValueFontSize;
            }

            public void setSValueFontSize(String sValueFontSize) {
                this.sValueFontSize = sValueFontSize;
            }

            public int getIValueFontBold() {
                return iValueFontBold;
            }

            public void setIValueFontBold(int iValueFontBold) {
                this.iValueFontBold = iValueFontBold;
            }

            public int getIProportio() {
                return iProportio;
            }

            public void setIProportio(int iProportio) {
                this.iProportio = iProportio;
            }

            public float getPercent() {
                return iProportio / 100;
            }
        }

        public static class MainLookup {
            /**
             * sFieldName : iBscDataStockMRecNo
             * sLookUpName : sStockSelect
             * sFixFilters : sMatClass<'09'
             * iPageSize : 20
             * iMenuID : 0
             * iSerial : 1
             * sType : lookUp
             * sCondition :
             * sMatchFields : iBerCh=iBerCh,iPurOrder=iPurOrder,sMatClass=sMatClass
             * sChangeFilters :
             * sTextID :
             * sValueID :
             * sEditMatchFields : #iBerCh#=#iBerCh#,#iPurOrder#=#iPurOrder#,#sMatClass#=#sMatClass#
             */

            private String sFieldName;
            private String sLookUpName;
            private String sFixFilters;
            private int iPageSize;
            private int iMenuID;
            private int iSerial;
            private String sType;
            private String sCondition;
            private String sMatchFields;
            private String sChangeFilters;
            private String sTextID;
            private String sValueID;
            private String sEditMatchFields;

            public String getSFieldName() {
                return sFieldName;
            }

            public void setSFieldName(String sFieldName) {
                this.sFieldName = sFieldName;
            }

            public String getSLookUpName() {
                return sLookUpName;
            }

            public void setSLookUpName(String sLookUpName) {
                this.sLookUpName = sLookUpName;
            }

            public String getSFixFilters() {
                return sFixFilters;
            }

            public void setSFixFilters(String sFixFilters) {
                this.sFixFilters = sFixFilters;
            }

            public int getIPageSize() {
                return iPageSize;
            }

            public void setIPageSize(int iPageSize) {
                this.iPageSize = iPageSize;
            }

            public int getIMenuID() {
                return iMenuID;
            }

            public void setIMenuID(int iMenuID) {
                this.iMenuID = iMenuID;
            }

            public int getISerial() {
                return iSerial;
            }

            public void setISerial(int iSerial) {
                this.iSerial = iSerial;
            }

            public String getSType() {
                return sType;
            }

            public void setSType(String sType) {
                this.sType = sType;
            }

            public String getSCondition() {
                return sCondition;
            }

            public void setSCondition(String sCondition) {
                this.sCondition = sCondition;
            }

            public String getSMatchFields() {
                return sMatchFields;
            }

            public void setSMatchFields(String sMatchFields) {
                this.sMatchFields = sMatchFields;
            }

            public String getSChangeFilters() {
                return sChangeFilters;
            }

            public void setSChangeFilters(String sChangeFilters) {
                this.sChangeFilters = sChangeFilters;
            }

            public String getSTextID() {
                return sTextID;
            }

            public void setSTextID(String sTextID) {
                this.sTextID = sTextID;
            }

            public String getSValueID() {
                return sValueID;
            }

            public void setSValueID(String sValueID) {
                this.sValueID = sValueID;
            }

            public String getSEditMatchFields() {
                return sEditMatchFields;
            }

            public void setSEditMatchFields(String sEditMatchFields) {
                this.sEditMatchFields = sEditMatchFields;
            }
        }

        public static class ChildLookup {
            /**
             * sTableName : MMStockInD
             * sFieldName : sBerChID
             * sLookUpName : BscDataStockDSelect
             * sFixFilters : iMainRecNo='#m.iBscDataStockMRecNo#'
             * iPageSize : 20
             * sMatchFields : iBscDataStockDRecNo=iRecNo,sBerChID=sBerChID,iBscDataStockDRecNo=sBerChID,sBerChID=iRecNo
             */

            private String sTableName;
            private String sFieldName;
            private String sLookUpName;
            private String sFixFilters;
            private int iPageSize;
            private String sMatchFields;

            public String getSTableName() {
                return sTableName;
            }

            public void setSTableName(String sTableName) {
                this.sTableName = sTableName;
            }

            public String getSFieldName() {
                return sFieldName;
            }

            public void setSFieldName(String sFieldName) {
                this.sFieldName = sFieldName;
            }

            public String getSLookUpName() {
                return sLookUpName;
            }

            public void setSLookUpName(String sLookUpName) {
                this.sLookUpName = sLookUpName;
            }

            public String getSFixFilters() {
                return sFixFilters;
            }

            public void setSFixFilters(String sFixFilters) {
                this.sFixFilters = sFixFilters;
            }

            public int getIPageSize() {
                return iPageSize;
            }

            public void setIPageSize(int iPageSize) {
                this.iPageSize = iPageSize;
            }

            public String getSMatchFields() {
                return sMatchFields;
            }

            public void setSMatchFields(String sMatchFields) {
                this.sMatchFields = sMatchFields;
            }
        }
    }
}
