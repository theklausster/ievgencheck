package Connection;

public interface ISubject {
	
	void notifySubscriber(String msg);
	void addSubscriber(ISub sub);
	void removeSubscriber(ISub sub);

}
