package b201210028;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;  
/**
 * 
 * @author Şule Betül BUDAK
 *         b201210028
 *         sule.budak@ogr.sakarya.edu.tr
 * @since 20.04.2023
 * 
 * <p>
 * javaFileHomework classı istenilen txt dosyasını yol alarak alır ve 
 * kullanıcıya dosyadaki yorumları yorumların türlerine göre (tek satır,çoklu satır ve javadoc yorumları)
 * okuma, okunan yorumları dosyalara yazdırma ve sayma işlemlerini yapar.
 * İşlemler sırasında ilk önce dosya listeye aktarılır ve buradan okuma işlemleri gerçekleştirilir.
 * Listenin özelliklerikullanılarak diğer işlemler tamamlanır.
 * </p>
 * 
 */
public class javaFileHomework {
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException
	{
		Scanner in=new Scanner(System.in);
		//txt dosyasının yolu
	    String fileName = "C:\\\\\\\\Users\\\\\\\\sbetu\\\\\\\\Desktop\\\\\\\\ödevDosyası.txt"; 
	    
	    //dosyaya yazma işlemleri için dosyalar
	    String tek="teksatir.txt";
	    String cok="coksatir.txt";
	    String jav="javadoc.txt";
	    FileWriter fileWriter = new FileWriter(tek);
	    FileWriter mfileWriter = new FileWriter(cok);
	    FileWriter jfileWriter = new FileWriter(jav);
	    
	     //dosyanın tüm satırlarının liste içerisine aktarılıp okunması
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		
		//yorum satırı sayısının tutulması
		int sinlgeCommentCount = 0;  
		int multiCommentCount = 0;
		int javadocCommentCount = 0;
		
		System.out.println("dosya okumak işlemleri için aşağıdakilerden birini giriniz"
				+ "\n1-Dosyaya yaz"
				+ "\n2-Yorum say");
		int answer=in.nextInt();
		
		if(answer==1)
		{
			fileWriter.write("Tek satır yorumları:\n");
			mfileWriter.write("Çoklu satır yorumları:\n");
			jfileWriter.write("javadoc yorumları:\n");
			//liste yöntemiyle txt dosyası içinde aramaların yapılması
			for (String line : lines)
			{
				//classların bulunması
				if (line.trim().startsWith("public class")||line.trim().startsWith("private class")||line.trim().startsWith("class")||
					line.trim().startsWith("final class ")||line.trim().startsWith("final class ")||line.trim().startsWith("abstract class ")||
					line.trim().startsWith("final class ")) 
				{
					fileWriter.write(line); 
					mfileWriter.write(line);
					jfileWriter.write(line);
				}
				//fonksiyonların bulunması
				if ( line.trim().startsWith(" private String")||line.trim().startsWith("private boolean")
					||line.trim().startsWith("public boolean")||line.trim().startsWith("public void")
					||line.trim().startsWith("void")||line.trim().startsWith("public String")
					||line.trim().startsWith("private void")||line.trim().startsWith("public static")
					||line.trim().startsWith("public double")||line.trim().startsWith("private double") )
				{
					fileWriter.write(line); 
					mfileWriter.write(line);
					jfileWriter.write(line);
				}
				//yorum satırlarının bulunması
				if (line.trim().startsWith("//")) 
				{
					fileWriter.write(line); 
				}
				if(line.trim().startsWith("/*"))
				{
					mfileWriter.write(line);
				}
				if(line.trim().startsWith("/**"))
				{
					jfileWriter.write(line);
				}
			}
			 fileWriter.close();
			 jfileWriter.close();
			 mfileWriter.close();
            System.out.println("Dosyaya yazma islemi basarili."
            		+ "\nDosyalarinizi kontrol ediniz");
            
		}
		
		if(answer==2)
		{
			for (String line : lines)
			{
				if (line.trim().startsWith("public class")||line.trim().startsWith("private class")||line.trim().startsWith("class")||
					line.trim().startsWith("final class ")||line.trim().startsWith("final class ")||line.trim().startsWith("abstract class ")||
					line.trim().startsWith("final class ")) 
				{
					System.out.println("Sinif:"+line);
						
				}
				if ( line.trim().startsWith(" private String")||line.trim().startsWith("private boolean")
					||line.trim().startsWith("public boolean")||line.trim().startsWith("public void")
					||line.trim().startsWith("void")||line.trim().startsWith("public String")
					||line.trim().startsWith("private void")||line.trim().startsWith("public static")
					||line.trim().startsWith("public double")||line.trim().startsWith("private double") )
				{
					System.out.println("Fonksiyon:"+line);
				}
				if (line.trim().startsWith("//")) 
				{
					System.out.println(line);
					sinlgeCommentCount++;
				}
				if(line.trim().startsWith("/*"))
				{
					System.out.println(line);
					multiCommentCount++;
				}
				if(line.trim().startsWith("/**"))
				{
					System.out.println(line);
					javadocCommentCount++;
				}
			}
			 System.out.println("Tek Satir Yorum Sayisi: " + sinlgeCommentCount);
			 System.out.println("Çok Satir Yorum Sayisi: " + multiCommentCount);
			 System.out.println("Javadoc Yorum Sayisi: " + javadocCommentCount);
			 System.out.println("Sayma işlemi tamamnlamiştir.");
			
		}

	}

}
