package com.thedancercodes.android.realm_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thedancercodes.android.realm_example.data.Dog;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mLog;

    // A private field representing Realm Class Instance
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLog = (TextView) findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());

        // Initialize the Realm Database
        Realm.init(this);
        realm = Realm.getDefaultInstance();

    }

    public void addData(View view) {
        try {
            realm.beginTransaction();
            realm.copyToRealm(new Dog(1,"Simba", 9));
            realm.copyToRealm(new Dog(2,"Moana", 4));
            realm.commitTransaction();
        } catch (RealmPrimaryKeyConstraintException e) {

            // back out the transition that is currently in effect
            realm.cancelTransaction();
        }

        // clear output on the screen
        clearLog(null);

        log("Data added to Realm");
    }

    public void queryData(View view) {
    }

    /**
     * Clear the output TextView
     * @param view The button the user clicked
     */
    public void clearLog(View view) {
        mLog.setText("");
    }

    /**
     * Logs a message - called initially by addData()
     *
     * @param message The message to display
     */
    private void log(String message) {
        Log.i(TAG, message);
        mLog.append(message + "\n");
        adjustScroll();
    }

    /**
     * Adjusts scroll vertically to ensure last line is displayed
     */
    private void adjustScroll() {
        final int scrollAmount = mLog.getLayout()
                .getLineTop(mLog.getLineCount()) - mLog.getHeight();
        if (scrollAmount > 0)
            mLog.scrollTo(0, scrollAmount);
        else
            mLog.scrollTo(0, 0);
    }

}
