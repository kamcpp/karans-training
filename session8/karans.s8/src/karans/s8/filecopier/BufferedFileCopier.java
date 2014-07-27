package karans.s8.filecopier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedFileCopier extends AbstractFileCopier {

	private int bufferSize;

	public BufferedFileCopier(String source, String destination) {
		this(source, destination, 1024);
	}

	public BufferedFileCopier(String source, String destination, int bufferSize) {
		super(source, destination);
		this.bufferSize = bufferSize;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	@Override
	protected void internalCopy(InputStream in, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[bufferSize];
		while (in.read(buffer) != -1) {
			out.write(buffer);
		}
	}

}
