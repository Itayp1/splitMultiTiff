package menora.filenet.opti;

import com.sun.media.jai.codec.*;

import javax.imageio.ImageIO;
import javax.media.jai.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;

import static java.nio.charset.StandardCharsets.US_ASCII;

public class SplitMultiTiff {

    private List<String> documents;

    public SplitMultiTiff() {
        this.documents = new ArrayList<>();
    }

    public SplitTifRes splitTiff(String document) throws IOException {
//        System.out.println(document);
        byte[] decoded = Base64.getDecoder().decode(document);
        InputStream ss = new ByteArrayInputStream(decoded);


        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", ss, null);
        int count = dec.getNumPages();
//        TIFFEncodeParam param = new TIFFEncodeParam();
//		param.setCompression(32946);
//		param.setLittleEndian(false); // Intel
//        System.out.println("This TIF has " + count + " image(s)");
//        ArrayList<ByteArrayOutputStream> imagesStream = new ArrayList<ByteArrayOutputStream>();
        SplitTifRes splitTifRes = new SplitTifRes();

        for (int i = 0; i < count; i++) {
//            RenderedImage page = dec.decodeAsRenderedImage(i);
           // String PageInBase64 = encodeToString((BufferedImage) page, "tif");
            RenderedImage render = dec.decodeAsRenderedImage(i);
            PlanarImage op = new NullOpImage(render, null, null, OpImage.OP_IO_BOUND);
            BufferedImage imageBuffer = op.getAsBufferedImage();

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(imageBuffer, "jpg", os);
            byte[] decodedDoc = Base64.getEncoder().encode(os.toByteArray());
            String Base64doc = new String(decodedDoc);
            splitTifRes.setSingleDocument(Base64doc);

//            imagesStream.add(os);
//            File f = new File("C:\\temp\\single_" + i + ".tif");
//            System.out.println("Saving " + f.getCanonicalPath());
            documents.add(Base64doc);
//            ParameterBlock pb = new ParameterBlock();
//            pb.addSource(page);
//            pb.add(f.toString());
//            pb.add("tiff");
//            pb.add(param);
//            RenderedOp r = JAI.create("filestore", pb);
//            r.dispose();


        }

        return splitTifRes;
    }




}