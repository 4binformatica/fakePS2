import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.awt.*;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Opener {

	JButton button;
	/* ----------------------------- INTERNAL ACCESS ---------------------------- */

	/* ----------------------------- EXTERNAL ACCESS ---------------------------- */
	public static String filePath;

	Opener() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new ImageFilter());
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setCurrentDirectory(new File("."));
		int response = fileChooser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
		}
	}

	/* ---------------------------- SETTERS & GETTERS --------------------------- */

	public static String getFilePath() {
		return filePath;
	}

	/* ------------------------ END OF GETTERS $ GETTERS ------------------------ */
}

class ImageFilter extends FileFilter {
	public final static String JPEG = "jpeg";
	public final static String JPG = "jpg";
	public final static String GIF = "gif";
	public final static String TIFF = "tiff";
	public final static String TIF = "tif";
	public final static String PNG = "png";
	public final static String JFIF = "jfif";

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = getExtension(f);
		if (extension != null) {
			if (extension.equals(TIFF) ||
					extension.equals(TIF) ||
					extension.equals(GIF) ||
					extension.equals(JPEG) ||
					extension.equals(JPG) ||
					extension.equals(PNG) ||
					extension.equals(JFIF)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "Image Only";
	}

	String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}
