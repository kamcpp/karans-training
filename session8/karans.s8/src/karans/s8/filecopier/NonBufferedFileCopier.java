package karans.s8.filecopier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NonBufferedFileCopier extends AbstractFileCopier {

	public NonBufferedFileCopier(String source, String destination) {
		super(source, destination);
	}

	@Override
	protected void internalCopy(InputStream in, OutputStream out)
			throws IOException {
		int c = 0;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
	}

}
