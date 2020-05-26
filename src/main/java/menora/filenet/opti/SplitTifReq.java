package menora.filenet.opti;

public class SplitTifReq {
    public SplitTifReq(String ecnodedFile) {
        this.ecnodedFile = ecnodedFile;
    }
    public SplitTifReq() {

    }
    public String getEcnodedFile() {
        return ecnodedFile;
    }

    public void setEcnodedFile(String ecnodedFile) {
        this.ecnodedFile = ecnodedFile;
    }

    private String ecnodedFile;
}
