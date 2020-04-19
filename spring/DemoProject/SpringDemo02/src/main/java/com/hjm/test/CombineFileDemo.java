package com.hjm.test;

import org.junit.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class CombineFileDemo {
    @Test
    public void demo() {
        String path = "I:/其他软件备份/9408151173/99999122315614/其他/UCDownload";
        String dirPath = "I:/其他软件备份/9408151173/99999122315614/其他/UCDownload01/out";
        File dirFolder = new File(dirPath);
        File srcParentFolder = new File(path);
        File[] s = srcParentFolder.listFiles();
        for (File dir : srcParentFolder.listFiles()) {
            new Thread(() -> {
                File src = dir;
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    combineFolderFile(src, dirFolder);
                    System.out.println(Thread.currentThread().getName() + " mission done! ");
                } catch (FileNotFoundException | InterruptedException e) {
                    e.printStackTrace();
                }
            }, dir.getName() + "-combine-thread").start();


        }
    }

    public static void main(String[] args) {
        String path = "I:/其他软件备份/9408151173/99999122315614/其他/UCDownload";
        String dirPath = "I:/其他软件备份/9408151173/99999122315614/其他/UCDownload01/out";
        File dirFolder = new File(dirPath);
        File srcParentFolder = new File(path);
        File[] s = srcParentFolder.listFiles();
        for (File dir : srcParentFolder.listFiles()) {
            new Thread(() -> {
                File src = dir;
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    combineFolderFile(src, dirFolder);
                    System.out.println(Thread.currentThread().getName() + " mission done! ");
                } catch (FileNotFoundException | InterruptedException e) {
                    e.printStackTrace();
                }
            }, dir.getName() + "-combine-thread").start();


        }
    }

    public static void combineFolderFile(File srcFolder, File dirFolder) throws FileNotFoundException {
        File[] files = srcFolder.listFiles();
        if (!dirFolder.exists()) {
            dirFolder.mkdirs();
        }
        File dirFile = new File(dirFolder.getAbsolutePath() + "/" + srcFolder.getName() + ".mp4");
        System.out.println("合成" + dirFile.getName() + "视频开始********************************");
        FileOutputStream fout = new FileOutputStream(dirFile);
        byte[][] bytes = new byte[files.length][];
        for (File f : files) {
            byte[] bs = new byte[1024 * 1024 * 3];
            int index = Integer.valueOf(f.getName().replace("Y2hlbmppbmdjb25n", ""));
            FileInputStream fi = new FileInputStream(f);
            try {
                int len = fi.read(bs);
                bytes[index] = new byte[len];
                System.arraycopy(bs, 0, bytes[index], 0, len);
                fi.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            for (byte[] bs : bytes) {
                fout.write(bs, 0, bs.length);
            }
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("合成" + dirFile.getName() + "视频结束========================================");
    }


}
