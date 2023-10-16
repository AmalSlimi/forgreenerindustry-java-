/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.forGreenerIndustry.gui;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.edu.forGreenerIndustry.entities.Post;
import tn.edu.forGreenerIndustry.services.ServicePost;

/**
 * FXML Controller class
 *
 * @author mila
 */
public class PostFXMLController implements Initializable {

    @FXML
    private Label tfPost;
    @FXML
    private TextField tfEntreprise;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfContenu;
    @FXML
    private ComboBox<String> comboBoxType;
    @FXML
    private DatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAjouter(ActionEvent event) {
        try {
            int idPost = Integer.parseInt(tfPost.getText());
            int idEntreprise = Integer.parseInt(tfEntreprise.getText());
            String titre = tfTitre.getText();
            String selectedValue = comboBoxType.getValue();
            String contenu = tfContenu.getText();
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate); // Convert LocalDate to SQL Date

            
            // Create a Post object 
            Post newPost = new Post(idPost, idEntreprise, titre, "Event", contenu, date, "url_photo.jpg", 0);
            // Here, "Event" and "url_photo.jpg" are placeholders; you can customize them

            // Call your service to add the Post to the database
            ServicePost service = new ServicePost();
            service.ajouter(newPost);

            // Optionally, you can show a success message or perform other actions
            showAlert("Post added successfully");
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter valid numbers.");
        }
    }

    private void showAlert(String post_added_successfully) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
