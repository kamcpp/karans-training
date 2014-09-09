package example.common.crypto.impl;

import example.common.crypto.HashProvider;
import example.common.crypto.HashProviderFactory;

public class HashProviderFactoryImpl implements HashProviderFactory {

	@Override
	public HashProvider getHashProvider() {
		return new Sha1HashProvider();
	}
}
