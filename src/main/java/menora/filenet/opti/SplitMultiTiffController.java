package menora.filenet.opti;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SplitMultiTiffController {

    @RequestMapping(method= RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE,value="/splitmultitiff")
    public ResponseEntity<SplitTifRes> splitTifDocument(@RequestBody SplitTifReq splitTifReq) throws IOException {

        SplitMultiTiff splitMultiTiff = new SplitMultiTiff();
        SplitTifRes documents =  splitMultiTiff.splitTiff(splitTifReq.getEcnodedFile());

//       splitTifRes.setSingleDocument("SDfdsf");
//       splitTifRes.setSingleDocument("sdfdsfsd");

        return new ResponseEntity<>(documents, HttpStatus.OK);

    }
}
