package cn.me.myboot;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.Security;

/**
 * 国密SM3摘要算法实现工具.
 * 用于替换MD5、SHA算法
 *
 * @author linzp
 * @since 2023/2/8 10:48
 */
public final class SM3Util {

    /**
     * 私有构造器.
     */
    private SM3Util() {
    }

    // 拓展算法提供方，加载BC库.
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * SM3摘要算法逻辑
     *
     * @param srcData 待加密byte[]
     * @return
     */
    private static byte[] sm3(byte[] srcData) {
        SM3Digest sm3Digest = new SM3Digest();
        sm3Digest.update(srcData, 0, srcData.length);
        byte[] hash = new byte[sm3Digest.getDigestSize()];
        sm3Digest.doFinal(hash, 0);
        return hash;
    }

    /**
     * 摘要算法加密
     *
     * @param srcData 待加密byte[]
     * @return
     */
    public static String encrypt(byte[] srcData) {
        byte[] hash = sm3(srcData);
        String hexString = Hex.toHexString(hash);
        return hexString;
    }

    /**
     * 指定密钥进行加密.
     *
     * @param key     密钥
     * @param srcData 待加密byte[]
     * @return
     */
    private static byte[] hmacSm3(byte[] key, byte[] srcData) {
        KeyParameter keyParameter = new KeyParameter(key);
        SM3Digest digest = new SM3Digest();
        HMac mac = new HMac(digest);
        mac.init(keyParameter);
        mac.update(srcData, 0, srcData.length);
        byte[] hash = new byte[mac.getMacSize()];
        mac.doFinal(hash, 0);
        return hash;
    }

    /**
     * 指定密钥进行加密.
     *
     * @param key     密钥
     * @param srcData 待加密byte[]
     * @return
     */
    public static String encrypt(byte[] key, byte[] srcData) {
        byte[] hash = hmacSm3(key, srcData);
        String hexString = Hex.toHexString(hash);
        return hexString;
    }

    /**
     * 基于BC库的摘要算法加密
     *
     * @param srcData 待加密byte[]
     * @return
     * @throws Exception
     */
    private static byte[] sm3bc(byte[] srcData) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SM3", "BC");
        byte[] digest = messageDigest.digest(srcData);
        return digest;
    }

    /**
     * 基于BC库的摘要算法加密
     *
     * @param srcData 待加密byte[]
     * @return
     * @throws Exception
     */
    public static String encryptBC(byte[] srcData) throws Exception {
        byte[] hash = sm3bc(srcData);
        String hexString = Hex.toHexString(hash);
        return hexString;
    }

    /**
     * 对文件进行摘要算法加密.
     *
     * @param file
     * @return
     */
    public static String encrypt(File file) {
        //TODO-linzp 如使用大文件应该对此方法进行优化，避免出现OOM
        byte[] srcData;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            srcData = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("file not found!");
        } finally {
            closeResoruce(fis, bos);
        }
        return encrypt(srcData);
    }

    /**
     * 关闭资源.
     *
     * @param fis
     * @param bos
     */
    private static void closeResoruce(FileInputStream fis, ByteArrayOutputStream bos) {
        if (null != fis) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != bos) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
