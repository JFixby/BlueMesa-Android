
package com.jfixby.bluemesa.gdx;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.jfixby.bluemesa.BlueMesaAndroid;
import com.jfixby.scarabei.android.api.AndroidComponent;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.android.ScarabeiAndroid;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

public class AndroidLauncher extends AndroidApplication implements com.jfixby.bluemesa.AndroidApplication {
	private static final String DEVICE_ID = "98D331B2B6D3";

	@Override
	protected void onCreate (final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		this.initialize(new EntryPoint(), config);

		final AndroidComponent x = new AndroidComponentX();

		ScarabeiAndroid.deploy(x);
		L.d("ScarabeiAndroid deployed!");
		final BlueMesaAndroid bm = new BlueMesaAndroid(this, DEVICE_ID);

		bm.run();

	}

	@Override
	public void requestBT () {
		final Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		this.startActivityForResult(turnOn, 0);
	}

	@Override
	public com.jfixby.bluemesa.AndroidBluetoothAdapter getAdaptor () {
		return new AndroidBTAdaptor();
	}

}
