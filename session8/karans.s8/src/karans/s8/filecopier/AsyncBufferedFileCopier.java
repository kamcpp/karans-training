package karans.s8.filecopier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AsyncBufferedFileCopier extends AbstractFileCopier {

	private Thread workingThread;
	private BufferedFileCopier bufferedFileCopier;

	public AsyncBufferedFileCopier(String source, String destination) {
		this(source, destination, 1024);
	}

	public AsyncBufferedFileCopier(String source, String destination,
			int bufferSize) {
		super(source, destination);
		bufferedFileCopier = new BufferedFileCopier(source, destination,
				bufferSize);
	}

	
	public Thread getWorkingThread() {
		return workingThread;
	}

	@Override
	public void copy() {
		workingThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Starting copy operation ...");
				bufferedFileCopier.copy();
				System.out.println("Copy is finished.");
			}
		});
		workingThread.start();
	}

	@Override
	protected void internalCopy(InputStream in, OutputStream out)
			throws IOException {
		throw new UnsupportedOperationException();
	}
}
