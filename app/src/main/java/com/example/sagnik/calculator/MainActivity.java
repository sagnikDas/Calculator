package com.example.sagnik.calculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sagnik.calculator.R;


public class MainActivity extends AppCompatActivity {

    Calculator calc;
    Button zero,one,two,three,four,five,six,seven,eight,nine,multiply,divide,subtract,add,equals,clear,decimalSeparator;
    TextView textView,textViewMini;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TableLayout v = (TableLayout) li.inflate(R.layout.activity_main, null);
    */    calc = new Calculator();
        textView = (TextView) findViewById(R.id.text_output_display);
        textViewMini = (TextView) findViewById(R.id.text_input_display);

        //Calculator buttons
  /*      zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        subtract = (Button) findViewById(R.id.sub);
        add = (Button) findViewById(R.id.add);
        equals = (Button) findViewById(R.id.equalto);
        clear = (Button) findViewById(R.id.reset);
        decimalSeparator = (Button) findViewById(R.id.dot);
*/

/*        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
            });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    buttonClick(v);
                }
                catch(RuntimeException e)
                {
                    e.printStackTrace();
                }

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        decimalSeparator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });*/

    }

    public void buttonClick(View v) {
        Button button = (Button) findViewById(v.getId());
        String button_text = (String) button.getText();
        calc.calculate(button_text);
        textView = (TextView) findViewById(R.id.text_output_display);
        textViewMini = (TextView) findViewById(R.id.text_input_display);

        textView.setText(calc.getFinalDisplayText());
        textViewMini.setText(calc.getFinalDisplayMiniText());

    }

    public static class Calculator {
        double num1;
        String operator;
        double memory;
        boolean shouldClearText;
        double result;

        String currentDisplayText;
        String currentDisplayMiniText;

        String finalDisplayText;
        String finalDisplayMiniText;

        public String getFinalDisplayText() {
            return finalDisplayText;
        }

        public String getFinalDisplayMiniText() {
            return finalDisplayMiniText;
        }

        public Calculator() {
            num1 = 0.0;
            operator = "";
            memory = 0.0;
            shouldClearText = false;
            //		Log.d("Constructor", Boolean.valueOf(shouldClearText).toString());
            result = 0.0;

            currentDisplayText = Double.valueOf(num1).toString();
            currentDisplayMiniText = Double.valueOf(num1).toString();

            finalDisplayText = Double.valueOf(num1).toString();
            finalDisplayMiniText = Double.valueOf(num1).toString();
        }

        public void calculate(String buttonText) {
            currentDisplayMiniText = finalDisplayMiniText;
            currentDisplayText = finalDisplayText;

            switch (buttonText) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    numberEntered(buttonText);
                    break;
                case ".":
                    periodEntered(buttonText);
                    break;
                case "*":
                case "/":
                case "-":
                case "+":
                    operatorEntered(buttonText);
                    break;
                case "=":
                    calculateResult();
                    break;
                case "1/x":
                    calculateReciprocal();
                    break;
                case "MC":
                case "MR":
                case "MS":
                case "MPlus":
                case "MMinus":
                    performMemoryOperation(buttonText);
                    break;

                case "B":
                    backspaceEntered();
                    break;
                case "CE":
                case "C":
                    clearScreen(buttonText);
                    break;
                case "+/-":
                    toggleSign();
                    break;
                default:
                    miscOperatorEntered(buttonText);
                    break;
            }
            standardizeDisplay();
        }

        private void standardizeDisplay() {
            switch(finalDisplayText) {
                case "0.0":
                case "-0.0":
                    finalDisplayText="0";
                    break;
                default:
                    double displayNumber = Double.parseDouble(finalDisplayText);
                    if ((displayNumber == Math.floor(displayNumber)) && !Double.isInfinite(displayNumber)) {
                        finalDisplayText = String.valueOf((int) Math.floor(displayNumber));
                    }
            }
        }

        private void periodEntered(String period) {
            String existingDisplay = currentDisplayText;
            Log.d("periodEntered", Boolean.valueOf(shouldClearText).toString());

            if (shouldClearText == true) {
                existingDisplay = "0";
                shouldClearText = false;
            }

            finalDisplayText = existingDisplay + period;
            System.out.println(". text = " + finalDisplayText);

        }

        private void numberEntered(String number) {
            String existingDisplay = currentDisplayText;
            Log.d("numberEntered", Boolean.valueOf(shouldClearText).toString());

            if (shouldClearText == true) {
                existingDisplay = "0.0";
                Log.d("numberEntered", "existingDisplay is " + existingDisplay + "in shouldClearText == true");
                shouldClearText = false;
            }

            if (existingDisplay.equals("0") || existingDisplay.equals("0.0")) {
                existingDisplay = "";
                Log.d("numberEntered", "existingDisplay is " + existingDisplay + "in existingDisplay.equals==0");
            }


            Log.d("numberEntered", "existingDisplay is " + existingDisplay + "right before finalDisplayText is calculated");
            finalDisplayText = existingDisplay + number;
            System.out.println("1 text = " + finalDisplayText);
        }

        private void toggleSign() {
            double number = Double.parseDouble(currentDisplayText);

            number = -number;
            System.out.println("Number is " + number);

            finalDisplayText = Double.valueOf(number).toString();
        }

        private void clearScreen(String clearButtonText) {
            switch (clearButtonText) {
                case "CE":
                    finalDisplayText = "0";
                    break;

                case "C":
                    finalDisplayText = "0";
                    num1 = 0;
                    operator = "";
                    break;
            }
        }

        private void backspaceEntered() {
            Log.d("backspaceEntered", Boolean.valueOf(shouldClearText).toString());
            if (shouldClearText == true) {
                finalDisplayText = "0.0";
                return;
            }

            int length = currentDisplayText.length();

            if (length > 0) {
                String newText = currentDisplayText.substring(0, length - 1);

                if (newText.equals("-")) {
                    newText = "0";
                }

                if (newText.equals("")) {
                    newText = "0";
                }

                finalDisplayText = newText;
            }

        }

        private void operatorEntered(String operation) {
            Log.d("operatorEntered", "invoked");
            System.out.println("current_display_text: " + currentDisplayText);
            num1 = Double.parseDouble(currentDisplayText);

            if (!operator.equals("")) {
                performOperation(result, num1, "" + operator);
                finalDisplayMiniText = currentDisplayMiniText + " " + currentDisplayText + " " + operation;
            } else {
                result = num1;
                finalDisplayMiniText = currentDisplayText + " " +  operation;
            }

            operator = operation;

            Log.d("operatorEntered", Boolean.valueOf(shouldClearText).toString());
            shouldClearText = true;
        }

        private void miscOperatorEntered(String operation) {
            Log.d("miscOperatorEntered", operation);
        }

        private void calculateResult() {
            double num2 = Double.parseDouble(currentDisplayText);

            performOperation(result, num2, operator);

            finalDisplayText = String.valueOf(result);


            num1 = 0.0;
            operator = "";
            result = 0.0;
            finalDisplayMiniText = String.valueOf(num1);
            shouldClearText = true;
        }

        private void calculateReciprocal() {
            if (currentDisplayText.equalsIgnoreCase("0.0")) {
                finalDisplayText = "To Infinity and beyond!";
                // TODO: Do I need an isCalculatable kind of variable? What if the user does a -1 on this?
            } else {
                double num2 = Double.parseDouble(currentDisplayText);
                num2 = 1 / num2;
                finalDisplayText = String.valueOf(num2);
            }
            num1 = 0.0;
            operator = "";
            result = 0.0;
            finalDisplayMiniText = String.valueOf(num1);
            shouldClearText = true;
        }

        private void performOperation(double num1, double num2, String op) {
            switch (op) {
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "+":
                    result = num1 + num2;
                    break;
                default:

            }

        }

        private void performMemoryOperation(String operation) {
            switch (operation) {
                case "MC":
                    memory = 0;
                    break;
                case "MR":
                    currentDisplayText = "" + memory;
                    break;
                case "MS":
                    memory = Double.parseDouble(currentDisplayText);
                    break;
                case "M+":
                    memory = memory + Double.parseDouble(currentDisplayText);
                    break;
                case "M-":
                    memory = memory - Double.parseDouble(currentDisplayText);
                    break;
                default:

            }
        }
    }
}
