/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopapirollo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author dencs
 */
public class viewController implements Initializable {
    
    //számon tartja hogy éppen ki hányat nyert
    private int winPc = 0;
    private int winPlayer = 0;
    //az aktuális mutatás kerül bele (kő, papír vagy olló
    private String toolPc = "";
    private String toolPlayer = "";
    
//<editor-fold defaultstate="collapsed" desc="FXML">
    @FXML
    private ImageView imgRockPc;
    
    @FXML
    private ImageView imgScissorsPc;
    
    @FXML
    private ImageView imgPaperPc;
    
    @FXML
    private ImageView imgRockPlayer;
    
    @FXML
    private ImageView imgScissorsPlayer;
    
    @FXML
    private ImageView imgPaperPlayer;
    
    @FXML
    private Button btnRock;
    
    @FXML
    private Button btnPaper;
    
    @FXML
    private Button btnScissors;
    
    @FXML
    private Text txtPayerScore;
    
    @FXML
    private Text txtPcScore;
//</editor-fold>
    //ha az ollóra kattint a játékos...
    @FXML
    private void handlerScissorsButtonClick(ActionEvent e){
        change(imgScissorsPlayer);
    }
    //ha az papírra kattinta játékos...
    @FXML
    private void handlerPaperButtonClick(ActionEvent e){
        change(imgPaperPlayer);
    }
    //ha az kőre kattint a játékos...
    @FXML
    private void handlerRockButtonClick(ActionEvent e){
        change(imgRockPlayer);
    }
    
    //újraindul a játék minden értéket alapra állítok
    @FXML
    private void handlerRestartButtonClick(ActionEvent e ){
        imgRockPlayer.setVisible(false);
        imgScissorsPlayer.setVisible(false);
        imgPaperPlayer.setVisible(false);
        
        imgRockPc.setVisible(false);
        imgScissorsPc.setVisible(false);
        imgPaperPc.setVisible(false);
        
        winPc = 0;
        winPlayer = 0;
    
        toolPc = "";
        toolPlayer = "";
        
        txtPcScore.setText("0");
         txtPayerScore.setText("0");
    }
    
    
    private void change(ImageView showImg){
        imgRockPlayer.setVisible(false);
        imgScissorsPlayer.setVisible(false);
        imgPaperPlayer.setVisible(false);
        
        imgRockPc.setVisible(false);
        imgScissorsPc.setVisible(false);
        imgPaperPc.setVisible(false);
        
        showImg.setVisible(true);
        toolPlayer = showImg.getId();
        
        // random szám generálással oldottam meg a gép mutatását (1: kő, 2: papír, 3: olló)
        int random = (int) (Math.random()*3)+1;
        System.out.println(String.valueOf(random));
        switch(random){
            case 1: imgRockPc.setVisible(true);
                    toolPc = imgRockPc.getId();
            break;
            case 2: imgPaperPc.setVisible(true);
                    toolPc = imgPaperPc.getId();
            break;
            case 3: imgScissorsPc.setVisible(true);
                    toolPc = imgScissorsPc.getId();
            break;
        }
        //System.out.println(toolPc + " - " + toolPlayer );
        
        //aki nyer annak a pontszámát felplusszolom és beleteszem a megfelelő text mezőbe
        if ((toolPc.equals("imgScissorsPc") && toolPlayer.equals("imgPaperPlayer"))
                ||  (toolPc.equals("imgPaperPc") && toolPlayer.equals("imgRockPlayer"))
                ||  (toolPc.equals("imgRockPc") && toolPlayer.equals("imgScissorsPlayer"))){
            txtPcScore.setText(String.valueOf(++winPc));
        }else if((toolPc.equals("imgScissorsPc") && toolPlayer.equals("imgScissorsPlayer"))
                || (toolPc.equals("imgPaperPc") && toolPlayer.equals("imgPaperPlayer"))
                || (toolPc.equals("imgRockPc") && toolPlayer.equals("imgRockPlayer"))){
            
        }else{
            txtPayerScore.setText(String.valueOf(++winPlayer));
        }
       // System.out.println("" + winPc + " " + winPlayer);
    }
    
    //kezdéskor elrejtek minden képet, kinullázom a pontokat mutató text-eket
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgRockPc.setVisible(false);
        imgScissorsPc.setVisible(false);
        imgPaperPc.setVisible(false);
        imgRockPlayer.setVisible(false);
        imgScissorsPlayer.setVisible(false);
        imgPaperPlayer.setVisible(false);
        txtPayerScore.setText("0");
        txtPcScore.setText("0");
        btnRock.setFocusTraversable(false);
        btnPaper.setFocusTraversable(false);
        btnScissors.setFocusTraversable(false);
    }
    
}
