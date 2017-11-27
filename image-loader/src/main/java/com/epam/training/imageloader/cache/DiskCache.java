package com.epam.training.imageloader.cache;

import android.graphics.Bitmap;

import java.io.File;
import java.io.IOException;

public interface DiskCache {

	File get(String imageUri);

	void save(String imageUri, Bitmap bitmap) throws IOException;
}
