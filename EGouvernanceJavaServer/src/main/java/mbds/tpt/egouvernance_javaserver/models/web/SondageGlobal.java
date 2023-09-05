package mbds.tpt.egouvernance_javaserver.models.web;

import java.util.List;

import mbds.tpt.egouvernance_javaserver.models.SondageMere;
import mbds.tpt.egouvernance_javaserver.models.SondageOption;

public class SondageGlobal {
    private SondageMere mere;
    private List<SondageOption> options;
    public SondageMere getMere() {
        return mere;
    }
    public void setMere(SondageMere mere) {
        this.mere = mere;
    }
    public List<SondageOption> getOptions() {
        return options;
    }
    public void setOptions(List<SondageOption> options) {
        this.options = options;
    }


}
