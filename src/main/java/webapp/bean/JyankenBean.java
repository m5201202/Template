package webapp.bean;

import javax.enterprise.context.RequestScoped; import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;
@Named
@RequestScoped
public class JyankenBean implements Serializable {
    private int selectedHand; private String result;
    public String jyanken() {
        Random rand = new Random();
        int computedHand = rand.nextInt(3);
        if (selectedHand == computedHand) { result = "Draw!"; }
        else if (selectedHand == 0 && computedHand == 1) { result = "You Win!"; }
        else if (selectedHand == 1 && computedHand == 2) { result = "You Win!"; }
        else if (selectedHand == 2 && computedHand == 0) { result = "You Win!"; }
        else { result="I Win!"; }
        return "/jyanken/result";
    }
    public void setSelectedHand(int selectedHand) { this.selectedHand = selectedHand; }
    public int getSelectedHand() {return selectedHand;}
    public void setResult(String result) { this.result = result; }
    public String getResult() {return result;}
}