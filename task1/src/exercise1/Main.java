package exercise1;


public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MediaFireConnector user1 = new MediaFireConnector("christina.410@hotmail.com","ihatehomework");
//		String s= user1.calculateSignature();
//		System.out.println("signature is : "+s);
//		String token = user1.getSessionToken();
//		System.out.println("sessiontoken is: " + token);
		System.out.println(user1.getUserInfo());

	}

}
