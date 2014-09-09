package example.common.crypto;

import example.common.crypto.impl.HashProviderFactoryImpl;

public class Crypto {

	public static HashProviderFactory getHashProviderFactory() {
		return new HashProviderFactoryImpl();
	}
}
