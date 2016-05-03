

public interface INotifier {

	public void addSub(ISub sub);
	public void removeSub(ISub sub);
	public void notifySub(String msg);
}
