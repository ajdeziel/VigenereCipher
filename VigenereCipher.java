/**
 * VigernereCipher
 * Based on NullCipher created for 2015-01 CSC115 Assignment 1.
 * @author: Alain-Joseph Po-Deziel
 */

public class VigenereCipher implements Cipher {

	private int keyArray[];
	
	private String key;
	
    public VigenereCipher(String key) {
		this.key = key;
		int keylen = key.length();
		int[] KeyArray = new int[keylen];
		
		keyArray = stringToIntArray(key);

		this.keyArray = keyArray;
	}//end VigenereCipher
   
   
    private void dumpArray(int[] array, String text) {
		System.out.print(text + ", ");
		for (int i = 0; i < ((text.length()) - 1); i++) {
			System.out.printf("%s, ", array[i]);
		}//end for
	}//end dumpArray
	
	private int[] stringToIntArray(String text) {
		int len = (text.length());
		int[] intArray = new int[len];
		for (int i = 0; i < len; i++){
			intArray[i] = (text.charAt(i) - 97);
		}//end for
		return intArray;
	}//end stringToIntArray: to convert text string into array of alphanumeric values (i.e. a is 0, b is 1, etc.)
	
	private String intArraytoString(int[] encodedText) {
		int len = (encodedText.length);
		char[] charString = new char[len];
		for (int i = 0; i < len; i++) {
			charString[i] = (char)(encodedText[i] + 97);
		}//end for
		String StringConverted = new String(charString);
		return StringConverted;
	}//end intArraytoString to convert array of alphanumeric values into text string
	
	public String encrypt(String plainText) {
        
		int[] encryptArray = stringToIntArray(plainText);
		int[] encryptedLine = new int[plainText.length()];
		for (int j = 0; j < plainText.length(); j++) {
			encryptedLine[j] = (keyArray[j % key.length()] + encryptArray[j]) % 26;
		}//end for
		
		plainText = intArraytoString(encryptedLine);
		
		return plainText;
    }//end encrypt: to encrypt a given message

   
    public String decrypt(String cipherText) {
		
		int[] decryptArray = stringToIntArray(cipherText);
		int[] decryptedLine = new int[cipherText.length()];
		for (int k = 0; k < cipherText.length(); k++) {
			decryptedLine[k] = (decryptArray[k] - keyArray[k % key.length()] + 26) % 26;
		}//end for
		
		cipherText = intArraytoString(decryptedLine);
		
        return cipherText;
    }//end decrypt: to decrypt a given message

	
	public void setKey(String key) {
		this.key = key;
    }//end setKey
	
}
