package com.yyy.huojiapda.Bill;

import java.util.List;

public class BillInfo {
    private List<ReportConditionBean> ReportCondition;
    private List<ReportInfoBean> ReportInfo;
    private List<ReportColumnsBean> ReportColumns;
    private List<ReportColumns2> ReportColumns2;

    public List<ReportConditionBean> getReportCondition() {
        return ReportCondition;
    }

    public void setReportCondition(List<ReportConditionBean> ReportCondition) {
        this.ReportCondition = ReportCondition;
    }

    public List<ReportInfoBean> getReportInfo() {
        return ReportInfo;
    }

    public void setReportInfo(List<ReportInfoBean> ReportInfo) {
        this.ReportInfo = ReportInfo;
    }

    public List<ReportColumnsBean> getReportColumns() {
        return ReportColumns;
    }

    public void setReportColumns(List<ReportColumnsBean> ReportColumns) {
        this.ReportColumns = ReportColumns;
    }

    public List<ReportColumns2> getReportColumns2() {
        return ReportColumns2;
    }

    public void setReportColumns2(List<ReportColumns2> ReportColumns2) {
        this.ReportColumns2 = ReportColumns2;
    }

    public static class ReportConditionBean {
        /**
         * iSerial : 1
         * sFieldName : dDate
         * sCaption : 日期
         * sFieldType : D
         * sLookUpName :
         * sLookUpFilters :
         * sOpTion : >=
         * sValue : CurrentDate-30
         */

        private int iSerial;
        private String sFieldName;
        private String sCaption;
        private String sFieldType;
        private String sLookUpName;
        private String sLookUpFilters;
        private String sOpTion;
        private String sValue;

        public int getISerial() {
            return iSerial;
        }

        public void setISerial(int iSerial) {
            this.iSerial = iSerial;
        }

        public String getSFieldName() {
            return sFieldName;
        }

        public void setSFieldName(String sFieldName) {
            this.sFieldName = sFieldName;
        }

        public String getSCaption() {
            return sCaption;
        }

        public void setSCaption(String sCaption) {
            this.sCaption = sCaption;
        }

        public String getSFieldType() {
            return sFieldType;
        }

        public void setSFieldType(String sFieldType) {
            this.sFieldType = sFieldType;
        }

        public String getSLookUpName() {
            return sLookUpName;
        }

        public void setSLookUpName(String sLookUpName) {
            this.sLookUpName = sLookUpName;
        }

        public String getSLookUpFilters() {
            return sLookUpFilters;
        }

        public void setSLookUpFilters(String sLookUpFilters) {
            this.sLookUpFilters = sLookUpFilters;
        }

        public String getSOpTion() {
            return sOpTion;
        }

        public void setSOpTion(String sOpTion) {
            this.sOpTion = sOpTion;
        }

        public String getSValue() {
            return sValue;
        }

        public void setSValue(String sValue) {
            this.sValue = sValue;
        }
    }

    public static class ReportInfoBean {
        /**
         * sBillType : 物料入库单
         * sFieldKey : iRecNo
         * sDeitailFieldKey : iRecNo
         * pPageCount : 30
         * iStore : 0
         * iChildStore : 0
         * iHaveChild : 1
         * sLinkField : iRecNo=iMainRecNo
         * sAppStyle : 制单
         * iRowAlternation : 0
         * sAppFilters1 :
         * sAppFilters2 :
         * sAppFilters3 :
         * sAppFilters4 :
         * sAppFiltersName1 :
         * sAppFiltersName2 :
         * sAppFiltersName3 :
         * sAppFiltersName4 :
         * sChartType :
         * sSerialField :
         * sXAxisField :
         * sYAxisField :
         * sXAxisLabelFormatterSimple :
         * sYAxisLabelFormatterSimple :
         * iChildShowChart : 0
         * sChildChartType :
         * sChildXAxisField :
         * sChildYAxisField :
         * sChildSerialField :
         * sChildXAxisLabelFormatterSimple :
         * sChildYAxisLabelFormatterSimple :
         */

        private String sBillType;
        private String sFieldKey;
        private String sDeitailFieldKey;
        private int pPageCount;
        private int iStore;
        private int iChildStore;
        private int iHaveChild;
        private String sLinkField;
        private String sAppStyle;
        private int iRowAlternation;
        private String sAppFilters1;
        private String sAppFilters2;
        private String sAppFilters3;
        private String sAppFilters4;
        private String sAppFiltersName1;
        private String sAppFiltersName2;
        private String sAppFiltersName3;
        private String sAppFiltersName4;
        private String sChartType;
        private String sSerialField;
        private String sXAxisField;
        private String sYAxisField;
        private String sXAxisLabelFormatterSimple;
        private String sYAxisLabelFormatterSimple;
        private int iChildShowChart;
        private String sChildChartType;
        private String sChildXAxisField;
        private String sChildYAxisField;
        private String sChildSerialField;
        private String sChildXAxisLabelFormatterSimple;
        private String sChildYAxisLabelFormatterSimple;

