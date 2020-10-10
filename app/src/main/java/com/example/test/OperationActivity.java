package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.tools.EditTextWatcher;

public class OperationActivity extends AppCompatActivity {

    private TextView textView, textViewOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(OperationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        textView = findViewById(R.id.textName);
        textViewOperation = findViewById(R.id.operationName);
        setTextViewsFocusChangeListener(getIntent().getExtras().getInt("operation"));
    }
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(OperationActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

    private void setTextViewsFocusChangeListener(final int operationIdx) {
        textViewOperation.setText(getOperationNameByIndex(operationIdx));
        final int[] editTexts = new int[]{R.id.edNumerator1, R.id.edDenominator1, R.id.edNumerator2, R.id.edDenominator2};
        final EditText[] editTextComponents = new EditText[editTexts.length];
        for (int i = 0, textViewsLength = editTexts.length; i < textViewsLength; i++) {
            int textViewIdx = editTexts[i];
            editTextComponents[i] = findViewById(textViewIdx);
            editTextComponents[i].addTextChangedListener(new EditTextWatcher(new Runnable() {
                @Override
                public void run() {
                    closeKeyboard();
                }
            }));
            editTextComponents[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    boolean isCalc = true;
                    for (TextView component : editTextComponents) {
                        if (component.getText().length() <= 0) {
                            textView.setText("");
                            isCalc = false;
                            break;
                        }
                    }
                    if (isCalc) {
                        textView.setText(
                                doOperation(
                                        operationIdx,
                                        Integer.parseInt(editTextComponents[0].getText().toString()),
                                        Integer.parseInt(editTextComponents[1].getText().toString()),
                                        Integer.parseInt(editTextComponents[2].getText().toString()),
                                        Integer.parseInt(editTextComponents[3].getText().toString()))
                        );
                    }
                }
            });
        }
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager imn = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imn.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    private String getOperationNameByIndex(int index) {
        switch (index) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
            default:
                return "";
        }
    }

    private String doOperation(int operationIdx, int a1, int a2, int b1, int b2) {
        switch (operationIdx) {
            case 0:
                return plusDrob(a1, a2, b1, b2);
            case 1:
                return minusDrob(a1, a2, b1, b2);
            case 2:
                return umnDrob(a1, a2, b1, b2);
            case 3:
                return delDrob(a1, a2, b1, b2);
            default:
                throw new RuntimeException("Неподдерживаемый тип операции");
        }
    }

    /**
     * Метод вычисления суммы двух дробей
     *
     * @param a1 Числитель первой дроби
     * @param a2 Знаменатель первой дроби
     * @param b1 Числитель второй дроби
     * @param b2 Знаменатель второй дроби
     */
    public static String plusDrob(int a1, int a2, int b1, int b2) {
        //checkDigit(a1, a2, b1, b2);
        int noz = noz(a2, b2);
        int sum1 = noz / a2 * a1;
        int sum2 = noz / b2 * b1;
        int sum = sum1 + sum2;
        return getResult(sum, noz);
    }

    public String minusDrob(int a1, int a2, int b1, int b2) {
        int noz = noz(a2, b2);
        int sum1 = noz / a2 * a1;
        int sum2 = noz / b2 * b1;
        int sum = sum1 - sum2;
        return getResult(sum, noz);
    }

    public String umnDrob(int a1, int a2, int b1, int b2) {
        int sum = a1 * b1;
        int noz = a2 * b2;
        return getResult(sum, noz);
    }

    public String delDrob(int a1, int a2, int b1, int b2) {
        return umnDrob(a1, a2, b2, b1);
    }


    private static String getResult(int sum, int noz) {
        float sumD = (float) sum / noz;
        String s = "";
        int p = 0;
        if (Math.abs(sum) >= noz) {
            p = sum / noz;
            sum = sum - (p * noz);
        }
        if (p != 0) {
            s = "" + p;
        }
        if (sum != 0) {
            int coeff = getCoeffDevide(sum, noz);
            if (coeff != 0) {
                sum = sum / coeff;
                noz = noz / coeff;
            }
            s = ("".equals(s) ? "" : s + " ") + sum + "/" + noz;
        }
        if (p == 0 && sum == 0 && "".equals(s)) {
            s = "0";
        }
        System.out.println("Результат: " + s + " или в десятичном представлении = " + sumD);
        return s;
    }

    private static int noz(int a, int b) {
        if (a > b && a % b == 0) {
            return a;
        } else if (b % a == 0) {
            return b;
        }
        return a * b;
    }

    private static int getCoeffDevide(int sum, int noz) {
        int coeff = 0;
        int a = 10;
        if (noz % sum == 0) {
            return sum;
        }
        while (a >= 2) {
            if (sum % a == 0 && noz % a == 0) {
                sum = sum / a;
                noz = noz / a;
                if (coeff == 0) {
                    coeff = a;
                } else {
                    coeff = coeff * a;
                }
            } else {
                a--;
            }
        }
        return coeff;
    }
}

