package rs.ac.ni.pmf.kvizic;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    public static final String KEY_USERNAME = "USERNAME";
    public static final String KEY_SCORE = "SCORE";
    public static final ActivityResultContract<String, Integer> QUIZ_CONTRACT = new ActivityResultContract<String, Integer>() {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String input) {
            final Intent intent = new Intent(context, QuizActivity.class);
            intent.putExtra(KEY_USERNAME, input);
            return intent;
        }

        @Override
        public Integer parseResult(int i, @Nullable Intent intent) {
            if(intent == null){
                return  -1;
            }else{
                intent.getIntExtra(KEY_SCORE, 0);
            }
            return null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
}