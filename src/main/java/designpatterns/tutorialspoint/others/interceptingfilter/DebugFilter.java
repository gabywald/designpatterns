package designpatterns.tutorialspoint.others.interceptingfilter;

public class DebugFilter implements Filter {
	public void execute(String request){
		System.out.println("Request / debug log: {" + request + "}");
	}
}
