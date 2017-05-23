
package com.jfixby.bluemesa.gdx;

import android.os.ParcelUuid;

import com.jfixby.bluemesa.AndroidParcelUuid;

public class RedAndroidParcelUuid implements AndroidParcelUuid {

	private final ParcelUuid x;

	public RedAndroidParcelUuid (final ParcelUuid x) {
		this.x = x;
	}

	@Override
	public String getString () {
		return this.x.toString();
	}

}
