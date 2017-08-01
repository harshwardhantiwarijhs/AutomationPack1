package generics;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Dimension;

import javax.imageio.ImageIO;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class UtilityLib {
	
	public static String getPropertyValue(String path,String key){
		String v="";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e){
		}
		return v;
	}
	//-----------------------------------------------------------
	/**
	 * Get the screen shot of Page
	 * 
	 */
	public static void getScreenShot(WebDriver driver,String path){
		try{
			TakesScreenshot t=(TakesScreenshot) driver;
			File srcFile= t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(path));
		}
		catch(Exception e){
		}
	}
	/**
	 * Get the screen shot of Desktop
	 * @param path of the screen shot
	 * @author Bhanu
	 */
	public static void getScreenShot(String path){
		try{
			Robot r=new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage img= r.createScreenCapture(new Rectangle(d));
			ImageIO.write(img,"png",new File(path));
			}
			catch(Exception e){
			}
	}
	
	public static String now(){
		SimpleDateFormat s=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return s.format(new Date());
	}
	
	public static String getCellValue(String path,String sheet,int r,int c){
		String v="";
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
		}
		return v;
	}
	public static int getRowCount(String path,String sheet){
		int  r=0;
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			r=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){
		}
		return r;
	}
}
