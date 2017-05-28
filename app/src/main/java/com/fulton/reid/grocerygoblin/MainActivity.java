package com.fulton.reid.grocerygoblin;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {


    boolean lbsBool = false;
    boolean ozBool = false;
    boolean qtyBool = false;

    CharSequence text = "Did not select a Unit of Measure";
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Toast error = Toast.makeText(this, text, duration);

        setContentView(R.layout.activity_main);
        final ToggleButton lbsBtn = (ToggleButton) findViewById(R.id.lbsButton);
        final ToggleButton ozBtn = (ToggleButton) findViewById(R.id.ozButton);
        final ToggleButton qtyBtn = (ToggleButton) findViewById(R.id.qtyButton);
        final Button calculate = (Button) findViewById(R.id.calcButton);
        final TextView unittxt1 = (TextView) findViewById(R.id.unitTxt1);

        final TextView txtPrice1 = (TextView) findViewById(R.id.Pricetxt1);
        final TextView txtPrice2 = (TextView) findViewById(R.id.priceTxt2);
        final TextView priceFinal1 = (TextView) findViewById(R.id.Final1);
        final TextView priceFinal2 = (TextView) findViewById(R.id.Final2);
        final TextView unitTxtXXX1 = (TextView) findViewById(R.id.qtyItem1);
        final TextView unitTxtXXX2 = (TextView) findViewById(R.id.qtyItem2);


        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                try{
                if (lbsBool){
                    double qty1 = Double.valueOf(unitTxtXXX1.getText().toString());
                    double price1 = Double.valueOf(txtPrice1.getText().toString());
                    double qty2 = Double.valueOf(unitTxtXXX2.getText().toString());
                    double price2 = Double.valueOf(txtPrice2.getText().toString());
                    double costperXXX1 = (price1/qty1);
                    double costperXXX2 = (price2/qty2);
                    costperXXX1 = round(costperXXX1,2);
                    costperXXX2 = round(costperXXX2,2);
                    priceFinal1.setText(String.valueOf(costperXXX1));
                    priceFinal2.setText(String.valueOf(costperXXX2));

                    if (costperXXX1 > costperXXX2)
                    {
                        priceFinal1.setTextColor(Color.rgb(255,0,0));
                        priceFinal2.setTextColor(Color.rgb(0,255,0));


                    }
                    else
                    {

                        priceFinal1.setTextColor(Color.rgb(0,255,0));
                        priceFinal2.setTextColor(Color.rgb(255,0,0));


                    }


                }

                else if (ozBool){

                    double qty1 = Double.valueOf(unitTxtXXX1.getText().toString());
                    double price1 = Double.valueOf(txtPrice1.getText().toString());
                    double qty2 = Double.valueOf(unitTxtXXX2.getText().toString());
                    double price2 = Double.valueOf(txtPrice2.getText().toString());
                    double costperXXX1 = (price1/qty1);
                    double costperXXX2 = (price2/qty2);
                    costperXXX1 = round(costperXXX1,2);
                    costperXXX2 = round(costperXXX2,2);
                    priceFinal1.setText(String.valueOf(costperXXX1));
                    priceFinal2.setText(String.valueOf(costperXXX2));

                    if (costperXXX1 > costperXXX2)
                    {
                        priceFinal1.setTextColor(Color.rgb(255,0,0));
                        priceFinal2.setTextColor(Color.rgb(0,255,0));


                    }
                    else
                    {

                        priceFinal1.setTextColor(Color.rgb(0,255,0));
                        priceFinal2.setTextColor(Color.rgb(255,0,0));


                    }
                }

                else if (qtyBool){



                    double qty1 = Double.valueOf(unitTxtXXX1.getText().toString());
                    double price1 = Double.valueOf(txtPrice1.getText().toString());
                    double qty2 = Double.valueOf(unitTxtXXX2.getText().toString());
                    double price2 = Double.valueOf(txtPrice2.getText().toString());
                    double costperXXX1 = (price1/qty1);
                    double costperXXX2 = (price2/qty2);
                    costperXXX1 = round(costperXXX1,2);
                    costperXXX2 = round(costperXXX2,2);
                    priceFinal1.setText(String.valueOf(costperXXX1));
                    priceFinal2.setText(String.valueOf(costperXXX2));

                    if (costperXXX1 > costperXXX2)
                    {
                        priceFinal1.setTextColor(Color.rgb(255,0,0));
                        priceFinal2.setTextColor(Color.rgb(0,255,0));


                    }
                    else
                    {

                        priceFinal1.setTextColor(Color.rgb(0,255,0));
                        priceFinal2.setTextColor(Color.rgb(255,0,0));


                    }
                }

                else

                {

                    error.show();


                }

            }
                catch (Throwable e) {
                    e.printStackTrace();
                }}

        });


        //set the variables whether it be lbs or oz or quantity.
        lbsBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbsBool = true;
                    ozBool = false;
                    qtyBool = false;
                    ozBtn.setChecked(false);
                    qtyBtn.setChecked(false);
                    unittxt1.setText("LBS");

                } else {
                    lbsBool = false;
                    // The toggle is disabled
                }
            }
        });

        ozBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbsBool = false;
                    qtyBool = false;
                    ozBool = true;
                    lbsBtn.setChecked(false);
                    qtyBtn.setChecked(false);
                    unittxt1.setText("Oz");



                } else {
                    ozBool = false;
                }
            }
        });

        qtyBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    qtyBool = true;
                    lbsBool = false;
                    ozBool = false;
                    ozBtn.setChecked(false);
                    lbsBtn.setChecked(false);
                    unittxt1.setText("Qty");



                } else {
                    qtyBool = false;
                    // The toggle is disabled
                }
            }
        });

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}