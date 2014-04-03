package myjebbraintut3.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView message;
    private ImageView droid;
    private View.OnClickListener droidTapListener;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //
        initializeApp();
    }

    private void initializeApp() {
        message = (TextView) findViewById(R.id.message);
        droid = (ImageView) findViewById(R.id.imageView);

        droidTapListener = new View.OnClickListener() {
            public void onClick(View v) {
                //
                touchDroid();
            }
        };
        droid.setOnClickListener(droidTapListener);
    }

    private void touchDroid() {
        counter++;
        //
        String temp = getStringForDisplay(counter);
        message.setText(String.format("You touched the droid %s", temp));
    }

    private String getStringForDisplay(int count) {
        String temp;
        switch (count) {
            case 1:
                temp = "once";

                break;
            case 2:
                temp = "twice";
                break;
            default:
                temp = String.format("%d times", count);
        }

        return temp;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
