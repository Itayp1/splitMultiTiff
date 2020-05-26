package menora.filenet.opti;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.TIFFEncodeParam;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitMultiTiff {

    private List<String> documents;

    public SplitMultiTiff() {
        this.documents = new ArrayList<>();
    }

    public List<String> splitTiff(String document) throws IOException {

        File myObj = new File("C:\\temp\\multipage.tiff");

        FileSeekableStream ss = new FileSeekableStream("C:\\temp\\111.tif");
        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", ss, null);
        int count = dec.getNumPages();
        TIFFEncodeParam param = new TIFFEncodeParam();
//		param.setCompression(32946);
//		param.setLittleEndian(false); // Intel
        System.out.println("This TIF has " + count + " image(s)");

        for (int i = 0; i < count; i++) {
            RenderedImage page = dec.decodeAsRenderedImage(i);

            File f = new File("C:\\temp\\single_" + i + ".tif");
            System.out.println("Saving " + f.getCanonicalPath());
            documents.add("Saving " + f.getCanonicalPath());
            ParameterBlock pb = new ParameterBlock();
            pb.addSource(page);
            pb.add(f.toString());
            pb.add("tiff");
            pb.add(param);
            RenderedOp r = JAI.create("filestore", pb);
            r.dispose();


        }
        return this.documents;
    }

}