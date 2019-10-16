package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kerwin
 * @title: Utils
 * @projectName ServletDemo
 * @date 2019/09/30 - 17:52
 */
public class Utils {
    /**
     * 使用MD5 加密密码 使明文变成MD5编码
     * eg:kerwin  -->  c8198892471e0e21ce3c62c95f506527
     */
    public static String Digest(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md5 != null;
        return new BigInteger(1, md5.digest()).toString(16);
    }



    /**
     * 返回一个SqlSessionFactory对象
     * */
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}

