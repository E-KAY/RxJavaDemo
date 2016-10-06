package com.nd.android.rxjavademo.activity;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.adapter.MainListDataAdapter;
import com.nd.android.rxjavademo.data.IMainListData;
import com.nd.android.rxjavademo.data.MainListDataFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * MainListActivity
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public class MainListActivity extends BaseCompatActivity {

    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
        }

        setSupportActionBar(toolbar);
    }

    private void initData() {
        StickyListHeadersListView listView = (StickyListHeadersListView) findViewById(R.id.lv_datas);
        MainListDataAdapter mainListDataAdapter = new MainListDataAdapter(this);
        if (listView != null) {
            listView.setAdapter(mainListDataAdapter);
        }
        List<IMainListData> mainListDatas = MainListDataFactory.getInstance().getMainListDatas();

        Collections.sort(mainListDatas, new Comparator<IMainListData>() {
            @Override
            public int compare(IMainListData lhs, IMainListData rhs) {

                int result = lhs.getMainTitle() - rhs.getMainTitle();
                if (result == 0) {
                    result = lhs.getSubTitle() - rhs.getSubTitle();
                }
                return result;
            }
        });

        mainListDataAdapter.setDataList(mainListDatas);
    }

    private void initSearchViewEvent() {
        if (mSearchView == null) {
            return;
        }

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_list_activity, menu);
        MenuItem createItem = menu.findItem(R.id.mi_main_search);
        mSearchView = (SearchView) createItem.getActionView();
        initSearchViewEvent();
        return true;
    }


}
