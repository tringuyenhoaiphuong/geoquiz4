package com.lemycanh.geoquiz4;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    ArrayList<Question> mQuestionList;
    int mCurrentQuestionIndex;

    @BindView(R.id.btn_traloidung)
    Button mBtnTraLoiDung;

    @BindView(R.id.btn_traloisai)
    Button mBtnTraLoiSai;

    @BindView(R.id.tv_cauhoi)
    TextView mTvCauHoi;

    @OnClick(R.id.btn_traloidung)
    void OnBtnTraLoiDungClick(View v) {
        Toast.makeText(MainActivity.this, R.string.traloidung, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_traloisai)
    void OnBtnTraLoiSaiClick(View v) {
        Toast.makeText(MainActivity.this, R.string.traloisai, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loadQuestion();
        showQuestion();
    }

    private void showQuestion() {
        mTvCauHoi.setText(mQuestionList.get(mCurrentQuestionIndex).getCauHoi());
    }

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
