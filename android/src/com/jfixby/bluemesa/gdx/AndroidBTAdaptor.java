
package com.jfixby.bluemesa.gdx;

import com.jfixby.bluemesa.*;
import com.jfixby.scarabei.api.collections.CollectionConverter;
import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.jfixby.scarabei.api.log.L;

public class AndroidBTAdaptor implements AndroidBluetoothAdapter {

	@Override
	public Set<AndroidBluetoothDevice> getBondedDevices () {
		L.d("getting adaptor");
		final BluetoothAdapter ad = BluetoothAdapter.getDefaultAdapter();
		L.d("getting adaptor",ad);
		final java.util.Set<BluetoothDevice> devices = ad.getBondedDevices();
		L.d("devices",devices);
		final Set<BluetoothDevice> in = Collections.newSet(devices);
		final Set<AndroidBluetoothDevice> output = Collections.newSet();
		Collections.convertCollection(in, output, new CollectionConverter<BluetoothDevice, AndroidBluetoothDevice>() {

			@Override
			public AndroidBluetoothDevice convert (final BluetoothDevice input) {
				return new RedAndroidBluetoothDevice(input);
			}

		});
		output.print("devices list");
		return output;
	}

}
