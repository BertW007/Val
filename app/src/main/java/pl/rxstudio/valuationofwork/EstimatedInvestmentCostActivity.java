package pl.rxstudio.valuationofwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EstimatedInvestmentCostActivity extends AppCompatActivity {

    EditText editZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimated_investment_cost);




        final EditText editTextIntermalArea = findViewById(R.id.etitTextInterlnalArea);
        editTextIntermalArea.setText(Indicator.internalArea);

        editTextIntermalArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Indicator.internalArea = editTextIntermalArea.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText editTextZIndicator = findViewById(R.id.editZ);
        editTextZIndicator.setText(Double.toString(Indicator.indicatorZ));
        editTextZIndicator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startZ();
            }
        });

    }

    private void startZ(){
       Intent intent = new Intent(EstimatedInvestmentCostActivity.this, IndicatorZActivity.class);
       startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        editZ = findViewById(R.id.editZ);
        editZ.setText(Double.toString(Indicator.valueKat));
        Log.i("safsf", Double.toString(Indicator.valueKat));


    }
}