        public String getSBillType() {
            return sBillType;
        }

        public void setSBillType(String sBillType) {
            this.sBillType = sBillType;
        }

        public String getSFieldKey() {
            return sFieldKey;
        }

        public void setSFieldKey(String sFieldKey) {
            this.sFieldKey = sFieldKey;
        }

        public String getSDeitailFieldKey() {
            return sDeitailFieldKey;
        }

        public void setSDeitailFieldKey(String sDeitailFieldKey) {
            this.sDeitailFieldKey = sDeitailFieldKey;
        }

        public int getPPageCount() {
            return pPageCount;
        }

        public void setPPageCount(int pPageCount) {
            this.pPageCount = pPageCount;
        }

        public int getIStore() {
            return iStore;
        }

        public void setIStore(int iStore) {
            this.iStore = iStore;
        }

        public int getIChildStore() {
            return iChildStore;
        }

        public void setIChildStore(int iChildStore) {
            this.iChildStore = iChildStore;
        }

        public int getIHaveChild() {
            return iHaveChild;
        }

        public void setIHaveChild(int iHaveChild) {
            this.iHaveChild = iHaveChild;
        }

        public String getSLinkField() {
            return sLinkField;
        }

        public void setSLinkField(String sLinkField) {
            this.sLinkField = sLinkField;
        }

        public String getSAppStyle() {
            return sAppStyle;
        }

        public void setSAppStyle(String sAppStyle) {
            this.sAppStyle = sAppStyle;
        }

        public int getIRowAlternation() {
            return iRowAlternation;
        }

        public void setIRowAlternation(int iRowAlternation) {
            this.iRowAlternation = iRowAlternation;
        }

        public String getSAppFilters1() {
            return sAppFilters1;
        }

        public void setSAppFilters1(String sAppFilters1) {
            this.sAppFilters1 = sAppFilters1;
        }

        public String getSAppFilters2() {
            return sAppFilters2;
        }

        public void setSAppFilters2(String sAppFilters2) {
            this.sAppFilters2 = sAppFilters2;
        }

        public String getSAppFilters3() {
            return sAppFilters3;
        }

        public void setSAppFilters3(String sAppFilters3) {
            this.sAppFilters3 = sAppFilters3;
        }

        public String getSAppFilters4() {
            return sAppFilters4;
        }

        public void setSAppFilters4(String sAppFilters4) {
            this.sAppFilters4 = sAppFilters4;
        }

        public String getSAppFiltersName1() {
            return sAppFiltersName1;
        }

        public void setSAppFiltersName1(String sAppFiltersName1) {
            this.sAppFiltersName1 = sAppFiltersName1;
        }

        public String getSAppFiltersName2() {
            return sAppFiltersName2;
        }

        public void setSAppFiltersName2(String sAppFiltersName2) {
            this.sAppFiltersName2 = sAppFiltersName2;
        }

        public String getSAppFiltersName3() {
            return sAppFiltersName3;
        }

        public void setSAppFiltersName3(String sAppFiltersName3) {
            this.sAppFiltersName3 = sAppFiltersName3;
        }

        public String getSAppFiltersName4() {
            return sAppFiltersName4;
        }

        public void setSAppFiltersName4(String sAppFiltersName4) {
            this.sAppFiltersName4 = sAppFiltersName4;
        }

        public String getSChartType() {
            return sChartType;
        }

        public void setSChartType(String sChartType) {
            this.sChartType = sChartType;
        }

        public String getSSerialField() {
            return sSerialField;
        }

        public void setSSerialField(String sSerialField) {
            this.sSerialField = sSerialField;
        }

        public String getSXAxisField() {
            return sXAxisField;
        }

        public void setSXAxisField(String sXAxisField) {
            this.sXAxisField = sXAxisField;
        }

        public String getSYAxisField() {
            return sYAxisField;
        }

        public void setSYAxisField(String sYAxisField) {
            this.sYAxisField = sYAxisField;
        }

        public String getSXAxisLabelFormatterSimple() {
            return sXAxisLabelFormatterSimple;
        }

        public void setSXAxisLabelFormatterSimple(String sXAxisLabelFormatterSimple) {
            this.sXAxisLabelFormatterSimple = sXAxisLabelFormatterSimple;
        }

        public String getSYAxisLabelFormatterSimple() {
            return sYAxisLabelFormatterSimple;
        }

        public void setSYAxisLabelFormatterSimple(String sYAxisLabelFormatterSimple) {
            this.sYAxisLabelFormatterSimple = sYAxisLabelFormatterSimple;
        }

        public int getIChildShowChart() {
            return iChildShowChart;
        }

        public void setIChildShowChart(int iChildShowChart) {
            this.iChildShowChart = iChildShowChart;
        }

        public String getSChildChartType() {
            return sChildChartType;
        }

