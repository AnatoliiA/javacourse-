/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author Kamarali Anatolii
 */
public abstract class Toy extends Product{
    private int ageto;
    private int agefrom;
    private String article;
    
    
    public Toy(double price, int ageto, int agefrom, String article){
            super(price);
            this.agefrom = agefrom;
            this.ageto = agefrom;
            this.article = article;
    }
    
    public int setAgeto(){
        return this.getAgeto();
    }
    
   public int setAgefrom(){
        return this.getAgefrom();
    }
   
   @Override
   public String toString(){
     return " Игрушка предназначена для возраста от " + getAgefrom() + " до " + getAgeto() + " артикль " + getArticle();
   };

    /**
     * @return the ageto
     */
    public int getAgeto() {
        return ageto;
    }

    /**
     * @param ageto the ageto to set
     */
    public void setAgeto(int ageto) {
        this.ageto = ageto;
    }

    /**
     * @return the agefrom
     */
    public int getAgefrom() {
        return agefrom;
    }

    /**
     * @param agefrom the agefrom to set
     */
    public void setAgefrom(int agefrom) {
        this.agefrom = agefrom;
    }

    /**
     * @return the article
     */
    public String getArticle() {
        return article;
    }

    /**
     * @param article the article to set
     */
    public void setArticle(String article) {
        this.article = article;
    }
    
}
