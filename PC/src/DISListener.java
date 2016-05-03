import java.io.DataInputStream;
import java.util.ArrayList;

public class DISListener implements INotifier, Runnable {

	private ArrayList<ISub> subs;
	private DataInputStream dis;

	public DISListener(DataInputStream dis) {
		subs = new ArrayList<ISub>();
		this.dis = dis;
	}

	@Override
	public void addSub(ISub sub) {
		subs.add(sub);

	}

	@Override
	public void removeSub(ISub sub) {
		subs.remove(sub);

	}

	@Override
	public void notifySub(String msg) {
		System.out.println(msg + " from robot");
		for (ISub sub : subs) {
			sub.getInput(msg);
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				notifySub(dis.readUTF());
			} catch (Exception e) {

			}
		}

	}

}
