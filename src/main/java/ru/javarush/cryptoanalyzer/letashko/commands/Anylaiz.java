package ru.javarush.cryptoanalyzer.letashko.commands;



import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;


 public class Anylaiz {

    private static final int MIN_RSA_MODULUS_LEN_BITS = 1024;

    private static final int MIN_EC_FIELD_SIZE_BITS = 160;

    private static final int MIN_DSA_P_LEN_BITS = 1024;
    private static final int MIN_DSA_Q_LEN_BITS = 160;

    private static final String[] SIGNATURE_ALGORITHM_OID_BLACKLIST = {
            "1.2.840.113549.1.1.2", // md2WithRSAEncryption
            "1.2.840.113549.1.1.3", // md4WithRSAEncryption
            "1.2.840.113549.1.1.4", // md5WithRSAEncryption
            "1.2.840.113549.1.1.5", // sha1WithRSAEncryption
            "1.2.840.10040.4.3", //dsa-with-sha1
            "1.2.840.10045.4.1", //ecdsa-with-sha1
    };

    public static final void check(X509Certificate[] chain) throws CertificateException {
        for (X509Certificate cert : chain) {
            try {
                checkCert(cert);
            } catch (CertificateException e) {
                throw new CertificateException("Неприемлемый сертификат: "
                        + cert.getSubjectX500Principal(), e);
            }
        }
    }

    public static final void check(List<X509Certificate> chain) throws CertificateException {
        for (X509Certificate cert : chain) {
            try {
                checkCert(cert);
            } catch (CertificateException e) {
                throw new CertificateException("Неприемлемый сертификат: "
                        + cert.getSubjectX500Principal(), e);
            }
        }
    }

    public static final void checkCert(X509Certificate cert) throws CertificateException {
        checkKeyLength(cert);
        checkSignatureAlgorithm(cert);
    }

    private static void checkKeyLength(X509Certificate cert) throws CertificateException {
        Object pubkey = cert.getPublicKey();
        if (pubkey instanceof RSAPublicKey) {
            int modulusLength = ((RSAPublicKey) pubkey).getModulus().bitLength();
            if (modulusLength < MIN_RSA_MODULUS_LEN_BITS) {
                throw new CertificateException(
                        "RSA modulus is < " + MIN_RSA_MODULUS_LEN_BITS + " bits");
            }
        } else if (pubkey instanceof ECPublicKey) {
            int fieldSizeBits =
                    ((ECPublicKey) pubkey).getParams().getCurve().getField().getFieldSize();
            if (fieldSizeBits < MIN_EC_FIELD_SIZE_BITS) {
                throw new CertificateException(
                        "EC key field size is < " + MIN_EC_FIELD_SIZE_BITS + " bits");
            }
        } else if (pubkey instanceof DSAPublicKey) {
            int pLength = ((DSAPublicKey) pubkey).getParams().getP().bitLength();
            int qLength = ((DSAPublicKey) pubkey).getParams().getQ().bitLength();
            if ((pLength < MIN_DSA_P_LEN_BITS) || (qLength < MIN_DSA_Q_LEN_BITS)) {
                throw new CertificateException(
                        "DSA key length is < (" + MIN_DSA_P_LEN_BITS + ", " + MIN_DSA_Q_LEN_BITS
                                + ") bits");
            }
        } else {
            // Unknown keys will be of type X509PublicKey.
            throw new CertificateException("Отклонение неизвестного ключевого класса " + pubkey.getClass().getName());
        }
    }

    private static void checkSignatureAlgorithm(
            X509Certificate cert) throws CertificateException {
        String oid = cert.getSigAlgOID();
        for (String blacklisted : SIGNATURE_ALGORITHM_OID_BLACKLIST) {
            if (oid.equals(blacklisted)) {
                throw new CertificateException("Подпись использует небезопасную хэш-функцию: " + oid);
            }
        }
    }
}