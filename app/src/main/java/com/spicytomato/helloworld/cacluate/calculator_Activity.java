package com.spicytomato.helloworld.cacluate;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.spicytomato.helloworld.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class calculator_Activity extends Activity {
    final int ONE = R.id.one_button;
    final int TWO = R.id.two_button;
    final int THREE = R.id.three_button;
    final int FOUR = R.id.four_button;
    final int FIVE = R.id.five_button;
    final int SIX = R.id.six_button;
    final int SEVEN = R.id.seven_button;
    final int EIGHT = R.id.eight_button;
    final int NINE = R.id.nine_button;
    final int ZERO = R.id.zero_button;
    final int POINT = R.id.point_button;
    final int AC = R.id.AC_button;
    final int RESULT = R.id.result_button;
    final int POSITIVE = R.id.positive_button;
    final int ADD = R.id.add_button;
    final int SUBTRACT = R.id.subtract_button;
    final int DIVIDE = R.id.divide_button;
    final int MULTIPLY = R.id.multiply_button;
    final int REMAINDER = R.id.remainder_button;

    private Button mButtonRemainder;
    private Button mButtonDivide;
    private Button mButtonAdd;
    private Button mButtonMultiply;
    private Button mButtonSubtract;
    private Button mButtonResult;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private TextView mTextViewResult;
    private Button mButtonAC;
    private Button mButtonPositive;
    private List<BigDecimal> mDoubleList;
    private int mLastCalculate;
    private boolean mIsClear = true;
    private Button mButtonZero;
    private Button mButtonPoint;
    private Boolean mIsAC;
    private int mNowCalculate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        GridLayout gridLayout = findViewById(R.id.gridlayout);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        int column = gridLayout.getColumnCount();
        int row = gridLayout.getRowCount();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            if (gridLayout.getChildAt(i).getId() != R.id.result_textview) {
                Button button = (Button) gridLayout.getChildAt(i);
                button.setWidth(screenWidth / column);
                button.setHeight(screenHeight / row);
            } else {
                TextView textView = (TextView) gridLayout.getChildAt(i);
                textView.setWidth(screenWidth / column);
                textView.setHeight(screenHeight / row);
            }
        }


        mButtonAC = findViewById(R.id.AC_button);

        mButtonRemainder = findViewById(R.id.remainder_button);
        mButtonDivide = findViewById(R.id.divide_button);
        mButtonAdd = findViewById(R.id.add_button);
        mButtonMultiply = findViewById(R.id.multiply_button);
        mButtonSubtract = findViewById(R.id.subtract_button);
        mButtonResult = findViewById(R.id.result_button);
        mButtonPositive = findViewById(R.id.positive_button);

        mButtonOne = findViewById(R.id.one_button);
        mButtonTwo = findViewById(R.id.two_button);
        mButtonThree = findViewById(R.id.three_button);
        mButtonFour = findViewById(R.id.four_button);
        mButtonFive = findViewById(R.id.five_button);
        mButtonSix = findViewById(R.id.six_button);
        mButtonSeven = findViewById(R.id.seven_button);
        mButtonEight = findViewById(R.id.eight_button);
        mButtonNine = findViewById(R.id.nine_button);
        mButtonZero = findViewById(R.id.zero_button);
        mButtonPoint = findViewById(R.id.point_button);

        mTextViewResult = findViewById(R.id.result_textview);


        mDoubleList = new ArrayList<>();

        OperateListener operateListener = new OperateListener();
        NumberListener numberListener = new NumberListener();

        mButtonAC.setOnClickListener(operateListener);
        mButtonRemainder.setOnClickListener(operateListener);
        mButtonDivide.setOnClickListener(operateListener);
        mButtonAdd.setOnClickListener(operateListener);
        mButtonMultiply.setOnClickListener(operateListener);
        mButtonSubtract.setOnClickListener(operateListener);
        mButtonResult.setOnClickListener(operateListener);
        mButtonRemainder.setOnClickListener(operateListener);

        mButtonPositive.setOnClickListener(numberListener);

        mButtonOne.setOnClickListener(numberListener);
        mButtonTwo.setOnClickListener(numberListener);
        mButtonThree.setOnClickListener(numberListener);
        mButtonFour.setOnClickListener(numberListener);
        mButtonFive.setOnClickListener(numberListener);
        mButtonSix.setOnClickListener(numberListener);
        mButtonSeven.setOnClickListener(numberListener);
        mButtonEight.setOnClickListener(numberListener);
        mButtonNine.setOnClickListener(numberListener);
        mButtonZero.setOnClickListener(numberListener);
        mButtonPoint.setOnClickListener(numberListener);

        mDoubleList.add(0, new BigDecimal("0"));

        mTextViewResult.setText("0");
        mTextViewResult.setEnabled(false);

    }

    private class NumberListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case ONE:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "1");
                    else {
                        mTextViewResult.setText("1");
                        mIsClear = false;
                    }
                    break;
                case TWO:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "2");
                    else {
                        mTextViewResult.setText("2");
                        mIsClear = false;
                    }
                    break;
                case THREE:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "3");
                    else {
                        mTextViewResult.setText("3");
                        mIsClear = false;
                    }
                    break;
                case FOUR:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "4");
                    else {
                        mTextViewResult.setText("4");
                        mIsClear = false;
                    }
                    break;
                case FIVE:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "5");
                    else {
                        mTextViewResult.setText("5");
                        mIsClear = false;
                    }
                    break;
                case SIX:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "6");
                    else {
                        mTextViewResult.setText("6");
                        mIsClear = false;
                    }
                    break;
                case SEVEN:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "7");
                    else {
                        mTextViewResult.setText("7");
                        mIsClear = false;
                    }
                    break;
                case EIGHT:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "8");
                    else {
                        mTextViewResult.setText("8");
                        mIsClear = false;
                    }
                    break;
                case NINE:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "9");
                    else {
                        mTextViewResult.setText("9");
                        mIsClear = false;
                    }
                    break;
                case ZERO:
                    if (!mIsClear)
                        mTextViewResult.setText(mTextViewResult.getText() + "0");
                    else {
                        mTextViewResult.setText("0");
                        mIsClear = false;
                    }
                    break;
                case POSITIVE:
                    String old = mTextViewResult.getText().toString();
                    if (old.charAt(0) == '-') {
                        String newS = (String) old.subSequence(1, mTextViewResult.length());
                        mTextViewResult.setText(newS);
                    } else {
                        mTextViewResult.setText("-" + old);
                    }
                    break;
                //TODO
                //还要注意格式不规范无法进行计算
                case POINT:
                    if (!mTextViewResult.getText().toString().matches("[0-9]{1,}.[0-9]*+")) {
                        Log.d("mTextViewResult", "ok");
                        mTextViewResult.setText(mTextViewResult.getText().toString() + ".");
                        mIsClear = false;
                    }
