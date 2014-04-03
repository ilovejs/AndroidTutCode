package tut4.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
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
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main);

        initializeApp();

        // Is there any state from previous instances?
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            updateView();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("counter", counter);
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

    // Private members
    private void initializeApp() {
        message = (TextView) findViewById(R.id.message);
        droid = (ImageView) findViewById(R.id.imageView);

        droidTapListener = new View.OnClickListener() {
            public void onClick(View v) {
                touchDroid();
            }
        };
        droid.setOnClickListener(droidTapListener);
    }
    private void touchDroid() {
        counter++;
        updateView();
    }
    private void updateView() {
        if (counter == 0)   return;
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
}
