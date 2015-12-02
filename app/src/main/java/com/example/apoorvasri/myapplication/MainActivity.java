package com.example.apoorvasri.myapplication;

        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private EditText inputTF;
    private TextView setsTF;
    private TextView returnLabel;
    private TextView falseLabel;
    private Stack sets;
    private boolean[] hashing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.inputTF = (EditText) this.findViewById(R.id.inputTF);
        this.setsTF = (TextView) this.findViewById(R.id.setsTF);
        this.returnLabel = (TextView) this.findViewById(R.id.returnLabel);
        this.falseLabel = (TextView) this.findViewById(R.id.falseLabel);
        this.sets = new Stack();
        this.hashing = new boolean[]{false, false, false, false, false, false, false, false, false, false};
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void StringtoSet(View v)
    {
        String temp = this.inputTF.getText().toString();
        this.inputTF.setText("");

        addBloomFilter(temp);
        this.sets.push(temp);

        this.setsTF.setText(this.sets.toString());
    }

    public void StringChecking(View v)
    {
        String temp = this.inputTF.getText().toString();
        if (BloomFilter(temp))
        {
            this.returnLabel.setText("INPUT IS PRESENT:)");
        }
        else
        {
            this.returnLabel.setText("INPUT FAILS BLOOM FILTER TEST:( ");
        }
        if (SetChecking(temp))
        {
            this.falseLabel.setText("INPUT IS IN THE SET!!");
        }
        else
        {
            this.falseLabel.setText("INPUT NOT IN THE SET!!:(");
        }
    }

    private boolean BloomFilter(String value)
    {
        int index = Math.abs(MurmurHash.hash32(value) % 10);
        if (this.hashing[index] == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean SetChecking(String value)
    {
        String[] setsArray = this.sets.toArray();
        for (int i = 0; i < setsArray.length; i++)
        {
            if (setsArray[i].equals(value))
            {
                return true;
            }
        }
        return false;
    }

    private void addBloomFilter(String value)
    {
        int index = Math.abs(MurmurHash.hash32(value) % 10);
        this.hashing[index] = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
