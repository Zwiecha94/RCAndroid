package util;

import com.example.rca.R;

import android.app.Activity;

import android.content.Intent;

public class ThemeUtils

{

	private static int cTheme;

	public final static int DESIGN = 0;

	public final static int DIAGNOSIS = 1;

	public void changeToTheme(Activity activity, int theme)

	{

		cTheme = theme;

		activity.finish();

		activity.startActivity(new Intent(activity, activity.getClass()));

	}

	public static void onActivityCreateSetTheme(Activity activity)

	{

		switch (cTheme)

		{

		case DESIGN:

			activity.setTheme(R.style.DesignAppTheme);

			break;

		case DIAGNOSIS:

			activity.setTheme(R.style.DiagnosisAppTheme);

			break;

		}

	}

}