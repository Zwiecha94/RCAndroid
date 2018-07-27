package gui;

import com.example.rca.R;

import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import properties.Cement;
import properties.Concrete;
import properties.Dimensions;
import properties.Forces;
import properties.Reinforcement;

@SuppressWarnings({ "deprecation", "unused" })
public class MainActivity extends ActivityGroup {
	static Forces forces = new Forces();
	static Dimensions dimenstions = new Dimensions();
	static Concrete concrete = new Concrete();
	static Reinforcement reinforcement = new Reinforcement();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Forces forces = new Forces();
		//ForcesActivity forcesActivity = new ForcesActivity(forces);
		
		SpannableString s = new SpannableString("Reinforced Concrete Design");
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        
        setTitle(s);
		

		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this.getLocalActivityManager());

		TabSpec tab1 = tabHost.newTabSpec("Start");
		TabSpec tab2 = tabHost.newTabSpec("Materia³y");
		TabSpec tab3 = tabHost.newTabSpec("Wymiary");
		TabSpec tab4 = tabHost.newTabSpec("Wyniki");

		tab1.setIndicator("Start");
		tab1.setContent(new Intent(this, ForcesActivity.class));
		tab2.setIndicator("Materia³y");
		tab2.setContent(new Intent(this, MaterialsActivity.class));
		tab3.setIndicator("Wymiary");
		tab3.setContent(new Intent(this, DimensionsActivity.class));
		tab4.setIndicator("Wyniki");
		tab4.setContent(new Intent(this, ResultsActivity.class));
		/*
		tab4.setIndicator("Test");
		tab4.setContent(new Intent(this, TestActivity.class));
		*/
		
		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
		tabHost.addTab(tab3);
		tabHost.addTab(tab4);

		TabWidget tw = (TabWidget) tabHost.findViewById(android.R.id.tabs);
		for (int i = 0; i < tw.getChildCount(); ++i) {
			View tabView = tw.getChildTabViewAt(i);
			TextView tv = (TextView) tabView.findViewById(android.R.id.title);
			tv.setTextSize(16);
			tv.setTextColor(Color.parseColor("#FFFFFF"));
		}
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */
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
