package pl.rxstudio.valuationofwork;

public class Indicator {
    private String indicatorObjectsGroups;
    private String indicatorObjects;
    private int  indicatorCategory;

    private String categoryCategory;
    private String categoryDescription;

    private int feeForPZTAbove;

    private double feeForPZTCategory1;
    private double feeForPZTCategory2;
    private double feeForPZTCategory3;
    private double feeForPZTCategory4;
    private double feeForPZTCategory5;




    private String table2Work;
    private String table2Min;
    private String table2Max;

    public static String internalArea;
    public static double indicatorZ;
    public static double architectsFee;
    public static double additives;
    public static double feeRate;
    public static double indicatorW;
    public static double indicatorD;
    public static double valueZ;
    public static double valueKat;
    public static int    valueKatPZT;
    public static double valueHaS1;
    public static double valueHaS2;
    public static double valueHaS3;
    public static double valueHa;
    public static double valueHaPZT;
    public static double areaPZT;
    public static double valueFeePZT;


    public  Indicator() {}

    public Indicator(String indicatorObjectsGroups, String indicatorObjects, int indicatorCategory) {
        this.indicatorObjectsGroups = indicatorObjectsGroups;
        this.indicatorObjects = indicatorObjects;
        this.indicatorCategory = indicatorCategory;
    }
//    public Indicator(String table2Work, String table2Min, String table2Max) {
//        this.table2Work = table2Work;
//        this.table2Min = table2Min;
//        this.table2Max = table2Max;
//    }

    public Indicator(String categoryCategory, String categoryDescription) {
        this.categoryCategory = categoryCategory;
        this.categoryDescription = categoryDescription;
          }

    public Indicator(int feeForPZTAbove, double feeForPZTCategory1,
                     double feeForPZTCategory2, double feeForPZTCategory3,
                     double feeForPZTCategory4, double feeForPZTCategory5) {
        this.feeForPZTAbove = feeForPZTAbove;

        this.feeForPZTCategory1 = feeForPZTCategory1;
        this.feeForPZTCategory2 = feeForPZTCategory2;
        this.feeForPZTCategory3 = feeForPZTCategory3;
        this.feeForPZTCategory4 = feeForPZTCategory4;
        this.feeForPZTCategory5 = feeForPZTCategory5;
    }


    public void haEs1(double peWu, double esHa, double wu, double de) {
        valueHaS1 = peWu * esHa * wu *de;
          }

//    public void haEs2(double peWu, double esHa, double wu, double de) {
//        architectsFee = peWu * esHa * wu *de;
//    }

//    public void haEs3(double peWu, double esHa, double wu, double de) {
//        architectsFee = peWu * esHa * wu *de;
//    }

    public void ha(double haS1, double haS2, double haS3) {
        valueHa = haS1 + haS1 + haS1;
    }

    public String getIndicatorObjectsGroups() {
        return indicatorObjectsGroups;
    }

    public void setIndicatorObjectsGroups(String indicatorObjectsGroups) {
        this.indicatorObjectsGroups = indicatorObjectsGroups;
    }

    public String getIndicatorObjects() {
        return indicatorObjects;
    }

    public void setIndicatorObjects(String indicatorObjects) {
        this.indicatorObjects = indicatorObjects;
    }

    public int getIndicatorCategory() {
        return indicatorCategory;
    }

    public void setIndicatorCategory(int indicatorCategory) {
        this.indicatorCategory = indicatorCategory;
    }

    public String getCategoryCategory() {
        return categoryCategory;
    }

    public void setCategoryCategory(String categoryCategory) {
        this.categoryCategory = categoryCategory;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }


    public int getFeeForPZTAbove() {
        return feeForPZTAbove;
    }

    public void setFeeForPZTAbove(int feeForPZTAbove) {
        this.feeForPZTAbove = feeForPZTAbove;
    }

    public double getFeeForPZTCategory1() {
        return feeForPZTCategory1;
    }

    public void setFeeForPZTCategory1(double feeForPZTCategory1) {
        this.feeForPZTCategory1 = feeForPZTCategory1;
    }

    public double getFeeForPZTCategory2() {
        return feeForPZTCategory2;
    }

    public void setFeeForPZTCategory2(double feeForPZTCategory2) {
        this.feeForPZTCategory2 = feeForPZTCategory2;
    }

    public double getFeeForPZTCategory3() {
        return feeForPZTCategory3;
    }

    public void setFeeForPZTCategory3(double feeForPZTCategory3) {
        this.feeForPZTCategory3 = feeForPZTCategory3;
    }

    public double getFeeForPZTCategory4() {
        return feeForPZTCategory4;
    }

    public void setFeeForPZTCategory4(double feeForPZTCategory4) {
        this.feeForPZTCategory4 = feeForPZTCategory4;
    }

    public double getFeeForPZTCategory5() {
        return feeForPZTCategory5;
    }

    public void setFeeForPZTCategory5(double feeForPZTCategory5) {
        this.feeForPZTCategory5 = feeForPZTCategory5;
    }

    public double getIndicatorZ() {
        return indicatorZ;
    }

    public void setIndicatorZ(double indicatorZ) {
        this.indicatorZ = indicatorZ;
    }

    public double getArchitectsFee() {
        return architectsFee;
    }

    public void setArchitectsFee(double architectsFee) {
        this.architectsFee = architectsFee;
    }

    public double getAdditives() {
        return additives;
    }

    public void setAdditives(double additives) {
        this.additives = additives;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public double getIndicatorW() {
        return indicatorW;
    }

    public void setIndicatorW(double indicatorW) {
        this.indicatorW = indicatorW;
    }
}
