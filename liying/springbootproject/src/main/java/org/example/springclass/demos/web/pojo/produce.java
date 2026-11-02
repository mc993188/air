package org.example.springclass.demos.web.pojo;

public class produce {

    private  Integer Id;
    private String proname;
    private String proimg;
    private Double proprice;
    private Integer prosalenum;
    private String storename;

    public produce(Integer id, String proname, String proimg, Double proprice, Integer prosalenum, String storename) {
        Id = id;
        this.proname = proname;
        this.proimg = proimg;
        this.proprice = proprice;
        this.prosalenum = prosalenum;
        this.storename = storename;
    }


    public Integer getId() {return Id;}
    public void setId(Integer id) {Id = id;}

    public String getProname() {return proname;}
    public void setProname(String proname) {this.proname = proname;}

    public String getProimg() {return proimg;}
    public void setProimg(String proimg) {this.proimg = proimg;}

    public Double getProprice() {return proprice;}
    public void setProprice(Double proprice) {this.proprice = proprice;}

    public Integer getProsalenum() {return prosalenum;}
    public void setProsalenum(Integer prosalenum) {this.prosalenum = prosalenum;}

    public String getStorename() {return storename;}
    public void setStorename(String storename) {this.storename = storename;}
}
