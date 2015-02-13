import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Transient ¹Ø¼ü×Ö
 * 
 * Console output:
 *  	a = Name,b = ZhangFei 
 *  	a = Name,b = null
 */
public class TestTransient {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		TestBean bean = new TestBean("Name", "ZhangFei");
		System.out.println(bean);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"d://test.txt"));
		oos.writeObject(bean);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"d://test.txt"));
		bean = (TestBean) ois.readObject();
		ois.close();
		System.out.println(bean);
	}
}

class TestBean implements Serializable {

	private static final long serialVersionUID = 4892653971794775817L;
	
	private String a;
	private transient String b;

	public TestBean(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return "a = " + a + ",b = " + b;
	}
}