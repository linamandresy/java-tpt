package mbds.tpt.egouvernance_javaserver.helpers.web;

public class WebResponse {
    private int status;
    private Object content;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Object getContent() {
        return content;
    }
    public void setContent(Object content) {
        this.content = content;
    }
    public WebResponse(Object content) {
        setStatus(200);
        this.setContent(content);
    }
    public WebResponse(int status, Object content) {
        this.setStatus(status);
        this.setContent(content);
    }

    
}
