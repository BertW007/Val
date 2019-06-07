package pl.rxstudio.valuationofwork;

import android.provider.BaseColumns;

public final class IndicatorContract {

    private IndicatorContract() {}


    public static class IndicatorZTable implements BaseColumns {
        public static final String TABLE_NAME = "indicatorZCategories";
        public static final String COLUMN_FUNCTIONAL_GROUPS = "functionalGroups";
        public static final String COLUMN_OBJECTS = "objects";
        public static final String COLUMN_CATEGORY = "category";
    }

//    public static class Number2Table implements BaseColumns {
//        public static final String TABLE_NAME = "table2";
//        public static final String COLUMN_WORK_PERSON = "osobaPracująca";
//        public static final String COLUMN_HOURLY_RATE_MIN = "stawkaGodzinowaMin";
//        public static final String COLUMN_HOURLY_RATE_MAX = "stawkaGodzinowaMax";
//    }

    public static class CategoryTablePZT implements BaseColumns {
        public static final String TABLE_NAME = "categoryTablePZT";
        public static final String COLUMN_CATEGORY = "kategoria";
        public static final String COLUMN_DESCRIPTION = "opis";
    }

    public static class CategoryTableFeeForPZT implements BaseColumns {
        public static final String TABLE_NAME = "categoryTableFeeForPZT";
        public static final String COLUMN_AREA_ABOVE = "areaAbove";

        public static final String COLUMN_CATEGORY_1_FEE = "category1Fee";
        public static final String COLUMN_CATEGORY_2_FEE = "category2Fee";
        public static final String COLUMN_CATEGORY_3_FEE = "category3Fee";
        public static final String COLUMN_CATEGORY_4_FEE = "category4Fee";
        public static final String COLUMN_CATEGORY_5_FEE = "category5Fee";
    }

//    public class IndicatorZValue {
//        public String indicatorZ = "0";
//
//    }


}
