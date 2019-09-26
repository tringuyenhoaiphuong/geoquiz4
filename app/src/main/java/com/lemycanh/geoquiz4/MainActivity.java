package com.lemycanh.geoquiz4;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    final String TAG = "GeoQuiz";

    ArrayList<Question> mQuestionList;
    int mCurrentQuestionIndex;

    @BindView(R.id.btn_traloidung)
    Button mBtnTraLoiDung;

    @BindView(R.id.btn_traloisai)
    Button mBtnTraLoiSai;

    @BindView(R.id.btn_previous)
    ImageButton mBtnPrevious;

    @BindView(R.id.btn_next)
    ImageButton mBtnNext;

    @BindView(R.id.tv_cauhoi)
    TextView mTvCauHoi;

    @OnClick(R.id.btn_traloidung)
    void OnBtnTraLoiDungClick(View v) {
        answer(true);
    }

    @OnClick(R.id.btn_traloisai)
    void OnBtnTraLoiSaiClick(View v) {
        answer(false);
    }

    private void answer(boolean b) {
        Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
        if(currentQuestion.IsTrue() == b) {
            Toast.makeText(MainActivity.this, R.string.traloidung, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.traloisai, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_next)
    void OnBtnNextClick(View v) {
        if(mCurrentQuestionIndex == mQuestionList.size() - 1) return;
        mCurrentQuestionIndex++;
        showQuestion();
    }

    @OnClick(R.id.btn_previous)
    void OnBtnPreviousClick(View v) {
        if(mCurrentQuestionIndex == 0) return;
        mCurrentQuestionIndex--;
        showQuestion();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loadQuestion();
        showQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState called");
        outState.putInt("CurrentQuestionIndex", mCurrentQuestionIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState called");
        mCurrentQuestionIndex = savedInstanceState.getInt("CurrentQuestionIndex");
        showQuestion();
    }

    private void showQuestion() {
        mTvCauHoi.setText(mQuestionList.get(mCurrentQuestionIndex).getCauHoi());
    }
//   https://github.com/lemycanh/geoquiz4.git
    private void loadQuestion() {
        mQuestionList = new ArrayList<Question>();
        String cauhois[] = getResources().getStringArray(R.array.danhsachcauhoi);
        TypedArray tralois = getResources().obtainTypedArray(R.array.danhsachtraloi);
        mQuestionList.add(new Question(cauhois[0], tralois.getBoolean(0, false)));
        mQuestionList.add(new Question(cauhois[1], tralois.getBoolean(1, false)));
        mQuestionList.add(new Question(cauhois[2], tralois.getBoolean(2, false)));
        mCurrentQuestionIndex = 0;
    }
}
