package com.ticodev.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* SHA256 + salt 암호화 */
public class HashEncoder {

    private static final int SALT_SIZE = 16;

    private MessageDigest md;
    private String salt;
    private String encodedMsg;

    /*
    생성자에서 암호화를 처리하고, 암호화된 메세지 또는 salt 값을
    Getter로 가져오는 방식
    */
    public HashEncoder(String hashAlgorithm, String msg)
            throws NoSuchAlgorithmException {

        this.md = MessageDigest.getInstance(hashAlgorithm);
        this.salt = generateSalt();
        this.encodedMsg = encoding(msg + this.salt);
    }

    public HashEncoder(String hashAlgorithm, String msg, String salt)
            throws NoSuchAlgorithmException {

        this.md = MessageDigest.getInstance(hashAlgorithm);
        this.salt = salt;
        this.encodedMsg = encoding(msg + this.salt);
    }

    public HashEncoder(String msg)
            throws NoSuchAlgorithmException {

        this("SHA-256", msg);
    }



    private String generateSalt() {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);

        return byteToHexString(salt);
    }

    private String encoding(String msg) {
        md.update(msg.getBytes());
        return byteToHexString(md.digest());
    }

    public static String byteToHexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(Integer.toString((b & 0xFF) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public String getSalt() {
        return salt;
    }

    public String getEncodedMsg() {
        return encodedMsg;
    }

}
