/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.swing.JOptionPane;

/**
 *
 * @author PC ASUS
 */
public class MessageDialog {

    public MessageDialog() {
    }
    
    public static void ErrorMessage(String title, String Message){
//        Log.getInstance().severeLogger(Message);
        JOptionPane.showMessageDialog(null, Message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void ErrorMessage(){
//        Log.getInstance().severeLogger("Echec de l'operation");
        JOptionPane.showMessageDialog(null, "Opération échoue", "Echec", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void warningMessage(String title, String Message){
//        Log.getInstance().warningLogger(Message);
        JOptionPane.showMessageDialog(null, Message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void infoMessage(String title, String Message){
//        Log.getInstance().infoLogger(Message);
        JOptionPane.showMessageDialog(null, Message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void successMessage(String title, String Message){
        JOptionPane.showMessageDialog(null, Message, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void successMessage(){
        JOptionPane.showMessageDialog(null, "Opération réussie", "Succes", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static int questionMessage(String title, String Message){
       return JOptionPane.showConfirmDialog(null, Message, title, 
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static int delQuestionMessage(){
       return JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir supprimmer cette ligne?", "Attention", 
               JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }
}
