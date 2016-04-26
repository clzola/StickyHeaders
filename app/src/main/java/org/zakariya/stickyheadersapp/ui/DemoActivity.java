package org.zakariya.stickyheadersapp.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import org.zakariya.stickyheaders.SectioningAdapter;
import org.zakariya.stickyheadersapp.R;

/**
 * Created by shamyl on 4/26/16.
 */
public class DemoActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		progressBar = (ProgressBar) findViewById(R.id.progress);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;

			case R.id.reloadMenuItem:
				RecyclerView.Adapter adapter = recyclerView.getAdapter();
				if (adapter instanceof SectioningAdapter){
					((SectioningAdapter)adapter).notifyAllSectionsDataSetChanged();
				} else {
					adapter.notifyDataSetChanged();
				}
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
