package menora.filenet.opti;

import com.sun.media.jai.codec.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MainApplication.class, args);

		}
//
//		String  tiffFilePath= "C:/temp/multipage.tiff";
//		String outputFileType = "tif";
//		ImageInputStream is = ImageIO.createImageInputStream(myObj);
//		if (is == null || is.length() == 0){
//			// handle error
//
//			System.out.println("not exist ");
//			return;
//		}
//		Iterator<ImageReader> iterator = ImageIO.getImageReaders(is);
//
//		if (iterator == null || !iterator.hasNext()) {
//			throw new IOException("Image file format not supported by ImageIO: " + tiffFilePath);
//		}
//// We are just looking for the first reader compatible:
//		ImageReader reader = (ImageReader) iterator.next();
//		iterator = null;
//		reader.setInput(is);

    /*



     */
	}