//                    mTextViewResult.setText(mTextViewResult.getText() + ".");
                    break;
                default:
                    break;
            }
        }
    }

    private class OperateListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (mTextViewResult.getText().toString() != null && mTextViewResult.getText().toString().length() != 0) {
                String content = mTextViewResult.getText().toString();
                BigDecimal num = new BigDecimal(content);
                switch (v.getId()) {
                    case ADD:
                        mNowCalculate = 0;
                        mDoubleList.add(0, num);
                        mIsClear = true;
                        break;
                    case SUBTRACT:
                        mNowCalculate = 1;
                        mDoubleList.add(0, num);
                        mIsClear = true;
                        break;
                    case MULTIPLY:
                        mNowCalculate = 2;
                        mDoubleList.add(0, num);
                        mIsClear = true;
                        break;
                    case DIVIDE:
                        mNowCalculate = 3;
                        mDoubleList.add(0, num);
                        mIsClear = true;
                        break;
                    case REMAINDER:
                        mNowCalculate = 6;
                        mDoubleList.add(0, num);
                        mIsClear = true;
                        break;
                    case AC:
                        getResult(5, 5);
                        mIsClear = true;
                        break;
                    case RESULT:
                        getResult(mLastCalculate, mNowCalculate);
                        mNowCalculate = 0;
                        break;
                    default:
                        break;

                }
            }
        }
    }


    private void getResult(int lastCalculate, int nowCalculate) {
        if (mTextViewResult.getText().toString() != null && mTextViewResult.getText().toString().length() != 0) {
            String content = mTextViewResult.getText().toString();
            BigDecimal num = new BigDecimal(content);
            switch (nowCalculate) {
                case 0:
                    BigDecimal bigDecimal = mDoubleList.get(0).add(num);
                    mTextViewResult.setText(bigDecimal.toString());
                    mDoubleList.clear();
                    mDoubleList.add(0, bigDecimal);
                    break;
                case 1:
                    BigDecimal bigDecimal1 = mDoubleList.get(0).subtract(num);
                    mTextViewResult.setText(bigDecimal1.toString());
                    mDoubleList.clear();
                    mDoubleList.add(0, bigDecimal1);
                    break;
                case 2:
                    BigDecimal bigDecimal2 = mDoubleList.get(0).multiply(num);
                    mTextViewResult.setText(bigDecimal2.toString());
                    mDoubleList.clear();
                    mDoubleList.add(0, bigDecimal2);
                    break;
                case 3:
                    if (!num.multiply(new BigDecimal("8")).toString().equals(new String("0"))) {
                        BigDecimal bigDecimal3 = mDoubleList.get(0).divide(num);
                        mTextViewResult.setText(bigDecimal3.toString());
                        mDoubleList.clear();
                        mDoubleList.add(0, bigDecimal3);
                    } else {
                        Toast.makeText(this, "被除数不能为0", Toast.LENGTH_LONG).show();
                        mDoubleList.clear();
                        mDoubleList.add(0, num);
                    }

                    break;
                case 4:
                    mTextViewResult.setText(mDoubleList.get(0).toString());
                    break;
                case 5:
                    mDoubleList.clear();
                    mDoubleList.add(0, new BigDecimal("0"));
                    mTextViewResult.setText("0");
                    mIsAC = true;
                    break;
                case 6:
                    BigDecimal bigDecimal4 = mDoubleList.get(0).remainder(num);
                    mTextViewResult.setText(bigDecimal4.toString());
                    mDoubleList.clear();
                    mDoubleList.add(0, bigDecimal4);
                    break;
                default:
                    break;
            }
        }
        mIsClear = true;
    }
}
