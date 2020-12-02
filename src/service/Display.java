/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author amen
 * @param <T>
 * @param <PK>
 */
public class Display<T, PK extends Serializable> {

    private int answer;
    private String picture;

    public Display() {
    }

    public void populateDataList(AbstractTableModel model, JTable dataList) {
        dataList.setModel(model);
//        new TableButtons().addButtonsToTable(dataList);
    }

    public void cardReplace(JPanel pane1, JPanel pane2, String card) {
        pane1.removeAll();
        pane1.repaint();
        pane1.add(pane2, card);
        pane1.validate();
    }

    public void cardReplace(JPanel pane1, JPanel pane2) {
        pane1.removeAll();
        pane1.repaint();
        pane1.add(pane2);
        pane1.validate();
    }

    public void cardReplace(JPanel pane1, JPanel pane2, boolean validated) {
        if (validated == true) {
            this.cardReplace(pane1, pane2);
        } else {

        }
    }

    public void addLookAndFeel(String className, Component component) {
        UIManager.LookAndFeelInfo laf[] = UIManager.getInstalledLookAndFeels();
        try {
            UIManager.setLookAndFeel((String) laf[1].getClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(className).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(className).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(className).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(className).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(component);
    }

    public String getPicture(JLabel label, JComponent component) {
        JFileChooser file = new JFileChooser();
        file.setFileFilter(new FileNameExtensionFilter("jpeg,jpg ou png", "jpg",
                "jpeg", "png"));
        file.setCurrentDirectory(new File("..\\..\\GecoGui\\src\\tg\\mikam\\geco\\view\\pictures"));
        this.answer = file.showOpenDialog(component);
        if (JFileChooser.OPEN_DIALOG == this.answer) {
            picture = file.getSelectedFile().getAbsolutePath();
            this.setPicture(picture, label);
        }
        return picture;
    }

    public String pictureTo(JLabel label, JComponent component, File directory) {
        JFileChooser file = new JFileChooser();
        file.setFileFilter(new FileNameExtensionFilter("jpeg,jpg ou png", "jpg",
                "jpeg", "png"));
        this.answer = file.showOpenDialog(component);
        if (JFileChooser.OPEN_DIALOG == this.answer) {
            directory = new File("toto.txt");
            System.out.println(directory.getAbsolutePath() + "gggg" + directory);
            this.copy(file.getSelectedFile(), directory);
            picture = file.getSelectedFile().getAbsolutePath();
            this.setPicture(picture, label);
        }
        return picture;
    }

    public void setPicture(String picture, JLabel label) {
        label.setIcon(null);
        String img = "<html><img alt=\"\" src=\"file:\\\\\\" + picture
                + "\"height='" + label.getHeight() + "'" + " width='"
                + label.getWidth() + "'/></html>";
        label.setText(img);
    }

    public String getDate(JDateChooser dat) {
        return (String.valueOf(dat.getCalendar().get(Calendar.DATE)) + "-"
                + String.valueOf(dat.getCalendar().get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(dat.getCalendar().get(Calendar.YEAR)));
    }

    public void copy(File Source, File Destination) {
        boolean result = false;
        FileInputStream srcFile = null;
        FileOutputStream destFile = null;
        try {
            srcFile = new FileInputStream(Source);
            destFile = new FileOutputStream(Destination);
            byte buffer[] = new byte[512 * 1024];
            int nbReader;
            while ((nbReader = srcFile.read(buffer)) != -1) {
                destFile.write(buffer, 0, nbReader);
            }
            result = true;
        } catch (FileNotFoundException nf) {
            nf.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                srcFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                destFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        return result;
    }

//    public List<PersonExcelFileValues> readExcelFile(HSSFWorkbook wb, HSSFSheet sheet,
//            int rowCount, int colCount) {
//        HSSFRow row = null;
//        int sheetsCount = 0;
//        List<PersonExcelFileValues> sheetValues = new LinkedList<>();
//        PersonExcelFileValues personExcelFileValues;
//        rowCount = sheet.getPhysicalNumberOfRows() - 1;
//        for (int i = 1; i <= rowCount; i++) {
//            row = sheet.getRow(i);
//            personExcelFileValues = new PersonExcelFileValues();
//            if (row.getCell((short) 1) != null) {
//                personExcelFileValues.setStatus(row.getCell((short) 1)
//                        .getStringCellValue());
//            }
//            if (row.getCell((short) 2) != null) {
//                personExcelFileValues.setMatricule(row.getCell((short) 2)
//                        .toString());
//            }
//            if (row.getCell((short) 3) != null) {
//                personExcelFileValues.setLastName(row.getCell((short) 3)
//                        .getStringCellValue());
//            }
//            if (row.getCell((short) 4) != null) {
//                personExcelFileValues.setFirstName(row.getCell((short) 4)
//                        .getStringCellValue());
//            }
//            sheetValues.add(personExcelFileValues);
//        }
//
//        return sheetValues;
//    }
//
//    public HSSFWorkbook getExcelFile(JComponent component) {
//        String excelFile = null;
//        InputStream myxls = null;
//        HSSFWorkbook wb = null;
//        try {
//            JFileChooser file = new JFileChooser();
////            file.setFileFilter(new FileNameExtensionFilter("excel 97-2003", "xls"));
//            answer = file.showOpenDialog(component);
//            if (JFileChooser.OPEN_DIALOG == answer) {
//                excelFile = file.getSelectedFile().getAbsolutePath();
//            }
//            myxls = new FileInputStream(excelFile);
//            try {
//                wb = new HSSFWorkbook(myxls);
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            try {
//                myxls.close();
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        return wb;
//    }

//    public String savePath(JFrame frame, String path) {
//        JFileChooser file = new JFileChooser();
//        file.setBounds(50, 80, 70, 80);
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf,excel", ".pdf,.xsl");
//        file.setFileFilter(filter);
//        file.setFileSelectionMode(1);
//        int returnVal = file.showSaveDialog(frame);
//        if (JFileChooser.APPROVE_OPTION == returnVal) {
//            path = file.getSelectedFile().getAbsolutePath();
//        } else {
//            JOptionPane.showMessageDialog(null, "chemin incorrecte"
//                    + " des classes", "erreur",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//        return path;
//    }
//
//    public PrintJob printDialogue(JFrame frame){
//        PrintJob job = frame.getToolkit().getPrintJob(frame,"impression", null);
//        return job;
//    }
//
//    public void printFile(String path){
////        System.out.println("coool");
//       if(Desktop.isDesktopSupported()){
////           System.out.println("coool1");
//              if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.PRINT)){
////                  System.out.println("coool2");
//                  try {
//                         java.awt.Desktop.getDesktop().print(new File(path));
////                         System.out.println("coool3");
//                  } catch (IOException ex) {
//                        //Traitement de l'exception
//                      ex.printStackTrace();
//                  }
//               } else {
//                //La fonction n'est pas supportée par votre système d'exploitation
//             }
//           }else {
//              //Desktop pas supportée par votre système d'exploitation
//          }
//    }
//
//    public void printFile(String path,JFrame frame){
//         if(Desktop.isDesktopSupported()){
//              if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.PRINT)){
//                  try {
//                    if (printDialogue(frame) != null) {
//                         java.awt.Desktop.getDesktop().print(new File(path));
//                    }
//                  } catch (IOException ex) {
//                        System.out.println(ex.getMessage());
//                  }
//               } else {
//                System.out.println("La fonction n'est pas "
//                        + "supportée par votre système d'exploitation");
//             }
//           }else {
//              System.out.println("Desktop pas supportée par "
//                      + "votre système d'exploitation");
//          }
    }
