package src;

public class Pyramid{
    String pharaoh ;
    String modern_name ;
    String site ;
    double height ;
    public Pyramid(String pharaoh ,String modern_name,String site,double hight){
        
       try {
            this.height = height;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.modern_name = modern_name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.pharaoh = pharaoh;
        } catch (Exception e) {
            e.printStackTrace();
        }try {
            this.site = site;
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    double getHight(){
        return height;
    }
      
    String getModern_name(){
        return modern_name;
    }
        
    String getPharaoh(){
        return pharaoh;
    }
        
    String getSite(){
        return site;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setHight(double hight) {
        this.height = hight;
    }
    
    
}