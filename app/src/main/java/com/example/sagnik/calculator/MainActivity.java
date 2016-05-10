package com.example.sagnik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sagnik.calculator.R;

public class MainActivity extends AppCompatActivity {

    Button zero , one , two , three , four , five , six ,
            seven , eight , nine , add , sub , divide ,
            multiply , dot , resetC , Equalto ;

    EditText edt1 ;
    TextView opdisplay;

    float mValueOne , mValueTwo ;

    boolean mAddition , mSubtract ,mMultiplication ,mDivision ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        dot = (Button) findViewById(R.id.dot);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        resetC = (Button) findViewById(R.id.reset);
        Equalto = (Button) findViewById(R.id.equalto);
        edt1 = (EditText) findViewById(R.id.text_input_display);
        opdisplay=(TextView) findViewById(R.id.text_output_display);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"1");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"2");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"3");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"4");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"5");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"6");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"7");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"8");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"9");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"0");
                opdisplay.setText(edt1.getText().toString());
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (edt1 == null) {
                        edt1.setText("");
                    }
                    else {
                        mValueOne = Float.parseFloat(edt1.getText() + "");
                        mAddition = true;
                        opdisplay.setText(edt1.getText().toString());
                        edt1.setText(null);
                    }
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(edt1.getText() + "");
                    mSubtract = true;
                    opdisplay.setText(edt1.getText()+" - ");
                    edt1.setText(null);
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(edt1.getText() + "");
                    mMultiplication = true;
                    opdisplay.setText(edt1.getText()+" * ");
                    edt1.setText(null);
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(edt1.getText() + "");
                    mDivision = true;
                    //sdded next two lines
                    //edt1.setText(edt1.getText()+" / ");
                    opdisplay.setText(edt1.getText()+" / ");
                    edt1.setText(null);

                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        });

        Equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mValueTwo = Float.parseFloat(edt1.getText() + "");

                    if (mAddition == true) {

                        //edt1.setText(mValueOne + mValueTwo +"");
                        opdisplay.setText(mValueOne + mValueTwo + "");
                        mAddition = false;
                    }
                    if (mSubtract == true) {
                        opdisplay.setText(mValueOne - mValueTwo + "");
                        mSubtract = false;
                    }

                    if (mMultiplication == true) {
                        opdisplay.setText(mValueOne * mValueTwo + "");
                        mMultiplication = false;
                    }

                    if (mDivision == true) {
                        opdisplay.setText(mValueOne / mValueTwo + "");
                        mDivision = false;
                    }
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        });

        resetC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                opdisplay.setText("");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+".");
            }
        });
    }

}