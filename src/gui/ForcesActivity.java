package gui;

import com.example.rca.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import properties.Forces;
import util.CustomTextWatcher;

public class ForcesActivity extends Activity {
	private Forces forces = MainActivity.forces;
	private Button analysisSelectButton;
	private Button countButton;
	private EditText mEdEditText;
	private EditText mEkEditText;
	private EditText mEkltEditText;
	private EditText nEdEditText;
	private EditText vEdEditText;
	private EditText vEdRedEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forces);
		// Przypisanie przycisków z xml
		mEdEditText = (EditText) findViewById(R.id.mEdEditText);
		mEkEditText = (EditText) findViewById(R.id.mEkEditText);
		mEkltEditText = (EditText) findViewById(R.id.mEkltEditText);
		nEdEditText = (EditText) findViewById(R.id.nEdEditText);
		vEdEditText = (EditText) findViewById(R.id.vEdEditText);
		vEdRedEditText = (EditText) findViewById(R.id.vEdRedEditText);
		
		mEdEditText.setText("0");
		nEdEditText.setText("0");
		vEdEditText.setText("0");
		mEkEditText.setText("0");
		mEkltEditText.setText("0");
		vEdRedEditText.setText("0");
		
		
		//Listenery
		addListeners();
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
				if (analysisSelectButton.getText() == "Diagnostyka") {
					analysisSelectButton.setText("Projektowanie");

				} else {
					analysisSelectButton.setText("Diagnostyka");

				}
			}
		});
	}

	private void addListeners() {
		
		CustomTextWatcher mEdTtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (mEdEditText.getText().toString().length() == 0) {
					forces.setmEd(0.0);
				} else {
					forces.setmEd(Double.parseDouble(mEdEditText.getText().toString()));
				}
				System.out.println("MEd= " + forces.getmEd());
			}
		};
		mEdEditText.addTextChangedListener(mEdTtextWatcher);
		
		
		CustomTextWatcher mEkTtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (mEkEditText.getText().toString().length() == 0) {
					forces.setmEk(0.0);
				} else {
					forces.setmEk(Double.parseDouble(mEkEditText.getText().toString()));
				}
				System.out.println("MEk= " + forces.getmEk());
			}
		};
		mEkEditText.addTextChangedListener(mEkTtextWatcher);
		
		
		CustomTextWatcher mEkltTtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (mEkltEditText.getText().toString().length() == 0) {
					forces.setmEklt(0.0);
				} else {
					forces.setmEklt(Double.parseDouble(mEkltEditText.getText().toString()));
				}
				System.out.println("MEklt= " + forces.getmEklt());
			}
		};
		mEkltEditText.addTextChangedListener(mEkltTtextWatcher);

		
		CustomTextWatcher nEdTtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (nEdEditText.getText().toString().length() == 0) {
					forces.setnEd(0.0);
				} else {
					forces.setnEd(Double.parseDouble(nEdEditText.getText().toString()));
				}
				System.out.println("NEd= " + forces.getnEd());
			}
		};
		nEdEditText.addTextChangedListener(nEdTtextWatcher);

		
		CustomTextWatcher vEdTtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (vEdEditText.getText().toString().length() == 0) {
					forces.setvEd(0.0);
				} else {
					forces.setvEd(Double.parseDouble(vEdEditText.getText().toString()));
				}
				System.out.println("VEd= " + forces.getvEd());
			}
		};
		vEdEditText.addTextChangedListener(vEdTtextWatcher);
		
		
		CustomTextWatcher vEdRedTtextWatcher = new CustomTextWatcher() {
			@Override
			public void afterTextChanged(Editable editable) {

				if (vEdRedEditText.getText().toString().length() == 0) {
					forces.setvEdRed(0.0);
				} else {
					forces.setvEdRed(Double.parseDouble(vEdRedEditText.getText().toString()));
				}
				System.out.println("VEdRed= " + forces.getvEdRed());
			}
		};
		vEdRedEditText.addTextChangedListener(vEdRedTtextWatcher);

		Spinner reinforcementSpinner = (Spinner) findViewById(R.id.reinforcementSpinner);
		Spinner loadSpinner = (Spinner) findViewById(R.id.typeOfLoadSpinner);

		ArrayAdapter<CharSequence> reinforcementAdapter = ArrayAdapter.createFromResource(this,
				R.array.reinforcement_array, android.R.layout.simple_spinner_item);
		reinforcementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		reinforcementSpinner.setAdapter(reinforcementAdapter);

		reinforcementSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				((TextView) adapterView.getChildAt(0)).setGravity(Gravity.CENTER);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		ArrayAdapter<CharSequence> loadAdapter = ArrayAdapter.createFromResource(this, R.array.typeofload_array,
				android.R.layout.simple_spinner_item);
		loadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		loadSpinner.setAdapter(loadAdapter);

		loadSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				((TextView) adapterView.getChildAt(0)).setGravity(Gravity.CENTER);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		addAnalysisButtonListener();
		addCountButtonListener();
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
