package karans.s8.filecopier;

public interface FileCopier {

	String source();
	
	String destination();
	
	void copy();
}
