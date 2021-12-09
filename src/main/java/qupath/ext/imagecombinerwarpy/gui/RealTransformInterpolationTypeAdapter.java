/*********************************
 * This file is part of ImageCombinerWarpy ...
 * 
 * .. a QuPath extension based on the QuPath 'Interactive Image Alignment' tool
 *  
 * The ImageCombinerWarpy is thought as an experimental� tool.
 * 
 * It is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Peter Haub (@phaub), Oct 2021
 * 
 *********************************/


package qupath.ext.imagecombinerwarpy.gui;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import net.imglib2.realtransform.RealTransformSerializer;

public class RealTransformInterpolationTypeAdapter extends TypeAdapter<RealTransformInterpolation> {
	public static RealTransformInterpolationTypeAdapter INSTANCE = new RealTransformInterpolationTypeAdapter();
	
	@Override
	public void write(JsonWriter out, RealTransformInterpolation value) throws IOException {
		RealTransformSerializer.getRealTransformAdapter().toJson((Object)value, value.getClass(), out);
	}

	@Override
	public RealTransformInterpolation read(JsonReader in) throws IOException {
		RealTransformInterpolation realtransformInterpolation = RealTransformSerializer.deserializeInterpolationSequence(in, RealTransformInterpolation.class);
		return realtransformInterpolation;
	}
}