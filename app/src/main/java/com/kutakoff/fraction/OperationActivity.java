package com.kutakoff.fraction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kutakoff.fraction.MainActivity;
import com.kutakoff.fraction.R;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class OperationActivity extends AppCompatActivity {

    private static String SPEC_DELIMITER_FRACTION = "̸";

    private static Map<Character, String> specSymbolsUp = Collections.unmodifiableMap(new HashMap<Character, String>(){{
        put('0', "⁰");
        put('1', "¹");
        put('2', "²");
        put('3', "³");
        put('4', "⁴");
        put('5', "⁵");
        put('6', "⁶");
        put('7', "⁷");
        put('8', "⁸");
        put('9', "⁹");
    }});

    private static Map<Character, String> specSymbolsDown = Collections.unmodifiableMap(new HashMap<Character, String>(){{
        put('0', "₀");
        put('1', "₁");
        put('2', "₂");
        put('3', "₃");
        put('4', "₄");
        put('5', "₅");
        put('6', "₆");
        put('7', "₇");
        put('8', "₈");
        put('9', "₉");
    }});

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_operation);
        final Button button_back = findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (getIntent().getExtras() != null) {
            setTextViewsFocusChangeListener(getIntent().getExtras().getInt("operation"));
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OperationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setTextViewsFocusChangeListener(final int operationIdx) {
        TextView textViewOperation = findViewById(R.id.operationName);
        textViewOperation.setText(getOperationNameByIndex(operationIdx));
        final int[] editTexts = new int[]{R.id.edNumerator1, R.id.edDenominator1, R.id.edNumerator2, R.id.edDenominator2};
        final EditText[] editTextComponents = new EditText[editTexts.length];
        for (int i = 0, textViewsLength = editTexts.length; i < textViewsLength; i++) {
            int textViewIdx = editTexts[i];
            editTextComponents[i] = findViewById(textViewIdx);
        }
        final TextView textName = findViewById(R.id.textName);
        final Button button1 = findViewById(R.id.buttonCalculate);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                closeKeyboard();
                textName.setText(makeCheckAndGetResult(editTextComponents, operationIdx));
            }
        });
    }

    private String makeCheckAndGetResult(EditText[] editTextComponents, int operationIdx) {
        String sNum1 = editTextComponents[0].getText().toString();
        String sDenum1 = editTextComponents[1].getText().toString();
        String sNum2 = editTextComponents[2].getText().toString();
        String sDenum2 = editTextComponents[3].getText().toString();
        try {
            checkFractionsEmpty(sNum1, "числитель 1 дроби");
            checkFractionsEmpty(sDenum1, "знаменатель 1 дроби");
            checkFractionsEmpty(sNum2, "числитель 2 дроби");
            checkFractionsEmpty(sDenum2, "знаменатель 2 дроби");
        } catch (IllegalStateException e) {
            // Ошибка, возвращаем пустое значение
            return "";
        }
        int num1 = Integer.parseInt(sNum1);
        int denum1 = Integer.parseInt(sDenum1);
        int num2 = Integer.parseInt(sNum2);
        int denum2 = Integer.parseInt(sDenum2);

        if (denum1 == 0 || denum2 == 0) {
            Toast.makeText(getApplicationContext(), "Знаменатель не может иметь значение \"0\"", Toast.LENGTH_LONG).show();
            return "";
        } else {
            return doOperation(operationIdx, num1, denum1, num2, denum2);
        }
    }

    private void checkFractionsEmpty(String value, String checkPartName) throws IllegalStateException {
        if ("".equals(value)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Не заполнен " + checkPartName, Toast.LENGTH_LONG);
            toast.show();
            throw new IllegalStateException();
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imn = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imn.hideSoftInputFromWindow(view.getWindowToken(), 0);
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

    /**
     * Выполнить операцию
     *
     * @param operationIdx Номеер типа операции
     * @param a1 Числитель первой дроби
     * @param a2 Знаменатель первой дроби
     * @param b1 Числитель второй дроби
     * @param b2 Знаменатель второй дроби
     * @return Результат выполнения операции
     */
    public String doOperation(int operationIdx, int a1, int a2, int b1, int b2) {
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
        String s = "";
        int p = 0;
        if (noz != 0) {
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
                StringBuilder sumSResult = new StringBuilder();
                if (sum != 0) {
                    String sumS = Integer.toString(sum);
                    for (char ch : sumS.toCharArray()) {
                        sumSResult.append(specSymbolsUp.get(ch));
                    }
                }
                StringBuilder nozSResult = new StringBuilder();
                if (noz != 0) {
                    String nozS = Integer.toString(noz);
                    for (char ch : nozS.toCharArray()) {
                        nozSResult.append(specSymbolsDown.get(ch));
                    }
                }
                s += " " + sumSResult.toString() + "   " + SPEC_DELIMITER_FRACTION + nozSResult.toString();
            }
        }
        if ((p == 0 && sum == 0 && "".equals(s)) || noz == 0) {
            s = "0";
        }
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




