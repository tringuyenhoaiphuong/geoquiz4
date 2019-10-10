package com.lemycanh.geoquiz4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheatActivity extends AppCompatActivity {

    private static final String CHEAT_INTENT_QUESTION_CONTENT = "CHEAT_INTENT_QUESTION_CONTENT";
    @BindView(R.id.tv_question_content)
    TextView mTvQuestionContent;

    @OnClick(R.id.btn_show_answer)
    void OnBtnShowAnswerClick(View v) {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        ButterKnife.bind(this);

        Intent startIntent = getIntent();
        String questionContent = startIntent.getStringExtra(CheatActivity.CHEAT_INTENT_QUESTION_CONTENT);
        mTvQuestionContent.setText(questionContent);
    }

    public static Intent createIntent(Context context, String questionContent) {
        Intent startCheatAcitivityIntent = new Intent(context, CheatActivity.class);
        startCheatAcitivityIntent.putExtra(CHEAT_INTENT_QUESTION_CONTENT, questionContent);
        return startCheatAcitivityIntent;
    }
}
