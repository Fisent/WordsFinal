package lukzieniewicz.gmail.com.wordsfinal;

/**
 * Created by Fisent on 17.05.2017.
 */

public class Word {
    private String english;
    private String polish;
    private String category;

    public Word(String eng, String pol){
        english = eng;
        polish = pol;
    }

    public Word(String eng, String pol, String category){
        polish = pol;
        english = eng;
        this.category = category;
    }

    public void setEnglish(String english){
        this.english = english;
    }

    public void setPolish(String polish){
        this.polish = polish;
    }

    public String getEnglish(){
        return english;
    }

    public String getPolish(){
        return polish;
    }

    public String getCategory(){
        return category;
    }

    public String toString(){
        return english + " - " + polish + "(" + category + ")";
    }
}
