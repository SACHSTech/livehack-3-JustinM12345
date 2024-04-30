class Problem1 extends ConsoleProgram {

  /**
  * Description
  * @author: Justin M.
  * Ask user for first name, last name, student number, and username
  * Then using methods, will display the validation status of their username and their generated password
  */
  
  public void run() {
    // Initialize Variables
    String strFirst;
    String strLast;
    String strNum;
    String strUser;

    //Ask user for inputs
    System.out.println("***** Student Account Registration ***** ");
    strFirst = readLine("Enter your first name: ");
    strLast = readLine("Enter your last name: ");
    strNum = readLine("Eenter your student numer: ");
    strUser = readLine("Enter a new username: ");
    
    // Call methods
    boolean boolUserResult = validateUsername(strUser);
    String strPasswordResult = createPassword(strFirst, strLast, strNum);

    //Print out results
    System.out.println("\nValid username: " + boolUserResult);
    System.out.println("Your passsword is: " + strPasswordResult);
  }

  /**
   * Returns true or false if the username meets the following conditions:
   * Consists of only lettes and digits
   * Has at least one digit
   * Length is greater than 7 characters long
   * 
   * @param strUsername The username provided
   * @return True or Fales depending on if the uesrname meets the conditions 
   *
   */

  public boolean validateUsername(String strUsername) 
  {
    // Initialize Variables
    boolean boolValidate = true;
    int intInvalidate = 0;
    int intHasDigits = 0;

    // Checking if username has a digit to validate it, and also checking if a username has non-letters/digits to invalidate it
    for (int i = 0; i < strUsername.length(); i++){

      if (Character.isDigit(strUsername.charAt(i))){
        intHasDigits++;
      }

      else if (Character.isLetterOrDigit(strUsername.charAt(i)) == false){
        intInvalidate++;
      }
    }

    // Checking values to see if username should be invalidated
    if (intInvalidate != 0 || strUsername.length() <= 7 || intHasDigits == 0){
       boolValidate = false;
       return boolValidate;
     }

    // Returns if username is valid
    else{
       return boolValidate;
    }
   }

  /**
   * Creates a password using the parameters provided
   * @param strFirst
   * @param strLast
   * @param strStudentNum
   * @return Password rule: lowercase first 4 characters of last name + uppercase first initial of first name + middle 3 numbers of the student number
   * 
   */

  public String createPassword(String strFirst, String strLast, String strStudentNum)
  {
    
    //Throw exception for blank arguments or incorrect number of digits in student number
    if (strFirst == "" || strLast == "" || strStudentNum.length() != 9){
      throw new IllegalArgumentException("incorrect parameters(s)");
    }
             
    // Initialize Variables
    String strNewPassword = "";
    int intLastNameCharCount = 0;
    int intMiddleOfNum;

    // Creates beginning of password with lowercase first 4 letters of last name
    for (int i = 0; i < strLast.length(); i++){
      
      if (intLastNameCharCount > 3){
        break;
      }

      strNewPassword = strNewPassword + Character.toLowerCase(strLast.charAt(i));
      intLastNameCharCount++;
    }

    // Adds in uppercase first letter of first name to passwo
    strNewPassword = strNewPassword + Character.toUpperCase(strFirst.charAt(0));

    // Determine middle of student number and add middle 3 numbers
    intMiddleOfNum = strStudentNum.length() / 2;
    strNewPassword = strNewPassword + strStudentNum.charAt(intMiddleOfNum - 1) + strStudentNum.charAt(intMiddleOfNum) + strStudentNum.charAt(intMiddleOfNum + 1);

    // Returns new password
    return strNewPassword;

  }
}