package gui;

import com.example.rca.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import properties.Reinforcement;
import util.CustomTextWatcher;

public class DimensionsActivity extends Activity {
	Reinforcement reinforcement = MainActivity.reinforcement;
	private EditText phiS1EditText;
	private EditText phiS2EditText;
	private EditText phiSw1EditText;
	private EditText phiSw2EditText;
	private EditText a1EditText;
	private EditText a2EditText;
	private EditText nSw1EditText;
	private EditText nSw2EditText;
	private EditText nS1EditText;
	private EditText nS2EditText;
	private EditText s1EditText;
	private EditText s2EditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dimensions);
		
		phiS1EditText = (EditText) findViewById(R.id.phiS1EditText);
		phiS2EditText = (EditText) findViewById(R.id.phiS2EditText);
		
		phiSw1EditText = (EditText) findViewById(R.id.phiSw1EditText);
		phiSw2EditText = (EditText) findViewById(R.id.phiSw2EditText);
		
		a1EditText = (EditText) findViewById(R.id.a1EditText);
		a2EditText = (EditText) findViewById(R.id.a2EditText);
		
		nSw1EditText = (EditText) findViewById(R.id.nSw1EditText);
		nSw2EditText = (EditText) findViewById(R.id.nSw2EditText);
		
		nS1EditText = (EditText) findViewById(R.id.nS1EditText);
		nS2EditText = (EditText) findViewById(R.id.nS2EditText);
		
		s1EditText = (EditText) findViewById(R.id.s1EditText);
		s2EditText = (EditText) findViewById(R.id.s2EditText);
		
		//wartoœci pocz¹tkowe
		phiS1EditText.setText("16");
		phiS2EditText.setText("16");
		a1EditText.setText("0.05");
		a2EditText.setText("0.05");
		nS1EditText.setText("0");
		nS2EditText.setText("0");
		
		phiSw1EditText.setText("8");
		phiSw2EditText.setText("8");
		nSw1EditText.setText("2");
		nSw2EditText.setText("0");
		s1EditText.setText("0");
		s2EditText.setText("0");
		
		addListeners();
	}

	private void addListeners() {
		CustomTextWatcher phiS1TtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (phiS1EditText.getText().toString().length() == 0) {
					reinforcement.setPhiS1(0.0);
				} else {
					reinforcement.setPhiS1(Double.parseDouble(phiS1EditText.getText().toString()));
				}
				System.out.println("\u03D5s1= " + reinforcement.getPhiS1());
			}
		};
		phiS1EditText.addTextChangedListener(phiS1TtextWatcher);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dimensions, menu);
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
