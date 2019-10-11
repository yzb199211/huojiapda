package com.yyy.huojiapda.main;

import com.yyy.huojiapda.R;
import com.yyy.pda.util.FontUtil;
import com.yyy.pda.util.StringUtil;

import java.util.List;

public class MainMenu {

    /**
     * success : true
     * message :
     * menus : [{"iMenuID":"285","sMenuName":"PDA","sIcon":"","ChildMenus":[{"iMenuID":286,"sMenuName":"采购入库单","iSerial":1,"iFormID":100000301,"sIcon":"","sAppStyle":"制单","iShowChart":0,"iIsUnion":0,"iPageGetData":0}]}]
     */

    private boolean success;
    private String message;
    private List<MenusBean> menus;

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

    public List<MenusBean> getMenus() {
        return menus;
    }

    public void setMenus(List<MenusBean> menus) {
        this.menus = menus;
    }

    public static class MenusBean {
        /**
         * iMenuID : 285
         * sMenuName : PDA
         * sIcon :
         * ChildMenus : [{"iMenuID":286,"sMenuName":"采购入库单","iSerial":1,"iFormID":100000301,"sIcon":"","sAppStyle":"制单","iShowChart":0,"iIsUnion":0,"iPageGetData":0}]
         */

        private String iMenuID;
        private String sMenuName;
        private String sIcon;
        private List<ChildMenusBean> ChildMenus;

        public String getIMenuID() {
            return iMenuID;
        }

        public void setIMenuID(String iMenuID) {
            this.iMenuID = iMenuID;
        }

        public String getSMenuName() {
            return sMenuName;
        }

        public void setSMenuName(String sMenuName) {
            this.sMenuName = sMenuName;
        }

        public String getSIcon() {
            return sIcon;
        }

        public void setSIcon(String sIcon) {
            this.sIcon = sIcon;
        }

        public List<ChildMenusBean> getMenus() {
            return ChildMenus;
        }

        public void setChildMenus(List<ChildMenusBean> ChildMenus) {
            this.ChildMenus = ChildMenus;
        }

        public static class ChildMenusBean {
            /**
             * iMenuID : 286
             * sMenuName : 采购入库单
             * iSerial : 1
             * iFormID : 100000301
             * sIcon :
             * sAppStyle : 制单
             * iShowChart : 0
             * iIsUnion : 0
             * iPageGetData : 0
             */

            private int iMenuID;
            private String sMenuName;
            private int iSerial;
            private int iFormID;
            private String sIcon;
            private String sAppStyle;
            private int iShowChart;
            private int iIsUnion;
            private int iPageGetData;

            public int imgRes() {
                return StringUtil.isNotEmpty(getSIcon()) ? FontUtil.getImg(getSIcon()) : R.mipmap.icon_all;
            }

            public int menuId() {
                return iMenuID;
            }

            public void setMenuId(int iMenuID) {
                this.iMenuID = iMenuID;
            }

            public String menuName() {
                return sMenuName;
            }

            public void setMenuName(String sMenuName) {
                this.sMenuName = sMenuName;
            }

            public int getISerial() {
                return iSerial;
            }

            public void setISerial(int iSerial) {
                this.iSerial = iSerial;
            }

            public int formId() {
                return iFormID;
            }

            public void setFormId(int iFormID) {
                this.iFormID = iFormID;
            }

            public String getSIcon() {
                return sIcon;
            }

            public void setSIcon(String sIcon) {
                this.sIcon = sIcon;
            }

            public String getSAppStyle() {
                return sAppStyle;
            }

            public void setSAppStyle(String sAppStyle) {
                this.sAppStyle = sAppStyle;
            }

            public int getIShowChart() {
                return iShowChart;
            }

            public void setIShowChart(int iShowChart) {
                this.iShowChart = iShowChart;
            }

            public int getIIsUnion() {
                return iIsUnion;
            }

            public void setIIsUnion(int iIsUnion) {
                this.iIsUnion = iIsUnion;
            }

            public int getIPageGetData() {
                return iPageGetData;
            }

            public void setIPageGetData(int iPageGetData) {
                this.iPageGetData = iPageGetData;
            }
        }
    }
}
