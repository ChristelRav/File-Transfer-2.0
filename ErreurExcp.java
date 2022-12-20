package exception;

import java.sql.*;
import java.lang.Exception;
public class ErreurExcp extends Exception{
  public ErreurExcp(String str) throws Exception{
    super(str);
  }
 
} 