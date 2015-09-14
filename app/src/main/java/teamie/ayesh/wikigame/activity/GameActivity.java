package teamie.ayesh.wikigame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import teamie.ayesh.wikigame.R;
import teamie.ayesh.wikigame.utils.IndexedClickableSpan;
import teamie.ayesh.wikigame.utils.Utils;

public class GameActivity extends AppCompatActivity {

    private final String text = "Sri Lanka has maritime borders with India to the northwest and the Maldives to the southwest.";
    private Toolbar mToolbar;
    private TextView textContainTextView;
    private int wordPos = 0;
    private String textHolder[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {


            overridePendingTransition(R.anim.animation_enter,
                    R.anim.animation_leave);


            wordPos = getWordPos();

            setContentView(R.layout.activity_game);

            UIInitialize();


            wordProcessLogic();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.exception), Toast.LENGTH_LONG).show();
            callBack();
        }
    }

    /**
     * word process method
     * @throws Exception
     */
    private void wordProcessLogic() throws Exception {
        try {

            textHolder = text.split(" ");

            textHolder[wordPos] = " 0000 ";

            int firstLength = 0 ;


            SpannableStringBuilder ssb = new SpannableStringBuilder();

            for (int i = 0; i < textHolder.length; i++) {

                if (i == wordPos){
                    firstLength =   ssb.length();
                }

                ssb.append(textHolder[i]+" ");

            }

            Log.e("firstLength",firstLength+"");

            ssb.setSpan(new IndexedClickableSpan(firstLength, firstLength+5, this, text), firstLength,
                    firstLength+5, Spanned.SPAN_POINT_MARK);

            textContainTextView.setText(ssb);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * get randam value for remove word
     * @return int word place
     * @throws Exception
     */
    private int getWordPos() throws Exception {
        try {

            int ran = Utils.getRandomNumber();

            return ran % (text.length());


        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Initailize UI Component
     * @throws Exception
     */
    private void UIInitialize() throws Exception {
        try {

            textContainTextView = (TextView) findViewById(R.id.textContainTextView);

            SpannableString ss = new SpannableString(text);
            //  create spans for "this", "is", "the" and "text"
//            ss.setSpan(new IndexedClickableSpan(0, 4,this,text), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new IndexedClickableSpan(5, 7, this, text), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            ss.setSpan(new IndexedClickableSpan(8, 11,this,text), 8, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            ss.setSpan(new IndexedClickableSpan(12, 16,this,text), 12, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


            textContainTextView.setText(ss);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * general back action
     */
    private void callBack() {
        finish();
    }

    @Override
    public void onBackPressed() {
        callBack();
    }


}
