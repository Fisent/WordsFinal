package lukzieniewicz.gmail.com.wordsfinal;

import java.io.Serializable;

/**
 * Created by Fisent on 17.05.2017.
 */

public class Word implements Serializable{
    private String english;
    private String polish;
    private int level;
    private String category;

    public Word(String eng, String pol){
        level = -2;
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

    public int getLevel() { return level; }

    public String toString(){
        return english + " (" + level + ")";
    }

    public void levelUp(){
        level++;
    }

    public void levelDown(){
        level--;
    }
}
