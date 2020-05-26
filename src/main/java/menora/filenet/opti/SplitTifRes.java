package menora.filenet.opti;

import java.util.ArrayList;
import java.util.List;

public class SplitTifRes {

    public SplitTifRes(List<String> document) {
        this.document = document;
    }



    public SplitTifRes() {
     this.document = new ArrayList<>();
    }

    public List<String> getDocument() {
        return document;
    }


    public void setDocument(List<String> document) {
        this.document = document;
    }
    public void setSingleDocument(String document) {
        this.document.add(document);
    }


    private List<String> document;
}
