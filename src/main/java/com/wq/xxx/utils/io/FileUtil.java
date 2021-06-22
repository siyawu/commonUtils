package com.wq.xxx.utils.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * 文件操作工具类
 * Created by wuqiang on 2021/5/8-14:34
 */
public final class FileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
    
    private static final int ONE_CACH = 1024;
    
    private FileUtil() {
    }
    
    /**
     * 删除文件
     *
     * @param files 文件组
     */
    public static void delete(File... files) {
        if (files != null) {
            for (File file : files) {
                delete(file);
            }
        }
    }
    
    /**
     * 删除文件
     *
     * @param file 文件
     */
    public static void delete(File file) {
        if (file != null) {
            file.delete();
        }
    }
    
    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        
        }
    }
    
    /**
     * 写入数据导文件
     *
     * @param msgList
     * @param file
     */
    public static void writeToFile(List<String> msgList, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            for (String msg : msgList) {
                msg = msg + "\r\n";
                byte[] bytes = msg.getBytes();
                fos.write(bytes);
            }
            fos.close();
        } catch (IOException e) {
            LOGGER.error("setTextToFile error", e);
        }
    }
    
    public static String openFileToString(String filePath) {
        try {
            StringBuilder stringBuffer = new StringBuilder();
            File file = new File(filePath);
            if (!file.exists()) {
                return stringBuffer.toString();
            }
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            char[] str = new char[ONE_CACH];
            int readLength = 0;
            while ((readLength = br.read(str)) != -1) {
                stringBuffer.append(str, 0, readLength);
            }
            return stringBuffer.toString();
        } catch (Exception ignored) {
        }
        return "";
    }
}
