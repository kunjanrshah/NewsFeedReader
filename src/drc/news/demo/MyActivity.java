package drc.news.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MyActivity  extends Activity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setTitle( "OSU Sports News" );
        setContentView( createList( this ) );
    }

    private View createList( Activity activity )
    {
        LinearLayout mainPanel = new LinearLayout( activity );
        ListView listView = new ListView( activity );
        final FeedListAdapter feedListAdapter = new FeedListAdapter( activity );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener()
        {
            public void onItemClick( AdapterView<?> parentView, View childView, int position, long id )
            {
                feedListAdapter.click( position );
            }
        } );
        listView.setAdapter( feedListAdapter );
        mainPanel.addView( listView );
        return mainPanel;
    }
}
