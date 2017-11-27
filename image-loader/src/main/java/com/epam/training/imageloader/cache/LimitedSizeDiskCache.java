package com.epam.training.imageloader.cache;


import android.graphics.Bitmap;
import android.os.StatFs;

import com.epam.training.imageloader.util.IOUtils;
import com.epam.training.imageloader.util.MD5;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;

public class LimitedSizeDiskCache implements DiskCache {

    private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    private static final int DEFAULT_COMPRESS_QUALITY = 80;
    private static final int BUFFER_SIZE = 4096;
    private static final String IMAGE_CACHE_DIR_NAME = "IMAGE_CACHE";
    private static final int MIN_DISK_CACHE_SIZE = 5 * 1024 * 1024;
    private static final int MAX_DISK_CACHE_SIZE = 50 * 1024 * 1024;
    private final File cacheDir;

    public LimitedSizeDiskCache(File cacheDir) {
        this.cacheDir = new File(cacheDir, IMAGE_CACHE_DIR_NAME);
        if (!cacheDir.exists()) {
            boolean mkdir = this.cacheDir.mkdirs();
            if (!mkdir) {
                throw new IllegalStateException("Can't create dir for images");
            }
        }
    }

    @Override
    public File get(String imageUri) {
        final String fileName = MD5.hash(imageUri);
        File[] files = cacheDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return fileName.equals(name);
            }
        });
        if (files.length == 1) {
            return files[0];
        } else {
            return new File(cacheDir, fileName);
        }
    }

    @Override
    public void save(String imageUri, Bitmap bitmap) throws IOException {
        File imageFile = get(imageUri);
        OutputStream os = new BufferedOutputStream(new FileOutputStream(imageFile), BUFFER_SIZE);
        try {
            boolean savedSuccessfully = bitmap.compress(DEFAULT_COMPRESS_FORMAT, DEFAULT_COMPRESS_QUALITY, os);
        } finally {
            IOUtils.closeStream(os);
        }
    }

    static long calculateDiskCacheSize(File dir) {
        long size = MIN_DISK_CACHE_SIZE;

        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            long available = ((long) statFs.getBlockCount()) * statFs.getBlockSize();
            size = available / 50;
        } catch (IllegalArgumentException ignored) {
        }

        return Math.max(Math.min(size, MAX_DISK_CACHE_SIZE), MIN_DISK_CACHE_SIZE);
    }
}
