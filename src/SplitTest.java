
public class SplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "please use temporary password 'rahulshettyacademy' to Login.";
		String password[]= text.split("'");
		String pass = password[1];
		System.out.println(pass);
		
	}

}
