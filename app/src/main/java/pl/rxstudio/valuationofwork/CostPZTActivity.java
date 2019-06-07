package pl.rxstudio.valuationofwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CostPZTActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;
    private EditText editText;
    private List<Indicator> indicatorListSelected;
    private List<Indicator> feePZTListSelected;
    private ArrayList<Table8Item> table8List;
    private Table8Adapter table8Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_pzt);

        initList();

        Spinner spinnerTable8 = findViewById(R.id.spinnerTable8);

        table8Adapter = new Table8Adapter(this, table8List);
        spinnerTable8.setAdapter(table8Adapter);

        spinnerTable8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Table8Item clickedItem = (Table8Item) parent.getItemAtPosition(position);
                String clickedTable8Add = clickedItem.getTable8Add();
                Toast.makeText(CostPZTActivity.this, clickedTable8Add + " selected", Toast.LENGTH_SHORT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final IndicatorDbHelper dbHelperSelected = new IndicatorDbHelper(this);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextArea);
        indicatorListSelected = dbHelperSelected.getCategoryPZT();
        feePZTListSelected = dbHelperSelected.getFeePZT();

        CustomAdapter customAdapter = new CustomAdapter(this, getObjectCategory(),getObjectDescription());
        listView.setAdapter(customAdapter);

        ArrayAdapter listAdapter = new ArrayAdapter(this, R.layout.activity_list_item, R.id.firstLine, getObjectCategory());
        //listView.setAdapter(listAdapter);
        ArrayAdapter listAdapter2 = new ArrayAdapter(this, R.layout.activity_list_item, R.id.secondLine, getObjectCategory());
        //listView.setAdapter(listAdapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Indicator.valueKatPZT = position+1;


                textView.setText(Integer.toString(Indicator.valueKatPZT));
                calculateFeePZT();
            }
        });

        editText.setText(Double.toString(Indicator.areaPZT));

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Indicator.areaPZT = Double.parseDouble(editText.getText().toString());
                //editText.setText(Double.toString(Indicator.areaPZT));
                textView.setText(Double.toString(Indicator.areaPZT));
                calculateFeePZT();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    private void initList(){
        table8List = new ArrayList<>();
        table8List.add(new Table8Item("D9-1a", "a) teren płaski o spadkach od 2% do 5%", 0.05));
        table8List.add(new Table8Item("D9-1b", "b) teren lekko pofałdowany od 2% do 5%", 0.10));
        table8List.add(new Table8Item("D9-1c", "c) teren falisty o spadkach od 5% do 10%", 0.15));
        table8List.add(new Table8Item("D9-1d", "d) teren zróżnicowany, pofałdowany o spadkach ponad 10%", 0.20));
        table8List.add(new Table8Item("D9-2", "Przy wykonywaniu osobnych przekrojów poprzecznych w celu\n" +
                "obliczania mas ziemnych", 0.10));
        table8List.add(new Table8Item("D9-3", "a) teren płaski o spadkach od 2% do 5%", 0.20));
        table8List.add(new Table8Item("D9-4", "a) teren płaski o spadkach od 2% do 5%", 0.20));
        table8List.add(new Table8Item("D9-5", "a) teren płaski o spadkach od 2% do 5%", 0.20));
        table8List.add(new Table8Item("D9-6", "a) teren płaski o spadkach od 2% do 5%", 0.20));

    }
    private String[] getObjectCategory() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getCategoryCategory();
        }
        return groupList;
    }
    private String[] getObjectDescription() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getCategoryDescription();
        }
        return groupList;
    }

    private String[] getFeePZTAbove() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getCategoryCategory();
        }
        return groupList;
    }

    private void calculateFeePZT(){
        textView.setText(Double.toString(Indicator.areaPZT));
        textView.setText(Integer.toString(Indicator.valueKatPZT));
    }



}
