/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopapirollo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;

/**
 *
 * @author dencs
 */
public class viewController implements Initializable {
    
//<editor-fold defaultstate="collapsed" desc="comment">
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
//</editor-fold>
    
    @FXML
    private void handlerScissorsButtonClick(){
        mutasd(imgScissorsPlayer);
    }
    
    @FXML
    private void handlerPaperButtonClick(){
        mutasd(imgPaperPlayer);
    }
    
    @FXML
    private void handlerRockButtonClick(){
        mutasd(imgRockPlayer);
    }
    
    private void mutasd(ImageView showImg){
        imgRockPlayer.setVisible(false);
        imgScissorsPlayer.setVisible(false);
        imgPaperPlayer.setVisible(false);
        
        imgRockPc.setVisible(false);
        imgScissorsPc.setVisible(false);
        imgPaperPc.setVisible(false);
        
        showImg.setVisible(true);
        
        int random = (int) (Math.random()*3)+1;
        System.out.println(String.valueOf(random));
        switch(random){
            case 1: imgRockPc.setVisible(true);
            break;
            case 2: imgPaperPc.setVisible(true);
            break;
            case 3: imgScissorsPc.setVisible(true);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgRockPc.setVisible(false);
        imgScissorsPc.setVisible(false);
        imgPaperPc.setVisible(false);
        imgRockPlayer.setVisible(false);
        imgScissorsPlayer.setVisible(false);
        imgPaperPlayer.setVisible(false);
        
    }
    
}
