package com.mk.demos.java.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * zip sub folder
 * @author WangChen
 * Created on 2019/11/19 12:02
 * @since 1.0
 */
public class ZipTest {

    public static void addDirToZipArchive(ZipOutputStream zos, File fileToZip, String parentDirectoryName) throws Exception {
        if (fileToZip == null || !fileToZip.exists()) {
            return;
        }

        String zipEntryName = fileToZip.getName();
        if (parentDirectoryName!=null && !parentDirectoryName.isEmpty()) {
            zipEntryName = parentDirectoryName + "/" + fileToZip.getName();
        }

        if (fileToZip.isDirectory()) {
            System.out.println("+" + zipEntryName);
            for (File file : fileToZip.listFiles()) {
                addDirToZipArchive(zos, file, zipEntryName);
            }
        } else {
            System.out.println("   " + zipEntryName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = new FileInputStream(fileToZip);
            zos.putNextEntry(new ZipEntry(zipEntryName));
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
            fis.close();
        }
    }

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\tmp\\archive.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        addDirToZipArchive(zos, new File("D:\\tmp\\test\\"), "a/b");
        zos.flush();
        fos.flush();
        zos.close();
        fos.close();
        File file = new File("D:\\tmp\\test/thumb-4.jpg");
        System.out.println(file.getParent());
        System.out.println(file.getName());
    }
}
