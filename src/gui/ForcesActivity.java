package gui;

import com.example.rca.R;
import util.ThemeUtils;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import properties.Forces;
import gui.MainActivity;

public class ForcesActivity extends Activity {
	Forces forces;
	private Button analysisSelectButton;
	private Button countButton;
	private ThemeUtils theme = new ThemeUtils();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forces);
				
		Spinner spinner = (Spinner) findViewById(R.id.reinforcementSpinner);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.reinforcement_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
	               ((TextView) adapterView.getChildAt(0)).setGravity(Gravity.CENTER);
	        }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
	 });
		addAnalysisButtonListener();
		
	}
	
	
	private void addCountButtonListener() {
		countButton = (Button) findViewById(R.id.countButton);
		countButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
			}
		});
	}
	
	private void addAnalysisButtonListener() {
		analysisSelectButton = (Button) findViewById(R.id.analysisSelectButton);
		analysisSelectButton.setText("Diagnostyka");
		analysisSelectButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if(analysisSelectButton.getText() == "Diagnostyka") {
					analysisSelectButton.setText("Projektowanie");
										
				} else {
					analysisSelectButton.setText("Diagnostyka");
										
				}
			}
		});
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.forces, menu);
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


