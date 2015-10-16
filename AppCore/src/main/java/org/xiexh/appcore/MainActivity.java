package org.xiexh.appcore;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import org.xiexh.appcore.xmlparser.DomParserTest;
import org.xiexh.appcore.xmlparser.PrintRivers;
import org.xiexh.appcore.xmlparser.PullPraserTest;
import org.xiexh.appcore.xmlparser.SAXParserTest;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      DomParserTest dom = new DomParserTest();
//        SAXParserTest sax = new SAXParserTest();
        PullPraserTest pull = new PullPraserTest();
        PrintRivers.print(pull.getRiversFromXml("river.xml"));
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
