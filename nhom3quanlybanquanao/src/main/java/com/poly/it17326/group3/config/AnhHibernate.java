/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.config;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author doand
 */
public class AnhHibernate {

    public static Image getAppicon() {
        URL url = AnhHibernate.class.getResource("/E://anh");
        return new ImageIcon(url).getImage();
    }
    
    public  static  void save(File src){
        File  file = new File("logos",src.getName());
        
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        try {
            Path from = Path.of(src.getAbsolutePath());
            Path to = Paths.get(file.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public  static ImageIcon read (String fileName){
       File path = new File("logos", fileName);
       return new ImageIcon(path.getAbsolutePath());
   }
}
