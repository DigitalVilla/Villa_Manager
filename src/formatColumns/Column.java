package formatColumns;
/**
 * Utility Class to format table columns based on formating all data types to
 * strings
 *
 * @author Dave Watson
 * @version 1.0
 */

import java.text.*;

public class Column
{
  /**
   * Method to center a string in a column of size
   * specified by the user.
   *
   * @param s a String to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the string centered 
	* in the column
   */
	public static String center(String s, int columnSize)
	{
		int length, start;
		StringBuffer sb = new StringBuffer(columnSize);

		for (int i = 0; i < columnSize; i++)
		{
			sb.replace(i, i + 1, " ");
		}

		length = s.length();

		if (length > columnSize)
		{
			return s.substring(0, columnSize);
		}
		else
		{
			start = (columnSize - length) / 2;
			sb.replace(start, start + length, s);
		}
		return sb.toString();
	}

  /**
   * Method to center a integer in a column of size
   * specified by the user.
   *
   * @param n a int to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the int centered 
	* in the column
   */
  public static String center(int n, int columnSize)
  {
    return center(Integer.toString(n),columnSize);
  }

  /**
   * Method to center a long in a column of size
   * specified by the user.
   *
   * @param n a long to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the long centered 
	* in the column
   */
  public static String center(long n, int columnSize)
  {
	  //System.out.println("using long");
	  return center(Long.toString(n),columnSize);
  }

   /**
   * Method to center a double in a column of size
   * specified by the user and number of decimal
   * places specified by the user.
   *
   * @param n a double to be centered in a column
   * @param columnSize an int representing the size
	* of the column
	* @param numDecimals int containing the number of
	* required decimal places in the real number.
	* @param money boolean if true places a $ at the in
	* the value and if false no $.
   *
   * @return a String representing the double centered 
	* in the column
   */
  public static String center(double n, int columnSize,
                        int numDecimals, boolean money)
  {
    String s = null, fmtstr = "0.";

    for(int i = 0; i < numDecimals; i++)
    {
      fmtstr = fmtstr+"0";
    }

    DecimalFormat fmt = new DecimalFormat(fmtstr);
    s = fmt.format(n);

    if(money == true)
    {
      s = "$" + s;
    }

    return center(s,columnSize);
  }

  /**
   * Method to center a character in a column of size
   * specified by the user.
   *
   * @param n a char to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the character centered 
	* in the column
   */
  public static String center(char c, int columnSize)
  {
    String s = "";
    s = s + c;

    return center(s,columnSize);
  }

  //********************** LEFT JUSTIFICATION *******************/

  /**
   * Method to left justify a string in a column of size
   * specified by the user.
   *
   * @param s a String to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the string left justified 
	* in the column
   */
	public static String leftJustify(String s, int columnSize)
	{
		int length, start;
		StringBuffer sb = new StringBuffer(columnSize);

		for (int i = 0; i < columnSize; i++)
		{
			sb.replace(i, i + 1, " ");
		}

		length = s.length();

		if (length > columnSize)
		{
			return s.substring(0, columnSize);
		}
		else
		{
			start = 0;
			sb.replace(start, start + length, s);
		}

		return sb.toString();
	}

  /**
   * Method to left  justify a integer in a column of size
   * specified by the user.
   *
   * @param n a int to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the int left justified 
	* in the column
   */
  public static String leftJustify(int n, int columnSize)
  {
	  return leftJustify(Integer.toString(n),columnSize);
  }

  /**
   * Method to left justify a long in a column of size
   * specified by the user.
   *
   * @param n a long to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the long left justified 
	* in the column
   */
  public static String leftJustify(long n, int columnSize)
  {
	  return leftJustify(Long.toString(n),columnSize);
  }

   /**
   * Method to left justify a double in a column of size
   * specified by the user and number of decimal
   * places specified by the user.
   *
   * @param n a double to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
	* @param numDecimals int containing the number of
	* required decimal places in the real number.
	* @param money boolean if true places a $ at the in
	* the value and if false no $.
   *
   * @return a String representing the double left justified 
	* in the column
   */
  public static String leftJustify(double n, int columnSize,
                            int numDecimals, boolean money)
  {
	  String s = null, fmtstr = "0.";

	    for(int i = 0; i < numDecimals; i++)
	    {
	      fmtstr = fmtstr+"0";
	    }

	    DecimalFormat fmt = new DecimalFormat(fmtstr);
	    s = fmt.format(n);

	    if(money == true)
	    {
	      s = "$" + s;
	    }

	    return leftJustify(s,columnSize);
  }

  /**
   * Method to left justify a character in a column of size
   * specified by the user.
   *
   * @param n a char to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the character left 
	* justified in the column
   */
  public static String leftJustify(char c, int columnSize)
  {
	  String s = "";
	    s = s + c;

	    return leftJustify(s,columnSize);
  }

  //********************** RIGHT JUSTIFICATION *******************/

  /**
   * Method to right justify a string in a column of size
   * specified by the user.
   *
   * @param s a String to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the string right justified 
	* in the column
   */
  public static String rightJustify(String s, int columnSize)
  {
    int length, start;
    StringBuffer sb = new StringBuffer(columnSize);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();
    
    if(length > columnSize)
    {
    	return s.substring(0, columnSize);
	}	
	else
    {
    	start = columnSize - length;
    	sb.replace(start,start + length, s);
    }

    return sb.toString();
  }

  /**
   * Method to right  justify a integer in a column of size
   * specified by the user.
   *
   * @param n a int to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the int right justified 
	* in the column
   */
  public static String rightJustify(int n, int columnSize)
  {
	  return rightJustify(Integer.toString(n),columnSize);
  }

  /**
   * Method to right justify a long in a column of size
   * specified by the user.
   *
   * @param n a long to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the long right justified 
	* in the column
   */
  public static String rightJustify(long n, int columnSize)
  {
    return rightJustify(Long.toString(n),columnSize);
  }

   /**
   * Method to right justify a double in a column of size
   * specified by the user and number of decimal
   * places specified by the user.
   *
   * @param n a double to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
	* @param numDecimals int containing the number of
	* required decimal places in the real number.
	* @param money boolean if true places a $ at the in
	* the value and if false no $.
   *
   * @return a String representing the double right justified 
	* in the column
   */
  public static String rightJustify(double n, int columnSize,
                              int numDecimals, boolean money)
  {
	  String s = null, fmtstr = "0.";

	    for(int i = 0; i < numDecimals; i++)
	    {
	      fmtstr = fmtstr+"0";
	    }

	    DecimalFormat fmt = new DecimalFormat(fmtstr);
	    s = fmt.format(n);

	    if(money == true)
	    {
	      s = "$" + s;
	    }

	    return rightJustify(s,columnSize);
  }

  /**
   * Method to right justify a character in a column of size
   * specified by the user.
   *
   * @param n a char to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the character right 
	* justified in the column
   */
  public static String rightJustify(char c, int columnSize)
  {
	  String s = "";
	    s = s + c;

	    return rightJustify(s,columnSize);
  }
}