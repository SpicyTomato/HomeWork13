package com.spicytomato.helloworld.cacluate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    final int AC = R.id.AC_button;
    final int RESULT = R.id.result_button;
    final int POSITIVE = R.id.positive_button;
    final int ADD = R.id.add_button;
    final int SUBTRACT = R.id.subtract_button;
    final int DIVIDE = R.id.divide_button;
    final int MULTIPLY = R.id.multiply_button;

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
    private int mCalculate = -1;
    private List<BigDecimal> mDoubleList;
    private int mLastCalculate;
    private boolean mIsClear = true;
    private Button mButtonZero;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        //TODO
        //小数按钮


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

        mTextViewResult = findViewById(R.id.result_textview);

        mDoubleList = new ArrayList<>();

        OperateListener operateListener = new OperateListener();
        NumberListener numberListener = new NumberListener();

        mButtonAC.setOnClickListener(operateListener);
        mButtonRemainder.setOnClickListener(operateListener);
        mButtonAdd.setOnClickListener(operateListener);
        mButtonMultiply.setOnClickListener(operateListener);
        mButtonSubtract.setOnClickListener(operateListener);
        mButtonResult.setOnClickListener(operateListener);
        mButtonPositive.setOnClickListener(operateListener);

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

        mDoubleList.add(0,new BigDecimal("0"));

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
                        old.subSequence(1, mTextViewResult.length());
                        mTextViewResult.setText("+" + old);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private class OperateListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case ADD:
                    getResult(mLastCalculate,0);
                    break;
                case SUBTRACT:
                    getResult(mLastCalculate,1);
                    break;
                case MULTIPLY:
                    getResult(mLastCalculate,2);
                    break;
                case DIVIDE:
                    getResult(mLastCalculate,3);
                    break;
                case AC:
                    mTextViewResult.setText("0");
                    break;
                case RESULT:
                    getResult(mCalculate, 4);
                    break;

            }
        }
    }


    private void getResult(int lastCalculate, int nowCalculate) {
        if (mTextViewResult.getText().toString() != null && mTextViewResult.getText().toString().length() != 0) {
            String content = mTextViewResult.getText().toString();
            BigDecimal num = new BigDecimal(content);
            if (lastCalculate != -1) {
                switch (lastCalculate) {
                    case 0:
                        BigDecimal bigDecimal = mDoubleList.get(0).add(num);
                        mTextViewResult.setText(bigDecimal.toString());
                        mDoubleList.clear();
                        mDoubleList.add(0, bigDecimal);
                        if (nowCalculate != 4) {
                            mLastCalculate = nowCalculate;
                        } else {
                            mLastCalculate = -1;
                        }
                        break;
                    case 1:
                        BigDecimal bigDecimal1 = mDoubleList.get(0).subtract(num);
                        mTextViewResult.setText(bigDecimal1.toString());
                        mDoubleList.clear();
                        mDoubleList.add(0, bigDecimal1);
                        if (nowCalculate != 4) {
                            mLastCalculate = nowCalculate;
                        } else {
                            mLastCalculate = -1;
                        }

                        break;
                    case 2:
                        BigDecimal bigDecimal2 = mDoubleList.get(0).multiply(num);
                        mTextViewResult.setText(bigDecimal2.toString());
                        mDoubleList.clear();
                        mDoubleList.add(0, bigDecimal2);
                        if (nowCalculate != 4) {
                            mLastCalculate = nowCalculate;
                        } else {
                            mLastCalculate = -1;
                        }
                        break;
                    case 3:
                        BigDecimal bigDecimal3 = mDoubleList.get(0).divide(num);
                        mTextViewResult.setText(bigDecimal3.toString());
                        mDoubleList.clear();
                        mDoubleList.add(0, bigDecimal3);
                        if (nowCalculate != 4) {
                            mLastCalculate = nowCalculate;
                        } else {
                            mLastCalculate = -1;
                        }
                        break;
                    case 4:
                        mTextViewResult.setText(mDoubleList.get(0).toString());
                        break;
                }
            } else {
                mDoubleList.clear();
                mDoubleList.add(0, num);
                mLastCalculate = nowCalculate;
            }
        }
        mIsClear = true;
    }
}
