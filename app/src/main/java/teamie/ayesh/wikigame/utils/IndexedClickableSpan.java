package teamie.ayesh.wikigame.utils;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ayesh on 9/10/15.
 */
public class IndexedClickableSpan extends ClickableSpan {

    int startIndex, endIndex;
    private Context context;
    private String text;

    public IndexedClickableSpan(int startIndex, int endIndex, Context context, String text) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.context = context;
        this.text = text;
    }

    @Override
    public void onClick(View widget) {
        String word = text.substring(startIndex, endIndex);
        Toast.makeText(context, "You clicked on " + word, Toast.LENGTH_SHORT).show();
    }
}