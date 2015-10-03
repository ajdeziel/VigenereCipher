/**
 * CipherTester
 * Created for 2015-01 CSC115 Assignment 1 to test encryption and decryption of VigenereCipher.
 * @author: Alain-Joseph Po-Deziel
 * @submissionDate: 28/01/2015
 */

public class CipherTester {

	private static void decryptTest() {
		VigenereCipher Cipher = new VigenereCipher ("bob");
		String decryptedString = Cipher.decrypt("uvfnsttohf");
		
		if (decryptedString.equals("themessage")) {
			System.out.println(decryptedString);
			System.out.println("DecryptTest PASSED!");
		} else {System.out.println(decryptedString);
		System.out.print("DecryptTest FAILED.\n\n");}//end if else
		
		}//end decryptTest: to evaluate decrypt function if running correctly
		
	private static void encryptTest() {
		VigenereCipher Cipher = new VigenereCipher("bob");
		String encryptedString = Cipher.encrypt("themessage");
		
		if (encryptedString.equals("uvfnsttohf")) {
			System.out.println(encryptedString);
			System.out.println("EncryptTest PASSED!");
		} else {System.out.println(encryptedString);
		System.out.println("EncryptTest FAILED.");}//end if else
					
		}//end encryptTest: else to evaluate encrypt function if running correctly
		
	public static void main (String args[]) {
		decryptTest();
		
		encryptTest();

	}//end main
}