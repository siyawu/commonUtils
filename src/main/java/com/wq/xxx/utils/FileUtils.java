package com.wq.xxx.utils;

import java.io.*;

/**
 * 文件操作公共方法
 * created by wuqiang
 */
public final class FileUtils {
    private static final int ONE_CACH = 1024;
    
    private FileUtils() {
    
    }
    
    /**
     * 复制单个文件
     *
     * @param srcFileName 待复制的文件名
     * @param tarFileName 目标文件名
     * @param coverlay    如果目标文件已存在，是否覆盖
     * @return 如果复制成功，则返回true，否则返回false
     */
    public static boolean copyFileCover(String srcFileName, String tarFileName, Boolean coverlay) {
        File srcFile = new File(srcFileName);
        if (!srcFile.exists()) {
            return false;
        } else if (!srcFile.isFile()) {
            return false;
        }
        
        File tarFile = new File(tarFileName);
        if (!tarFile.exists()) {
            try {
                tarFile.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 关闭单个文件流
     *
     * @param closeable
     */
    public static void closeStream(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        
        }
    }
    
    /**
     * 关闭文件流
     *
     * @param closeables
     */
    public static void closeStream(Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        
        for (Closeable item : closeables) {
            closeStream(item);
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