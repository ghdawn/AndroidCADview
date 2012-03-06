import java.io.InputStream;

import android.R.bool;
import android.R.string;


public interface IFileObtain
{
	boolean Open(string path,string filename);
	InputStream getFile();
}
