package com.hjm.test;

import org.junit.Test;

import java.io.*;

public class CombineFileDemo {
    @Test
    public void demo(){
        String path = "F:/download/UCDownload";
        String dirPath = "F:/download/UCDownload01/out";
        File dirFolder = new File(dirPath);
        File srcParentFolder = new File(path);
        for(File dir : srcParentFolder.listFiles()){
            try {
                combineFolderFile(dir,dirFolder);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public static void combineFolderFile(File srcFolder,File dirFolder) throws FileNotFoundException {
//        String path = "F:/download/UCDownload/aijianjidemo/1c4298c73b31117f3ab60ebc12cb1bcb6a05ae15";
//        String dirPath = "F:/download/UCDownload/aijianjidemo/out";
//        File srcFolder = new File(path);
//        File dirFolder = new File(dirPath);
        File[] files = srcFolder.listFiles();
        if(!dirFolder.exists()){
            dirFolder.mkdirs();
        }
        File dirFile = new File(dirFolder.getAbsolutePath()+"/"+srcFolder.getName()+".mp4");
        System.out.println("合成"+dirFile.getName()+"视频开始********************************");
        FileOutputStream fout = new FileOutputStream(dirFile);
//        byte[] bytes = new byte[1024*1024];
        byte[][] bytes = new byte[files.length][];
        for(File f : files){
            byte[] bs = new byte[1024*1024*3];
            int index = Integer.valueOf(f.getName().replace("Y2hlbmppbmdjb25n",""));
//            if(f.getName().endsWith(".MP4")){
//                System.out.println(f.getName());
                FileInputStream fi = new FileInputStream(f);
                try {
                    int len = fi.read(bs);
                    bytes[index] = new byte[len];
//                    System.out.println("bytes["+index+"]");
                    System.arraycopy(bs,0,bytes[index],0,len);
//                    fout.write(bytes,0,len);
                    fi.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

//            }
        }
        try {
            for(byte[] bs : bytes){
                fout.write(bs,0,bs.length);
            }
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        FileInputStream fi = new FileInputStream();
        System.out.println("合成"+dirFile.getName()+"视频结束========================================");
    }


}
