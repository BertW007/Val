package pl.rxstudio.valuationofwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pl.rxstudio.valuationofwork.IndicatorContract.*;

public class IndicatorDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "indicatoresysk.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public IndicatorDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_INDICATOR_TABLE = "CREATE TABLE " +
                IndicatorZTable.TABLE_NAME  + " ( " +
                IndicatorZTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                IndicatorZTable.COLUMN_FUNCTIONAL_GROUPS + " TEXT, " +
                IndicatorZTable.COLUMN_OBJECTS + " TEXT, " +
                IndicatorZTable.COLUMN_CATEGORY + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_INDICATOR_TABLE);
        fillIndicatorsTable();

        final String SQL_CREATE_CATEGORY_PZT_TABLE = "CREATE TABLE " +
                CategoryTablePZT.TABLE_NAME  + " ( " +
                CategoryTablePZT._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoryTablePZT.COLUMN_CATEGORY + " TEXT, " +
                CategoryTablePZT.COLUMN_DESCRIPTION + " TEXT" +
                 ")";
        db.execSQL(SQL_CREATE_CATEGORY_PZT_TABLE);
        fillCategoryTablePZT();

        final String SQL_CREATE_FEE_FOR_PZT_TABLE = "CREATE TABLE " +
                CategoryTableFeeForPZT.TABLE_NAME  + " ( " +
                CategoryTableFeeForPZT._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoryTableFeeForPZT.COLUMN_AREA_ABOVE + " INT, " +
                CategoryTableFeeForPZT.COLUMN_CATEGORY_1_FEE + " DOUBLE, " +
                CategoryTableFeeForPZT.COLUMN_CATEGORY_2_FEE + " DOUBLE, " +
                CategoryTableFeeForPZT.COLUMN_CATEGORY_3_FEE + " DOUBLE, " +
                CategoryTableFeeForPZT.COLUMN_CATEGORY_4_FEE + " DOUBLE, " +
                CategoryTableFeeForPZT.COLUMN_CATEGORY_5_FEE + " DOUBLE" +
                ")";
        db.execSQL(SQL_CREATE_FEE_FOR_PZT_TABLE);
        fillCategoryFeeForPZT();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ IndicatorZTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ CategoryTablePZT.TABLE_NAME);
        onCreate(db);


//        db.execSQL("DROP TABLE IF EXISTS "+ Number2Table.TABLE_NAME);
//        onCreate(db);
    }

