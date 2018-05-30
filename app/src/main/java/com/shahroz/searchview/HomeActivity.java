package com.shahroz.searchview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.shahroz.svlibrary.interfaces.onSearchListener;
import com.shahroz.svlibrary.interfaces.onSimpleSearchActionsListener;
import com.shahroz.svlibrary.utils.Util;
import com.shahroz.svlibrary.widgets.MaterialSearchView;

public class HomeActivity extends AppCompatActivity implements onSimpleSearchActionsListener, onSearchListener {
    private  FloatingActionButton fab;
    private MaterialSearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.showSnackBarMessage(view,"Its just here to make screen look pretty :D");
            }
        });

        mSearchView = (MaterialSearchView) findViewById(R.id.msv_test);
        mSearchView.setOnSearchListener(this);
        mSearchView.setSearchResultsListener(this);
        mSearchView.setHintText("Search");

        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSearchView.display();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearch(String query) {

    }

    @Override
    public void searchViewOpened() {
        Toast.makeText(HomeActivity.this,"Search View Opened",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchViewClosed() {
        Util.showSnackBarMessage(fab,"Search View Closed");
    }

    @Override
    public void onItemClicked(String item) {
        Toast.makeText(HomeActivity.this,item + " clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScroll() {

    }

    @Override
    public void error(String localizedMessage) {

    }

    @Override
    public void onCancelSearch() {
        Util.showSnackBarMessage(fab,"Search View Cleared");
        mSearchView.hide();
    }
}
