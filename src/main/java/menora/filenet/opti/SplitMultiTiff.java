package menora.filenet.opti;

import com.sun.media.jai.codec.*;

import javax.imageio.ImageIO;
import javax.media.jai.*;
import java.awt.image.BufferedImage;

import java.awt.image.RenderedImage;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

import java.util.List;



public class SplitMultiTiff {

    private List<String> documents;

    public SplitMultiTiff() {
        this.documents = new ArrayList<>();
    }

    public SplitTifRes splitTiff(String document) throws IOException {

        byte[] decoded = Base64.getDecoder().decode(document);
        InputStream ss = new ByteArrayInputStream(decoded);


        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", ss, null);
        int count = dec.getNumPages();

        SplitTifRes splitTifRes = new SplitTifRes();

        for (int i = 0; i < count; i++) {

            RenderedImage render = dec.decodeAsRenderedImage(i);
            PlanarImage op = new NullOpImage(render, null, null, OpImage.OP_IO_BOUND);
            BufferedImage imageBuffer = op.getAsBufferedImage();

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(imageBuffer, "jpg", os);
            byte[] decodedDoc = Base64.getEncoder().encode(os.toByteArray());
            String Base64doc = new String(decodedDoc);
            splitTifRes.setSingleDocument(Base64doc);


            documents.add(Base64doc);



        }

        return splitTifRes;
    }




}