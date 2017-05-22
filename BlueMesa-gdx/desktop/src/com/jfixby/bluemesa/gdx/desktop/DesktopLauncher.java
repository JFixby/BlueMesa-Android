
package com.jfixby.bluemesa.gdx.desktop;

import java.io.IOException;

import com.jfixby.bluemesa.GasSensorMessage;
import com.jfixby.bluemesa.GasSensorMessageReader;
import com.jfixby.bluemesa.GasSensorMessageReaderException;
import com.jfixby.bluemesa.GasSensorMessageReaderSpecs;
import com.jfixby.bluemesa.desktop.DekstopBTConnectionOpener;
import com.jfixby.bluemesa.sqs.DesktopMessageTransport;
import com.jfixby.bluemesa.sqs.MessageTransport;
import com.jfixby.bluemesa.sqs.MessageTransportSpecs;
import com.jfixby.scarabei.amazon.aws.RedAWS;
import com.jfixby.scarabei.api.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.aws.api.AWS;
import com.jfixby.scarabei.gson.GoogleGson;

public class DesktopLauncher {
	public static void main (final String[] arg) throws IOException {
		ScarabeiDesktop.deploy();
		AWS.installComponent(new RedAWS());
		Json.installComponent(new GoogleGson());
// final BTSpecs specs = ScarabeiBlueTooth.newBTSpecs();
// final BT bt = ScarabeiBlueTooth.newBT(specs);

// final RemoteDeviceDiscovery disco = new RemoteDeviceDiscovery();
// final Collection<BTDeviceInfo> list = disco.getDevices();
// list.print("list");

// final ServicesSearch search = new ServicesSearch();
// final Map<String, Map<String, String>> devices = search.getBluetoothDevices();
// devices.print("devices");
		final String DEVICE_ID = "98D331B2B6D3";
		final MessageTransportSpecs t_specs = new MessageTransportSpecs();
		t_specs.deviceID = DEVICE_ID;
		final MessageTransport transport = new DesktopMessageTransport(t_specs);
		final String url = "btspp://" + DEVICE_ID + ":1;authenticate=false;encrypt=false;master=false";
// final InputStream java_stream =;
		final GasSensorMessageReaderSpecs specs = new GasSensorMessageReaderSpecs();
		specs.url = (url);
		specs.deviceID = DEVICE_ID;
		final GasSensorMessageReader reader = new GasSensorMessageReader(specs);
		reader.open(new DekstopBTConnectionOpener());

		while (true) {
			GasSensorMessage message;
			try {
				message = reader.read();
				message.print();
				transport.send(message);
			} catch (final GasSensorMessageReaderException e) {
				L.d(e.toString());
			}

		}
// is.close();
// final BluetoothAdapter bta = new BluetoothAdapter();

// BluetoothDevice connect_device = mBluetoothAdapter.getRemoteDevice(address);
//
// try {
// BluetoothSocket socket = connect_device.createRfcommSocketToServiceRecord(my_UUID);
// socket.connect();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }

// final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
// new LwjglApplication(new EntryPoint(), config);
	}
}
