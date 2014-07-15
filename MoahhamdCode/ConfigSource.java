package reflectionPackage;
public interface ConfigSource {
	public String getPackageNme();
	public String getClassName();
	public void read(String fileName);

}
