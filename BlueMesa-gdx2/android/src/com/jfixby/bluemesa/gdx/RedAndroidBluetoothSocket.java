
package com.jfixby.bluemesa.gdx;

import java.io.IOException;
import java.io.InputStream;

import android.bluetooth.BluetoothSocket;

import com.jfixby.bluemesa.AndroidBluetoothSocket;

public class RedAndroidBluetoothSocket implements AndroidBluetoothSocket {

	private final BluetoothSocket socket;

	public RedAndroidBluetoothSocket (final BluetoothSocket createInsecureRfcommSocketToServiceRecord) {
		this.socket = createInsecureRfcommSocketToServiceRecord;
	}

	@Override
	public void connect () throws IOException {
		this.socket.connect();
	}

	@Override
	public InputStream getInputStream () throws IOException {
		return this.socket.getInputStream();
	}

}
