package pl.rxstudio.valuationofwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private String zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editArea);
        textView = findViewById(R.id.textView8);

        Button buttonSKI = findViewById(R.id.buttonSKI);
        buttonSKI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSKI();
            }
        });


        zValue = Indicator.internalArea;
        editText.setText(Indicator.internalArea);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Indicator.internalArea = editText.getText().toString();
                textView.setText(Indicator.internalArea);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        editText.setText(Indicator.internalArea);


    }

    private void startSKI(){
        Intent intent = new Intent(MainActivity.this, EstimatedInvestmentCostActivity.class);
        startActivity(intent);

    }

    public void startPZT(View view){
        Intent intent = new Intent(MainActivity.this, CostPZTActivity.class);
        startActivity(intent);

    }


}