        public void setSChildChartType(String sChildChartType) {
            this.sChildChartType = sChildChartType;
        }

        public String getSChildXAxisField() {
            return sChildXAxisField;
        }

        public void setSChildXAxisField(String sChildXAxisField) {
            this.sChildXAxisField = sChildXAxisField;
        }

        public String getSChildYAxisField() {
            return sChildYAxisField;
        }

        public void setSChildYAxisField(String sChildYAxisField) {
            this.sChildYAxisField = sChildYAxisField;
        }

        public String getSChildSerialField() {
            return sChildSerialField;
        }

        public void setSChildSerialField(String sChildSerialField) {
            this.sChildSerialField = sChildSerialField;
        }

        public String getSChildXAxisLabelFormatterSimple() {
            return sChildXAxisLabelFormatterSimple;
        }

        public void setSChildXAxisLabelFormatterSimple(String sChildXAxisLabelFormatterSimple) {
            this.sChildXAxisLabelFormatterSimple = sChildXAxisLabelFormatterSimple;
        }

        public String getSChildYAxisLabelFormatterSimple() {
            return sChildYAxisLabelFormatterSimple;
        }

        public void setSChildYAxisLabelFormatterSimple(String sChildYAxisLabelFormatterSimple) {
            this.sChildYAxisLabelFormatterSimple = sChildYAxisLabelFormatterSimple;
        }
    }

    public static class ReportColumnsBean {
        /**
         * iShowOrder : 13
         * sFieldsName : iSerial
         * sFieldsdisplayName : 序号
         * sFieldsType : string
         * iWidth : 1
         * iMerge : 0
         * sAlign : left
         * iSort : 0
         * ifix : 0
         * isChild : true
         */

        private int iShowOrder;
        private String sFieldsName;
        private String sFieldsdisplayName;
        private String sFieldsType;
        private int iWidth;
        private int iMerge;
        private String sAlign;
        private int iSort;
        private int ifix;
        private boolean isChild;

        public int getIShowOrder() {
            return iShowOrder;
        }

        public void setIShowOrder(int iShowOrder) {
            this.iShowOrder = iShowOrder;
        }

        public String getSFieldsName() {
            return sFieldsName;
        }

        public void setSFieldsName(String sFieldsName) {
            this.sFieldsName = sFieldsName;
        }

        public String getSFieldsdisplayName() {
            return sFieldsdisplayName;
        }

        public void setSFieldsdisplayName(String sFieldsdisplayName) {
            this.sFieldsdisplayName = sFieldsdisplayName;
        }

        public String getSFieldsType() {
            return sFieldsType;
        }

        public void setSFieldsType(String sFieldsType) {
            this.sFieldsType = sFieldsType;
        }

        public int getIWidth() {
            return iWidth;
        }

        public void setIWidth(int iWidth) {
            this.iWidth = iWidth;
        }

        public int getIMerge() {
            return iMerge;
        }

        public void setIMerge(int iMerge) {
            this.iMerge = iMerge;
        }

        public String getSAlign() {
            return sAlign;
        }

        public void setSAlign(String sAlign) {
            this.sAlign = sAlign;
        }

        public int getISort() {
            return iSort;
        }

        public void setISort(int iSort) {
            this.iSort = iSort;
        }

        public int getIfix() {
            return ifix;
        }

        public void setIfix(int ifix) {
            this.ifix = ifix;
        }

        public boolean isIsChild() {
            return isChild;
        }

        public void setIsChild(boolean isChild) {
            this.isChild = isChild;
        }
    }

    public static class ReportColumns2 {
        /**
         * iSerial : 1
         * iColumnNum : 1
         * sFieldsName : sStatusName
         * sFieldsDisplayName : 状态
         * sFieldsType : string
         * sNameFontColor :
         * sNameFontSize :
         * iNameFontBold : 0
         * sValueFontColor :
         * sValueFontSize :
         * iValueFontBold : 0
         * iProportio : 30
         * iDetail : 0
         */

        private int iSerial;
        private int iColumnNum;
        private String sFieldsName;
        private String sFieldsDisplayName;
        private String sFieldsType;
        private String sNameFontColor;
        private String sNameFontSize;
        private int iNameFontBold;
        private String sValueFontColor;
        private String sValueFontSize;
        private int iValueFontBold;
        private int iProportio;
        private int iDetail;

        public int getISerial() {
            return iSerial;
        }

        public void setISerial(int iSerial) {
            this.iSerial = iSerial;
        }

        public int getIColumnNum() {
            return iColumnNum;
        }

        public void setIColumnNum(int iColumnNum) {
            this.iColumnNum = iColumnNum;
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
            return sFieldsType;
        }

        public void setSFieldsType(String sFieldsType) {
            this.sFieldsType = sFieldsType;
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

        public int getIDetail() {
            return iDetail;
        }

        public void setIDetail(int iDetail) {
            this.iDetail = iDetail;
        }
    }
}

