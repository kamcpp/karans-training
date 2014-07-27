package karans.s8.filecopier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractFileCopier implements FileCopier {

	private String source;
	private String destination;

	public AbstractFileCopier(String source, String destination) {
		setSource(source);
		setDestination(destination);
	}
	
	public String source() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String destination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public void copy() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source());
			out = new FileOutputStream(destination());
			internalCopy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
			try {
				out.close();
			} catch (Exception e) {
			}
		}
	}

	protected abstract void internalCopy(InputStream in, OutputStream out) throws IOException;
}