//    private void fillTable2() {
//
//        String[] person = new String[]{ "Za prace standardowo świadczone przez szefa biura \n" +
//                        "architektonicznego lub wysoko kwalifikowanego projektanta",
//                "Za prace, dla których świadczenia niezbędna jest wiedza zawodowa architekta –\n" +
//                        "standardowo świadczone przez architekta prowadzącego projekt",
//                "Za prace, dla których świadczenia niezbędna jest wiedza zawodowa architekta –\n" +
//                        "standardowo świadczone przez architekta asystenta projektanta",
//                "Za prace, dla których świadczenia niezbędne są kwalifikacje kreślarza lub innego\n"
//        };
//
//        String[] min = new String[]{  "320","160", "120", "80"
//        };
//
//        String[] max = new String[]{"600","300", "260", "200"
//        };
//
//        for (int i = 0; i < max.length; i++) {
//            Indicator q1 = new Indicator(person[i], min[i], max[i]);
//            addIndicatorTable2(q1);
//        }
//    }

    private void fillIndicatorsTable() {

        String[] groups = new String[]{ "Mieszkalne", "Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne","Mieszkalne",
                "Biura","Biura","Biura","Biura","Biura","Biura","Biura",
                "Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność","Administracja i łączność",
                "Straż, policja, więzienia","Straż, policja, więzienia","Straż, policja, więzienia","Straż, policja, więzienia","Straż, policja, więzienia","Straż, policja, więzienia","Straż, policja, więzienia",
                "Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi","Handel i usługi",
                "Oświata","Oświata","Oświata","Oświata","Oświata","Oświata",//"Oświata"
                "Nauka","Nauka","Nauka","Nauka","Nauka","Nauka",//"Nauka"
                "Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna","Zdrowie i opieka społeczna",//"Zdrowie i opieka społeczna"
                "Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura","Kultura",//"Kultura"
                "Obiekty kultu religijnego","Obiekty kultu religijnego","Obiekty kultu religijnego","Obiekty kultu religijnego","Obiekty kultu religijnego",//"Obiekty kultu religijnego"
                "Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja","Sport i rekreacja",//"Sport i rekreacja"
                "Hotele i turystyka","Hotele i turystyka","Hotele i turystyka","Hotele i turystyka","Hotele i turystyka","Hotele i turystyka","Hotele i turystyka","Hotele i turystyka",//"Hotele i turystyka"
                "Rolnicze","Rolnicze","Rolnicze","Rolnicze","Rolnicze","Rolnicze",//"Rolnicze"
                "Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja","Komunikacja",//"Komunikacja"
                "Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny","Przemysł i magazyny",//"Przemysł i magazyny"
                "Militarne i obrony cywilnej","Militarne i obrony cywilnej","Militarne i obrony cywilnej","Militarne i obrony cywilnej",//"Militarne i obrony cywilnej"
                "Inne","Inne","Inne","Inne"//"Inne"
        };

        String[] objects = new String[]{  "proste jednorodzinne budynki mieszkalne (niepodpiwniczone, bez garażu)",
                "budynki jednorodzine z garażami, domy bliźniacze",
                "budynki mieszkalne jednorodzinne z indywidualnymi wymaganiami",
                "jednorodzinne budynki tarasowe",
                "rezydencje o najwyższym standardzie",
                "budynki jednorodzinne w zabudowie zwartej (szeregowej, łańcuchowej, dywanowej)",
                "budynki wielorodzinne niskie (do 12m), bez garaży i wind",
                "budynki wielorodzinne (poza wyżej i niżej wymienionymi)",
                "budynki wielorodzinne wysokościowe (ponad 55m)",
                "budynki wielorodzinne o najwyższym standardzie z indywidualnymi wnętrzami pod klucz",
                "proste domy letniskowe",
                "domy wakacyjne (całoroczne)",
                "jw. z indywidualnymi wymaganiami",//Mieszkalne
                "proste obiekty biurowe, jednokondygnacjowe, bez garaży",
                "budynki biurowe wielokondygnacyjne niskie (do 12m), bez garaży",
                "budynki biurowe wielokondygnacyjne średnio wysokie i wysokie (do 55m), z garażami (piętra typu open – space, bez aranżacji)",
                "jw. z częścią żywieniową (stołówką) oraz zespołem odnowy biologicznej ",
                "budynki biurowe wielokondygnacyjne wysokościowe (powyżej 55m), z garażami (piętra typu open – space, bez aranżacji)",
                "jw. z częścią żywieniową (stołówką) oraz zespołem odnowy biologicznej, usługami",
                "budynki biurowe ze specjalnymi wymaganiami (np. prestiżowe siedziby firm)", //Biura
                "siedziby wójtów",
                "siedziby gmin, powiatów, starostwa",
                "siedziby władz wojewódzkich",
                "ratusze",
                "gmachy administracji rządowej",
                "jw. o najwyższym standardzie",
                "ambasady",
                "sądy szczebla powiatowego",
                "sądy szczebla wojewódzkiego i stołecznego",
                "punkty pocztowe (b/ części telekomunikacyjnej)",
                "urzędy pocztowe (b/ części telekomunikacyjnej)",
                "centrale telefoniczne",//Administracja i łączność

                "remizy strażackie",
                "siedziby straży z pełnym zapleczem technicznym",
                "posterunki policji",
                "komisariaty",
                "siedziby policji szczebla wojewódzkiego i stołecznego",
                "areszty",
                "więzienia",// Straż, policja, więzienia

                "proste, jednofunkcyjne pawilony handlowe lub usługowe",
                "supermakety bez uzupełniającego programu wydzielonych sklepów i usług",
                "supermakety z uzupełniającym programem wydzielonych sklepów i usług",
                "obiekty małej gastronomii",
                "obiekty (pawilony) handlowe i handlowo-usługowe o różnorodnym programie ",
                "hale targowe",
                "domy towarowe",
                "budynki centrów handlowych z wieloma placówkami handlowymi, usługowymi, gastronomicznymi oraz zapleczem (tu także galerie typu „shopping mall”)",
                "salony samochodowe",
                "sklepy specjalistyczne",
                "sklepy specjalistyczne ze specjalnymi wymaganiami co do wykończenia i ekspozycji",
                "kawiarnie, herbaciarnie, bary, puby ",
                "kantyny, stołówki, jadłodajnie",
                "restauracje", //Handel i usługi

                "przedszkola","szkoły podstawowe z częścią żywieniową lub/i z zapleczem sportowym",
                "gimnazja, licea","szkoły zawodowe (z warsztatami i/lub laboratoriami)",
                "internaty bez części żywieniowej i sportowej","internaty z częścią żywieniową lub/i sportową",//Oświata

                "obiekty wydziałów wyższych uczelni bez laboratoriów; administracja wyższych uczelni",
                "obiekty wydziałów wyższych uczelni z laboratoriami","instytuty naukowe (z laboratoriami)",
                "laboratoria naukowe","hotele asystenckie, akademiki","akademiki z zapleczem żywieniowym i rekreacyjnym",//Nauka

                "noclegownie","żłobki","domy dziecka","przychodnie zdrowia",
                "budynki centrów medycznych z zapleczem diagnostycznym","domy spokojnej starości",
                "hospicja","budynki ośrodków rehabilitacyjnych","domy uzdrowiskowe z zapleczem rehabilitacyjnym",
                "oddziały zabiegowe szpitali","kliniki",//Zdrowie i opieka

                "świetlice","kluby mieszkańsców","dyskoteki","kina (1-2 sale dla ok. 200 osób lub mniejsze)",
                "multikina","teatry o ograniczonej technologii, cyrki stałe",
                "teatry, opery, operetki","filharmonie, sale koncertowe","sale i pawilony wystawowe, galerie",
                "muzea – pawilony muzealne","muzea o najwyższym standardzie","sale wielofunkcyjne",
                "sale kongresowe","centra kongresowe",
                "biblioteki bez zaplecza konserwacji zbiorów, magazynów zwartych (np. małe miejskie lub gminne – ok.100.000 woluminów i mniejsze",
                "biblioteki o pełnym programie",//Kultura

                "kaplice","kościoły; synagogi","kościoły; synagogi o najwyższych wymaganiach co do wykończenia i wyposażenia",
                "plebanie","budynki klasztorów (cz. mieszkalna, refektarz, kuchnia, kaplica, zaplecze sportowo - rekreacyjne)",//Obiekty kultu religijnego

                "wiaty (np. na sprzęt pływający)","magazyny sprzętu sportowego","hangary na łodzie",
                "domki campingowe letnie (bez łazienek)","przebieralnie",
                "pawilony – szatnie, umywalnie i toalety","domki wypoczynkowe (z toaletami i łazienkami)",
                "sale gimnastyczne i sportowe dla gier zespołowych (koszykówka, siatkówka, piłka ręczna itp)",
                "hale sportowe (np. lekkoatletyczne)","pływalnie kryte","lodowiska kryte",
                "wielofunkcyjne budynki sportowe (hala + pływalnia + lodowisko itp.)",
                "zespoły odnowy biologicznej (basen, jacuzzi, sauna, masaż itp.)",//Sport i rekreacja

                "schroniska","hotele młodzieżowe, hotele turystyczne","hotele pracownicze, asystenckie",
                "motele","hotele niższych kategorii (nie więcej niż **), pensjonaty","hotele***",
                "hotele**** i *****","domy wczasowe (pełne zaplecze rekreacyjne, żywieniowe)",//Hotele i turystyka

                "proste budynki gospodarcze","szopy, stodoły","stajnie","chlewnie","szklarnie","kliniki weterynaryjne\n",//Rolnicze

                "jednokondygnacyjne garaże wolnostojące i boksy","wielostanowiskowe garaże jednokondygnacjowe naziemne (bez ścian)",
                "wielostanowiskowe garaże nadziemne zamknięte","garaże podziemne",
                "stacje obsługi pojazdów","stacje paliw","stacje paliw z usługami (sklep, kawiarnia, restauracja)",
                "bazy sprzetowo-transportowe ","budynki dworców autobusowych","budynki stacji kolejowych ",
                "budynki dworców kolejowych","budynki pasażerskich dworców lotniczych",//Komunikacja

                "proste budynki przemysłowe, magazynowe, warsztatowe","skomplikowane budynki magazynowe, wielokondygnacyjne",
                "kotłownie","chłodnie, mroźnie","spalarnie śmieci; zakłady utylizacji odpadów",
                "pralnie przemysłowe","obiekty przemysłu maszynowego, przetwórczego, spożywczego",
                "obiekty przemysłu poligraficznego","obiekty przemysłowe zagrożone wybuchem, promieniowaniem jonizującym itp",
                "obiekty przemysłu farmaceutycznego, chemicznego",
                "obiekty przemysłowe unikalne, techniki jądrowej, clean-roomy itp., o najwyższych wymaganiach technologicznych i wykończeniowych",
                "laboratoria i ośrodki badawcze dla przemysłu",//Przemysł i magazyny

                "koszary bez części żywieniowej i sportowej","koszary z częścią żywieniową lub/i sportową;",
                "schrony","schrony umożliwiające wielodniowe przetrwanie",//Militarne i obrony cywilnej

                "proste budynki gospodarcze","baraki","wiaty","krematoria"//Inne
        };

        Integer[] category = new Integer[]{23,35,46,46,67,46,34,45,56,67,23,34,56, //Mieszkalne
                23,34,45,56,56,67,67, //Biura
                34,35,46,46,56,67,67,45,57,34,45,45,//Administracja i łączność
                34,45,23,34,45,23,35,// Straż, policja, więzienia
                24,34,45,24,45,35,46,56,46,45,57,46,34,57,//Handel i usługi
                34,45,45,45,34,45,//Oświata
                45,57,57,67,34,45,//Nauka
                23,34,35,45,57,46,57,57,57,67,67,//Zdrowie i opieka społeczna
                23,34,34,45,57,57,67,67,47,57,67,57,57,67,45,57,//Kultura
                37,57,67,35,46,//Obiekty kultu religijnego
                12,12,12,23,13,23,34,45,45,56,56,67,57,//Sport i rekreacja
                35,35,35,45,35,45,57,46,//Hotele i turystyka
                12,11,23,24,23,35,//Rolnicze
                12,12,23,23,34,34,45,34,45,45,57,67,//Komunikacja
                23,35,23,45,45,45,45,45,56,56,67,57,//Przemysł i magazyny
                23,34,34,45,//Militarne i obrony cywilnej
                11,11,11,34//Inne



        };

        for (int i = 0; i < category.length; i++) {
            Indicator q1 = new Indicator(groups[i], objects[i], category[i]);
            addIndicator(q1);
        }
    }


    private void fillCategoryTablePZT() {

        String[] cat = new String[]{ "KATEGORIA 1", "KATEGORIA 2","KATEGORIA 3","KATEGORIA 4","KATEGORIA 5"
        };


        String[] desc = new String[]{  "- tereny o jednorodnej , nieskomplikowanej zabudowie, prostym zagospodarowaniu i uzbrojeniu\n" +
                "(do 3 projektowanych sieci), bez urządzeń technologicznych i z ewentualnymi pojedynczymi\n" +
                "urządzeniami technicznymi\n" +
                "- tereny z układem komunikacji wewnętrznej - do 10% powierzchni opracowania\n" +
                "- tereny z pojedynczym zakresem funkcyjnym\n" +
                "- tereny z pozostawieniem w 90% istniejącego ukształtowania\n" +
                "- tereny o prostych układach szaty roślinnej i jej jednorodnym składzie.",
                "- tereny o niejednorodnej zabudowie, prostym zagospodarowaniu i uzbrojeniu ,\n" +
                        "(do 4 projektowanych sieci), pojedynczymi urządzeniami technicznymi i technologicznymi\n" +
                        "- tereny z układem komunikacji wewnętrznej – od 10% do15% powierzchni opracowania\n" +
                        "- tereny – do 3 zakresów funkcyjnych\n" +
                        "- tereny o prostej rzeźbie z niedużymi zmianami w stosunku do istniejącego ukształtowania\n" +
                        "- tereny o prostych układach szaty roślinnej lecz jej niejednorodnym składzie.",
                "- tereny:\n" +
                        "a) o skomplikowanej i rozczłonkowanej zabudowie , oraz złożonych założeniach\n" +
                        "przestrzenno-plastycznych, z niewielką ilością urządzeń technicznych ,\n" +
                        "technologicznych i sieci uzbrojenia (do 5 projektowanych sieci), lub\n" +
                        "b) o średnim stopniu trudności projektowanej zabudowy i założeń przestrzennych, lecz z\n" +
                        "dużą ilością projektowanych urządzeń technicznych , technologicznych i sieci\n" +
                        "uzbrojenia (powyżej 5 projektowanych sieci),\n" +
                        "- tereny z układem komunikacji wewnętrznej – od 15% do 20% powierzchni opracowania\n" +
                        "- tereny o licznych zakresach funkcyjnych o prostych związkach\n" +
                        "- tereny o przeciętnym zakresie zmian ukształtowania\n" +
                        "- tereny o złożonych układach kompozycyjnych szaty roślinnej i jej niejednorodnym składzie.",
                "- tereny jak w Kategorii 3a, lecz z dużą ilością : sieci uzbrojenia ( powyżej 5 projektowanych\n" +
                        "sieci), ciągów i urządzeń technologicznych, urządzeń technicznych oraz konstrukcji\n" +
                        "inżynierskich .\n" +
                        "- tereny z układem komunikacji wewnętrznej – powyżej 20% powierzchni opracowania\n" +
                        "- tereny wielofunkcyjne o różnorakich powiązaniach\n" +
                        "- tereny o bogatym projektowanym zróżnicowaniu z dużymi zmianami w stosunku do\n" +
                        "istniejącego ukształtowania\n" +
                        "- tereny o złożonych układach kompozycyjnych szaty roślinnej i jej niejednorodnym składzie.",


                "- tereny jak w Kategorii 4. – dla najtrudniejszych zakładów produkcji podstawowej w\n" +
                        "przemysłach: górniczym, hutniczym, chemicznym, energetycznym.\n" +
                        "- tereny z układem komunikacji wewnętrznej – powyżej 20% powierzchni opracowania,\n" +
                        "z torowiskami i urządzeniami torowymi."
        };



        for (int i = 0; i < cat.length; i++) {
            Indicator q1 = new Indicator(cat[i], desc[i]);
            addCategoryPZT(q1);
        }
    }


    private void fillCategoryFeeForPZT() {

        int[] areaAbove = new int[]{0,2,5,10,20,30,40,60,80,100,150,200,250,300,400,500
        };
        double[] cat1 = new double[]{6.60,5.80,5.05,4.35,3.70,3.10,2.60,2.15,1.75,1.40,1.15,0.95,0.80,0.70,0.62,0.57
        };
        double[] cat2 = new double[]{7.13,6.26,5.45,4.70,3.99,3.35,2.81,2.32,1.89,1.51,1.24,1.03,0.86,0.76,0.67,0.62
        };
        double[] cat3 = new double[]{8.20,7.20,6.27,5.40,4.60,3.85,3.23,2.67,2.17,1.74,1.43,1.18,1.00,0.88,0.77,0.72
        };
        double[] cat4 = new double[]{0,8.79,7.65,6.59,5.61,4.70,3.94,3.26,2.65,2.12,1.74,1.44,1.22,1.07,0.94,0.88
        };
        double[] cat5 = new double[]{0,11.43,9.94,8.57,7.29,6.11,5.12,4.24,3.44,2.76,2.26,1.87,1.58,1.39,1.22,1.15
        };





        for (int i = 0; i < cat1.length; i++) {
            Indicator q1 = new Indicator(areaAbove[i], cat1[i],cat2[i],cat3[i],cat4[i],cat5[i]);
            addFeePZT(q1);
        }
    }
    private void addCategoryPZT(Indicator indicator) {
        ContentValues cv = new ContentValues();
        cv.put(CategoryTablePZT.COLUMN_CATEGORY, indicator.getCategoryCategory());
        cv.put(CategoryTablePZT.COLUMN_DESCRIPTION, indicator.getCategoryDescription());
        db.insert(CategoryTablePZT.TABLE_NAME, null, cv);
    }
    private void addIndicator(Indicator indicator) {
        ContentValues cv = new ContentValues();
        cv.put(IndicatorZTable.COLUMN_FUNCTIONAL_GROUPS, indicator.getIndicatorObjectsGroups());
        cv.put(IndicatorZTable.COLUMN_OBJECTS, indicator.getIndicatorObjects());
        cv.put(IndicatorZTable.COLUMN_CATEGORY, indicator.getIndicatorCategory());
        db.insert(IndicatorZTable.TABLE_NAME, null, cv);
    }
    private void addFeePZT(Indicator indicator) {
        ContentValues cv = new ContentValues();
        cv.put(CategoryTableFeeForPZT.COLUMN_AREA_ABOVE, indicator.getFeeForPZTAbove());
        cv.put(CategoryTableFeeForPZT.COLUMN_CATEGORY_1_FEE, indicator.getFeeForPZTCategory1());
        cv.put(CategoryTableFeeForPZT.COLUMN_CATEGORY_2_FEE, indicator.getFeeForPZTCategory2());
        cv.put(CategoryTableFeeForPZT.COLUMN_CATEGORY_3_FEE, indicator.getFeeForPZTCategory3());
        cv.put(CategoryTableFeeForPZT.COLUMN_CATEGORY_4_FEE, indicator.getFeeForPZTCategory4());
        cv.put(CategoryTableFeeForPZT.COLUMN_CATEGORY_5_FEE, indicator.getFeeForPZTCategory5());
        db.insert(CategoryTableFeeForPZT.TABLE_NAME, null, cv);
    }

    public List<Indicator> getAllIndicators() {
        List<Indicator> indicatorList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + IndicatorZTable.TABLE_NAME, null);

        movingToFirst(indicatorList, c);

        c.close();
        return indicatorList;
    }

    public List<Indicator> getGroupIndicators(String groupObjects) {
        List<Indicator> indicatorList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + IndicatorZTable.TABLE_NAME +
                " WHERE " + IndicatorZTable.COLUMN_FUNCTIONAL_GROUPS + " = '" + groupObjects +"'", null);
        movingToFirst(indicatorList, c);

        c.close();
        return indicatorList;
    }

    public List<Indicator> getCategoryPZT() {
        List<Indicator> indicatorList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoryTablePZT.TABLE_NAME, null);
        movingToFirstPZT(indicatorList, c);

        c.close();
        return indicatorList;
    }

    public List<Indicator> getFeePZT() {
        List<Indicator> indicatorList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoryTableFeeForPZT.TABLE_NAME, null);
        movingToFirstFeeForPZT(indicatorList, c);

        c.close();
        return indicatorList;
    }

    public List<Indicator> getCategoryIndicators(String objects) {
        List<Indicator> indicatorList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + IndicatorZTable.TABLE_NAME +
                " WHERE " + IndicatorZTable.COLUMN_OBJECTS + " = '" + objects +"'", null);
        movingToFirst(indicatorList, c);

        c.close();
        return indicatorList;
    }



    public List<Indicator> getGroupIndicators() {
        List<Indicator> indicatorList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + IndicatorZTable.TABLE_NAME +
                " GROUP BY "+ IndicatorZTable.COLUMN_FUNCTIONAL_GROUPS, null);

        movingToFirst(indicatorList, c);

        c.close();
        return indicatorList;
    }


    public void movingToFirst(List indicatorList, Cursor c) {
        if (c.moveToFirst()) {
            do {
                Indicator indicator = new Indicator();
                indicator.setIndicatorObjectsGroups(c.getString(c.getColumnIndex(IndicatorZTable.COLUMN_FUNCTIONAL_GROUPS)));
                indicator.setIndicatorObjects(c.getString(c.getColumnIndex(IndicatorZTable.COLUMN_OBJECTS)));
                indicator.setIndicatorCategory(c.getInt(c.getColumnIndex(IndicatorZTable.COLUMN_CATEGORY)));
                indicatorList.add(indicator);
            } while (c.moveToNext());
        }
    }
    public void movingToFirstPZT(List indicatorList, Cursor c) {
        if (c.moveToFirst()) {
            do {
                Indicator indicator = new Indicator();
                indicator.setCategoryCategory(c.getString(c.getColumnIndex(CategoryTablePZT.COLUMN_CATEGORY)));
                indicator.setCategoryDescription(c.getString(c.getColumnIndex(CategoryTablePZT.COLUMN_DESCRIPTION)));

                indicatorList.add(indicator);
            } while (c.moveToNext());
        }
    }
    public void movingToFirstFeeForPZT(List indicatorList, Cursor c) {
        if (c.moveToFirst()) {
            do {
                Indicator indicator = new Indicator();
                indicator.setFeeForPZTAbove(c.getInt(c.getColumnIndex(CategoryTableFeeForPZT.COLUMN_AREA_ABOVE)));
                indicator.setFeeForPZTCategory1(c.getDouble(c.getColumnIndex(CategoryTableFeeForPZT.COLUMN_CATEGORY_1_FEE)));
                indicator.setFeeForPZTCategory2(c.getDouble(c.getColumnIndex(CategoryTableFeeForPZT.COLUMN_CATEGORY_2_FEE)));
                indicator.setFeeForPZTCategory3(c.getDouble(c.getColumnIndex(CategoryTableFeeForPZT.COLUMN_CATEGORY_3_FEE)));
                indicator.setFeeForPZTCategory4(c.getDouble(c.getColumnIndex(CategoryTableFeeForPZT.COLUMN_CATEGORY_4_FEE)));
                indicator.setFeeForPZTCategory5(c.getDouble(c.getColumnIndex(CategoryTableFeeForPZT.COLUMN_CATEGORY_5_FEE)));
                indicatorList.add(indicator);
            } while (c.moveToNext());
        }
    }

}
